package com.steve.entity.mob.mobs;

import com.steve.entity.mob.Mob;
import com.steve.utility.animation.Animation;
import com.steve.utility.Vector2i;

public class Man extends Mob {
    public Man(Vector2i vector2i) {
        super(vector2i, Animation.manAnimation());

    }

    public Man(int x, int y) {
        super(x, y, Animation.manAnimation());
    }

    @Override
    public void tick() {
        super.tick();
    }
}
