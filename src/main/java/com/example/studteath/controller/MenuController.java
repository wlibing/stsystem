package com.example.studteath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/signup")
    public String sign(Model model) {
        return "user/signup";
    }

    @RequestMapping("/searchUser")
    public String searchUser(Model model) {
        return "user/search";
    }
}
