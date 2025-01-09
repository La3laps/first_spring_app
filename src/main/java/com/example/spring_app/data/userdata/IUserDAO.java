package com.example.spring_app.data.userdata;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO {
    List<UserData> getAllUsers();

    UserData getUserById(int id);

    int addUser(UserData user);

    void updateUser(UserData user);

    void deleteUser(int id);
}
