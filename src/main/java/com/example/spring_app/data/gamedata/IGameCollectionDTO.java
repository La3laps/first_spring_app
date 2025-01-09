package com.example.spring_app.data.gamedata;
import java.util.ArrayList;

public interface IGameCollectionDTO {
     ArrayList<ArrayList<String>> getOngoingGames();
     
     void setOngoingGames(ArrayList<String> settings);
}
