package com.enjoyyourtime.app.areas.user.services;

import com.enjoyyourtime.app.areas.user.entities.User;
import com.enjoyyourtime.app.areas.user.models.bindingModels.RegistrationModel;
import com.enjoyyourtime.app.areas.user.models.viewModels.UserViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {


    void register(RegistrationModel registrationModel);

    List<UserViewModel> findAll();

    UserViewModel getByUsername(String username);
    UserViewModel getById(Long id);
    User findOneByUserName(String userName);
}
