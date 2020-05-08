package com.steve.entity.item;

import com.steve.utility.Vector2i;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Item {
    protected Vector2i vector2i;
    protected BufferedImage sprite;
    protected String name;

    public Item(int x, int y, String name, BufferedImage sprite) {
        this.name = name;
        this.sprite = sprite;
        vector2i = new Vector2i(x, y);
    }

    public Vector2i getVector2i() {
        return vector2i;
    }

    public int getX() {
        return vector2i.getX();
    }

    public int getY() {
        return vector2i.getY();
    }

    public String getName() {
        return this.name;
    }

    public BufferedImage getSprite() {
        return this.sprite;
    }

    public void transform(int ax, int ay) {
        this.vector2i.sumX(ax);
        this.vector2i.sumY(ay);
    }

    public void render(Graphics g, Graphics2D g2D) {
        g.drawImage(sprite, getX(), getY(), null);
    }

    @Override
    public boolean equals(Object o) {
        return (vector2i.equals((Vector2i) o)) && (name.equals(((Item) o).name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector2i, name);
    }
}