package com.budgetducklingsinc.ducksandspringboot.service;

import com.budgetducklingsinc.ducksandspringboot.repository.AuthenticationRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private AuthenticationRepository authenticationRepository;

    public AuthenticationService() {
        this.authenticationRepository = new AuthenticationRepository();
    }
    public boolean login(String username, String password) {
        String getPassword = authenticationRepository.login(username);
        if(getPassword.equals(password)) {
            return true;
        }
        return false;
    }
}
