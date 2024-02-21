# RESTful Social Network API With Spring Boot 3

## About this repository
This repository contains an Api created with Java and Spring Boot 3 simulating a social network api, in which users can post and can also make comments on their and others' posts.

## Purposes of Use:

- Query Users, Posts or Comments: Users can easily enter, search, view and delete information about available users, posts and comments.


- Simple Integration: Designed to be easily integrated into frontend applications or any other platform that needs to manage users, posts and comments.

## Functionalities
- Insert
- To update
- Delete
- To view
- View by ID

## Technologies used
- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- Validation
- Maven
- MySQL Driver
- MySQL Database
- JPA/Hibernate

## UML Diagram
![diagrama](https://github.com/valdirsantos714/social-network-ApiRestFul/blob/main/src/main/java/com/valdirsantos714/ApiRestFulRedeSocial/assets/diagrama.PNG)

## Prerequisites
Make sure you have the following tools installed on your machine:

- Java Development Kit (JDK) - version 17.
- Maven - for dependency management and project construction.

## Installation
- Clone the repository:
- `$ git clone https://github.com/valdirsantos714/account-management-api`
- Install dependencies with Maven
- Configure the database properties in the `application.properties` and `application-dev.properties` file.
- Run the application locally.

## How to make Requests

Place the link `http://localhost:8080` in Postman or any other collaboration platform for API development with the following endpoints:

- `GET /users` - To return a list of all users, account or products.

- `GET /users/{id}` - To return a specific object.

- `POST /users` - To save a new object to the database.

- `PUT /users` - To change an object.

- `DELETE /users/{id}` - To delete a specific object.

=================================================

# API RESTful de Rede Social Com Spring Boot 3

## Sobre este repositório
Este repositório contém uma Api criada com Java e Spring Boot 3 simulando uma api de rede social, na qual os usuários podem fazer postagens e também podem fazer comentários nas postagens suas e nas dos outros.

## Finalidades de Uso:

- Consulta de Usuários, Postagens ou Comentários : Os usuários podem facilmente inserir, buscar, visualizar e deletar informações sobre usuários, postagens e comentários disponíveis.


- Integração Simples: Projetado para ser facilmente integrado a aplicações frontend ou qualquer outra plataforma que necessite gerenciar usuários, postagens e comentários.

## Funcionalidades
- Inserir
- Atualizar
- Deletar
- Visualizar
- Visualizar por Id

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- Validation
- Maven
- MySQL Driver
- Banco de Dados MySQL
- JPA / Hibernate

## Diagrama UML
![diagrama](https://github.com/valdirsantos714/social-network-ApiRestFul/blob/main/src/main/java/com/valdirsantos714/ApiRestFulRedeSocial/assets/diagrama.PNG)

## Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java Development Kit (JDK) - versão 17.
- Maven - para gerenciamento de dependências e construção do projeto.

## Instalação
- Clone o repositório:
- `$ git clone https://github.com/valdirsantos714/account-management-api`
- Instale dependências com Maven
- Configure as propriedades do banco de dados no arquivo `application.properties` e no `application-dev.properties`.
- Execute a aplicação localmente.

## Como fazer Requisições

Coloque no Postman ou em qualquer outra plataforma de colaboração para desenvolvimento de API o link `http://localhost:8080` com os seguintes endpoints:

- `GET /users` - Para retornar uma lista de todos os usuários, conta ou produtos.

- `GET /users/{id}` - Para retornar um objeto específico.

- `POST /users` - Para salvar um novo objeto no banco de dados.

- `PUT /users` - Para alterar um objeto.

- `DELETE /users/{id}` - Para excluir um determinado objeto.
  