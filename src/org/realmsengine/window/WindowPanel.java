package org.realmsengine.window;

import org.realmsengine.input.GameTime;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.Duration;

public class WindowPanel extends JPanel implements Runnable {
    private GameLoop gameLoop;
    private Thread thread;
    private final Window window;
    private volatile boolean hasDrawn = false;

    public WindowPanel(Window window) {
        this.window = window;
        super.setPreferredSize(new Dimension(window.width, window.height));
        super.setBackground(Color.BLACK);
        super.setDoubleBuffered(true);
    }

    public void start(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
        thread = new Thread(this, "RealmsMainThread");
        thread.start();
    }

    @Override
    public void run() {
        while (thread.isAlive()) {
            GameTime.deltaNanos = System.nanoTime() - GameTime.lastFrame;
            GameTime.delta = (double)GameTime.deltaNanos / 1_000_000_000.0;
            GameTime.lastFrame = System.nanoTime();
            double frameInterval = 1_000_000_000.0 / window.targetFPS;
            double nextFrameTime = System.nanoTime() + frameInterval    ;

            gameLoop.update();
            hasDrawn = false;
            repaint();
            while (!hasDrawn) { Thread.onSpinWait(); }

            double remainingTime = nextFrameTime - System.nanoTime();
            if (remainingTime < 0) { remainingTime = 0; }
            try {
                Thread.sleep(Duration.ofNanos((long)remainingTime));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        if (gameLoop == null) {
            g.dispose();
            return;
        }
        super.paintComponent(g);
        gameLoop.draw(g);
        g.dispose();
        hasDrawn = true;
    }
}
