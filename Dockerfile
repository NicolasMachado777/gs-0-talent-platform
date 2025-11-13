# Imagem base com JDK 17
FROM maven:3.9.9-eclipse-temurin-17
#FROM eclipse-temurin:17-jre-alpine


COPY . /opt/app

WORKDIR /opt/app

RUN mvn clean package -DskipTests

# Expõe a porta 8081 (a mesma configurada no application.properties)
EXPOSE 8081

# Comando de inicialização
CMD ["java","-jar","target/app.jar"]