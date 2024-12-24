package com.example.spring_app.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.spring_app.gamedto.GameCreationDTOImpl;
import com.example.spring_app.plugin.ConnectFourPlugin;
import com.example.spring_app.plugin.TaquinPlugin;
import com.example.spring_app.plugin.TicTacToePlugin;

import fr.le_campus_numerique.square_games.engine.Game;


@Service
public class GameServiceImpl implements GameService {
    private final ArrayList<ArrayList<String>> gameList = new ArrayList<>();
    
    @Override
    public Game createGame(GameCreationDTOImpl gameCreationParams) {
        switch (gameCreationParams.getGameType()) {
            case "tictactoe" -> {
                return new TicTacToePlugin().createGame();
            }
            case "taquin" -> {
                return new TaquinPlugin().createGame();
            }
            case "connectfour" -> {
                return new ConnectFourPlugin().createGame();
            }
            default -> {
                System.out.println("No game was chosen");
                return null;
            }
        }
    }

    public void updateGameList(ArrayList<String> settings) {
        if (settings.get(0) != null) {
            gameList.add(settings);
        }
    }

    public ArrayList<ArrayList<String>> getGameList() {
        return gameList;
    }
}