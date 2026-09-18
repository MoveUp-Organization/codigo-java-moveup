````markdown
# MoveUp — Java

Projeto desenvolvido em Java para o **Challenge SoulUP — FIAP**, na disciplina de **Domain Driven Design Using Java**.

A aplicação faz parte da solução **MoveUp**, voltada à mobilidade urbana sustentável, e utiliza **Oracle Database** e **JDBC** para persistência e manipulação de dados.

---

## Sobre o projeto

A MoveUp é uma solução criada para incentivar o uso de meios de transporte mais sustentáveis e tornar a mobilidade urbana mais acessível.

O projeto integra benefícios, missões, pontos e vouchers ao ecossistema da SoulUP, utilizando recursos de gamificação para estimular hábitos de mobilidade mais sustentáveis.

---

## Objetivo

Nesta etapa do Challenge, o objetivo é aplicar os conceitos estudados em Java para representar e gerenciar as principais entidades da aplicação.

O sistema permite realizar operações de cadastro, consulta, atualização e exclusão de dados, além da integração com banco de dados Oracle.

---

## Funcionalidades

A aplicação contempla o gerenciamento de:

- Usuários;
- Missões;
- Transportes;
- Vouchers;
- Dados armazenados no banco Oracle;
- Operações de CRUD.

---

## Tecnologias utilizadas

| Tecnologia | Utilização |
|---|---|
| Java | Desenvolvimento da aplicação |
| Oracle Database | Armazenamento dos dados |
| JDBC | Integração entre Java e banco de dados |
| SQL | Manipulação e consulta dos dados |
| IntelliJ IDEA | Ambiente de desenvolvimento |
| Git | Controle de versão |
| GitHub | Hospedagem do repositório |

---

## Conceitos aplicados

Durante o desenvolvimento foram utilizados conceitos como:

- Programação Orientada a Objetos;
- Classes e objetos;
- Encapsulamento;
- Construtores e métodos;
- Organização em pacotes;
- Persistência de dados;
- Padrão DAO;
- JDBC;
- CRUD;
- Separação de responsabilidades.

---

## Arquitetura

O projeto utiliza separação de responsabilidades entre as diferentes partes da aplicação.

### Model

Responsável pela representação das entidades e de seus dados.

### DAO

As classes DAO (`Data Access Object`) são responsáveis pela comunicação com o banco de dados e pela execução das operações de inserção, consulta, atualização e exclusão.

### Connection

Responsável por estabelecer a conexão entre a aplicação Java e o Oracle Database por meio do JDBC.

### Test

Utilizado para executar e validar as funcionalidades implementadas.

---

## Banco de dados

A persistência dos dados é realizada utilizando **Oracle Database**.

A comunicação entre a aplicação e o banco ocorre por meio do **JDBC (Java Database Connectivity)**.

Fluxo simplificado:

```text
Aplicação Java
      ↓
     DAO
      ↓
     JDBC
      ↓
Oracle Database
````

---

## CRUD

As principais operações realizadas pela aplicação são:

| Operação | SQL      | Descrição             |
| -------- | -------- | --------------------- |
| Create   | `INSERT` | Cadastrar um registro |
| Read     | `SELECT` | Consultar registros   |
| Update   | `UPDATE` | Atualizar um registro |
| Delete   | `DELETE` | Excluir um registro   |

---

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/MoveUp-Organization/codigo-java-moveup.git
```

### 2. Acesse o projeto

```bash
cd codigo-java-moveup
```

### 3. Abra o projeto

Abra o projeto em uma IDE compatível com Java, como o IntelliJ IDEA.

### 4. Configure o banco de dados

Para utilizar as funcionalidades que dependem do banco, configure a conexão com o Oracle Database.

São necessários:

* URL de conexão;
* Usuário;
* Senha;
* Driver JDBC do Oracle.

> Dados sensíveis, como usuário e senha do banco de dados, não devem ser publicados no repositório.

### 5. Execute a aplicação

Após configurar o ambiente e o banco de dados, execute as classes responsáveis pela inicialização ou pelos testes das funcionalidades.

---

## Contexto acadêmico

Projeto desenvolvido para o **Challenge SoulUP — FIAP**, na disciplina de **Domain Driven Design Using Java**.

---

## Repositório

https://github.com/MoveUp-Organization/codigo-java-moveup

---

## Status

Projeto acadêmico em desenvolvimento.

```

Essa versão fica mais limpa e evita repetir várias vezes que é Challenge, SoulUP, FIAP, mobilidade sustentável e Java.
```
