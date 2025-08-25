package br.com.renan.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // Não armazenar a conexão como estático - cada thread deve ter sua própria conexão
    private static final String URL = "jdbc:postgresql://localhost:5432/vendas_onlinedb";
    private static final String USER = "renan";
    private static final String PASSWORD = "admin";
    
    // Bloco estático para registrar o driver (opcional para JDBC 4.0+)
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL não encontrado", e);
        }
    }
    
    // Construtor privado para evitar instanciação
    private ConnectionFactory() {}
    
    public static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // Configurações recomendadas:
            connection.setAutoCommit(false); // Melhor para controle transacional
            return connection;
        } catch (SQLException e) {
            throw new SQLException("Erro ao obter conexão com o banco de dados", e);
        }
    }
    
    // Método auxiliar para fechar conexão
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.getAutoCommit()) {
                    connection.rollback(); // Rollback se houver transação aberta
                }
                connection.close();
            } catch (SQLException e) {
                // Logar o erro adequadamente em produção
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método main para teste de conexão
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}