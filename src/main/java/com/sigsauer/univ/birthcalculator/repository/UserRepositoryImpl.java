package com.sigsauer.univ.birthcalculator.repository;

import com.sigsauer.univ.birthcalculator.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em = Persistence.createEntityManagerFactory("sample").createEntityManager();

    public List<User> findAll() {
        List<User> users = em.createQuery("SELECT User FROM User user").getResultList();
        return users.isEmpty() ? Collections.emptyList() : users;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public List<User> findByEmail(String email) {
        List<User> users = em.createQuery("SELECT User FROM User user WHERE user.email = :email")
                .setParameter("email", email)
                .getResultList();
        return users.isEmpty() ? Collections.emptyList() : users;
    }

    public User save(User user) {
        em.getTransaction().begin();
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        em.getTransaction().commit();
        return user;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Optional<User> optionalUser = this.findById(id);
        optionalUser.ifPresent(em::remove);
        em.getTransaction().commit();
    }




}
