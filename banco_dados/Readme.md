
![image](https://github.com/rxaviersantos/BootcampWEX/assets/85380530/710bf6b0-79e6-4711-b5b0-db9cf8eb9296)

<h1 align="center"> Estrutura do Banco de Dados: Agência de Viagens </h1>

<p align="center">
  Atividade Prática do Módulo 4
</p>

<p align="center">
  <img alt="License" src="https://img.shields.io/badge/License-MIT-green.svg"> <img alt="License" src="https://img.shields.io/badge/java_8-✓-blue.svg"> <img alt="License" src="https://img.shields.io/badge/mysql-✓-blue.svg"
</p>


### <img width="24" height="24" src="https://img.icons8.com/external-tal-revivo-shadow-tal-revivo/24/external-mysql-an-open-source-relational-database-management-system-logo-shadow-tal-revivo.png" alt="external-mysql-an-open-source-relational-database-management-system-logo-shadow-tal-revivo"/>  Tabelas:

``` 
Usuario:
id_usuario (INT, Chave Primária, Auto-incremento): Identificador único do usuário.
email_usuario (VARCHAR(50), Índice): Endereço de e-mail do usuário.
senha_usuario (VARCHAR(12)): Senha do usuário.
dataCadastro_usuario (DATETIME): Data e hora de cadastro do usuário.
```
```
Cliente:
cpf_cliente (VARCHAR(11), Chave Primária): CPF único do cliente.
id_usuario (INT): Identificador do usuário relacionado (Chave Estrangeira).
email_cliente (VARCHAR(50)): Endereço de e-mail do cliente.
telefone_cliente (VARCHAR(11)): Número de telefone do cliente.
nome_cliente (VARCHAR(60)): Nome do cliente.
INDEX idx_email_usuario (email_usuario): Índice na coluna email_usuario
```

```
Pedido:
num_pedido (INT, Chave Primária, Auto-incremento): Número único do pedido.
id_usuario (INT): Identificador do usuário que fez o pedido (Chave Estrangeira).
data_pedido (DATETIME): Data e hora do pedido.
formaPag_pedido (VARCHAR(20)): Forma de pagamento do pedido.
precoTotal_pedido (DECIMAL(12)): Preço total do pedido.
```

```
Passagem:
id_passagem (INT, Chave Primária, Auto-incremento): Identificador único da passagem.
num_pedido (INT): Número do pedido associado (Chave Estrangeira).
qtde_passagem (INT): Quantidade de passagens no pedido.
```
*Relacionamentos:*
A tabela `Cliente` tem um relacionamento com a tabela `Usuario` usando a chave estrangeira id_usuario, representando que um cliente está associado a um usuário.
A tabela `Pedido` tem um relacionamento com a tabela `Usuario` usando a chave estrangeira id_usuario, indicando que um pedido é feito por um usuário específico.
A tabela `Passagem` tem um relacionamento com a tabela `Pedido` usando a chave estrangeira num_pedido, mostrando que uma passagem está associada a um pedido.

*Índices:* 
Um índice foi criado na coluna email_usuario da tabela `Usuario` para otimizar consultas que envolvam o endereço de e-mail dos usuários.

Esta documentação fornece uma visão clara e concisa da estrutura do seu banco de dados para o projeto da Agência de Viagens. 