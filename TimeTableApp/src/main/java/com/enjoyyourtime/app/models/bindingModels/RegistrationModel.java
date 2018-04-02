package com.enjoyyourtime.app.models.bindingModels;

import com.enjoyyourtime.app.customValidations.IsPasswordMatching;

import javax.validation.constraints.Size;

@IsPasswordMatching
public class RegistrationModel {

    @Size(min = 3, message = "Username too short!")
    private String username;

    @Size(min = 6, message = "Password too short!")
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
