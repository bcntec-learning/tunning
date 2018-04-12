#!/bin/bash

SCRIPTS_PATH=`dirname "$0"`
. ${SCRIPTS_PATH}/include.sh  standalone



$JAVA_HOME/bin/jmc -vmargs -Xbootclasspath/a:$WILDFLY_HOME/bin/client/jboss-client.jar





