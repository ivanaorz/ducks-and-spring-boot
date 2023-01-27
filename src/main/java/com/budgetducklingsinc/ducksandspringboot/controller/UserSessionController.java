package com.budgetducklingsinc.ducksandspringboot.controller;
import com.budgetducklingsinc.ducksandspringboot.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@Controller
@RequestMapping("/userSession/*")
public class UserSessionController {
    private AuthenticationService authenticationService;

    public UserSessionController(){
        this.authenticationService = new AuthenticationService();

    }
    @GetMapping("login")
    public String showLoginPage() {
        return "loginPage";
    }

    @GetMapping("error/login")
    @ResponseBody
    public String errorHandler(@RequestParam int attempts) {
        return "Invalid attempt {" + attempts + "}, <a href='/'>try again</a>";
    }

    @PostMapping("login")
            public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {

        if (session.getAttribute("username") != null) {
            return "redirect:/invoicePage.html";
        } else {

            if (authenticationService.login(username, password)) {
                session.setMaxInactiveInterval(60 * 30);
                session.setAttribute("username", username);

                return "redirect:/invoicePage.html";
            }

                return "redirect:login";
            }
        }

    @PostMapping("logout")
    public String logout(HttpSession session) throws IOException {
        session.invalidate();
        return "redirect:login";
    }
    }


