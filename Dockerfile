FROM tomcat:9-jre10
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY ./target/Autoservice.war /usr/local/tomcat/webapps/ROOT.war
ADD wait-for-it.sh .
CMD ["./wait-for-it.sh", "autoservice-mysql:3306", "-t", "45", "--", "catalina.sh","run"]