package com.example.spring_app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_app.gamedto.GameCreationDTO;
import com.example.spring_app.service.GameServiceImpl;

import fr.le_campus_numerique.square_games.engine.Game;

@RestController
public class GameController {
    Game currentGame;
    private final ArrayList<ArrayList<String>> ongoingGames = new ArrayList<>();

    @Autowired
    private GameServiceImpl gameService;
    private GameCreationDTO gameSettings;

    @PostMapping("/games")
    public Game createGame(@RequestBody GameCreationDTO gameCreationParams) {
        currentGame = gameService.createGame(gameCreationParams);
        gameSettings = gameCreationParams;
        if (gameSettings != null) {
            gameSettings.setGameDTO(currentGame);
            gameSettings.setCurrentGameSettings();
            gameSettings.updateOnGoingGames(ongoingGames);
        }
        return currentGame;
    }

    @GetMapping("/games")
    public String choseGame() {
        return "Send a POST request to chose game.";
    }

    @GetMapping("/games/{gameId}")
    public ArrayList<String> getGame() {
        if (gameSettings != null) {
            return gameSettings.setCurrentGameSettings();
        } else {
            ArrayList<String> noGame = new ArrayList<>();
            noGame.add("There is no ongoing game...");
            return noGame;
        }

    }

    @GetMapping("/games/ongoing-games")
    public ArrayList<ArrayList<String>> getOngoingGames() {
        if (gameSettings != null) {
            return ongoingGames;
        } else {
            ArrayList<ArrayList<String>> noGames = new ArrayList<>();
            ArrayList<String> emptyList = new ArrayList<>();

            emptyList.add("There is no ongoing game...");
            noGames.add(emptyList);

            return noGames;
        }
    }

    @PutMapping("/games/{status}")
    public String updateStatus(@PathVariable String status, @RequestBody String entity) {
        // TODO: process PUT request
        return entity;
    }

}