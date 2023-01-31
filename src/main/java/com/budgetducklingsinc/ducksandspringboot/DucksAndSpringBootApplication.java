package com.budgetducklingsinc.ducksandspringboot;

import com.budgetducklingsinc.ducksandspringboot.model.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/payments")
public class DucksAndSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DucksAndSpringBootApplication.class, args);
    }

    @GetMapping
    public List<Payment> getPayments() {
        return List.of();
    }

}
