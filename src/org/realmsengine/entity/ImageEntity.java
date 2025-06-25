package org.realmsengine.entity;

import org.realmsengine.component.DrawComponent;
import org.realmsengine.component.PositionComponent;
import org.realmsengine.component.SizeComponent;
import org.realmsengine.component.TextureComponent;
import org.realmsengine.type.Texture;

import java.awt.Graphics2D;

public class ImageEntity implements DrawComponent, PositionComponent, SizeComponent, TextureComponent {
    private Texture texture;
    private double x, y;
    private double width, height;

    public ImageEntity(Texture texture, double x, double y, double width, double height) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public ImageEntity(Texture texture, double x, double y) {
        this(texture, x, y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(texture.getBufferedImage(), (int)x, (int)y, (int)width, (int)height, null);
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
    public Texture getTexture() {
        return texture;
    }

    @Override
    public void setTexture(Texture texture) {
        this.texture = texture;
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
}
