package com.evos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author leonardo.silva
 */
public class ConnectionFactory {

    private static final String DB_USERNAME = "evosgold";
    private static final String DB_PASSWORD = "devacs";

    // jdbc:[banco]://[ip ou caminho]:[porta]/[nome do banco]
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3050/C:/Evos/data/db/dbevos";

    public static Connection createConnectionToMySql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver"); // Faz com que a classe seja carregada

        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        return connection;
    }
}
