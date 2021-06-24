#!/bin/bash 

if [ "$1" != "" ]; then
  PORT=--server.port=$1
fi

nohup java -Xmx128m -Xss2m -Xms64m -jar service.jar $PORT > output.log 2>&1&
echo $! > pid

#-Dlog4j.configurationFile=config/log4j2.xml
#--spring.config.name=application-prod