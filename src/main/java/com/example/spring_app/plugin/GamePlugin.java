package com.example.spring_app.plugin;

import java.util.Locale;

import fr.le_campus_numerique.square_games.engine.Game;


public interface GamePlugin {
    String getName(Locale locale);

    Game createGame();
}