package com.steve.graphics;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.steve.GameEngine;

public class Window extends Canvas {
    public JFrame jframe;
    private static final long serialVersionUID = 1608042719441354180L;

    public Window(Dimension dimension, GameEngine game) {
        jframe = new JFrame();
        jframe.setTitle(game.Title);
        jframe.setPreferredSize(dimension);
        jframe.setMaximumSize(dimension);
        jframe.setMinimumSize(dimension);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocale(null);
        jframe.add(game);
        jframe.setVisible(true);
    }
}

