package org.realmsengine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Mouse.setDown(mouseEvent.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Mouse.setDown(mouseEvent.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        Mouse.captured = true;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        Mouse.captured = false;
    }
}
