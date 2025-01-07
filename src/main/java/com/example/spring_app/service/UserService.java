package com.example.spring_app.service;

import com.example.spring_app.data.IUserDAO;
import com.example.spring_app.data.UserData;

public class UserService implements IUserService {

    private IUserDAO userDAO;

    public UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int addUser(UserData user) {
        userDAO.addUser(user);
        return 1;
    }
}