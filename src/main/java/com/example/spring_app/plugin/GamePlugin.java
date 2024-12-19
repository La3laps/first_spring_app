package com.example.spring_app.plugin;

import java.util.Locale;

import org.springframework.stereotype.Component;

import fr.le_campus_numerique.square_games.engine.Game;

@Component
public interface GamePlugin {
    String getName(Locale locale);

    Game createGame();
}