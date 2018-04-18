package com.enjoyyourtime.app.areas.user.controllers;

import com.enjoyyourtime.app.areas.user.entities.User;
import com.enjoyyourtime.app.areas.user.models.viewModels.UserViewModel;
import com.enjoyyourtime.app.areas.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/profile/{id}")
    public String getProfilePage(@PathVariable Long id, Model model){
        UserViewModel userViewModel = this.userService.getById(id);
        if(userViewModel == null){
            model.addAttribute("view", "error/wrong-page");
            return "base-layout";
        }

        model.addAttribute("user", userViewModel);
        model.addAttribute("view", "user/profile");

        return "base-layout";
    }

    @GetMapping("/profile")
    public String getUserProfilePge(Model model, Principal principal){
        UserViewModel userViewModel =  this.userService.getByUsername(principal.getName());;
         if(userViewModel == null){
             model.addAttribute("view", "error/wrong-page");
             return "base-layout";
         }

         model.addAttribute("user", userViewModel);
         model.addAttribute("view", "user/profile");

         return "base-layout";
    }

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<UserViewModel> userViewModelList = this.userService.findAll();
        model.addAttribute("users", userViewModelList);
        return "users";
    }


}
