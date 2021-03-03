# Bankline Gama

API de um Bankline com cadastro de usuário, plano de contas e lançamentos. Também é possível visualizar os lançamentos de determinado usuário através do dashboard. O usuário é autenticado por JWT e os endpoints protegidos pelo Spring Security com exceção do endpoint de criação de usuário.
Este projeto foi proposto como desafio final da Academia Accenture promovido pela parceria entre Gama Academy e Accenture. Foi utilizado as tecnologias **Spring Boot, H2, Spring Security, JWT e Swagger**.

A documentação da API pode ser acessada em  [https://bankline-gamaacademy.herokuapp.com/swagger-ui.html](https://bankline-gamaacademy.herokuapp.com/swagger-ui.html)

## Javeiros de Konoha

-   **[Murilo Sérgio Rodrigues Júnior](https://github.com/murilosrj1990)**:  Realizou a construção da estrutura inicial com entidades, controllers e repositories, a codificação da parte relacionada a Lançamentos, configuração do Swagger e deploy no Heroku.
-   **[Vivian Tanaka](https://github.com/tanakav)**:  Realizou a codificação das partes relacionadas ao Usuário, Contas, Dashboard, ajustes em Lançamentos e Segurança Spring Security e JWT.

## Endpoints

### Usuário
- Criação de novo usuario. Ao criar um novo usuário é criado automatomaticamente duas contas (conta de débito e conta de crédito) e três planos de conta padrão (DESPESA PADRÃO, RECEITA PADRÃO e TRANSFERENCIA PADRÃO)
`POST /usuarios`
	- Paramêtros do body em JSON:
			- nome: String
			- login: String
			- cpf: String
			- senha: String
			
- Busca de usuário por id 
`GET /usuarios/{id}`
	- Parâmetro de caminho (PathVariable):
			- id: Integer

- Busca de contas por login de usuário 
`GET /usuarios/contas/{login}`
	- Parâmetro de caminho (PathVariable):
			- login: String

### Lançamentos
- Criação de novo lançamento. Ao criar um novo lançamento, o saldo da(s) conta(s) envolvida(s) são atualizadas para refletir o tipo movimento do lançamento
`POST /lancamentos`
	- Parâmetros do body JSON:
			- data: Date em formato yyyy-MM-dd
			- conta: Integer
			- descricao: String
			- planoConta: Integer
			- valor: Double

- Criação de novo plano de conta 
`POST /lancamentos/planos-conta`
	- Parâmetros do body JSON:
			- descricao: String
			- login: String
			- padrao: Boolean
			- tipoMovimento: Integer

- Busca de planos de conta por login de usuário 
`GET /lancamentos/planos-conta/{login}`
	- Parâmetro de caminho (PathVariable):
			- login: String

### Dashboard
- Relação de lançamentos por conta por período. É obrigatório informar o período e login 
`GET /dashboard?login={login}&dataInicial={dataInicial}&dataFinal={dataFinal}`
	- Parâmetros de query (RequestParam):
			- login: String
			- dataInicial: Data em String em formato yyyy-MM-dd
			- dataFinal: Data em String em formato yyyy-MM-dd

### Login
- Autenticação e geração de token JWT 
`POST /login`
	- Parâmetros do body JSON:
			- login: String
			- senha: String
