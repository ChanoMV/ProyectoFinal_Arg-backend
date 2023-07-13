FROM amazoncorretto:1.8-alpine-jdk // de que imagen partimos
MAINTAINER mr54289 //quien es el dueño
COPY target.mr54289-0.0.1-SNAPSHOT.jar mr54289-app.jar              //va a copiar el empaquetado a github
ENTRYPOINT ["java","-jar","/mr54289-app.jar"]      //es la instruccion que se ejecuta primero