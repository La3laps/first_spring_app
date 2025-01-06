package com.example.spring_app.data;

import java.util.ArrayList;

public interface IUserDAO {
    ArrayList<UserData> getAllUsers();

    UserData getUserById(int id);

    int addUser(UserData user);

    void updateUser(UserData user);

    void deleteUser(int id);
}
