package com.sigsauer.univ.birthcalculator.model;

import com.sigsauer.univ.birthcalculator.utils.StringUtils;

import java.util.Date;

public class User {

    private Long id;
    private String email;
    private String password;
    private String name;
    private Date birth;

    public User() {
    }

    public User(String email, String password, String name, Date birth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birth = birth;
    }

    public User(Long id, String email, String password, String name, Date birth) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birth = birth;
    }

    public void update(User updated) {
        if (StringUtils.isNotEmpty(updated.getEmail())) this.email = updated.getEmail();
        if (StringUtils.isNotEmpty(updated.getName())) this.name = updated.getName();
        if (updated.getBirth() != null) this.birth = updated.getBirth();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
