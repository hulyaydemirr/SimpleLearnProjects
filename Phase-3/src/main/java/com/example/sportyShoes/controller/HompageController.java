package com.example.sportyShoes.controller;

import com.example.sportyShoes.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HompageController {

    @GetMapping(value = "/signInPage")
    public String signInPage(Model model) {
        model.addAttribute("login", new Login());
        return "signInPage";
    }

    @GetMapping(value = "/signUpPage")
    public String signUp(Model model){
        model.addAttribute("login", new Login());
        return "signUpPage";
    }

    @GetMapping(value = "/adminHome")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping(value = "/customerHome")
    public String customerHome(){
        return "customerHome";
    }
}
