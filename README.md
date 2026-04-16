# Sistema de Gestão de Tarefas - Desafio Técnico ESIG Group

Aplicação web de gerenciamento de tarefas desenvolvida como parte do processo seletivo da ESIG Group.

## Itens Implementados:

- **a)** Aplicação Java Web utilizando JavaServer Faces (JSF), sei que nao houve especficacao e que jakarta faces e jsf
  sao basicamente a mesma coisa, mas optei por jsf 2.23.
- **b)** Persistência em banco de dados Postgres.
- **c)** Compliance jpa com Hibernate como implementação
- **d)** Testes de unidade com JUnit 5 e Mockito

## Funcionalidades

- Cadastro e listagem de responsáveis.
- Cadastro de tarefas com título, descrição, responsável, prioridade e deadline.
- Listagem de tarefas com filtros por número, título/descrição, responsável e situação.
- Edição de tarefas.
- Soft delete de tarefas.
- Conclusão de tarefas.

## Tecnologias

- Java 21
- JavaServer Faces (JSF) 2.3 + Mojarra
- Hibernate
- PostgreSQL
- Weld
- JUnit + Mockito
- Apache Tomcat 9.0
- Maven
- Docker

## Pré-requisitos

- Java 21
- Maven
- Docker e Docker Compose

## Execução rápida

```bash
chmod +x run.sh
./run.sh
```

Aguarde alguns segundos e acesse:
http://localhost:8080/sigtarefa/cadastroDeResponsaveis.xhtml