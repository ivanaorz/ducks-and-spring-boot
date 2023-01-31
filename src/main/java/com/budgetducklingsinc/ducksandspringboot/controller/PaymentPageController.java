package com.budgetducklingsinc.ducksandspringboot.controller;

import com.budgetducklingsinc.ducksandspringboot.model.Payment;
import com.budgetducklingsinc.ducksandspringboot.service.InvoiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/paymentPage/")
public class PaymentPageController {
    private InvoiceService invoiceService;

    public PaymentPageController() {
        this.invoiceService = new InvoiceService();
    }

    @PostMapping
    protected String createPayment(HttpSession session, @ModelAttribute Payment payment) throws SQLException {
        String username = (String) session.getAttribute("username");
        invoiceService.createPayment(username, payment);
        return "redirect:invoicePage";
    }
}
