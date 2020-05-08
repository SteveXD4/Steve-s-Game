package com.steve.entity.mob.mobs;

import com.steve.entity.mob.Mob;
import com.steve.entity.mob.animation.Animation;
import com.steve.utility.Vector2i;

import java.awt.*;


public class Fish_test extends Mob {

    public Fish_test(Vector2i vector2i) {
        super(vector2i, Animation.fishAnimation());
    }

    public Fish_test(int x, int y) {
        super(x, y, Animation.fishAnimation());
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(Graphics g, Graphics2D g2D) {
        super.render(g, g2D);

    }
}
