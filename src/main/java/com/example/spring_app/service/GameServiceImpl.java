package com.example.spring_app.service;

import org.springframework.stereotype.Service;

import com.example.spring_app.gamedto.GameCreationDTO;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

@Service
public class GameServiceImpl implements GameService {

    @Override
    public Game createGame(GameCreationDTO gameCreationParams) {
        switch (gameCreationParams.getGameType()) {
            case "tictactoe" -> {
                return new TicTacToeGameFactory().createGame(gameCreationParams.getPlayerSettings("tictactoe"),
                        gameCreationParams.getBoardSettings("tictactoe"));
            }
            case "taquin" -> {
                return new TaquinGameFactory().createGame(gameCreationParams.getPlayerSettings("15 puzzle"),
                        gameCreationParams.getBoardSettings("15 puzzle"));
            }
            case "connectfour" -> {
                return new ConnectFourGameFactory().createGame(gameCreationParams.getPlayerSettings("connect4"),
                        gameCreationParams.getBoardSettings("connect4"));
            }
            default -> {
                System.out.println("No game was chosen");
                return null;
            }
        }
    }
}