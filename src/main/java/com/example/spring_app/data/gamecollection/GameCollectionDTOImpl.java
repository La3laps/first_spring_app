package com.example.spring_app.data.gamecollection;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class GameCollectionDTOImpl implements IGameCollectionDTO {
    private ArrayList<ArrayList<String>> ongoingGames;

    @Override
    public ArrayList<ArrayList<String>> getOngoingGames() {
        return this.ongoingGames;
    }

    @Override
    public void setOngoingGames(ArrayList<String> settings) {
        this.ongoingGames.add(settings);
    }

}