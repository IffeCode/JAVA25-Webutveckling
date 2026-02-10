#1 Select a base image
FROM tomcat:11.0-jdk25

#2 Remove the deafault application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

#3 Copy new default application - GritCRM-1.0-SNAPSHOT.war till
#3.1 .war i slutet är super viktigt!!!!
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

#4 Expose tomcats default parts
EXPOSE 8080

#5 Start tomcat
CMD ["catalina.sh", "run"]