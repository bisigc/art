#!/bin/bash -e

echo "==============================================="
echo "==   Starting Deployment (build postproc)    =="
echo "==       deployment script by cbisig         =="
echo "==============================================="


BUILDFILE=$WORKSPACE/build.sbt

if [ -f $BUILDFILE ]; then
  echo "Found Buildfile: "$BUILDFILE
else
  echo "Buildfile not found: "$BUILDFILE
  exit 1
fi

echo "Gattering app name and version from buildfile..."
# Grepping appname:  name := """art-app"""
APPNAME=`grep "^name" $BUILDFILE | sed 's/name.*\"\"\"\(.*\)\"\"\"/\1/'` 
# Grepping version:  version := "1.0-SNAPSHOT"
VERSION=`grep "^version" $BUILDFILE | sed 's/version.*\"\(.*\)\"/\1/'` 

DISTFILE=$APPNAME-$VERSION.zip
INSTALLPATH=/opt/$APPNAME

if [ -d $INSTALLPATH ]; then
  echo "Installpath exists: "$INSTALLPATH
  echo "Checking for running server..."
  PID=`pgrep "$APPNAME"`

  echo "Installpath does not yet exist 
  mkdir $INSTALLPATH
fi

cd $INSTALLPATH

unzip $WORKSPACE/target/universal/$DISTFILE



echo $APPNAME
echo $VERSION
echo $DISTFILE

