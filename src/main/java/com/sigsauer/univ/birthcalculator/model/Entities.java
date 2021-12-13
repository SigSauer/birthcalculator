package com.sigsauer.univ.birthcalculator.model;

import com.sigsauer.univ.birthcalculator.exception.UserAlreadyExistException;
import com.sigsauer.univ.birthcalculator.exception.UserException;
import com.sigsauer.univ.birthcalculator.exception.UserNotFoundException;
import com.sigsauer.univ.birthcalculator.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Entities {
    private final LinkedList<User> USERS = new LinkedList<>();

    private static Entities instance = null;

    private Entities() {}

    public static Entities getInstance() {
        if (instance == null) {
            instance = new Entities();
        }
        return instance;
    }

    private synchronized void reindex() {
        LinkedList<User> updated = new LinkedList<>(this.USERS);
        this.USERS.clear();
        updated.stream()
                .sorted(Comparator.comparingLong(User::getId))
                .forEachOrdered(u -> this.USERS.set(u.getId().intValue(), u));
    }

    private synchronized User authenticate(String email, String password) {
        return this.USERS.stream().filter(u -> u.getEmail().equalsIgnoreCase(email) &&
                u.getPassword().equals(password)).findAny().orElse(null);
    }

    private synchronized Long add(User user) {
        Long lastId;
        if (this.USERS.isEmpty())
            lastId = 0L;
        else {
            lastId = this.USERS.getLast().getId();
            lastId++;
        }
        user.setId(lastId);
        this.USERS.addLast(user);
        return lastId;
    }

    private synchronized boolean update(Long id, User user) throws UserException{
        User toUpdate = this.get(id);
        if (toUpdate.getEmail().equalsIgnoreCase(user.getEmail().toLowerCase()))
            throw new UserAlreadyExistException("EMAIL", user.getEmail());
        toUpdate.update(user);
        if (StringUtils.isNotEmpty(user.getPassword())) {
            toUpdate.setPassword(user.getPassword());
        }
        this.USERS.set(toUpdate.getId().intValue(), toUpdate);
        return true;
    }

    private synchronized boolean delete(Long id) throws UserNotFoundException {
        User foundUser = this.get(id);
        this.USERS.remove(foundUser);
        return true;
    }

    private synchronized User get(Long id) throws UserNotFoundException {
        User foundUser = null;
        try {
            foundUser = this.USERS.get(id.intValue());
        }catch (Exception ignored) {}
        if (foundUser == null)
            throw new UserNotFoundException("ID", id.toString());
        if (!foundUser.getId().equals(id)) {
            reindex();
            return this.get(id);
        } else
            return foundUser;
    }

    private synchronized List<User> emails(String email) {
        return this.USERS.stream()
                .filter(u -> u.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }

    private synchronized boolean exist(String email) {
        if (this.USERS.isEmpty()) return false;
        return this.USERS.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email.toLowerCase()));
    }


    public List<User> getAll() {
        return this.USERS;
    }

    public User getById(Long id) {
        return this.get(id);
    }

    public List<User> getByEmail(String email) {
        return this.emails(email);
    }

    public synchronized User addUser(User user) throws UserException {
        if (!this.exist(user.getEmail())) {
            Long addedId = this.add(user);
            return this.get(addedId);
        }else
            throw new UserAlreadyExistException("EMAIL", user.getEmail());
    }

    public void deleteUser(Long id) throws UserNotFoundException {
         this.delete(id);
    }

    public User updateUser(Long id, User user) throws UserException {
        this.update(id, user);
        return this.get(id);
    }
}
