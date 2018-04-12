#!/bin/bash

SCRIPTS_PATH=`dirname "$0"`
. ${SCRIPTS_PATH}/include.sh  standalone



CLI="$JAVA_HOME/bin/jvisualvm --cp:a $WILDFLY_HOME/bin/client/jboss-client.jar"
echo $CLI
$CLI





