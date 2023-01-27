package com.budgetducklingsinc.ducksandspringboot.controller;

import com.budgetducklingsinc.ducksandspringboot.model.PaymentTable;
import com.budgetducklingsinc.ducksandspringboot.service.InvoiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editPage/")
public class EditPageController {
    private InvoiceService invoiceService;

    public EditPageController() {
        this.invoiceService = new InvoiceService();
    }



    @PostMapping
    protected String updatePayment(HttpSession session, @ModelAttribute PaymentTable paymentTable) {
        String username = (String) session.getAttribute("username");
        invoiceService.updatePayment(username, paymentTable);
        return "redirect:invoicePage";
    }

    @PostMapping
    protected String deletePayment(HttpSession session, @ModelAttribute PaymentTable paymentTable) {
        String username = (String) session.getAttribute("username");
        invoiceService.deletePayment(username, paymentTable);
        return "redirect:invoicePage";
    }
}
