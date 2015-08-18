#!/bin/bash -e

#===============================================
#==   Several helpful bashfunctions written   ==
#==                  by cbisig                ==
#===============================================
# Contains the following functions:
# - log             ; Write a log message to sysout
# - log_e           ; Write an error message to sysout
# - log_w           ; Write a warning message to sysout
# - log_i           ; Write an info message to sysout
# - log_d           ; Write a debug message to sysout
# - shutdown_pid    ; Shutdown a process of a given PID

LEVEL_I="INFO   "
LEVEL_W="WARNING"
LEVEL_E="ERROR  "
LEVEL_D="DEBUG  "

log () {
  NOW=$(date +"%Y-%m-%d-%H.%M.%S.%4N")
  LEVEL=$1
  MSG=$2
  echo $NOW" : $LEVEL : $MSG"
}

log_i () {
  log "$LEVEL_I" "$1"
}

log_w () {
  log "$LEVEL_W" "$1"
}

log_e () {
  log "$LEVEL_E" "$1"
}

log_d () {
  log "$LEVEL_D" "$1"
}


########
# Function shutdown_pid kills process of a given PID
# if the process does not shutdown after 20 seconds
# a forced kill is triggered.
#########
shutdown_pid () {
  if [ -z "$1" ]; then
    log_e "No process id provided"
    return 1
  else
    PID=$1
  fi

  if [ -d /proc/$PID ]; then

    log_i "Stopping application (PID: $PID)..."
    kill $PID

    CNT=1
    while [ -d /proc/$PID ] && [ $CNT -lt 6 ]; do
      sleep 3
      log_i "Waiting for shutdown ($CNT)..."
      CNT=$((CNT+1))
    done

    if [ -d /proc/$PID ]; then
      log_w "Application did not stop after 20 seconds"
      log_i "Doing forced stop..."
      kill -9 $PID

      CNT=1
      while [ -d /proc/$PID ] && [ $CNT -lt 6 ]; do
        sleep 3
        log_i "Waiting for forced shutdown ($CNT)..."
        CNT=$((CNT+1))
      done

      if [ -d /proc/$PID ]; then
        log_e "There seems to be a serious issue with process $PID"
        log_e "Giving up on trying to stop. Please check $PID by yourself"
      else
        log_i "Application with $PID finally stopped"
      fi
    else
      log_i "Application with $PID successfully stopped"
    fi
  else
    log_i "Process with PID: $PID not running. Nothing to stop..."
  fi
}

