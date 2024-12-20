package com.example.spring_app.plugin;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;

@Component
public class ConnectFourPlugin implements GamePlugin {
    private final ConnectFourGameFactory connectFour;
    private final MessageSource messageSource;

    @Value("${game.connect4.default-player-count}")
    private int defaultPlayerCount;

    @Value("${game.connect4.default-board-size}")
    private int defaultBoardSize;

    public ConnectFourPlugin(ConnectFourGameFactory connectFourGameFactory, MessageSource messageSource) {
        this.connectFour = connectFourGameFactory;
        this.messageSource = messageSource;
    }

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage("game.tictactoe.name", null, locale);
    }

    @Override
    public Game createGame() {
        return connectFour.createGame(defaultPlayerCount, defaultBoardSize);
    }
}