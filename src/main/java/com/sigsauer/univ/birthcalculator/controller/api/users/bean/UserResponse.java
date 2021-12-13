package com.sigsauer.univ.birthcalculator.controller.api.users.bean;

import com.sigsauer.univ.birthcalculator.model.User;
import com.sigsauer.univ.birthcalculator.utils.DateUtils;

import java.util.Date;

public class UserResponse {

    private String email;
    private String name;
    private String birth;

    public UserResponse() {
    }

    public UserResponse(String email, String name, String birth) {
        this.email = email;
        this.name = name;
        this.birth = birth;
    }

    public UserResponse(User user) {
        if (user == null) new UserResponse();
        this.email = user.getEmail();
        this.name = user.getName();
        this.birth = DateUtils.convert(user.getBirth());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
