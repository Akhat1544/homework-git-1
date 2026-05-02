package com.sokolR.project.repository;

import com.sokolR.project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    // метод сохранения: принимает объект User и возвращает сохраненную версию
    User save (User user);
    Optional<User> findById(Long id); // метод поиска по Id: возвращает "контейнер" Optional, внутри которого может быть пользователь или пустота
    List<User> findAll(); // метод получения всех записей: возвращает список всех пользователей из хранилища
    void deleteById(Long id); // метод удаления: принимает id и удаляет запись, ничего не возвращая
    Optional <User> findByEmail(String email);
}
