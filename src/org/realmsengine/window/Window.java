package org.realmsengine.window;

import org.realmsengine.input.KeyHandler;
import org.realmsengine.input.MouseHandler;

import javax.swing.JFrame;

public class Window {
    private final WindowPanel panel;
    int width, height;
    public int targetFPS = 60;

    public Window(String title, int width, int height) {
        this.width = width;
        this.height = height;
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        panel = new WindowPanel(this);
        frame.add(panel);
        frame.addKeyListener(new KeyHandler());
        frame.addMouseListener(new MouseHandler());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public Window(int width, int height) {
        this("Realms Engine", width, height);
    }

    public void start(GameLoop gameLoop) {
        panel.start(gameLoop);
    }
}
