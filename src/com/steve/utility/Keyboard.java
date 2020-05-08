package com.steve.utility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private boolean[] key = new boolean[65536];

    public boolean getkey(int key) {
        return this.key[key];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true;
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            System.exit(0);
        //System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
