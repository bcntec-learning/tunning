#!/usr/bin/env bash

SCRIPTS_PATH=`dirname "$0"`
. ${SCRIPTS_PATH}/include.sh  standalone


if [ ! -z "$1" ]; then
    ADMIN_PASSWORD=$1
fi

$WILDFLY_HOME/bin/add-user.sh admin ${ADMIN_PASSWORD} --silent