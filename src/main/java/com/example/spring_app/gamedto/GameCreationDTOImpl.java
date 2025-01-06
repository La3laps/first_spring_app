package com.example.spring_app.gamedto;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.le_campus_numerique.square_games.engine.Game;

@Service
public class GameCreationDTOImpl implements IGameCreationDTO {
    private String gameType;
    private int playerCount;
    private int boardSize;
    private String gameId;
    private String status;

    @Override
    public String getGameType() {
        return this.gameType;
    }

    @Override
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

    @Override
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
            return this.gameId;
        }
        return "You need to create a game to play...";
    }

    @Override
    public ArrayList<String> setCurrentGameSettings() {
        ArrayList<String> settings = new ArrayList<>();

        settings.add(getCurrentIdIfExists());

        if (this.gameId != null) {
            settings.add(this.gameType);
            settings.add(this.status);
        }
        return settings;
    }

    @Override
    public void setGameDTO(Game currentGame) {
        if (currentGame != null) {
            this.gameId = currentGame.getId().toString();
            this.status = currentGame.getStatus().toString();
        }
    }

}