<h1 align="center"> Agência de Viagens</h1>

<p align="center">
  Atividade Prática do Módulo 4
</p>

<p align="center">
  <img alt="License" src="https://img.shields.io/badge/License-MIT-green.svg"> <img alt="License" src="https://img.shields.io/badge/java_8-✓-blue.svg"> <img alt="License" src="https://img.shields.io/badge/mysql-✓-blue.svg"
</p>


### 💥 Projeto 

Este é um projeto básico de uma agência de viagens, onde é possível realizar operações relacionadas a usuários, pedidos e passagens. O projeto foi desenvolvido utilizando as seguintes tecnologias:

### ⚒️ Tecnologias Utilizadas

*Java:* A linguagem de programação principal usada para desenvolver a lógica do back-end.

*MySQL:* Sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados da aplicação.

*Padrão de Projeto MVC (Model-View-Controller):* Arquitetura utilizada para organizar o código fonte, separando as responsabilidades de modelos, visualizações e controladores.

### 📲 Funcionalidades

O projeto oferece operações CRUD (Create, Read, Update, Delete) básicas para as entidades principais:

- Usuário: Cadastro de usuários com informações como nome, e-mail e cpf.

- Pedido: Registro de pedidos com detalhes sobre o usuário associado, data do pedido, forma de pagamento e preço total.

- Passagem: Registro de passagens associadas a um pedido específico, indicando a quantidade de passagens.

### 🧵 Como Rodar o Projeto

1. Configuração do Banco de Dados: Antes de executar o projeto, é necessário configurar um banco de dados MySQL com as tabelas necessárias (Usuario, Pedido, Passagem) conforme descrito no início deste README.

2. Configuração do Projeto Java: Abra o projeto em sua IDE favorita que suporte Java. Certifique-se de configurar as informações de conexão com o banco de dados (URL, usuário, senha) nas classes de DAO (UsuarioDAO, PedidoDAO, PassagemDAO).

3. Execução do Projeto: Após configurar o banco de dados e as classes de DAO, você pode executar o projeto. Ao fazer isso, o back-end estará pronto para receber requisições relacionadas às funcionalidades mencionadas.

### 🎡 Endpoints da API

O projeto possui endpoints básicos para cada entidade. Você pode acessar esses endpoints para realizar operações CRUD usando um cliente HTTP, como o Postman ou URL. Aqui estão alguns exemplos de endpoints:

    GET /usuarios: Retorna todos os usuários cadastrados.
    GET /usuarios/{id}: Retorna o usuário com o ID especificado.
    POST /usuarios: Cria um novo usuário com base nos dados fornecidos.
    PUT /usuarios/{id}: Atualiza as informações do usuário com o ID especificado.
    DELETE /usuarios/{id}: Exclui o usuário com o ID especificado.
    (Análogos endpoints para pedidos e passagens)

### 🏷️ Importante Notar

Este projeto é um exemplo básico e não foi desenvolvido com foco em aspectos de segurança, escalabilidade ou otimização de desempenho. Antes de utilizar em um ambiente de produção, é fundamental realizar aprimoramentos significativos, como:

*Validações de Dados:* Adicionar validações para garantir a integridade e segurança dos dados.

*Segurança:* Implementar autenticação e autorização adequadas para proteger os endpoints sensíveis.

*Tratamento de Exceções:* Adicionar tratamento de exceções robusto para lidar com erros de forma adequada.

*Optimização de Consultas:* Otimizar consultas ao banco de dados para melhorar o desempenho da aplicação.

