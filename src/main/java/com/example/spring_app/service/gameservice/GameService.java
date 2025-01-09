package com.example.spring_app.service.gameservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_app.data.gamedata.GameData;
import com.example.spring_app.plugin.ConnectFourPlugin;
import com.example.spring_app.plugin.TaquinPlugin;
import com.example.spring_app.plugin.TicTacToePlugin;

import fr.le_campus_numerique.square_games.engine.Game;

@Service
public class GameService implements IGameService {
    private final ArrayList<ArrayList<String>> gameList = new ArrayList<>();

    @Autowired
    TicTacToePlugin ticTacToePlugin;
    @Autowired
    ConnectFourPlugin connectFourPlugin;
    @Autowired
    TaquinPlugin taquinPlugin;
    
    @Override
    public Game createGame(GameData gameCreationParams) {
        switch (gameCreationParams.getFactoryId()) {
            case "tictactoe" -> {
                return ticTacToePlugin.createGame();
            }
            case "taquin" -> {
                return taquinPlugin.createGame();
            }
            case "connectfour" -> {
                return connectFourPlugin.createGame();
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