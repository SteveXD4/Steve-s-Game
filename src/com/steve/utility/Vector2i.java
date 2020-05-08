package com.steve.utility;

import java.util.Objects;

public class Vector2i {
    private int x, y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Vector2i(Vector2i other) {
        this.x = other.x;
        this.y = other.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void sumX(int x) {
        this.x += x;
    }

    public void sumY(int y) {
        this.y += y;
    }

    public void addX() {
        this.x++;
    }

    public void addY() {
        this.y++;
    }

    @Override
    public boolean equals(Object o) {
        Vector2i vector2i = (Vector2i) o;
        return vector2i.getX() == this.getX() && vector2i.getY() == this.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + " ," + y + ") ";
    }
}
