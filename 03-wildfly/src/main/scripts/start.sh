#!/usr/bin/env bash

SCRIPTS_PATH=`dirname "$0"`
. ${SCRIPTS_PATH}/include.sh  standalone

export JAVA_OPTS="-Xmx4g -XX:+UseG1GC  -XX:+UnlockCommercialFeatures -XX:+FlightRecorder  -server  -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=256m -Djava.net.preferIPv4Stack=true -Djboss.modules.system.pkgs=org.jboss.byteman -Djava.awt.headless=true"


server_start


