#!/bin/bash
PID=`cat pid`
kill -9 $PID
if ps -p $PID > /dev/null
then
   rm output.log
fi