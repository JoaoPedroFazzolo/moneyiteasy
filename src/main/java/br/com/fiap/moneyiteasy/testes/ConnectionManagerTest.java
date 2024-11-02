package br.com.fiap.moneyiteasy.testes;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;

import java.sql.Connection;

public class ConnectionManagerTest {

    public static void main(String[] args) {
        // Testando a conexão com o banco de dados
        Connection connection = null;
        try {
            // Obtendo a instância do ConnectionManager
            ConnectionManager connectionManager = ConnectionManager.getInstance();

            // Tentando estabelecer a conexão
            connection = connectionManager.getConnection();

            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer a conexão.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao tentar conectar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Fechando a conexão
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Conexão fechada com sucesso.");
                }
            } catch (Exception e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
