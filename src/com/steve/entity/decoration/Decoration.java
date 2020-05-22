package com.steve.entity.decoration;

import com.steve.entity.Entity;
import com.steve.utility.animation.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Decoration extends Entity {

    protected BufferedImage sprite;
    protected int timer;
    protected Rectangle rect;
    protected Animation animation;

    public Decoration(int x, int y) {
        super(x, y);
        timer = 0;
    }

    @Override
    public void tick() {
        timer++;
        if (timer >= 10000)
            timer = 0;
    }

    @Override
    public void render(Graphics g, Graphics2D g2D) {
        g.drawImage(sprite, getX(), getY(), null);
    }
}
