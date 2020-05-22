package com.steve.graphics.inventory;

import com.steve.GameEngine;
import com.steve.entity.item.Item;
import com.steve.utility.ImageLoader;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Inventory {

    private GameEngine game;

    public boolean IsOpen;

    private ItemSlot[][] slots = new ItemSlot[6][4];

    public Inventory(GameEngine game) {
        this.game = game;
        IsOpen = true;
        Item item = new Item(0, 0, "test", ImageLoader.getImgByID("itemtemplate"));
        slots[0][0] = new ItemSlot(new ItemStack(item, 64));
        slots[0][1] = new ItemSlot(new ItemStack(item, 64));
    }

    int timer = 0;

    public void tick() {
        if (timer == 0) {
            if (game.keyboard.getkey(69)) {
                IsOpen = !IsOpen;
                timer++;
            }
        } else timer++;
        if (timer > 10) {
            timer = 0;
        }
    }

    public void render(Graphics g, Graphics2D g2D) {
        if (IsOpen) {
            g.setColor(new Color(169, 169, 169, 100));
            g.fillRect(0, 0, 300, 200);

            g.setColor(Color.BLUE);
            for (int i = 0; i < 350; i += 50)
                g.fillRect(i, 0, 5, 200);
            for (int i = 0; i < 250; i += 50)
                g.fillRect(0, i, 300, 5);

            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 4; j++)
                    if (slots[i][j] != null) {
                        BufferedImage sprite = slots[i][j].getStack().getItem().getSprite();
                        int x = slots[i][j].getStack().getItem().getX();
                        int y = slots[i][j].getStack().getItem().getY();
                        int w = sprite.getWidth() * 4;
                        int h = sprite.getHeight() * 4;
                        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                        AffineTransform at = new AffineTransform();
                        at.scale(4.0, 4.0);
                        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                        after = scaleOp.filter(sprite, after);

                        g.drawImage(after, x, y, null);
                    }
        }
    }
}
