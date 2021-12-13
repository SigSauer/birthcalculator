package com.sigsauer.univ.birthcalculator.controller.api.users.bean;

import com.sigsauer.univ.birthcalculator.model.User;
import com.sigsauer.univ.birthcalculator.utils.DateUtils;
import com.sigsauer.univ.birthcalculator.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateUserRequest {

    private String email;
    private String password;
    private String name;
    private String birth;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String email, String password, String name, String birth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birth = birth;
    }

    public User toUser() {
        User user = new User();
        if (StringUtils.isNotEmpty(this.email)) user.setEmail(this.email);
        if (StringUtils.isNotEmpty(this.password)) user.setPassword(this.password);
        if (StringUtils.isNotEmpty(this.name)) user.setName(this.name);
        if (DateUtils.isConvertable(this.birth)) user.setBirth(DateUtils.convert(this.birth));
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
