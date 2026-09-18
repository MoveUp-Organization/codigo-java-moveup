<h1 align="center">MoveUp</h1>

<p align="center">
  Solução de mobilidade urbana sustentável desenvolvida para o<br>
  <strong>Challenge SoulUP — FIAP</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
  <img src="https://img.shields.io/badge/JDBC-007396?style=for-the-badge">
  <img src="https://img.shields.io/badge/FIAP-Challenge-ED145B?style=for-the-badge">
</p>

---

## Sobre o projeto

A **MoveUp** é uma solução desenvolvida para o Challenge SoulUP — FIAP com foco em mobilidade urbana sustentável.

A proposta busca incentivar escolhas de transporte mais sustentáveis e ampliar o acesso à mobilidade por meio de benefícios, missões, pontos e vouchers integrados ao ecossistema da SoulUP.

Este repositório contém a implementação em **Java** desenvolvida para a **Sprint 3**, com persistência de dados em **Oracle Database** utilizando **JDBC**.

---

## Funcionalidades

A aplicação contempla o gerenciamento das principais entidades da MoveUp:

- Cadastro e gerenciamento de usuários;
- Gerenciamento de missões;
- Gerenciamento de meios de transporte;
- Gerenciamento de vouchers;
- Consulta e persistência de dados;
- Operações de cadastro, leitura, atualização e exclusão.

---

## Tecnologias

| Tecnologia | Aplicação no projeto |
| --- | --- |
| **Java** | Desenvolvimento da aplicação e regras de negócio |
| **Oracle Database** | Persistência dos dados |
| **JDBC** | Comunicação entre Java e banco de dados |
| **SQL** | Manipulação e consulta dos registros |
| **IntelliJ IDEA** | Ambiente de desenvolvimento |
| **Git** | Controle de versão |
| **GitHub** | Versionamento e colaboração |

---

## Arquitetura

A aplicação utiliza separação de responsabilidades para manter o código organizado e facilitar sua manutenção.

| Camada | Responsabilidade |
| --- | --- |
| **Model** | Representação das entidades da aplicação |
| **DAO** | Acesso e manipulação dos dados |
| **Connection** | Gerenciamento da conexão com o banco Oracle |
| **Test** | Validação e execução das funcionalidades desenvolvidas |

O acesso ao banco segue o seguinte fluxo:

```text
Aplicação Java
      |
     DAO
      |
     JDBC
      |
Oracle Database
```

---

## Persistência de dados

As operações de persistência são realizadas por meio do padrão **DAO (Data Access Object)** e utilizam JDBC para comunicação com o Oracle Database.

O projeto implementa as operações fundamentais de CRUD:

| Operação | Comando SQL | Finalidade |
| --- | --- | --- |
| **Create** | `INSERT` | Cadastrar novos registros |
| **Read** | `SELECT` | Consultar registros |
| **Update** | `UPDATE` | Atualizar informações |
| **Delete** | `DELETE` | Remover registros |

---

## Conceitos aplicados

Durante o desenvolvimento foram aplicados conceitos estudados na disciplina **Domain Driven Design Using Java**, entre eles:

- Programação Orientada a Objetos;
- Encapsulamento;
- Classes, objetos, atributos e métodos;
- Construtores;
- Organização e separação de responsabilidades;
- Padrão DAO;
- Persistência de dados;
- JDBC;
- SQL;
- CRUD.

---

## Como executar

### Pré-requisitos

Antes de executar o projeto, é necessário possuir:

- JDK instalado;
- IntelliJ IDEA ou outra IDE compatível com Java;
- Acesso ao Oracle Database;
- Driver JDBC do Oracle;
- Git instalado para clonagem do repositório.

### 1. Clone o repositório

```bash
git clone https://github.com/MoveUp-Organization/codigo-java-moveup.git
```

### 2. Acesse o projeto

```bash
cd codigo-java-moveup/MoveUp
```

### 3. Abra na IDE

Abra a pasta do projeto no IntelliJ IDEA ou em outra IDE compatível com Java.

### 4. Configure o banco de dados

Configure os dados necessários para conexão com o Oracle Database:

- URL de conexão;
- Usuário;
- Senha;
- Driver JDBC.

> Nunca publique credenciais ou informações sensíveis de acesso ao banco de dados no repositório.

### 5. Execute

Com o ambiente e a conexão configurados, execute as classes responsáveis pela inicialização ou pelos testes das funcionalidades.

---

## Challenge

**Empresa parceira:** SoulUP  
**Instituição:** FIAP  
**Disciplina:** Domain Driven Design Using Java  
**Entrega:** Sprint 3  

---

<p align="center">
  <strong>MoveUp</strong><br>
  Mobilidade urbana, tecnologia e sustentabilidade.
</p>
