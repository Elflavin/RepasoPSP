package org.educa.examen.repository;

import org.educa.examen.entity.User;

import java.util.List;

public interface UserRepository {


    User getUser(String username);

    List<User> getUsers();

    void createUser(User user);

    void deleteUser(String username);

    void updateUser(User user);

    boolean existUser(String username);
}
