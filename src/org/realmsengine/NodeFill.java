package org.realmsengine;

import java.awt.Graphics2D;

public class NodeFill implements Node {
    public Color color;
    private NodeRectangle rect;

    public NodeFill(Color color) {
        this.color = color;
        rect = new NodeRectangle(0, 0, Panel.inst.getWidth(), Panel.inst.getHeight(), color);
    }

    @Override
    public void update() {}

    @Override
    public void draw(Graphics2D g) {
        rect.draw(g);
    }
}
