package com.sokolR.project.service;

import com.sokolR.project.entity.User;
import com.sokolR.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Регистрация пользователя
    public User registerUser(String name, String email) {
        // Проверка: нет ли такого email?
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким email уже существует!");
        }

        User newUser = new User(1, name, email, null, null);
        return userRepository.save(newUser);
    }

    // Добавление в корзину
    public void addToCart(Long userId, String productName) {
        User user = getUserOrThrow(userId);
        userRepository.save(user);
        System.out.println("✅ Товар '" + productName + "' добавлен в корзину пользователю " + user.name());
    }

    private User getUserOrThrow(Long userId) {

    }
}
