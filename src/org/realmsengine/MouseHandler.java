package org.realmsengine;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class MouseHandler implements java.awt.event.MouseListener {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        Mouse.setDown(e.getButton(), true);
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        Mouse.setDown(e.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    static void newFrame() {
        Point mousePos = java.awt.MouseInfo.getPointerInfo().getLocation();
        Mouse.x = mousePos.x - Panel.inst.getLocationOnScreen().x;
        Mouse.y = mousePos.y - Panel.inst.getLocationOnScreen().y;
    }
}
