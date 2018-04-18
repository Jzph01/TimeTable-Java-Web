package com.enjoyyourtime.app.areas.activity.services;

import com.enjoyyourtime.app.areas.activity.entities.Activity;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.AddActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.EditActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.repositories.ActivityRepository;
import com.enjoyyourtime.app.areas.user.entities.User;
import com.enjoyyourtime.app.areas.user.models.viewModels.UserViewModel;
import com.enjoyyourtime.app.areas.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void update(EditActivityBindingModel editActivityBindingModel) {
        Activity activity = this.modelMapper.map(editActivityBindingModel, Activity.class);
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
}
