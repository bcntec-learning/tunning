#!/bin/bash

if [  -z "$WILDFLY_INCLUDE" ]; then

export WILDFLY_INCLUDE=TRUE

if [ -z "$WILDFLY_HOME" ]; then
  echo "WILDFLY_HOME is empty"
  exit
fi



export JAVA_OPTS="$JAVA_OPTS $JAVA_OPTS_EXTRA "


WILDFLY_CLI=$WILDFLY_HOME/bin/jboss-cli.sh
WILDFLY_MODE=${2:-"standalone"}
WILDFLY_CONFIG=${3:-"$WILDFLY_MODE.xml"}
WILDFLY_EXEC="$WILDFLY_HOME/bin/standalone.sh   -b 0.0.0.0 -bmanagement 0.0.0.0 -Djboss.bind.address.management=0.0.0.0 -Duser.timezone=Europe/Madrid -Duser.language=es -Duser.country=ES"


function server_wait_for() {
  until `$WILDFLY_CLI -c ":read-attribute(name=server-state)" 2> /dev/null | grep -q running`; do
    sleep 2
    echo "waiting"
  done
}


function server_start(){

    echo "WILDFLY_MODE  : " $WILDFLY_MODE
    echo "WILDFLY_CONFIG: " $WILDFLY_CONFIG
    echo "WILDFLY_EXEC  : " $WILDFLY_EXEC
    $WILDFLY_EXEC
}
function server_shutdown(){
    if [ "$WILDFLY_MODE" = "standalone" ]; then
        $WILDFLY_CLI -c ":shutdown"
    else
        $WILDFLY_CLI -c "/host=*:shutdown"
    fi
}

function server_clean() {
    rm $WILDFLY_HOME/deployments/*
}



echo "WILDFLY_HOME  : " $WILDFLY_HOME
#echo "WILDFLY_CLI   : " $WILDFLY_CLI
#echo "WILDFLY_MODE  : " $WILDFLY_MODE
#echo "WILDFLY_CONFIG: " $WILDFLY_CONFIG
#echo "WILDFLY_EXEC  : " $WILDFLY_EXEC


fi



