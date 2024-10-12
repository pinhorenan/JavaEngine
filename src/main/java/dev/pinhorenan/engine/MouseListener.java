package dev.pinhorenan.engine;

public class MouseListener {
    private static MouseListener instance;
    private double scrollX, scrollY;
    private double xPosition, getScrollY, lastY, lastX;
    private boolean[] mouseButtonPressed = new boolean[3];
    private boolean isDragging;
}
