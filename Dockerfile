FROM tomcat:9
WORKDIR /usr/local/tomcat/webapps
COPY quizapp.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
