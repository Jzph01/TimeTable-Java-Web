package com.enjoyyourtime.app.areas.activity.services;

import com.enjoyyourtime.app.areas.activity.entities.Activity;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.AddActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.EditActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.models.viewModels.ActivityViewModel;

import java.util.List;

public interface ActivityService {


    void create(AddActivityBindingModel addActivityBindingModel, String userName);

    void update(EditActivityBindingModel editActivityBindingModel, String userName);

    void delete(Long id);

    Activity getById(Long id);

    EditActivityBindingModel findActivityById(Long id);

    List<ActivityViewModel> getAllActivities();
}
