package com.budgetducklingsinc.ducksandspringboot.controller;

import ch.qos.logback.core.model.Model;
import com.budgetducklingsinc.ducksandspringboot.model.PaymentTable;
import com.budgetducklingsinc.ducksandspringboot.service.InvoiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        PaymentTable userPaymentsList = invoiceService.getPaymentsList(username);
        model.addAttribute("payments", userPaymentsList.getPaymentsList());

        return "invoicePage";
    }

    @GetMapping
    protected String showPaymentPage(HttpSession session) {
        session.getAttribute("username");
        return "redirect:paymentPage.html";
    }

    @GetMapping
    protected String selectPayment(Model model, HttpSession session, @RequestParam int id) {
        String username = (String) session.getAttribute("username");
        ArrayList<PaymentTable> PaymentTable = new ArrayList<>();
        PaymentTable selectedPayment = invoiceService.selectPayment(username, id);

        PaymentTable.add(selectedPayment);
        model.addAttribute("payment table", paymentTable);
        return"redirect:editPage.html";

    }

    @GetMapping
    protected String showEditPage(HttpSession session) {
        session.getAttribute("username");
        return "redirect:editPage.html";
    }
}

