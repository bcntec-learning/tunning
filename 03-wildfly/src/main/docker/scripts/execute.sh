#!/usr/bin/env bash

SCRIPTS_PATH=`dirname "$0"`
. ${SCRIPTS_PATH}/include.sh  standalone


$SCRIPTS_PATH/init.sh
cp /opt/customization/apps/*.war /opt/wildfly/standalone/deployments/

$WILDFLY_EXEC


