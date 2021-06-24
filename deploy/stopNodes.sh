#!/bin/bash

echo SE DETIENE SERVICIO PROXY
cd "$(dirname "$(realpath "$0")")/app"
sh stop.sh
cd ..
echo SE DETIENEN PROXY
