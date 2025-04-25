Como rodar a aplicação?

No postman crie o endpoint 

POST

http://localhost:8080/transfer

corpo Json

<pre lang="json">
{
    "value": 100.00,
    "payer": 1,
    "payee": 2
}
</pre>
Lembre-se que o usuário 1 e 2 são tipo COMUM então eles podem fazer e receber transações.

O usuário 3 é tipo LOJISTA então só pode receber.

comandos sql para usar na base de dados
<pre lang="SQL">
  SELECT * FROM usuario;
  SELECT * FROM transacao;
  SELECT * FROM carteira;;
</pre>

401 unauthorized -> Essa exeção acontece quando você tem a dependência Spring Security no projeto e não configurou.

<h1>Transação simplificado
</h1>

<h2> Este projeto foi criado com base em um desafio tecnico pra transações entre contas bancarias </h2>

<h3>Tecnologias usadas</h3>
Springboot - para simplificar as configurações iniciais do projeto

PostgreSQL - banco de dados relacionais para amazenamento dos dados

SpringDataJPA - Para persistencia de dados

SpringWeb - Construção web, incluindo RESTfull, aplicação usando Spring MVC. Usa o Apache Tomcat como contêiner incorporado padrão.

SpringDevTools - Para live reload

Lombok - para código boilerplate

Openfeign - Biblioteca para comunicação entre microserviços

Spring cloud Security -> para o encriptamento dos seus dados

SpringValidation -> para validação da api, como campos unicos, validos nulos e não nulos... etc.

IDEA-Intellij -> Ambiente de desesnvolvimento integrado para codificação do desenvolvedor

SGBD-pgadmin -> Sistema de gerenciamento de banco de dados.

Gerenciador de dependências- Gradle

JAX-RX ou Java API for RESTful Web Services. Essa API permite que os desenvolvedores construam aplicações que se comunicam através do protocolo HTTP, utilizando os princípios REST (Representational State Transfer);
