package com.enjoyyourtime.app.areas.activity.services;

import com.enjoyyourtime.app.areas.activity.entities.Activity;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.AddActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.EditActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.models.viewModels.ActivityViewModel;
import com.enjoyyourtime.app.areas.activity.repositories.ActivityRepository;
import com.enjoyyourtime.app.areas.user.entities.User;
import com.enjoyyourtime.app.areas.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, UserService userService, ModelMapper modelMapper) {
        this.activityRepository = activityRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void create(AddActivityBindingModel addActivityBindingModel, String userName) {
        User user = this.userService.findOneByUserName(userName);
        Activity activity = this.modelMapper.map(addActivityBindingModel, Activity.class);
        activity.setEditor(user);
        this.activityRepository.saveAndFlush(activity);
    }

    @Override
    public void update(EditActivityBindingModel editActivityBindingModel, String userName) {
        Activity activity = this.modelMapper.map(editActivityBindingModel, Activity.class);
        User user = this.userService.findOneByUserName(userName);
        activity.setEditor(user);
        this.activityRepository.saveAndFlush(activity);
    }

    @Override
    public void delete(Long id) {
        this.activityRepository.deleteById(id);
    }

    @Override
    public Activity getById(Long id) {
        return  this.activityRepository.getOne(id);
    }

    @Override
    public EditActivityBindingModel findActivityById(Long id) {
        Activity activity = this.activityRepository.getOne(id);
        return this.modelMapper.map(activity, EditActivityBindingModel.class);
    }

    @Override
    public List<ActivityViewModel> getAllActivities() {

        List<Activity> activities = this.activityRepository.findAll();
        List<ActivityViewModel> activityViewModels = new ArrayList<>();

        for(Activity activity : activities){
           ActivityViewModel activityViewModel = this.modelMapper.map(activity, ActivityViewModel.class);
           activityViewModels.add(activityViewModel);
        }

        return activityViewModels;
    }


}
