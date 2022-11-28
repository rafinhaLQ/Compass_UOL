<h1 align="center">Programa de Bolsas Spring Boot Compass_UOL</h1>
Esse repositório contém as avaliações das sprints, de Rafael Luz de Queiroz, do programa de bolsas Spring Boot realizado pela empresa Compass_UOL.

**********

[Sprint 1](#sprint1)

[Sprint 2](#sprint2)

[Sprint 3](#sprint3)

[Sprint 4](#sprint4)

**********

<div id='sprint1'>

## Sprint 1

**Questão 1**

**a.** O tempo máximo da Daily deveria ser 15 minutos. Tendo em vista que a reunião é diaria e é necessário responder apenas 3 perguntas por membro.

**b.** O tempo máximo da Planning deveria ser pelo menos 5 horas. Levando em consideração que temos que analisar o rendimento do time e planejar uma sprint que traga resultados significativos em relação ao tempo.

**c.** O tempo máximo da Review deveria ser no máximo 2 horas. Por conta que é uma cerimônia para analisar o resultado da sprint e determinar futuras adaptações.

**d.** O tempo máximo da Retrospectiva deveria ser 2 horas. Pela necessidade de analisar o time, ver seus erros e acertos e fazer os ajustes necessários.


**Questão 2**
O Framework Scrum é uma forma de organizar as demandas do projeto e realizar os serviços. O Scrum é uma maneira eficiente de produzir produtos complexos, abertos a mudanças e de uma maneira mais eficiente.
Essa estrutura funciona dividindo os integrantes do time em 3, Product Owner, Time de desenvolvimento e Scrum Master, para maximizar a eficiência da produção, incentivando o trabalho em equipe e a comunicação. Uma outra boa prática dessa estrutura também é a realização de reuniões, chamadas de eventos, esses eventos são bem organizados e definidos para evitar outras reuniões e perdas desnecessárias na produção.
Outro grande fator no Scrum é a implementação do sistema de Sprints, que servem para dividir a produção do produto e gerar um protótipo utilizável para aprovação e analise de possível mudança e/ou incremento, assim conseguindo corrigir qualquer eventualidade.


**Questão 3**
Esse problema ocorreu devido à não adicionar os arquivos ao commit. Esse problema pode ser facilmente resolvido utilizando o comando "git add ." ou de forma mais específica "git add README.md Product.js".


**Questão 4**
Para desconsiderar os arquivos indesejados o time de desenvolvimento deve adicionar a lista de extensões em um arquivo ".gitignore".


**Questão 5**
As novas responsabilidades de José no seu novo cargo de Product Owner são: Apresentar e organizar os itens da Backlog, organizando-os de maneira de melhorar a produção, garantir que o time de desenvolvimento entenda os itens da Backlog e garantir o valor de trabalho do time.


### **Documentação**
**Questão 7**

O sistema da questão 7 só tem suporte para um usuário, se tentar criar outro usuário ele será salvo no mesmo local do último usuário, assim o substituindo.



<div id='sprint2'>

## Sprint 2

### **Documentação**

**Questão 1**

O sistema da questão 1 foi desenvolvido em **Java 19**, utiliza as seguintes bibliotecas externas e as seguintes versões:
* MySQL Connector Java 8.0.17
* c3p0 0.9.5.4
* Mchange Commons Java 0.2.16

Para configuração do banco de dados. Está na pasta de ScriptsSQL, dentro de Sprint2, o script ScriptSQLQuestao1 para criação do esquema, e da tabela produtos.
Também é importante no construtor da classe **ConnectionFactory.java** especificar a url, login e senha do seu banco.

Segue também algumas imagens mostrando o funcionamento do sistema visualmente no banco de dados:
* Banco depois de ser criado.

![aposCriarBanco](https://user-images.githubusercontent.com/87668199/198833842-81a25823-f9c7-45f8-83e9-84a24d5c3ae6.png)

* Banco depois de cadastrar os produtos.

![aposCadastrarProdutos](https://user-images.githubusercontent.com/87668199/198833919-6d0622d3-861c-4ab0-ab59-3cf5d8d0d11f.png)

* Banco depois de atualizar primeiro produto.

![aposAtualizarPrimeiroProduto](https://user-images.githubusercontent.com/87668199/198833965-a2ae03c8-8703-4e63-92be-c3ea0df7b2df.png)

* Banco depois de excluir o segundo produto.

![aposExcluirSegundoProduto](https://user-images.githubusercontent.com/87668199/198834002-d518c9bd-8c87-47fc-8b32-d2726b89bbd4.png)



**Questão 2**

O sistema da questão 2 foi desenvolvido em **Java 19**, utiliza as seguintes bibliotecas externas e as seguintes versões:
* MySQL Connector Java 8.0.17
* c3p0 0.9.5.4
* Mchange Commons Java 0.2.16

Para configuração do banco de dados. Está na pasta de ScriptsSQL, dentro de Sprint2, o script ScriptSQLQuestao2 para criação do esquema, da tabela filmes, e a inserção dos 20 filmes.
Também é importante no construtor da classe **ConnectionFactory.java** especificar a url, login e senha do seu banco.

Nesse sistema só tem 2 páginas de 10 filmes cada.



**Questão 3**

O programa da questão 3 recebe múltiplas entradas até receber uma entrada vazia, assim se encerrando.



<div id='sprint3'>

## Sprint 3

### **Documentação**

**Questão 1**

O sistema da questão 1 foi desenvolvido em **Java 19**.

O arquivo **.yaml** da documentação **Swagger** está em **src/main/resources/openapi.yaml**.

O banco de dados está sendo inicializado com todos os estados do Brasil, no **data.sql**.

No endpoint **PUT** os unicos atributos alterados serão o nome da Capital e a população, por razões que não faria muito sentido alterar os outros atributos.

<div id='sprint4'>

## Sprint 4

O sistema da questão 1 foi desenvolvido em **Java 17**.

A dependência Springdoc OpenAPI está instalada, para acessar o Swagger da aplicação, com a aplicação rodando, acesse a URL `http://localhost:8080/swagger-ui/index.html`.

Os associados e partidos inicializados no `data.sql` não estão vinculados entre si.

Exemplos de filtro e ordenação dos endpoints GET no Postman:

Endpoint GET - /associados

![image](https://user-images.githubusercontent.com/87668199/204184431-a91ca692-6aad-4a58-a500-3b5c90f40dda.png)

Endpoint GET - /partidos

![image](https://user-images.githubusercontent.com/87668199/204184656-085b00d7-2364-4b67-a342-1b5f959672f2.png)
