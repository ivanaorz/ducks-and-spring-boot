package com.budgetducklingsinc.ducksandspringboot.service;

import com.budgetducklingsinc.ducksandspringboot.model.Payment;
import com.budgetducklingsinc.ducksandspringboot.repository.InvoiceRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InvoiceService {

    private InvoiceRepository invoiceRepository;



    public InvoiceService() {
        this.invoiceRepository = new InvoiceRepository();
    }

    public void updatePayment(Payment payment) throws SQLException {
        invoiceRepository.updatePayment(payment);
    }

    public void deletePayment(String username, int id) throws SQLException {
        invoiceRepository.deletePayment(username, id);
    }

    public Payment selectPayment(String username, int id) throws SQLException {
        Payment selectedPayment = new Payment();
        invoiceRepository.selectPayment(username, id);
        return selectedPayment;
    }


    public void createPayment(int userId, Payment payment) throws SQLException {
        invoiceRepository.createPayment(userId, payment);
    }

    public ArrayList<Payment> getPaymentList(String username)  {
        ArrayList<Payment> paymentLists = new ArrayList<>();
        invoiceRepository.getPaymentList(username);
        return paymentLists;
    }
}

