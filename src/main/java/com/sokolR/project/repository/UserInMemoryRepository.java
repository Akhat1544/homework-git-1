package com.sokolR.project.repository;

import com.sokolR.project.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserInMemoryRepository implements UserRepository{

    private final Map<Long, User> database = new HashMap<>();
    private long nextId = 1;

    @Override
    public User save(User user) {

        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
