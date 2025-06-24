package org.realmsengine.input;

public class Key {
    private static final boolean[] keysDown = new boolean[400];

    public static boolean isDown(int keyCode) {
        if (keyCode < 0 || keyCode >= keysDown.length) {
            return false;
        }
        return keysDown[keyCode];
    }

    public static void setDown(int keyCode, boolean isDown) {
        if (keyCode < 0 || keyCode >= keysDown.length) { return; }
        keysDown[keyCode] = isDown;
    }
}
