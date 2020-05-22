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

            g.drawImage(ImageLoader.getImgByID("inventory"), 0, 0, null);

            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 4; j++)
                    if (slots[i][j] != null) {
                        double size = 5.0;
                        BufferedImage sprite = slots[i][j].getStack().getItem().getSprite();
                        int x = slots[i][j].getStack().getItem().getX();
                        int y = slots[i][j].getStack().getItem().getY();
                        int w = sprite.getWidth() * (int) size;
                        int h = sprite.getHeight() * (int) size;
                        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                        AffineTransform at = new AffineTransform();
                        at.scale(size, size);
                        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                        after = scaleOp.filter(sprite, after);

                        g.drawImage(after, i * 16, j * 16, null);
                    }
        }
    }
}
