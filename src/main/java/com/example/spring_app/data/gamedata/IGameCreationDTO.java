package com.example.spring_app.data.gamedata;

import java.util.ArrayList;

import fr.le_campus_numerique.square_games.engine.Game;

public interface IGameCreationDTO {
    String getGameType();

    int getPlayerSettings(String gameType);

    int getBoardSettings(String gameType);

    ArrayList<String> setCurrentGameSettings();

    void setGameDTO(Game currentGame);
}
