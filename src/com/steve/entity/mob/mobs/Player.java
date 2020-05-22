package com.steve.entity.mob.mobs;

import com.steve.entity.mob.Mob;
import com.steve.entity.mob.animation.Animation;


public class Player extends Mob {
    public Player(int x, int y, Animation animation) {
        super(x, y, Animation.manAnimation());
    }

    public void tick() {

    }
}
