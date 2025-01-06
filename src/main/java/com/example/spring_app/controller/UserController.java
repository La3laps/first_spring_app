package com.example.spring_app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_app.data.MySQLUserDAO;
import com.example.spring_app.data.UserData;

@RestController
public class UserController {

    @Autowired
    MySQLUserDAO msqlDAO;

    @PostMapping("/user")
    public void addUser(@RequestBody UserData user) {
        msqlDAO.addUser(user);
    }

    @GetMapping("/users")
    public ArrayList<UserData> getMethodName() {
        return msqlDAO.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public String showUser(@PathVariable String userId) {
        String username = msqlDAO.getUserById(Integer.parseInt(userId)).getName();
        System.out.println(msqlDAO.getUserById(Integer.parseInt(userId)).getName());
        String userEmail = msqlDAO.getUserById(Integer.parseInt(userId)).getEmail();

        String result = "The current user is " + username + ", his/her email is " + userEmail;
        return result;
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody UserData user) {
        msqlDAO.updateUser(user);

        return "User: " + user.getName() + " was updated in DB.";
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestBody UserData user) {
        msqlDAO.deleteUser(user.getId().intValue());

        return "User: " + user.getName() + " was deleted from DB.";
    }
}
