FROM openjdk:8-jre-slim

#about me
MAINTAINER Mihayluk Vitaliy "mihayluk@gmail.com"

#create folder with tests
RUN mkdir -p /tests

# Add the project jar & copy dependencies
ADD  target/container-test.jar /usr/share/tag/container-test.jar
ADD  target/libs /usr/share/tag/libs

# Add the suite xmls
ADD base-functionality.xml /usr/share/tag/base-functionality.xml

ENTRYPOINT /usr/bin/java -cp /usr/share/tag/container-test.jar:/usr/share/tag/libs/* -DseleniumHubHost=$SELENIUM_HUB -Dbrowser=$BROWSER org.testng.TestNG /usr/share/tag/$MODULE && ls