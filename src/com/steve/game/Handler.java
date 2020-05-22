package com.steve.game;

import com.steve.GameEngine;
import com.steve.entity.Entity;
import com.steve.entity.item.Item;
import com.steve.entity.mob.Mob;
import com.steve.entity.mob.mobs.Fish_test;
import com.steve.entity.mob.mobs.Man;
import com.steve.utility.ImageLoader;
import com.steve.worldgen.Tile;
import com.steve.worldgen.ore.Ore;
import com.steve.worldgen.tiles.TileGrass;

import java.awt.*;
import java.util.ArrayList;

public class Handler {
    public final int size = 600;

    private ArrayList<Entity> entityList = new ArrayList<>();
    private ArrayList<Mob> mobList = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();
    private Tile[][] tiles = new Tile[size][size];
    private Ore[][] ores = new Ore[size][size];

    private GameEngine engine;

    private int ax = 0, ay = 0;

    public Handler(GameEngine engine) {
        this.engine = engine;
        addEntity(new Man(300, 300));
        for (int i = 0; i < 3; i++)
            addEntity(new Fish_test(300, 300));
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles.length; j++) {
                addTile(new TileGrass(i, j));
            }
        addOrePatch(30, 30, 100000, 3);
        addItem(new Item(300, 300, "test", ImageLoader.getImgByID("itemtemplate")));
    }

    public void addEntity(Entity e) {
        if (e instanceof Mob) mobList.add((Mob) e);
        entityList.add(e);
    }

    public void addTile(Tile t) {
        tiles[t.getX() / 16][t.getY() / 16] = (Tile) t;
    }

    public void addOre(Ore o) {
        ores[o.getX() / 16][o.getY() / 16] = (Ore) o;
    }

    public void addItem(Item i) {
        itemList.add(i);
    }

    public void addOrePatch(int x, int y, int amount, int radius) {
        int startX = x - radius;
        int startY = y - radius;
        int stopX = x + radius;
        int stopY = y + radius;
        int t1 = (stopX - startX) * (stopY - startY);
        int t2 = amount / t1;
        //System.out.println("startX: " + startX + ", stopX: " + stopX + ", startY: " + startY + ", stopY: " + stopY + ", t1: " + t1 + ", t2:" + t2);
        for (int i = startX; i < stopX; i++)
            for (int j = startY; j < stopY; j++)
                addOre(new Ore(i, j, t2, Ore.ores.iron));
    }

    public void removeMob(int i) {
        mobList.remove(i);
        entityList.remove(i);
    }

    public void RemoveOre(Ore o) {
        for (int i = 0; i < ores.length; i++)
            for (int j = 0; j < ores.length; j++)
                if (!(ores[i][j] == null))
                    if (ores[i][j].equals(o))
                        ores[i][j] = null;
    }

    public void tick() {
        moveMap();

        for (int i = 0; i < mobList.size(); i++)
            mobList.get(i).tick();
    }

    private void moveMap() {
        ax = 0;
        ay = 0;
        if (engine.keyboard.getkey(37)) ax += 1;
        else if (engine.keyboard.getkey(39)) ax += -1;
        if (engine.keyboard.getkey(38)) ay += 1;
        else if (engine.keyboard.getkey(40)) ay += -1;
        for (int i = 0; i < entityList.size(); i++)
            entityList.get(i).transform(ax, ay);
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles.length; j++)
                if (!(tiles[i][j] == null))
                    tiles[i][j].transform(ax, ay);
        for (int i = 0; i < ores.length; i++)
            for (int j = 0; j < ores.length; j++)
                if (!(ores[i][j] == null))
                    ores[i][j].transform(ax, ay);
        for (int i = 0; i < itemList.size(); i++)
            itemList.get(i).transform(ax, ay);
    }


    public void render(Graphics g, Graphics2D g2D) {
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles.length; j++)
                if (!(tiles[i][j] == null))
                    if (onScreen(tiles[i][j].getX(), tiles[i][j].getY()))
                        tiles[i][j].render(g, g2D);
        for (int i = 0; i < ores.length; i++)
            for (int j = 0; j < ores.length; j++)
                if (!(ores[i][j] == null))
                    ores[i][j].render(g, g2D);
        for (int i = 0; i < mobList.size(); i++)
            mobList.get(i).render(g, g2D);
        for (int i = 0; i < itemList.size(); i++)
            itemList.get(i).render(g, g2D);
    }

    public boolean onScreen(int x, int y) {
        return (x < 1200) && (x > -32) && (y < 675) && (y > -32);
    }
}
