package com.enjoyyourtime.app.areas.activity.controllers;

import com.enjoyyourtime.app.areas.activity.models.bindingModels.AddActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/add")
    public String getActivityPage(Model model,@ModelAttribute AddActivityBindingModel addActivityBindingModel){
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


}
