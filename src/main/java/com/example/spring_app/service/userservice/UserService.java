package com.example.spring_app.service.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_app.data.userdata.JPAUserDAO;
import com.example.spring_app.data.userdata.UserData;

@Service
public class UserService implements IUserService {

    @Autowired
    private final JPAUserDAO userDAO;

    public UserService(JPAUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(UserData user) {
        userDAO.addUser(user);
    }

    public List<UserData> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public UserData getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public void updateUser(UserData user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
        ;
    }
}