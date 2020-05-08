package com.steve.game;

import com.steve.GameEngine;
import com.steve.graphics.inventory.Inventory;

import java.awt.*;

public class Game {

    private GameEngine gameEngine;
    private Handler handler;
    private Inventory inventory;

    public Game(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.handler = new Handler(gameEngine);
        this.inventory = new Inventory(gameEngine);
    }

    public void tick() {
        handler.tick();
        inventory.tick();
    }

    public void render(Graphics g, Graphics2D g2D) {
        handler.render(g, g2D);
        inventory.render(g, g2D);
    }
}
