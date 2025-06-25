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

    default void addWidth(double delta) {
        setWidth(getWidth() + delta);
    }
    default void addHeight(double delta) {
        setHeight(getHeight() + delta);
    }

    default void addSize(double deltaX, double deltaY) {
        addWidth(deltaX);
        addHeight(deltaY);
    }
}
