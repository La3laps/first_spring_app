package com.example.spring_app.board_game;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

@Service
public class GameCatalogImpl implements GameCatalog {
    private final TicTacToeGameFactory ticTacToeGameInstance = new TicTacToeGameFactory();
    private ArrayList<String> identifiers = new ArrayList<>();

    @Override
    public ArrayList<String> getGameIdentifiers() {
        String ticTacToeId = ticTacToeGameInstance.getGameFactoryId();

        identifiers.add(ticTacToeId);

        return identifiers;
    }
}