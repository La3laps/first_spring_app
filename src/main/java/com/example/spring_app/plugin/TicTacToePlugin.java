package com.example.spring_app.plugin;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

@Component
public class TicTacToePlugin implements GamePlugin {

    private final TicTacToeGameFactory ticTacToe = new TicTacToeGameFactory();

    @Autowired
    MessageSource messageSource;

    @Value("${game.tictactoe.default-player-count}")
    private int defaultPlayerCount;

    @Value("${game.tictactoe.default-board-size}")
    private int defaultBoardSize;

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage("game.tictactoe.name", null, locale);
    }

    @Override
    public Game createGame() {
        return ticTacToe.createGame(defaultPlayerCount, defaultBoardSize);

    };
}