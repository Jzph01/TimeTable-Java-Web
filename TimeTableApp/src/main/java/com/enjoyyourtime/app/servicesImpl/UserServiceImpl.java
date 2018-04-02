package com.enjoyyourtime.app.servicesImpl;

import com.enjoyyourtime.app.models.bindingModels.RegistrationModel;
import com.enjoyyourtime.app.models.viewModels.UserViewModel;
import com.enjoyyourtime.app.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public void register(RegistrationModel registrationModel) {

    }

    @Override
    public List<UserViewModel> findAll() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
