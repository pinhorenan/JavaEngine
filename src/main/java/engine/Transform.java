package engine;

import org.joml.Vector2f;

public class Transform {
    public Vector2f position;
    public Vector2f scale;

    // Default constructor
    public Transform() {
        init(new Vector2f(), new Vector2f());
    }

    // Constructor with position
    public Transform(Vector2f position) {
        init(position, new Vector2f());
    }

    // Complete constructor
    public Transform(Vector2f position, Vector2f scale) {
        init(position, scale);
    }

    public void init(Vector2f position, Vector2f scale) {
        this.position = position;
        this.scale = scale;
    }
}
