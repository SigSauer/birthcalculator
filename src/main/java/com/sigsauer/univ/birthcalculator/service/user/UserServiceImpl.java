package com.sigsauer.univ.birthcalculator.service.user;

import com.sigsauer.univ.birthcalculator.model.Entities;
import com.sigsauer.univ.birthcalculator.model.User;
import com.sigsauer.univ.birthcalculator.repository.UserRepository;
import com.sigsauer.univ.birthcalculator.repository.UserRepositoryImpl;
import com.sigsauer.univ.birthcalculator.utils.StringUtils;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<User> getAllUsers() {
        return Entities.getInstance().getAll();
    }

    @Override
    public User getUserById(Long id) {
        if (id == null) throw new IllegalArgumentException("id cannot be empty");
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user cannot be found by ID="+id));
    }

    @Override
    public List<User> getUsersByEmail(String email) {
        if (StringUtils.isEmpty(email)) throw new IllegalArgumentException("email cannot be empty");
        return userRepository.findByEmail(email);
    }

    @Override
    public Date getUserBirth(Long id) {
        if (id == null) throw new IllegalArgumentException("id cannot be empty");
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user birth cannot be received by ID="+id)).getBirth();
    }

    @Override
    public User createUser(User user) {
        if (user == null) throw new IllegalArgumentException("fields cannot be empty");
        User found = null;
        try {
            found = this.getUserById(user.getId());
        }catch (IllegalArgumentException ignored) {}
        if (found != null) {
            user.setId(found.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        user.setId(id);
        return this.createUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
