package org.realmsengine.component;

public interface PositionComponent {
    double getX();

    double getY();

    void setX(double x);

    void setY(double y);

    default void setPosition(double x, double y) {
        setX(x);
        setY(y);
    }

    default void addX(double delta) {
        setX(getX() + delta);
    }
    default void addY(double delta) {
        setY(getY() + delta);
    }

    default void addPosition(double deltaX, double deltaY) {
        addX(deltaX);
        addY(deltaY);
    }
}
