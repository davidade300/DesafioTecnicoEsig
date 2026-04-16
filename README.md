### Estrutura do Projeto

- Decidi fazer o projeto seguindo uma estrutura de arquitetura de camadas, utilizando hibernate para fazer o mapeamento
  objeto relacional das entidades, repositorios para isolar o acesso a dados e service para orquestrar os repositórios.

### Rodando o projeto Localmente:

- Basta instalar o servidor Apache tomcat 9:
  > https://tomcat.apache.org/download-90.cgi
- ....

# TODOS :

- adicionar no controller de tarefa metodo que:
    1. vai para o cadastro de tarefas
    2. vai para a listagem de tarefas
- adicionar no controller de responsavel metodo que:
    1. vai apra cadastro de responsaveis;
    2. vai para a listagem de tarefas;

- criar os arquivos de view de acordo com os nomes retornados nos metodos do controller de Tarefa.

### Notas:

- Deixei a exclusão como softDelete.
- Pulei a documentação de algumas coisas por questão de tempo disponível para entrega do projeto. Procurei documentar
  tudo que acho de maior relevância, seja método ou classe.

#   