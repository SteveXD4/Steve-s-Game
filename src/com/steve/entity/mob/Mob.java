package com.steve.entity.mob;

import com.steve.entity.Entity;
import com.steve.entity.mob.animation.Animation;
import com.steve.utility.Vector2i;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Mob extends Entity {
    protected BufferedImage idleSpite, sprite, rotate;
    protected Rectangle rect;
    protected int ax, ay;
    protected Random r;
    protected Animation animation;


    public Mob(Vector2i vector2i, Animation animation) {
        super(vector2i);
        rect = new Rectangle(16, 16, vector2i.getX(), vector2i.getY());
        this.animation = animation;
        this.animation.SetFrame(0);
        rotate = this.sprite = this.animation.getImg();
        r = new Random();
    }

    public Mob(int x, int y, Animation animation) {
        super(x, y);
        rect = new Rectangle(16, 16, vector2i.getX(), vector2i.getY());
        this.animation = animation;
        this.animation.SetFrame(0);
        rotate = this.sprite = this.animation.getImg();
        r = new Random();
    }

    @Override
    public void tick() {
        if (move())
            animation.tick();
        else animation.SetFrame(0);

        sprite = rotate = animation.getImg();

        if (ax > 0) rotate = rotate(sprite, 0);
        else if (ax < 0) rotate = rotate(sprite, 180);
        /*if (ax > 0) rotate = rotate(sprite, 270);
        else if (ax < 0) rotate = rotate(sprite, 90);*/
        vector2i.setX(vector2i.getX() + ax);
        vector2i.setY(vector2i.getY() + ay);
    }

    private boolean move() {
        if (r.nextInt(50) == 0) {
            if (r.nextBoolean())
                ax = r.nextInt(3) - 1;
            else
                ay = r.nextInt(3) - 1;
            if (r.nextInt(5) == 0) {
                ax = 0;
                ay = 0;
            }
        }
        return !((ax == 0) && ay == 0);
    }

    public static BufferedImage rotate(BufferedImage img, double angle) {
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, img.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w / 2, h / 2);
        graphic.drawImage(img, null, 0, 0);
        graphic.dispose();
        return rotated;
    }

    @Override
    public void render(Graphics g, Graphics2D g2D) {
        g.drawImage(rotate, vector2i.getX(), vector2i.getY(), null);
    }
}