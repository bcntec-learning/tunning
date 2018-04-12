#!/usr/bin/env bash

SCRIPTS_PATH=`dirname "$0"`
. ${SCRIPTS_PATH}/include.sh  standalone


$SCRIPTS_PATH/add-admin-user.sh admin ${ADMIN_PASSWORD} --silent

WILDFLY_EXEC="$WILDFLY_HOME/bin/standalone.sh  -b 0.0.0.0 -bmanagement 0.0.0.0 -Duser.timezone=Europe/Madrid -Duser.language=es -Duser.country=ES"

$WILDFLY_EXEC &

server_wait_for

echo "=> Executing on server"


$WILDFLY_CLI -c << EOF
 batch


# Add MySQL module
module add --name=com.mysql.driver --resources=/opt/customization/mysql-connector-java-5.1.39.jar  --dependencies=javax.api,javax.transaction.api

# Add MySQL driver
/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql.driver,driver-class-name=com.mysql.jdbc.Driver)


data-source add --name=TunningDS --driver-name=mysql --jndi-name=java:jboss/datasources/tunning --connection-url=$MYSQL_URI?useUnicode=true&amp;characterEncoding=UTF-8   --user-name=$MYSQL_USER   --password=$MYSQL_PASSWORD --use-ccm=true --enabled=true

run-batch
EOF



server_shutdown

cp /opt/customization/apps/*.war /opt/wildfly/standalone/deployments/

server_start


