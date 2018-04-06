package com.enjoyyourtime.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccessController {

    @GetMapping("/unauthorized")
    @ResponseBody
    public String unauthorized(){
        return "You Cannot Access This Page!!!";
    }

}
