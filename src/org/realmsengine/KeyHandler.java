package org.realmsengine;

import java.awt.event.KeyEvent;

public class KeyHandler implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        Key.setDown(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        Key.setDown(e.getKeyCode(), false);
    }
}
