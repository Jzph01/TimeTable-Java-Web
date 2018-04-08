package com.enjoyyourtime.app.models.bindingModels;

import com.enjoyyourtime.app.customValidations.IsPasswordMatching;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@IsPasswordMatching
public class RegistrationModel {

    @NotBlank(message = "Name should not be empty!")
    @Size(min = 3, message = "Username too short!")
    private String username;

    @Pattern(regexp = "^(?:\\S+)@(?:\\S+)\\.(?:\\S+)$", message = "Invalid Email")
    private String email;

    @Size(min = 6, message = "Password too short!")
    private String password;



    private String confirmPassword;

    public String getEmail() {
        return email;
    }

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

    public void setEmail(String email) {
        this.email = email;
    }
}
