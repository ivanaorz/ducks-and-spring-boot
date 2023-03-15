package com.budgetducklingsinc.ducksandspringboot.controller;

//import ch.qos.logback.core.model.Model;
import com.budgetducklingsinc.ducksandspringboot.model.Payment;
import com.budgetducklingsinc.ducksandspringboot.service.InvoiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
@RequestMapping
public class InvoicePageController {
    private InvoiceService invoiceService;

    public InvoicePageController() {
        this.invoiceService = new InvoiceService();
    }


    @GetMapping("invoicePage")
    protected String showAllPaymentsInvoicePage(Model model, HttpSession session)  {
        String username = (String) session.getAttribute("username");
        ArrayList<Payment> payments = new ArrayList<>();
        invoiceService.getPaymentList(username);
        model.addAttribute("payments", payments);

        return "invoicePage";
    }

    @GetMapping("paymentPage")
    protected String showPaymentPage(HttpSession session) {
        session.getAttribute("username");
        return "redirect:paymentPage.html";
    }

@ModelAttribute
    @GetMapping("editPage")
    protected String selectPayment(Model model, HttpSession session, @RequestParam int id) throws SQLException {
        String username = (String) session.getAttribute("username");
        Payment payment = invoiceService.selectPayment(username, id);
        model.addAttribute("payment", payment);
        return"redirect:editPage.html";

    }



    @GetMapping("editPage")
    protected String showEditPage(HttpSession session) {
        session.getAttribute("username");
        return "redirect:editPage.html";
    }

    @PostMapping("invoicePage/delete")
    protected String deletePayment(HttpSession session, @ModelAttribute int id) throws SQLException {
        String username = (String) session.getAttribute("username");
        invoiceService.deletePayment(username, id);
        return "redirect:invoicePage";
    }
}

