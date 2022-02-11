package com.evos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    // jdbc:[banco]://[ip ou caminho]:[porta]/[nome do banco]
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3055/dbevos";

    public static Connection createConnectionToMySql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver"); // Faz com que a classe seja carregada

        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        return connection;
    }
}
