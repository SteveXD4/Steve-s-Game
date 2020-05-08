package com.steve.worldgen.ore;

import com.steve.game.Handler;
import com.steve.utility.ImageLoader;
import com.steve.utility.Vector2i;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class Ore {
    protected BufferedImage sprite;
    protected Vector2i vector2i;
    protected int amount;
    protected Enum Oretype;
    protected Handler handler;

    public Ore(int x, int y, int amount, ores OreType) {
        vector2i = new Vector2i(x * 16, y * 16);
        this.amount = amount;
        this.Oretype = OreType;
        String string = t();
        switch (OreType) {
            case iron:
                this.sprite = ImageLoader.getImgByID("iron_ore_s" + string);
                break;
            case coal:
                this.sprite = ImageLoader.getImgByID("" + string);
                break;
            case copper:
                this.sprite = ImageLoader.getImgByID("" + string);
                break;
        }
    }

    //iron_ore_s1_a1
    private String t() {
        String s = "";
        if (0 <= amount && amount < 300) s = "1";
        if (300 <= amount && amount < 1500) s = "2";
        if (1500 <= amount && amount < 3000) s = "3";
        if (3000 <= amount) s = "4";
        s += "_a";
        s += new Random().nextInt(3) + 1;
        return s;
    }

    public void init(Handler handler) {
        this.handler = handler;
    }

    public void transform(int ax, int ay) {
        this.vector2i.sumX(ax);
        this.vector2i.sumY(ay);
    }

    public void mineOre() {
        amount--;
        if (amount <= 0)
            handler.RemoveOre(this);
    }

    public Enum getEnum() {
        return Oretype;
    }

    public int getX() {
        return vector2i.getX();
    }

    public int getY() {
        return vector2i.getY();
    }

    public Vector2i getVector2i() {
        return this.vector2i;
    }

    public void render(Graphics g, Graphics2D g2D) {
        g.drawImage(sprite, vector2i.getX(), vector2i.getY(), null);
    }

    @Override
    public boolean equals(Object o) {
        Ore t = (Ore) o;
        return ((vector2i == ((Ore) o).vector2i) && (amount == t.amount));
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector2i, amount, Oretype);
    }

    public enum ores {
        copper, iron, coal
    }

}
