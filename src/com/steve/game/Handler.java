package com.steve.game;

import com.steve.GameEngine;
import com.steve.entity.Entity;
import com.steve.entity.decoration.Decoration;
import com.steve.entity.decoration.Tree;
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
    private ArrayList<Decoration> decorationsList = new ArrayList<>();
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
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++)
                addEntity(new Tree(i, j));
        addOrePatch(30, 30, 100000, 3);
        addItem(new Item(300, 300, "test", ImageLoader.getImgByID("itemtemplate")));
    }

    public void addEntity(Entity e) {
        if (e instanceof Mob) mobList.add((Mob) e);
        else if (e instanceof Decoration) decorationsList.add((Decoration) e);
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
        for (Entity entity : entityList) entity.transform(ax, ay);
        for (Tile[] tile : tiles)
            for (int j = 0; j < tiles.length; j++)
                if (!(tile[j] == null))
                    tile[j].transform(ax, ay);
        for (Ore[] ore : ores)
            for (int j = 0; j < ores.length; j++)
                if (!(ore[j] == null))
                    ore[j].transform(ax, ay);
        for (Item item : itemList) item.transform(ax, ay);
        for (Decoration decoration:decorationsList)decoration.tick();
    }


    public void render(Graphics g, Graphics2D g2D) {
        for (Tile[] tile : tiles)
            for (int j = 0; j < tiles.length; j++)
                if (!(tile[j] == null))
                    if (onScreen(tile[j].getX(), tile[j].getY()))
                        tile[j].render(g, g2D);
        for (Ore[] ore : ores)
            for (int j = 0; j < ores.length; j++)
                if (!(ore[j] == null))
                    ore[j].render(g, g2D);
        for (Mob mob : mobList) mob.render(g, g2D);
        for (Item item : itemList) item.render(g, g2D);
        for (Decoration decoration : decorationsList) decoration.render(g, g2D);
    }

    public boolean onScreen(int x, int y) {
        return (x < 1200) && (x > -32) && (y < 675) && (y > -32);
    }
}
