package com.sokolR.project.service;

import com.sokolR.project.entity.User;
import com.sokolR.project.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//  Метод регистрации пользователя
    public User registerUser(String name, String email){
//        Проверка email
        if (userRepository.findByEmail(email).isPresent()){
            throw new IllegalArgumentException("Пользователь с таким email уже существует!");
        }
        User newUser = new User(null, name, email);
        return userRepository.save(newUser);
    }
}
