package com.budgetducklingsinc.ducksandspringboot.repository;

import com.budgetducklingsinc.ducksandspringboot.db.MysqlDatabase;
import com.budgetducklingsinc.ducksandspringboot.model.Payment;


import java.sql.*;
import java.util.ArrayList;

public class InvoiceRepository {

    private MysqlDatabase db;
    private Connection connection;

    public InvoiceRepository() {
        db = MysqlDatabase.getInstance();
        connection = db.getConnection();
    }

    public void getPaymentList(String username) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM payment WHERE username=?";
        ResultSet resultSet = statement.executeQuery(sql);
//        ArrayList<Payment> paymentList = new ArrayList<>();
//        Payment payment = new Payment();
        while (resultSet.next()) {
            resultSet.getString("username");
            resultSet.getString("title");
            resultSet.getString("dateOfPayment");
            resultSet.getString("description");
            resultSet.getString("category");
            resultSet.getString("price");
        }
        resultSet.close();
        statement.close();
    }

    public void updatePayment(String username, int id) throws SQLException {
        String sql = "UPDATE payment" + "SET username=?, title=?, dateOfPayment=?, description=?, category=?, price]?" + "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, "title");
        preparedStatement.setString(3, "dateOfPayment");
        preparedStatement.setString(4, "description");
        preparedStatement.setString(5, "category");
        preparedStatement.setString(6, "price");
        preparedStatement.setInt(7, id);
        preparedStatement.execute();
// }

     preparedStatement.close();

}

    public void deletePayment(String username, int id) throws SQLException {
        String sql = "DELETE from payment" + "WHERE username=? AND id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, id);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void createPayment() throws SQLException {
        String sql = "INSERT INTO payment (username, title, dateOfPayment, description, category, price)" + "VALUES(?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "username");
        preparedStatement.setString(2, "title");
        preparedStatement.setString(3, "dateOfPayment");
        preparedStatement.setString(4, "description");
        preparedStatement.setString(5, "category");
        preparedStatement.setString(6, "price");

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        resultSet.close();
    }

    public void selectPayment(String username, int id) throws SQLException {

        String sql = "SELECT * FROM payment WHERE username=? AND id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            resultSet.close();
    }
}
