package org.realmsengine;

import javax.swing.JFrame;

public class Window {
    JFrame jframe;
    public Panel panel;

    public Window(String title, int width, int height) {
        jframe = new JFrame();
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setTitle(title);

        panel = new Panel(width, height);
        jframe.add(panel);
        jframe.pack();

        jframe.setVisible(true);
    }
}
