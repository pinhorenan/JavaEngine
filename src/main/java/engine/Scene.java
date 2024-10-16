package engine;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
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
        for (GameObject go :  gameObjects) {
            go.start();
        }
        isRunning = true;
    }

    public void addGameObjectToScene(GameObject gameObject) {
        if (!isRunning) {
            gameObjects.add(gameObject);
        } else {
            gameObjects.add(gameObject);
            gameObject.start();
        }
    }

    // Update the scene
    public abstract void update(float dt);

}
