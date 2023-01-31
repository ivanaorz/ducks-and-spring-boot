package com.budgetducklingsinc.ducksandspringboot.controller;

import ch.qos.logback.core.model.Model;
import com.budgetducklingsinc.ducksandspringboot.model.Payment;
import com.budgetducklingsinc.ducksandspringboot.service.InvoiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/invoicePage/")
public class InvoicePageController {
    private InvoiceService invoiceService;

    public InvoicePageController() {
        this.invoiceService = new InvoiceService();
    }

    @GetMapping
    protected String showInvoicePage(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        invoiceService.getPaymentList(username);
        model.addAttribute("payment", payment.getPaymentList());

        return "invoicePage";
    }

    @GetMapping
    protected String showPaymentPage(HttpSession session) {
        session.getAttribute("username");
        return "redirect:paymentPage.html";
    }

    @GetMapping
    protected String selectPayment(Model model, HttpSession session, @RequestParam int id) throws SQLException {
        String username = (String) session.getAttribute("username");
        ArrayList<Payment> Payment = new ArrayList<>();
        Payment selectedPayment = invoiceService.selectPayment(username, id);

        Payment.add(selectedPayment);
        model.addAttribute("payment", payment.selectPayment());
        return"redirect:editPage.html";

    }

    @GetMapping
    protected String showEditPage(HttpSession session) {
        session.getAttribute("username");
        return "redirect:editPage.html";
    }
}

