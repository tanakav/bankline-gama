# Bankline Gama

API de um Bankline com cadastro de usuário, plano de contas e lançamentos. Também é possível visualizar os lançamentos de determinado usuário através do dashboard. O usuário é autenticado por JWT e os endpoints protegidos pelo Spring Security com exceção do endpoint de criação de usuário.
Este projeto foi proposto como desafio final da Academia Accenture promovido pela parceria entre Gama Academy e Accenture. Foi utilizado as tecnologias **Spring Boot, H2, Spring Security, JWT e Swagger**.

A documentação da API pode ser acessada em  [https://bankline-gamaacademy.herokuapp.com/swagger-ui.html](https://bankline-gamaacademy.herokuapp.com/swagger-ui.html)

## Javeiros de Konoha

-   **[Murilo Sérgio Rodrigues Júnior](https://github.com/murilosrj1990)**:  Realizou a construção da estrutura inicial com entidades, controllers e repositories, a codificação da parte relacionada a Lançamentos, configuração do Swagger e deploy no Heroku.
-   **[Vivian Tanaka](https://github.com/tanakav)**:  Realizou a codificação das partes relacionadas ao Usuário, Contas, Dashboard, ajustes em Lançamentos e Segurança Spring Security e JWT.
-   **[William Silva de Jesus](https://github.com/WilliamJesusDev)**:  Realizou ajustes Segurança Spring Security e JWT e implementação da funcionalidade de troca de senha.

## Endpoints

### Usuário
#### 1. Criação de novo usuario
**`POST /usuarios`**

Ao criar um novo usuário é criado automatomaticamente duas contas (conta de débito e conta de crédito) e três planos de conta padrão (DESPESA PADRÃO, RECEITA PADRÃO e TRANSFERENCIA PADRÃO).

Paramêtros do body em JSON:
- nome: String
- login: String
- cpf: String
- senha: String
			
#### 2. Busca de usuário por id 
**`GET /usuarios/{id}`**

Parâmetro de caminho (PathVariable):
- id: Integer

#### 3. Busca de contas por login de usuário 
**`GET /usuarios/contas/{login}`**

Parâmetro de caminho (PathVariable):
- login: String

### Lançamentos
#### 1. Criação de novo lançamento
**`POST /lancamentos`**

Ao criar um novo lançamento, o saldo da(s) conta(s) envolvida(s) são atualizadas para refletir o tipo movimento do lançamento.
Parâmetros do body JSON:
- data: Date em formato yyyy-MM-dd
- conta: Integer
- descricao: String
- planoConta: Integer
- valor: Double

#### 2. Criação de novo plano de conta 
**`POST /lancamentos/planos-conta`**

Parâmetros do body JSON:
- descricao: String
- login: String
- padrao: Boolean
- tipoMovimento: Integer

#### 3. Busca de planos de conta por login de usuário 
**`GET /lancamentos/planos-conta/{login}`**

Parâmetro de caminho (PathVariable):
- login: String

### Dashboard
#### 1. Relação de lançamentos por conta por período 
`GET /dashboard?login={login}&dataInicial={dataInicial}&dataFinal={dataFinal}`

É obrigatório informar o período e login.
Parâmetros de query (RequestParam):
- login: String
- dataInicial: Data em String em formato yyyy-MM-dd
- dataFinal: Data em String em formato yyyy-MM-dd

### Login
#### 1. Autenticação e geração de token JWT 
`POST /login`

Parâmetros do body JSON:
- login: String
- senha: String
