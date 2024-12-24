package com.example.spring_app.service;

import com.example.spring_app.gamedto.GameCreationDTOImpl;

import fr.le_campus_numerique.square_games.engine.Game;

public interface GameService {

    Game createGame(GameCreationDTOImpl gameCreationParams);
}