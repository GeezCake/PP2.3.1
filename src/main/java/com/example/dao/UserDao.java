// src/main/java/com/example/dao/UserDao.java
package com.example.dao;

import com.example.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
}