package com.example.spring_app.service.gameservice;

import com.example.spring_app.data.gamedata.GameData;

import fr.le_campus_numerique.square_games.engine.Game;

public interface IGameService {

    
    Game createGame(GameData gameCreationParams);
}