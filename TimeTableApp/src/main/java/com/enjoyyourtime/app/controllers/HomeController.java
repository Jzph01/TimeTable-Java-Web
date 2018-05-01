package com.enjoyyourtime.app.controllers;

import com.enjoyyourtime.app.areas.activity.services.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ActivityService activityService;

    public HomeController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public String getHomePge(Model model){
        model.addAttribute("activities", activityService.getAllActivities());
        model.addAttribute("view", "home/index");
        return "base-layout";
    }

    @GetMapping("/page")
    public String getPge(){
        return "page";
    }
}

