package com.enjoyyourtime.app.services;

import com.enjoyyourtime.app.models.bindingModels.RegistrationModel;
import com.enjoyyourtime.app.models.viewModels.UserViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {


    void register(RegistrationModel registrationModel);

    List<UserViewModel> findAll();
}
