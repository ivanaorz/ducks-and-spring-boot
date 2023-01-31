package com.budgetducklingsinc.ducksandspringboot.service;

import com.budgetducklingsinc.ducksandspringboot.model.Payment;
import com.budgetducklingsinc.ducksandspringboot.repository.InvoiceRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    private Payment updatePayment;


    public InvoiceService() {
        this.invoiceRepository = new InvoiceRepository();
    }

    public void updatePayment(String username, int id) throws SQLException {
        invoiceRepository.updatePayment(username, id);
    }

    public void deletePayment(String username, int id) throws SQLException {
        invoiceRepository.deletePayment(username, id);
    }

    public Payment selectPayment(String username, int id) throws SQLException {
        Payment selectedPayment = invoiceRepository.selectPayment(username, id);
        if (selectedPayment != null) {
            updatePayment = selectedPayment;
        }
        return selectedPayment;
    }

    public void createPayment(String username, Payment payment) throws SQLException {
        invoiceRepository.createPayment();
    }

    public List<Payment> getPaymentList(String username) throws SQLException {
        List<Payment> paymentLists = new ArrayList<>();
        invoiceRepository.getPaymentList(username);
        return paymentLists;
    }
}

