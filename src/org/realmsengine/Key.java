package org.realmsengine;

import java.util.Arrays;

public class Key {
    private static boolean[] keysDown = new boolean[java.awt.event.KeyEvent.KEY_LAST + 1];

    public static boolean isDown(int keyCode) {
        return keysDown[keyCode];
    }

    static void setDown(int keyCode, boolean isDown) {
        keysDown[keyCode] = isDown;
    }
}
