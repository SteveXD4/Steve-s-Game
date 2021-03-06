package com.steve.worldgen;

import com.steve.utility.Vector2i;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    protected Vector2i vector2i;
    protected Rectangle rect;
    protected BufferedImage sprite;

    public Tile(int x, int y) {
        this.vector2i = new Vector2i(x * 16, y * 16);
        this.rect = new Rectangle(vector2i.getX(), vector2i.getY(), 16, 16);
    }

    public void transform(int ax, int ay) {
        this.vector2i.sumX(ax);
        this.vector2i.sumY(ay);
    }

    public int getX() {
        return vector2i.getX();
    }

    public int getY() {
        return vector2i.getY();
    }

    public void render(Graphics g, Graphics2D g2D) {
        g.drawImage(sprite, vector2i.getX(), vector2i.getY(), null);
    }
}
