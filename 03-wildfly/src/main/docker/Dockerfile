FROM jboss/wildfly:10.0.0.Final


MAINTAINER Francisco Philip <fphilip@houseware.es>

ENV ADMIN_PASSWORD "Admin#12345"
ENV MYSQL_URI "jdbc:mysql://localhost:3306/tunning"
ENV MYSQL_USER  "tunning"
ENV MYSQL_PASSWORD "tunning"


EXPOSE 8080
EXPOSE 9990

ENV WILDFLY_HOME=/opt/jboss/wildfly

VOLUME /opt/tunning/
VOLUME /opt/jboss/wildfly/standalone/log


ADD ../scripts /opt/customization/
ADD scripts /opt/customization/

ADD http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.39/mysql-connector-java-5.1.39.jar /opt/customization/


ENV TZ=Europe/Madrid
USER root

RUN  ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN chmod 755 -c /opt/customization/*.sh
RUN chown jboss:jboss  /opt/customization/mysql-connector-java-5.1.39.jar

USER jboss

CMD ["/opt/customization/execute.sh"]


