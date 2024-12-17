package com.example.spring_app.gamedto;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class GameCollectionDTO {
    private ArrayList<ArrayList<String>> ongoingGames;

    public ArrayList<ArrayList<String>> getOngoingGames() {
        return this.ongoingGames;
    }

    public void setOngoingGames(ArrayList<String> settings) {
        this.ongoingGames.add(settings);
    }

}