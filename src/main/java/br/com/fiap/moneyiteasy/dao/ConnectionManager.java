package br.com.fiap.moneyiteasy.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static ConnectionManager connectionManager;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection(
                    "ORACLE_URL",
                    "ORACLE_USERNAME",
                    "ORACLE_PASSWORD");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}