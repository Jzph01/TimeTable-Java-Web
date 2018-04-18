package com.enjoyyourtime.app.areas.user.controllers;

import com.enjoyyourtime.app.areas.user.models.bindingModels.RegistrationModel;
import com.enjoyyourtime.app.areas.user.services.UserService;
import com.enjoyyourtime.app.errors.Errors;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserSecurityController {

    private final UserService userService;

    public UserSecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegistrationModel registrationModel){

        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/register";
        }

        this.userService.register(registrationModel);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", Errors.INVALID_CREDENTIALS);
        }

        model.addAttribute("view", "user/login");

        return "base-layout";
    }



}
