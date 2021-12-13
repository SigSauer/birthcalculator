package com.sigsauer.univ.birthcalculator.service.user;

import com.sigsauer.univ.birthcalculator.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> getUsersByEmail(String email);

    Date getUserBirth(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);



}
