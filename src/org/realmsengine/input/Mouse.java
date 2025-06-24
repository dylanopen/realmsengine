package org.realmsengine.input;

public class Mouse {
    public static int x = 0;
    public static int y = 0;
    public static boolean captured = true;
    private static final boolean[] buttonsDown = new boolean[10];

    public static void setDown(int button, boolean isDown) {
        if (button < 0 || button >= buttonsDown.length) { return; }
        buttonsDown[button] = isDown;
    }

    public static boolean isDown(int button) {
        if (button < 0 || button >= buttonsDown.length) { return false; }
        return buttonsDown[button];
    }
}
