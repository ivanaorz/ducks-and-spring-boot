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
@RequestMapping()
public class PaymentPageController {
    private InvoiceService invoiceService;

    public PaymentPageController() {
        this.invoiceService = new InvoiceService();
    }

    @PostMapping("paymentPage")
    protected String createPayment(HttpSession session, @ModelAttribute Payment payment) throws SQLException {
        int userId = (int) session.getAttribute("userId");
        invoiceService.createPayment(userId, payment);
        return "redirect:invoicePage";
    }
}
