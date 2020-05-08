package com.steve.graphics.inventory;

import com.steve.entity.item.Item;

import java.awt.image.BufferedImage;

public class ItemStack {
    protected Item item;
    public final int SIZE;
    protected BufferedImage sprite;

    public ItemStack(Item item, int SIZE) {
        this.item = item;
        this.SIZE = SIZE;
        sprite = this.item.getSprite();
    }

    public Item getItem() {
        return this.item;
    }
}
