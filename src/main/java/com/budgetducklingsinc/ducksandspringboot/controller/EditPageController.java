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
@RequestMapping("/editPage/")
public class EditPageController {
    private InvoiceService invoiceService;

    public EditPageController() {
        this.invoiceService = new InvoiceService();
    }



    @PostMapping
    protected String updatePayment(HttpSession session, @ModelAttribute int id) throws SQLException {
        String username = (String) session.getAttribute("username");
        invoiceService.updatePayment(username, id);
        return "redirect:invoicePage";
    }

    @PostMapping
    protected String deletePayment(HttpSession session, @ModelAttribute int id) throws SQLException {
        String username = (String) session.getAttribute("username");
        invoiceService.deletePayment(username, id);
        return "redirect:invoicePage";
    }
}
