package engine;

public abstract class Scene {

    // Constructor
    public Scene() {

    }

    // Initialize the scene
    public abstract void init();

    // Update the scene
    public abstract void update(float dt);

}
