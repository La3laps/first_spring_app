package com.example.spring_app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_app.service.GameCatalog;
import com.example.spring_app.service.GameCatalogImpl;

@RestController
public class GameCatalogController {

    @SuppressWarnings("unused")
    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/catalog")
    public ArrayList<String> getId() {
        GameCatalogImpl gameCatalogImpl = new GameCatalogImpl();
        return gameCatalogImpl.getGameIdentifiers();
    }
}