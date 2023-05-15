package com.example.sportyShoes.service;

import com.example.sportyShoes.repository.LoginRepository;
import com.example.sportyShoes.model.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public String signUp(Login login) {
        if(login.getTypeOfUser().equalsIgnoreCase("admin")) {
            return "Admin account can't create";
        }else {
            Optional<Login> result = loginRepository.findById(login.getEmailId());
            if(result.isPresent()) {
                return "Already account present";
            }else {
                loginRepository.save(login);
                return "Account created successfully";
            }
        }
    }

    public String signIn(Login login) {
        log.info("[signIn] user will be sign in!");
        Login ll = loginRepository.signIn(login.getEmailId(), login.getPassword(), login.getTypeOfUser());
        if(ll==null) {
            log.info("[signIn] login user could not be found!");
            return "Invalid emailid or password";
        }else {
            if(ll.getTypeOfUser().equalsIgnoreCase("admin")) {
                log.info("[signIn] Admin login successfully!");
                return "Admin login successfully";
            }else {
                log.info("[signIn] Customer login successfully!");
                return "Customer login successfully";
            }
        }

    }
}
