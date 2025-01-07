package com.example.spring_app.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPAUserDAO implements IUserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserData getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public int addUser(UserData user) {
        UserData savedUser = userRepository.save(user); // Save user
        return savedUser.getId();
    }

    @Override
    public void updateUser(UserData user) {
        UserData userToUpdate = getUserById(user.getId());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setName(user.getName());
        userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}