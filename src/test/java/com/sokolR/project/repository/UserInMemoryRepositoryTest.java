package com.sokolR.project.repository;

import com.sokolR.project.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Assertions.assertEquals(all.size(), 1);
    }
}