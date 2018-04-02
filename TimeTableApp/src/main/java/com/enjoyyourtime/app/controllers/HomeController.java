package com.enjoyyourtime.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePge(Model model){

        model.addAttribute("view", "home");
        return "base-layout";
    }
}
