package org.realmsengine.entity;

import org.realmsengine.component.ColorComponent;
import org.realmsengine.type.RgbaColor;
import org.realmsengine.component.DrawComponent;
import org.realmsengine.component.PositionComponent;
import org.realmsengine.component.SizeComponent;

import java.awt.Graphics2D;

public class RectangleEntity implements DrawComponent, PositionComponent, SizeComponent, ColorComponent {
    private double x, y;
    private double width, height;
    private RgbaColor color;

    public RectangleEntity(double x, double y, double width, double height, RgbaColor color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color.awt());
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public RgbaColor getRgbaColor() {
        return color;
    }

    @Override
    public void setColor(RgbaColor color) {
        this.color = color;
    }
}
