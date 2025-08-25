# Exemplos JDBC com PostgreSQL

Este projeto foi desenvolvido para fins de estudo pessoal, com o objetivo de treinar testes unitários em Java e a conexão com banco de dados utilizando JDBC e PostgreSQL. Demonstra um CRUD completo para as entidades **Cliente** e **Produto**.

## Tecnologias utilizadas

- **Java** (recomenda-se versão 8 ou superior)
- **JDBC**
- **PostgreSQL** (banco de dados relacional)
- **Driver JDBC do PostgreSQL** ([Download](https://jdbc.postgresql.org/download.html))
- **Spring Tool Suite** (IDE utilizada para desenvolvimento)

## Estrutura do projeto

- Os exemplos estão organizados em arquivos `.java`, cada um demonstrando uma operação diferente.
- Scripts SQL podem ser adicionados na pasta `/sql` para facilitar testes e criação de tabelas.

## Banco de dados e conexão

- **Banco**: PostgreSQL
- **Script para criar tabelas de exemplo**:
  ```sql
  CREATE TABLE cliente (
      id SERIAL PRIMARY KEY,
      nome VARCHAR(100),
      email VARCHAR(100)
  );

  CREATE TABLE produto (
      id SERIAL PRIMARY KEY,
      nome VARCHAR(100),
      preco DECIMAL
  );
  ```

### String de conexão JDBC

A configuração da conexão JDBC está centralizada na classe `ConnectionFactory`  
Caminho: `src/main/java/br/com/renan/dao/jdbc/ConnectionFactory.java`

Exemplo de configuração:
```java
private static final String URL = "jdbc:postgresql://localhost:5432/vendas_onlinedb";
private static final String USER = "seuusuario";
private static final String PASSWORD = "suasenha";

public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
}
```
As classes DAO, como `ClienteDAO` e `ProdutoDAO`, utilizam o método `getConnection()` da `ConnectionFactory` para acessar o banco.

## Como executar os exemplos

1. Instale o PostgreSQL em sua máquina e crie um banco de dados para testes.
2. Baixe o driver JDBC do PostgreSQL e adicione ao seu projeto.
3. Modifique os dados de conexão na classe `ConnectionFactory` conforme seu ambiente.
4. Compile e execute os arquivos `.java` para testar as operações de CRUD usando o **Spring Tool Suite**.
5. (Opcional) Execute os testes unitários para validar a integração.

## Observações

- Este repositório foi criado apenas para estudos.
- Sinta-se à vontade para contribuir com exemplos, melhorias ou sugestões.

## Referências

- [Documentação JDBC](https://docs.oracle.com/javase/tutorial/jdbc/)
- [Documentação PostgreSQL](https://www.postgresql.org/docs/)
- [Spring Tool Suite](https://spring.io/tools)

