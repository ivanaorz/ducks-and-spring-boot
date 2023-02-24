package com.budgetducklingsinc.ducksandspringboot.repository;

import com.budgetducklingsinc.ducksandspringboot.db.MysqlDatabase;
import com.budgetducklingsinc.ducksandspringboot.model.Employee;
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

    public ArrayList<Payment> getPaymentList(String username)  {
        ArrayList<Payment> paymentList = new ArrayList<>();

        String sql = "SELECT * FROM payment WHERE username=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Payment payment = new Payment();
                resultSet.getString("dateOfPayment");
                resultSet.getString("title");
                resultSet.getString("description");
                resultSet.getString("category");
                resultSet.getDouble("price");
                resultSet.getInt("id");
                paymentList.add(payment);
            }
        }catch (Exception e) {

       }
      return paymentList;
    }

    public void updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE payment" + "SET dateOfPayment=?, title=?, description=?, category=?, price?" + "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, payment.getDateOfPayment());
        preparedStatement.setString(2, payment.getTitle());
        preparedStatement.setString(3, payment.getDescription());
        preparedStatement.setString(4, payment.getCategory());
        preparedStatement.setDouble(5, payment.getPrice());
        preparedStatement.setInt(6, payment.getId());
        preparedStatement.execute();


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

    public void createPayment(int userId, Payment payment) throws SQLException {
        String sql = "INSERT INTO payment (userId, dateOfPayment, title, description, category, price)" + "VALUES(?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, payment.getDateOfPayment());
        preparedStatement.setString(3, payment.getTitle());
        preparedStatement.setString(4, payment.getDescription());
        preparedStatement.setString(5, payment.getCategory());
        preparedStatement.setDouble(6, payment.getPrice());

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        resultSet.close();
    }

    public Payment selectPayment(String username, int id) throws SQLException {
        Payment selectedPayment = new Payment();
        String sql = "SELECT * FROM payment WHERE username=? AND id=?";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            selectedPayment.setId(resultSet.getInt("id"));
            selectedPayment.setDateOfPayment(resultSet.getString("dateOfPayment"));
            selectedPayment.setTitle(resultSet.getString("title"));
            selectedPayment.setDescription(resultSet.getString("description"));
            selectedPayment.setCategory(resultSet.getString("category"));
            selectedPayment.setPrice(resultSet.getDouble("price"));

          return selectedPayment;
    }


}
