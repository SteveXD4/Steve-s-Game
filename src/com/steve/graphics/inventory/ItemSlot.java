package com.steve.graphics.inventory;

public class ItemSlot {

    protected ItemStack stack;

    public ItemSlot(ItemStack stack) {
        this.stack = stack;
    }

    public ItemStack getStack() {
        return this.stack;
    }
}
