package org.realmsengine.type;

public class RgbaColor {
    public int r;
    public int g;
    public int b;
    public int a;

    public RgbaColor(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public RgbaColor(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public RgbaColor() {
        this(0, 0, 0, 255);
    }

    public java.awt.Color awt() {
        return new java.awt.Color(r, g, b, a);
    }
}
