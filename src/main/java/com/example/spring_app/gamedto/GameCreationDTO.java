package com.example.spring_app.gamedto;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.le_campus_numerique.square_games.engine.Game;

@Service
public class GameCreationDTO {
    private String gameType;
    private int playerCount;
    private int boardSize;
    private UUID gameId;
    private String status;

    public String getGameType() {
        return this.gameType;
    }

    public int getPlayerSettings(String gameType) {
        switch (gameType) {
            case "tictactoe":
                this.playerCount = 2;
                break;
            case "15 puzzle":
                this.playerCount = 1;
                break;
            case "connect4":
                this.playerCount = 2;
                break;
            default:
                break;
        }
        return this.playerCount;
    }

    public int getBoardSettings(String gameType) {
        switch (gameType) {
            case "tictactoe" -> {
                this.boardSize = 3;
            }
            case "15 puzzle" -> {
                this.boardSize = 4;

            }
            case "connect4" -> {
                this.boardSize = 7;
            }
            default -> {
            }
        }
        return this.boardSize;
    }

    private String getCurrentIdIfExists() {
        if (this.gameId != null) {
            return this.gameId.toString();
        }
        return "You need to create a game to play...";
    }

    public ArrayList<String> setCurrentGameSettings() {
        ArrayList<String> settings = new ArrayList<>();

        settings.add(getCurrentIdIfExists());

        if (this.gameId != null) {
            settings.add(this.gameType);
            settings.add(this.status);
        }
        return settings;
    }

    public void setGameDTO(Game currentGame) {
        if (currentGame != null) {
            this.gameId = currentGame.getId();
            this.status = currentGame.getStatus().toString();
        }
    }

}