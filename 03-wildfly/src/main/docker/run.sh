#!/usr/bin/env bash

docker run -d --privileged  --name houseware-learn/tunning -p 9990:9990 -p 8080:8080 \
-e "MYSQL_URI=jdbc:mysql://localhost:3306/tunning" \
-e "MYSQL_USER=tunning" \
-e "MYSQL_PASSWORD=tunning" \
-e "ADMIN_PASSWORD=tunning" \
-v $datadir:/opt/tunning/:rw \
-v $logsdir:/opt/jboss/wildfly/standalone/log/:rw \
microbr/ree-jerarquias:${project.version}


