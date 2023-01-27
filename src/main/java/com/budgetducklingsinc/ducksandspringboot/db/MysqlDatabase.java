package com.budgetducklingsinc.ducksandspringboot.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDatabase {

    private static MysqlDatabase instance;
    private Connection connection;

    private MysqlDatabase() {
        String url = "jdbs:mysql://localhost:3306/budgetducklingsinc";
        try {
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static MysqlDatabase getInstance() {
        if(instance == null) {
            instance = new MysqlDatabase();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
