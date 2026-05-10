package com.sokolR.project.repository;

import com.sokolR.project.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Метод сохранения: принимает объект User и возвращает сохраненную версию
 * Метод поиска по Id: возвращает "контейнер" Optional, внутри которого может быть пользователь или пустота
 * Метод получения всех записей: возвращает список всех пользователей из хранилища
 * Метод удаления: принимает id и удаляет запись, ничего не возвращая
 */

public interface UserRepository {

    User save (User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    Optional <User> findByEmail(String email);
}
