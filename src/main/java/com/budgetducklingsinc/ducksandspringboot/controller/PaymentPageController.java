package com.budgetducklingsinc.ducksandspringboot.controller;

import ch.qos.logback.core.model.Model;
import com.budgetducklingsinc.ducksandspringboot.model.PaymentTable;
import com.budgetducklingsinc.ducksandspringboot.service.InvoiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paymentPage/")
public class PaymentPageController {
    private InvoiceService invoiceService;

    public PaymentPageController() {
        this.invoiceService = new InvoiceService();
    }

    @PostMapping
    protected String createPayment(HttpSession session, @ModelAttribute PaymentTable paymentTable) {
        String username = (String) session.getAttribute("username");
        invoiceService.createPayment(username,paymentTable);
        return "redirect:invoicePage";
    }
}
