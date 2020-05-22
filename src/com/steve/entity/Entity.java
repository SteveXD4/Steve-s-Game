package com.steve.entity;

import com.steve.utility.Vector2i;

import java.awt.*;

public class Entity {
    protected Vector2i vector2i;

    public Entity(Vector2i vector2i) {
        this.vector2i = vector2i;
    }

    public Entity(int x, int y) {
        vector2i = new Vector2i(x, y);
    }

    public void tick() {

    }

    public void transform(int ax, int ay) {
        this.vector2i.sumX(ax);
        this.vector2i.sumY(ay);
    }

    public Vector2i getVector2i() {
        return vector2i;
    }

    public void SetX(int x) {
        this.vector2i.setX(x);
    }

    public void SetY(int y) {
        this.vector2i.setX(y);
    }

    public int getX() {
        return this.vector2i.getX();
    }

    public int getY() {
        return this.vector2i.getY();
    }

    public void render(Graphics g, Graphics2D g2D) {

    }
}


