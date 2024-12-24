package com.example.spring_app.gamedto;

import java.util.ArrayList;

import com.example.spring_app.service.UserService;

public interface IUserDAO {
    ArrayList<UserService> getAllUsers();

    UserService getUserById(int id);

    void addUser(UserService user);

    void updateUser(UserService user);

    void deleteUser(int id);
}
