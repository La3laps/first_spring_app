package com.example.spring_app.service.gameservice;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

@Service
public class GameCatalogImpl implements GameCatalog {
    private final TicTacToeGameFactory ticTacToeGameInstance = new TicTacToeGameFactory();
    private final TaquinGameFactory taquinInstance = new TaquinGameFactory();
    private final ConnectFourGameFactory connectFourInstance = new ConnectFourGameFactory();
    private final ArrayList<String> identifiers = new ArrayList<>();

    @Override
    public ArrayList<String> getGameIdentifiers() {
        String ticTacToeId = ticTacToeGameInstance.getGameFactoryId();
        String taquinId = taquinInstance.getGameFactoryId();
        String connectFourId = connectFourInstance.getGameFactoryId();

        identifiers.add(ticTacToeId);
        identifiers.add(taquinId);
        identifiers.add(connectFourId);
        return identifiers;
    }
}