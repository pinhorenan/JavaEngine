package dev.pinhorenan.engine;

public class MouseListener {
    private static MouseListener instance;
    private double scrollX, scrollY;
    private double positionX, positionY, lastY, lastX;
    private boolean[] mouseButtonPressed = new boolean[3];
    private boolean isDragging;
}

private MouseListener() {
    this.scrollX = 0.0;
    this.scrollY = 0.0;
    this.xPosition = 0.0;
    this.yPosition = 0.0;
    this.lastX = 0.0;
    this.lastY = 0.0;
}
