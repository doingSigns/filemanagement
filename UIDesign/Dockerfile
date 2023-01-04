
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM maven:3-jdk-11

RUN apt-get update && apt-get install libgtk-3-0 libglu1-mesa xvfb -y && apt-get update

RUN apt-get install xvfb

RUN apt-get install openssh-client

# WORKDIR /apps/fm

# COPY . /apps/fm

##RUN mvn clean install

##CMD mvn exec:java -Dexec.mainClass="com.mycompany.fileManager.App"

