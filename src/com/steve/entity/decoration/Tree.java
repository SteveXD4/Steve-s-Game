package com.steve.entity.decoration;

import com.steve.utility.ImageLoader;
import com.steve.utility.animation.Animation;

import java.awt.*;

public class Tree extends Decoration {
    public Tree(int x, int y) {
        super(x * 64, y * 64);
        sprite = ImageLoader.getImgByID("tree_f1");
        rect = new Rectangle(getX(), getY(), 64, 128);
        animation = Animation.treeAnimation();
    }

    @Override
    public void tick() {
        super.tick();
        animation.tick();
    }

    @Override
    public void render(Graphics g, Graphics2D g2D) {
        g.drawImage(animation.getImg(), getX(), getY(), null);
    }
}
