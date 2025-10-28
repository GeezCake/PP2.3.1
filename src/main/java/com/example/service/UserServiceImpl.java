package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void create(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.removeUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAllUsers();
    }
}