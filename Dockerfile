#FROM ubuntu:latest
#LABEL authors="slged"
#
#ENTRYPOINT ["top", "-b"]

# JDK sürümü
FROM openjdk:17

# Bilgilerndirme
LABEL maintainer="hamitmizrak@gmail.com"

# Persist Data (Kalıcık Veri)
VOLUME /tmp

# Port
EXPOSE 4444

# Değişken
ARG JAR_FILE=/target/*.jar

# Değişkeni ekle
ADD ${JAR_FILE} docker_todo_react

ENTRYPOINT ["java","-jar","/docker_todo_react"]