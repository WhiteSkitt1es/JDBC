package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS info
                (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(128) NOT NULL
                );
                """;
        String sql1 = """
                DROP TABLE info;
                """;
        try (Connection connection = ConnectionManager.open()) {
            Statement statement = connection.createStatement();

            System.out.println(connection.getSchema());
            System.out.println(connection.getTransactionIsolation());

            boolean executeResult = statement.execute(sql);
            System.out.println(executeResult);
        }
    }
}
