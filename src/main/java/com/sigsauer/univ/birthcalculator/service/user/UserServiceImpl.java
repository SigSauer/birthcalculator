package com.sigsauer.univ.birthcalculator.service.user;

import com.sigsauer.univ.birthcalculator.model.Entities;
import com.sigsauer.univ.birthcalculator.model.User;
import com.sigsauer.univ.birthcalculator.utils.StringUtils;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public List<User> getAllUsers() {
        return Entities.getInstance().getAll();
    }

    @Override
    public User getUserById(Long id) {
        if (id == null) throw new IllegalArgumentException("id cannot be empty");
        User found = Entities.getInstance().getById(id);
        if (found == null) throw new IllegalArgumentException("user cannot be found by ID="+id);
        return found;
    }

    @Override
    public List<User> getUsersByEmail(String email) {
        if (StringUtils.isEmpty(email)) throw new IllegalArgumentException("email cannot be empty");
        return Entities.getInstance().getByEmail(email);
    }

    @Override
    public Date getUserBirth(Long id) {
        if (id == null) throw new IllegalArgumentException("id cannot be empty");
        Date result = Entities.getInstance().getById(id).getBirth();
        if (result == null) throw new IllegalArgumentException("user birth cannot be received by ID="+id);
        return result;
    }

    @Override
    public User createUser(User user) {
        if (user == null) throw new IllegalArgumentException("fields cannot be empty");
        User created = Entities.getInstance().addUser(user);
        if (created == null) throw new IllegalArgumentException("user cannot be created with values: "+user.toString());
        return created;
    }

    @Override
    public User updateUser(Long id, User user) {
        if (id == null || user == null) throw new IllegalArgumentException("fields cannot be empty");
        User updated = Entities.getInstance().updateUser(id, user);
        if (updated == null) throw new IllegalArgumentException("user cannot be updated by ID="+id+" with values: "+user.toString());
        return updated;
    }

    @Override
    public void deleteUser(Long id) {
        if (id == null) throw new IllegalArgumentException("id cannot be empty");
        Entities.getInstance().deleteUser(id);
    }
}
