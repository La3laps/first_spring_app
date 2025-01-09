package com.example.spring_app.data.gamedata;

import java.util.ArrayList;

import fr.le_campus_numerique.square_games.engine.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GameData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String factoryId;
    private String gameId;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public GameData(String factoryId, String gameId, String status) {
        this.factoryId = factoryId;
        this.gameId = gameId;
        this.status = status;
    }

    public GameData() {
    }
    
    // Getters et setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFactoryId() {
        return factoryId;
    }
    public void setName(String factoryId) {
        this.factoryId = factoryId;
    }
    public String getGameId() {
        return gameId;
    }
    public void setEmail(String gameId) {
        this.gameId = gameId;
    }
    public String getStatus() {
        return status;
    }

    private String getCurrentIdIfExists() {
        if (this.gameId != null) {
            return this.gameId;
        }
        return "You need to create a game to play...";
    }

    public ArrayList<String> setCurrentGameSettings() {
        ArrayList<String> settings = new ArrayList<>();

        settings.add(getCurrentIdIfExists());

        if (this.gameId != null) {
            settings.add(this.factoryId);
            settings.add(this.status);
        }
        return settings;
    }

    public void setGameDTO(Game currentGame) {
        if (currentGame != null) {
            this.gameId = currentGame.getId().toString();
            this.status = currentGame.getStatus().toString();
        }
    }

}