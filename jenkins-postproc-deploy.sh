#!/bin/bash -e

echo "==============================================="
echo "==   Starting Deployment (build postproc)    =="
echo "==       deployment script by cbisig         =="
echo "==============================================="

# Including some bash functions
. common_bash_functions.sh

BUILDFILE=$WORKSPACE/build.sbt
MAXMEM=256

if [ -f $BUILDFILE ]; then
  log_i "Found Buildfile: $BUILDFILE"
else
  log_e "Buildfile not found: $BUILDFILE"
  exit 1
fi

echo "Gattering app name and version from buildfile..."
# Grepping appname:  name := """art-app"""
APPNAME=`grep "^name" $BUILDFILE | sed 's/name.*\"\"\"\(.*\)\"\"\"/\1/'` 
# Grepping version:  version := "1.0-SNAPSHOT"
VERSION=`grep "^version" $BUILDFILE | sed 's/version.*\"\(.*\)\"/\1/'` 
#SRVPORT=`grep "playDefaultPort" $BUILDFILE | sed 's/.*playDefaultPort := \([0-9]*\)/\1/'`
SRVPORT=`grep "http.port" $BUILDFILE | sed 's/.*http.port=\([0-9]*\)"/\1/'`

DISTFILE=$APPNAME-$VERSION.zip
INSTALLPATH=/opt/$APPNAME
OLDVERSIONDIR=old_versions
OLDVERSIONPATH=$INSTALLPATH/$OLDVERSIONDIR
LOGPATH=$INSTALLPATH/logs
VERSIONFILE=$INSTALLPATH/VERSION.TXT
PIDFILEPATH=$INSTALLPATH/server.pid
  

if [ -d $INSTALLPATH ]; then
  log_i "Installpath exists: $INSTALLPATH"
  log_i "Checking for running server..."
  if [ -f $PIDFILEPATH ]; then
    PID=`cat $PIDFILEPATH`
    log_i "Found process: $PID"
    log_i "Stopping application..."
    shutdown_pid $PID
  else
    log_i "No PID file found: $PIDFILEPATH"
  fi

  if [ ! -d $OLDVERSIONPATH ];then 
    log_i "Old versions path does not exist: $OLDVERSIONPATH"
    mkdir $OLDVERSIONPATH
  fi

  log_i "Zipping current version..."

  if [ -f $VERSIONFILE ]; then
    CURRENTVERSION=`cat $VERSIONFILE`
  else
    log_w "No version file found: $VERSIONFILE"
    log_w "Using timestamp"
    CURRENTVERSION=$APPNAME-$(date +"%Y%m%d%H%M%S")
  fi

  ZIPFILEPATH=$OLDVERSIONPATH/$CURRENTVERSION.zip

  cd $INSTALLPATH

  log_i "Zipping current version to: $ZIPFILEPATH ..."
  zip -r $ZIPFILEPATH * -x $OLDVERSIONDIR
  log_i "Zipping $ZIPFILENAME finished"

  log_i "Deleting old version files..."
  find . -not -name "$OLDVERSIONDIR" -maxdepth 1 -exec rm -r {} \;

else
  log_i "Installpath does not yet exist"
  log_i "Creating directory: $INSTALLPATH"
  mkdir $INSTALLPATH || true
  if [ ! -d $INSTALLPATH ]; then
    log_e "Creation of directory $INSTALLPATH failed"
    log_e "Please create the directory manually and grant the jenkins user: mkdir $INSTALLPATH;chown jenkins:jenkins $INSTALLPATH"
    exit 1
  fi
fi

cd $INSTALLPATH

NEWVERSION=$WORKSPACE/target/universal/$DISTFILE
log_i "Unzipping new version from $NEWVERSION to $INSTALLPATH" 
unzip $NEWVERSION -d $INSTALLPATH
log_i "Unzipping done."

log_i "Creating version file..."
echo "$APPNAME-$VERSION" > $VERSIONFILE

log_i "Move files from $INSTALLPATH/$APPNAME-$VERSION to $INSTALLPATH"
mv $INSTALLPATH/$APPNAME-$VERSION/* $INSTALLPATH/.
rm -r $INSTALLPATH/$APPNAME-$VERSION 

log_i "Starting server on port $SRVPORT..."
if [ ! -d "$LOGPATH" ]; then
  log_i "Logpath $LOGPATH does not yet exist, creating ..."
  mkdir $LOGPATH
fi
cd $INSTALLPATH/logs
# Setting this BUILD_ID is a workaround so jenkins will not kill the background process after the build process has finished.
export BUILD_ID=dontKillMe
CMD="nohup $INSTALLPATH/bin/$APPNAME -mem $MAXMEM -J-server -Dpidfile.path=$PIDFILEPATH -Dapplication.context=/$APPNAME/ -Dhttp.port=$SRVPORT -Dapplication.home=$INSTALLPATH"
log_i "Executing the following command for starting the server: $CMD"
$CMD &

# sleep quickly to be sure the pid file exists
sleep 5
CNT=1
while [ ! -f $PIDFILEPATH ] && [ $CNT -lt 6 ]; do
  sleep 1
  log_i "Waiting for start of server... ($CNT of max 5)"
  CNT=$((CNT+1))
done

if [ -f $PIDFILEPATH ]; then
  PID=`cat $PIDFILEPATH`
  log_i "Server started with PID $PID"
  log_i "Deployment of new server version finished!"
else
  log_e "No PID file yet. Server failed to start. Please check."
  exit 1
fi

