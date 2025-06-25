package org.realmsengine.component;

public interface SizeComponent {
    double getWidth();
    double getHeight();
    void setWidth(double width);
    void setHeight(double height);
    default void setSize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }
}
