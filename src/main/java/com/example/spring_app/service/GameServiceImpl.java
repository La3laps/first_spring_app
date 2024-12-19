package com.example.spring_app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.spring_app.gamedto.GameCreationDTO;
import com.example.spring_app.plugin.ConnectFourPlugin;
import com.example.spring_app.plugin.TaquinPlugin;
import com.example.spring_app.plugin.TicTacToePlugin;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;


@Service
public class GameServiceImpl implements GameService {
    private final ArrayList<ArrayList<String>> gameList = new ArrayList<>();

    @Value("${game.tictactoe.name}")
    private MessageSource tictactoeMsg;
    @Value("${game.taquin.name}")
    private MessageSource taquinMsg;
    @Value("${game.connect4.name}")
    private MessageSource connectfourMsg;

    @Override
    public Game createGame(GameCreationDTO gameCreationParams) {
        switch (gameCreationParams.getGameType()) {
            case "tictactoe" -> {
                return new TicTacToePlugin(new TicTacToeGameFactory(), tictactoeMsg).createGame();
            }
            case "taquin" -> {
                return new TaquinPlugin(new TaquinGameFactory(), taquinMsg).createGame();
            }
            case "connectfour" -> {
                return new ConnectFourPlugin(new ConnectFourGameFactory(), connectfourMsg).createGame();
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