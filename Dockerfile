FROM maven:latest AS MAVEN_BUILD
#FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./
 
# package our application code
RUN mvn clean package -DskipTests=true
RUN ls -al target
#RUN pwd

FROM tomcat:9.0
MAINTAINER man24@yandex.ru
EXPOSE 8080
RUN rm -fr /usr/local/tomcat/webapps/ROOT*
COPY --from=MAVEN_BUILD /target/gwt-spring-boot.war /usr/local/tomcat/webapps/ROOT.war
#CMD [“catalina.sh”, “run”]
