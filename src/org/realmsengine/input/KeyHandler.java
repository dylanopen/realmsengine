package org.realmsengine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        Key.setDown(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Key.setDown(e.getKeyCode(), false);
    }
}
