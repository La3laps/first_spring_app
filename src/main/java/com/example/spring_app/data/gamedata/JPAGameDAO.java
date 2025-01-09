package com.example.spring_app.data.gamedata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPAGameDAO {

    @Autowired
    private GameRepository gameRepository;

    public List<GameData> getAllUsers() {
        return gameRepository.findAll();
    }

    public GameData getUserById(int userId) {
        return gameRepository.findById(userId).orElse(null);
    }

    public int addUser(GameData user) {
        GameData savedUser = gameRepository.save(user); // Save user
        return savedUser.getId();
    }

    // public void updateUser(GameData user) {
    //     GameData userToUpdate = getUserById(user.getId());
    //     userToUpdate.setEmail(user.getEmail());
    //     userToUpdate.setName(user.getName());
    //     gameRepository.save(userToUpdate);
    // }

    // public void deleteUser(int id) {
    //     gameRepository.deleteById(id);
    // }
}