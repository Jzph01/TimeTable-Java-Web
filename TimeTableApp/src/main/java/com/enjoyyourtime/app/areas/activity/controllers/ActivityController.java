package com.enjoyyourtime.app.areas.activity.controllers;

import com.enjoyyourtime.app.areas.activity.entities.Activity;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.AddActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.models.viewModels.ActivityViewModel;
import com.enjoyyourtime.app.areas.activity.services.ActivityService;
import com.enjoyyourtime.app.areas.user.models.viewModels.UserViewModel;
import com.enjoyyourtime.app.areas.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public ActivityController(ActivityService activityService, UserService userService, ModelMapper modelMapper) {
        this.activityService = activityService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String getAddActivityPage(Model model, @ModelAttribute AddActivityBindingModel addActivityBindingModel){
        model.addAttribute("view", "activity/create");
        return "base-layout";
    }

    @PostMapping("/add")
    public String addActivity(@Valid @ModelAttribute AddActivityBindingModel addActivityBindingModel
            , BindingResult bindingResult, Model model, Principal principal){
        if(bindingResult.hasErrors()){
            model.addAttribute("view", "activity/create");
            return "base-layout";
        }

        this.activityService.create(addActivityBindingModel, principal.getName());
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getActivity(Model model, @PathVariable Long id, Principal principal){
        Activity activity = this.activityService.getById(id);
        ActivityViewModel activityViewModel = this.modelMapper.map(activity, ActivityViewModel.class);
        UserViewModel userViewModel =  this.userService.getByUsername(principal.getName());
        model.addAttribute("activity", activityViewModel);
        model.addAttribute("user",userViewModel);
        model.addAttribute("view", "activity/show");
        return "base-layout";
    }


}
