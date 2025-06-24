package org.realmsengine.entity;

import org.realmsengine.component.Color;
import org.realmsengine.component.DrawComponent;
import org.realmsengine.type.RgbaColor;

import java.awt.Graphics2D;

public class Fill implements DrawComponent, Color {
    public RgbaColor color;

    public Fill(RgbaColor color) {
        this.color = color;
    }

    @Override
    public RgbaColor getRgbaColor() {
        return color;
    }

    @Override
    public void setColor(RgbaColor color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;
        new Rectangle(0, 0, width, height, color).draw(g);
    }
}
