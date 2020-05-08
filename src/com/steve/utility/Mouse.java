package com.steve.utility;

import java.awt.event.*;

public class Mouse extends MouseAdapter implements MouseMotionListener {

    private int x, y;
    private boolean[] keys = new boolean[4];

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        keys[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        keys[e.getButton()] = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}