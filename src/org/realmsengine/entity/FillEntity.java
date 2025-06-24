package org.realmsengine.entity;

import org.realmsengine.component.ColorComponent;
import org.realmsengine.component.DrawComponent;
import org.realmsengine.type.Color;

import java.awt.Graphics2D;

public class FillEntity implements DrawComponent, ColorComponent {
    public Color color;

    public FillEntity(Color color) {
        this.color = color;
    }

    @Override
    public Color getRgbaColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;
        new RectangleEntity(0, 0, width, height, color).draw(g);
    }
}
