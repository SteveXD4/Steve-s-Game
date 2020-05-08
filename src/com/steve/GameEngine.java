package com.steve;

import com.steve.game.Game;
import com.steve.utility.*;
import com.steve.graphics.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameEngine extends Canvas implements Runnable {

    private boolean running = false;
    public final String Title = "dont know yet";
    private Thread thread;
    public static final int width = 1200, height = width / 16 * 9;
    private final Dimension d = new Dimension(width, height);
    private Window window;
    public Keyboard keyboard;
    public Mouse mouse;
    private Game game;

    public GameEngine() {
        window = new Window(d, this);
        keyboard = new Keyboard();
        mouse = new Mouse();
        addKeyListener(keyboard);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        new ImageLoader();
        new MediaPlayer();
        game = new Game(this);

        start();
    }


    public void tick() {
        game.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2D = (Graphics2D) g;
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, width, height);
        game.render(g, g2D);
        // leave empty!
        g.dispose();
        bs.show();

    }

    public void start() {
        thread = new Thread(this);
        this.thread.start();
        running = true;
    }

    public void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000.0 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frame = 0;
        int Up = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                Up++;
                delta--;
            }
            if (running) {
                render();
            }
            frame++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frame);
                frame = 0;
                Up = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        new GameEngine();
    }
}
