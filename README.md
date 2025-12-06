# Spring Boot Web Services API 

Este projeto consiste no desenvolvimento de uma API RESTful para um sistema de e-commerce, com foco na implementação de boas práticas de engenharia de software, mapeamento objeto-relacional (ORM) complexo e arquitetura em camadas.

O objetivo principal foi construir um sistema robusto, escalável e desacoplado, utilizando o ecossistema Spring para gerenciar injeção de dependência e persistência de dados.

## Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3** (Web, Data JPA)
* **H2 Database** (Banco de dados em memória para ambiente de testes)
* **Maven** (Gerenciamento de dependências e build)
* **Postman** (Testes de integração de endpoints)

## Competências Técnicas e Arquitetura

O desenvolvimento deste projeto abordou conceitos fundamentais para a construção de backends corporativos:

### 1. Arquitetura em Camadas (Layered Architecture)
O sistema foi estruturado para garantir a separação de responsabilidades e manutenibilidade:
* **Resource Layer (Rest Controllers):** Responsável por expor os endpoints HTTP e receber as requisições.
* **Service Layer:** Camada intermediária que encapsula as regras de negócio.
* **Repository Layer (Data Access):** Interface de comunicação com o banco de dados utilizando Spring Data JPA.

### 2. Mapeamento Objeto-Relacional (JPA & Hibernate)
Implementação de modelos de dados relacionais complexos através da especificação JPA:
* **Associações One-to-Many e Many-to-One:** Modelagem de relacionamentos bidirecionais (ex: Usuários e Pedidos).
* **Associações Many-to-Many:** Implementação de tabela de junção entre Produtos e Categorias.
* **Classe de Associação e Chave Composta:** Solução para atributos em relacionamentos N:N utilizando `@EmbeddedId` e classes auxiliares de chave primária (ex: OrderItem).
* **Ciclo de Vida de Entidades:** Gerenciamento de persistência e *cascading*.

### 3. Tratamento de Exceções e Respostas HTTP
* **Global Exception Handling:** Utilização de `@ControllerAdvice` e `@ExceptionHandler` para interceptar exceções em toda a aplicação.
* **Custom Exceptions:** Implementação de exceções personalizadas (`ResourceNotFoundException`, `DatabaseException`) para garantir que erros de infraestrutura sejam traduzidos em mensagens de negócio claras e códigos HTTP semanticamente corretos (404, 400, etc).

### 4. Serialização e Controle de Dados
* **Prevenção de Referência Cíclica:** Controle da serialização JSON em relacionamentos bidirecionais utilizando `@JsonIgnore` para evitar recursividade infinita.
* **Padronização:** Formatação de datas e timestamps conforme padrão ISO 8601.

## Modelo de Domínio

O domínio da aplicação abrange as seguintes entidades e relacionamentos:
* **User:** Cliente do sistema, podendo possuir múltiplos pedidos.
* **Order:** Pedido realizado, contendo status, momento da compra e itens.
* **Category/Product:** Relacionamento muitos-para-muitos, permitindo categorização flexível de produtos.
* **OrderItem:** Entidade associativa que registra o preço e quantidade do produto no momento específico da compra.
* **Payment:** Relacionamento um-para-um com o pedido, registrando a confirmação do pagamento.

## Configuração e Execução

Pré-requisitos: Java 17+ e Maven.

```bash
# Clonar o repositório
git clone <link-do-repositorio>

# Acessar o diretório do projeto
cd nome-do-projeto

# Executar a aplicação
./mvnw spring-boot:run

Curso (Nelia Alves)
