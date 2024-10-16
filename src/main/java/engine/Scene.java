package engine;

public abstract class Scene {
    protected Camera camera;

    // Constructor
    public Scene() {

    }

    // Initialize the scene
    public void init() {

    }

    // Update the scene
    public abstract void update(float dt);

}
