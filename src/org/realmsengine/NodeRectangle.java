package org.realmsengine;

import java.awt.Graphics2D;

public class NodeRectangle implements Node {
    public double x, y;
    public double width, height;
    public Color color;

    public NodeRectangle(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void update() {}

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color.awt());
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }
}
