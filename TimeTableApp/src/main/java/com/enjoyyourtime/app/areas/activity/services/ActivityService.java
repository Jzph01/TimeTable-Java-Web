package com.enjoyyourtime.app.areas.activity.services;

import com.enjoyyourtime.app.areas.activity.entities.Activity;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.AddActivityBindingModel;
import com.enjoyyourtime.app.areas.activity.models.bindingModels.EditActivityBindingModel;

public interface ActivityService {


    void create(AddActivityBindingModel addActivityBindingModel, String userName);

    void update(EditActivityBindingModel editActivityBindingModel);

    void delete(Long id);

    Activity getById(Long id);


}
