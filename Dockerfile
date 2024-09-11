# Utiliza uma imagem base com JDK 17 (ou outra versão compatível com sua aplicação)
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

RUN apk add --no-cache bash

COPY wait-for-it.sh /app/wait-for-it.sh

RUN chmod +x /app/wait-for-it.sh

# Copia o arquivo JAR gerado pela aplicação para dentro do container
COPY target/ApiRestFul-RedeSocial-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponha a porta onde o Spring Boot rodará
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["./wait-for-it.sh", "database:3306", "--", "java", "-jar", "app.jar"]
