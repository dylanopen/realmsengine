package org.realmsengine;

import java.awt.Color;
import java.awt.Graphics2D;

public class Panel extends javax.swing.JPanel implements Runnable {
    private Thread thread;
    private Loop loop;
    public int fps = 60;
    public static Panel inst;
    private boolean hasDrawn = false;

    public Panel(int width, int height) {
        super();
        super.setPreferredSize(new java.awt.Dimension(width, height));
        super.setBackground(Color.black);
        super.setDoubleBuffered(true);
        super.setOpaque(true);
        super.setFocusable(true);
        super.addKeyListener(new KeyHandler());
        super.addMouseListener(new MouseHandler());
        Panel.inst = this;
    }

    public void setLoop(Loop loop) {
        this.loop = loop;
    }

    /// Please do NOT call this method without using Panel.setLoop(Loop) first.
    /// Your game will crash or simply not draw or update any nodes.
    public void startThread() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /// Do NOT call this method manually.
    /// Use the Panel.startThread() method instead.
    /// Otherwise, your game is likely to crash.
    @Override
    public void run() {
        double drawInterval = 1000000000.0 / fps; // a frame every 0.016667 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (thread != null) {
            long frameStartTime = System.nanoTime();
            update();
            repaint();
            while (!hasDrawn) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double remainingTime = nextDrawTime - System.nanoTime();
            if (remainingTime > 0) {
                try {
                    Thread.sleep((long) remainingTime / 1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            nextDrawTime += drawInterval;
            long frameEndTime = System.nanoTime();
            long deltaNano = frameEndTime - frameStartTime;
            Time.deltaNano = deltaNano;
            Time.delta = deltaNano / 1000000000.0;
            Time.currentFPS = 1.0 / Time.delta;
        }
    }

    public void stop() {
        thread = null;
    }

    public void update() {
        MouseHandler.newFrame();
        loop.update();
    }

    public void paintComponent(java.awt.Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;
        loop.draw(g);
        g.dispose();
        hasDrawn = true;
    }
}
