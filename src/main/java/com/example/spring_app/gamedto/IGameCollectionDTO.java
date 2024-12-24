package com.example.spring_app.gamedto;

import java.util.ArrayList;

public interface IGameCollectionDTO {
     ArrayList<ArrayList<String>> getOngoingGames();
     
     void setOngoingGames(ArrayList<String> settings);
}
