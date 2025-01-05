package com.example.spring_app.data;

import java.sql.Connection;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


@Repository
public class MySQLUserDAO implements IUserDAO {
    private Connection connection;
    private final ArrayList<UserData> userList = new ArrayList<>();

    @Override
    public ArrayList<UserData> getAllUsers(){
        return userList;
    };

    @Override
    public UserData getUserById(int id){
        return new UserData(null, null, null, null);
    };

    @Override
    public void addUser(UserData user){};
    
    @Override
    public void updateUser(UserData user){};

    @Override
    public void deleteUser(int id){

    };
}
