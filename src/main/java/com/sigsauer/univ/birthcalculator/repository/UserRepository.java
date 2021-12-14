package com.sigsauer.univ.birthcalculator.repository;

import com.sigsauer.univ.birthcalculator.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(Long id);

    List<User> findByEmail(String email);

    User save(User user);

    void delete(Long id);
}
