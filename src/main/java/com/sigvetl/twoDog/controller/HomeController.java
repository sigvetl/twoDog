package com.sigvetl.twoDog.controller;

import com.sigvetl.twoDog.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    private UserService userService;

    public HomeController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String home(Authentication authentication, Model model) {
        String username = authentication.getName();

        return "home";
    }
}
