package com.example.spring_app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_app.gamedto.GameCreationDTOImpl;
import com.example.spring_app.service.GameServiceImpl;

import fr.le_campus_numerique.square_games.engine.Game;

@RestController
public class GameController {
    Game currentGame;

    @Autowired
    private GameServiceImpl gameService;
    private GameCreationDTOImpl gameSettings;

    @PostMapping("/games")
    public Game createGame(@RequestBody GameCreationDTOImpl gameCreationParams) {
        currentGame = gameService.createGame(gameCreationParams);
        gameSettings = gameCreationParams;
        if (gameSettings != null) {
            gameSettings.setGameDTO(currentGame);
            ArrayList<String> currentGameSettings = gameSettings.setCurrentGameSettings();
            gameService.updateGameList(currentGameSettings);
        }
        return currentGame;
    }

    @GetMapping("/games")
    public String choseGame() {
        return "Send a POST request to chose game.";
    }

    @GetMapping("/games/{gameId}")
    public ArrayList<String> getGame(@PathVariable String gameId) {
        if (gameService != null) {
            ArrayList<ArrayList<String>> gameList = gameService.getGameList();
            for (ArrayList<String> elem : gameList) {
                for (String settings : elem) {
                    if (settings.equals(gameId)) {
                        return elem;
                    }
                }
            }
        }

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
        if (gameSettings != null && gameService != null) {
            return gameService.getGameList();
        } else {
            ArrayList<ArrayList<String>> noGames = new ArrayList<>();
            ArrayList<String> emptyList = new ArrayList<>();

            emptyList.add("There is no ongoing game...");
            noGames.add(emptyList);

            return noGames;
        }
    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable String gameId) {
        if (gameService != null) {
            ArrayList<ArrayList<String>> gameList = gameService.getGameList();

            for (ArrayList<String> elem : gameList) {
                if (elem.get(0).equals(gameId)) {
                    gameList.remove(elem);
                }
            }
        }

    }
}