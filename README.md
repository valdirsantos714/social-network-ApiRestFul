# Api de Rede Social Com Spring Boot 3

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
  