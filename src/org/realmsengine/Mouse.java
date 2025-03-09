package org.realmsengine;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class Mouse {
    public static boolean[] buttonsDown = new boolean[MouseEvent.MOUSE_LAST + 1];
    public static int x = 0;
    public static int y = 0;

    public static void setDown(int button, boolean isDown) {
        if (button >= 0 && button < buttonsDown.length) {
            buttonsDown[button] = isDown;
        }
    }

    public static boolean isButtonDown(int button) {
        if (button >= 0 && button < buttonsDown.length) {
            return buttonsDown[button];
        }
        return false;
    }

}
