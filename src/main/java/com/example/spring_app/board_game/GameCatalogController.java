package com.example.spring_app.board_game;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameCatalogController {

    @SuppressWarnings("unused")
    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/game")
    public ArrayList<String> getId() {
        GameCatalogImpl gameCatalogImpl = new GameCatalogImpl();
        return gameCatalogImpl.getGameIdentifiers();
    }
}