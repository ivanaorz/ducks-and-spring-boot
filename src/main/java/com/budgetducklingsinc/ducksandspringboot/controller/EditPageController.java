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
public class EditPageController {
   private InvoiceService invoiceService;

    public EditPageController() {
        this.invoiceService = new InvoiceService();
    }



    @PostMapping("editPage")
    protected String updatePayment(HttpSession session, @ModelAttribute Payment payment) throws SQLException {
        if (session.getAttribute("username") != null) {
            invoiceService.updatePayment(payment);
            return "redirect:invoicePage";
        }
        return "redirect:login";
    }

}
