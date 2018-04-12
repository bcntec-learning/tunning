#!/usr/bin/env bash
SCRIPTS_PATH=`dirname "$0"`
. ${SCRIPTS_PATH}/include.sh  standalone

echo ">>>$WILDFLY_CLI"

if [ $# -eq 0 ]; then
    $WILDFLY_CLI -c
    exit
fi


$WILDFLY_CLI -c $0