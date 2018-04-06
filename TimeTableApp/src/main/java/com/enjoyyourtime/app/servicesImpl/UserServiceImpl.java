package com.enjoyyourtime.app.servicesImpl;

import com.enjoyyourtime.app.entities.User;
import com.enjoyyourtime.app.errors.Errors;
import com.enjoyyourtime.app.models.bindingModels.RegistrationModel;
import com.enjoyyourtime.app.models.viewModels.UserViewModel;
import com.enjoyyourtime.app.repositories.UserRepository;
import com.enjoyyourtime.app.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, ModelMapper modelMapper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(RegistrationModel registrationModel) {
        User user = this.modelMapper.map(registrationModel, User.class);
        String encryptedPassword =this.bCryptPasswordEncoder.encode(registrationModel.getPassword());
        user.setPassword(encryptedPassword);
        this.userRepository.save(user);
    }

    @Override
    public List<UserViewModel> findAll() {
        List<UserViewModel> userViewModels = new ArrayList<>();
        List<User> users =this.userRepository.findAll();
        for(User user : users){
            UserViewModel userViewModel = this.modelMapper.map(user, UserViewModel.class);
            userViewModels.add(userViewModel);
        }
        return userViewModels;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findOneByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(Errors.INVALID_CREDENTIALS);
        }
        return user;
    }


}
