package com.sokolR.project.repository;

import com.sokolR.project.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserInMemoryRepositoryTest {

    private UserRepository userRepository = new UserInMemoryRepository();
    private User user = new User(1, "testConstuctor", "hello@world.ru", null, List.of());


    @Test
    void shouldSaveOneEntity() {
//        given - это то что у нас было
        UserRepository userRepository = new UserInMemoryRepository();
        User user = new User(1, "testConstuctor", "hello@world.ru", null, List.of());
//        when
        userRepository.save(user);
//        them
        List<User> all = userRepository.findAll();
        assertEquals(all.size(), 1);
    }

    @Test
    void shouldReturnEmptyOptionalWhenUserNotFound() {
        // given - это то что у нас было
        UserRepository userRepository = new UserInMemoryRepository();
        Long nonExistentId = 999L;

        // when
        Optional<User> result = userRepository.findById(nonExistentId);

        // then
        assertTrue(result.isEmpty(), "Optional должен быть пустым для несуществующего ID");
    }
    @Test
    void shouldReturnUserWhenUserExists() {
        // given - это то что у нас было
        UserRepository userRepository = new UserInMemoryRepository();
        User user = new User(1L, "testConstructor", "hello@world.ru", null, List.of());
        userRepository.save(user); // Сначала сохраняем, чтобы пользователь появился в хранилище
        Long existingId = 1L;

        // when
        Optional<User> result = userRepository.findById(existingId);

        // then
        assertTrue(result.isPresent(), "Optional не должен быть пустым");
        assertEquals(result.get().name(), "testConstructor");
        assertEquals(result.get().getEmail(), "hello@world.ru");
    }

    @Test
    void shouldReturnEmptyListWhenNoUsers() {
        // given - это то что у нас было
        UserRepository userRepository = new UserInMemoryRepository();

        // when
        List<User> all = userRepository.findAll();

        // then
        assertEquals(all.size(), 0, "Список должен быть пустым, если пользователей нет");
    }

    @Test
    void shouldDeleteExistingUser() {
        // given - это то что у нас было
        UserRepository userRepository = new UserInMemoryRepository();
        User user = new User(1L, "Удаление", "delete@test.com", null, List.of());
        userRepository.save(user); // Сначала сохраняем пользователя

        // when
        userRepository.deleteById(1L);

        // then
        List<User> all = userRepository.findAll();
        assertEquals(all.size(), 0, "Список должен быть пустым после удаления");
    }

    @Test
    void shouldReturnUserWhenEmailExists() {
        // given - это то что у нас было
        UserRepository userRepository = new UserInMemoryRepository();
        User user = new User(1L, "testConstructor", "hello@world.ru", null, List.of());
        userRepository.save(user); // Сохраняем, чтобы email попал в хранилище
        String searchEmail = "hello@world.ru";

        // when
        Optional<User> result = userRepository.findByEmail(searchEmail);

        // then
        assertTrue(result.isPresent(), "Optional не должен быть пустым");
        assertEquals(result.get().getEmail(), searchEmail);
    }
}