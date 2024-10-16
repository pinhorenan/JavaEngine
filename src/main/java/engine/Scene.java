package engine;

import renderer.Renderer;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
    protected Renderer renderer = new Renderer();
    protected Camera camera;
    private boolean isRunning = false;
    protected List<GameObject> gameObjects = new ArrayList<>();

    // Constructor
    public Scene() {

    }

    // Initialize the scene
    public void init() {

    }

    public void start() {
        for (GameObject object : gameObjects) {
            object.start();
            this.renderer.add(object);
        }
        isRunning = true;
    }

    public void addGameObjectToScene(GameObject object) {
        if (!isRunning) {
            gameObjects.add(object);
        } else {
            gameObjects.add(object);
            object.start();
            this.renderer.add(object);
        }
    }

    // Update the scene
    public abstract void update(float dt);

    public Camera camera() {
        return this.camera;
    }
}
