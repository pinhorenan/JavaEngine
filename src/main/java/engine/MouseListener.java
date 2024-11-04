package engine;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

@SuppressWarnings("FieldMayBeFinal")
public class MouseListener {
    private static MouseListener instance;
    private double scrollX, scrollY;
    private double positionX, positionY, lastY, lastX;
    private boolean[] mouseButtonPressed = new boolean[3];
    private boolean isDragging;

    // Constructor
    private MouseListener() {
        scrollX = 0.0;
        scrollY = 0.0;
        positionX = 0.0;
        positionY = 0.0;
        lastX = 0.0;
        lastY = 0.0;
    }

    // Singleton pattern
    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }
        return MouseListener.instance;
    }

    // Callbacks
    public static void mousePosCallback(long window, double positionX, double positionY) {
       get().lastX = get().positionX;
       get().lastY = get().positionY;
       get().positionX = positionX;
       get().positionY = positionY;
       get().isDragging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2];
    }

    public static void mouseButtonCallback(long window, int button, int action, int mods){
        if (action == GLFW_PRESS) {
            if (button < get().mouseButtonPressed.length) {
                get().mouseButtonPressed[button] = true;
            }
        } else if (action == GLFW_RELEASE) {
            get().mouseButtonPressed[button] = false;
            get().isDragging = false;
        }
    }

    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {
        get().scrollX = xOffset;
        get().scrollY = yOffset;
    }

    // Methods
    public static void endFrame() {
        get().scrollX = 0;
        get().scrollY = 0;
        get().lastX = get().positionX;
        get().lastY = get().positionY;
    }

    public static float getX() {
        return (float) get().positionX;
    }

    public static float getY() {
        return (float) get().positionY;
    }

    public static float getDx() {
        return (float) (get().lastX - get().positionX);
    }

    public static float getDy() {
        return (float) (get().lastY - get().positionY);
    }

    public static float getScrollX() {
        return (float) get().scrollX;
    }

    public static float getScrollY() {
        return (float) get().scrollY;
    }

    public static boolean isDragging() {
        return get().isDragging;
    }

    public static boolean mouseButtonDown(int button) {
        if (button < get().mouseButtonPressed.length) {
            return get().mouseButtonPressed[button];
        } else {
            return false;
        }
    }

}
