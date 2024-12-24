package com.example.spring_app.gamedto;

import java.util.ArrayList;

import com.example.spring_app.service.UserService;



public class MySQLUserDAO implements IUserDAO {

    private final ArrayList<UserService> userList = new ArrayList<>();

    @Override
    public ArrayList<UserService> getAllUsers(){
        return userList;
    };

    @Override
    public UserService getUserById(int id){
        return new UserService(null, null, null, null);
    };

    @Override
    public void addUser(UserService user){};
    
    @Override
    public void updateUser(UserService user){};

    @Override
    public void deleteUser(int id){

    };
}
