# Usar una imagen base de Java
FROM openjdk:11-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado a la imagen del contenedor
COPY target/buyer-service-0.0.1-SNAPSHOT.jar /app/buyer-service.jar

# Exponer el puerto que la aplicación usará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/buyer-service.jar"]


