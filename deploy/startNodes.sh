#!/bin/bash

echo INICIO SERVICIO PROXY
cd "$(dirname "$(realpath "$0")")/app"
PORT=9090
sh start.sh $PORT
cd ..
echo SE INICIAN PROXY
