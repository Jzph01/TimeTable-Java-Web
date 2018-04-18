package com.enjoyyourtime.app.areas.user.services;

import com.enjoyyourtime.app.areas.user.entities.User;
import com.enjoyyourtime.app.areas.user.models.bindingModels.RegistrationModel;
import com.enjoyyourtime.app.areas.user.models.viewModels.UserViewModel;
import com.enjoyyourtime.app.areas.user.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

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

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);


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
    public UserViewModel getByUsername(String username) {
        User user = this.userRepository.findOneByUsername(username);
        UserViewModel userViewModel = null;
        if (user != null){
            userViewModel = this.modelMapper.map(user,UserViewModel.class);
        }
        return userViewModel;
    }

    // getOne()
    @Override
    public UserViewModel getById(Long id) {
        User user = this.userRepository.getOne(id);
        UserViewModel userViewModel = null;
        if (user != null){
            userViewModel = this.modelMapper.map(user,UserViewModel.class);
        }
        return userViewModel;
    }

    @Override
    public User findOneByUserName(String userName) {
        return this.userRepository.findOneByUsername(userName);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Wrong");
        }

        return user;
    }


}
