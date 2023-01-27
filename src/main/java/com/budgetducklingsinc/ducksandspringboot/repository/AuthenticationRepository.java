package com.budgetducklingsinc.ducksandspringboot.repository;

import com.budgetducklingsinc.ducksandspringboot.db.MysqlDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthenticationRepository {

    private MysqlDatabase db;
    private Connection connection;
    public AuthenticationRepository() {
        db = MysqlDatabase.getInstance();
        connection = db.getConnection();
    }

    public String login(String username) {
        Connection conn = db.getConnection();
        String sql = "SELECT password FROM user WHERE username=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "password";
    }
}



