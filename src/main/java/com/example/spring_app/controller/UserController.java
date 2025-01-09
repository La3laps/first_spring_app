package com.example.spring_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_app.data.userdata.GameUserDTO;
import com.example.spring_app.data.userdata.JPAUserDAO;
import com.example.spring_app.data.userdata.UserData;

@RestController
public class UserController {

    @Autowired
    // MySQLUserDAO msqlDAO;
    JPAUserDAO msqlDAO;

    @PostMapping("/user")
    public void addUser(@RequestBody GameUserDTO user) {
        UserData userData = new UserData();
        userData.setEmail(user.email());
        userData.setName(user.name());
        msqlDAO.addUser(userData);
    }

    @GetMapping("/user")
    public List<UserData> getUser() {
        List<UserData> all = msqlDAO.getAllUsers();
        return all;
    }

    @GetMapping("/user/{userId}")
    public String showUser(@PathVariable String userId) {
        String username = msqlDAO.getUserById(Integer.parseInt(userId)).getName();
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

        msqlDAO.deleteUser(user.getId());

        return "User: " + user.getName() + " was deleted from DB.";
    }
}
