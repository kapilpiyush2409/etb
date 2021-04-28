package com.example.ETB.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class usercontroller {
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }
}
