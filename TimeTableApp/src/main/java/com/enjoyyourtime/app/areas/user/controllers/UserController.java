package com.enjoyyourtime.app.areas.user.controllers;

import com.enjoyyourtime.app.errors.Errors;
import com.enjoyyourtime.app.areas.user.models.bindingModels.RegistrationModel;
import com.enjoyyourtime.app.areas.user.models.viewModels.UserViewModel;
import com.enjoyyourtime.app.areas.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegistrationModel registrationModel){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }

        this.userService.register(registrationModel);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", Errors.INVALID_CREDENTIALS);

        }
        return "login";
    }


    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<UserViewModel> userViewModelList = this.userService.findAll();
        model.addAttribute("users", userViewModelList);
        return "users";
    }

    @GetMapping()
    public String getProfilePage(){
        return null;
    }
}
