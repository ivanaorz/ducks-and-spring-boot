package com.budgetducklingsinc.ducksandspringboot.service;

import com.budgetducklingsinc.ducksandspringboot.model.PaymentTable;
import com.budgetducklingsinc.ducksandspringboot.repository.InvoiceRepository;

import java.sql.SQLException;


public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    private PaymentTable updatePayment;


    public InvoiceService() {
        this.invoiceRepository = new InvoiceRepository();
    }

    public void updatePayment(String username, int id) throws SQLException {
        invoiceRepository.updatePayment(username, id);
    }

    public void deletePayment(String username, int id) throws SQLException {
        invoiceRepository.deletePayment(username, id);
    }

    public PaymentTable selectPayment(String username, int id) throws SQLException {
        PaymentTable selectedPayment = invoiceRepository.selectPayment(username, id);
        if(selectedPayment != null) {
            updatePayment = selectedPayment;
        }
        return selectedPayment;
    }
    public void createPayment() throws SQLException {
        invoiceRepository.createPayment();
    }

    public PaymentsList getPaymentsList(String username) {
        return invoiceRepository.getPaymentsList(username);
    }
}

