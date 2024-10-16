package engine;

import components.SpriteRenderer;
import org.joml.Vector2f;
import org.joml.Vector4f;

public class LevelEditorScene extends Scene {

    public LevelEditorScene() {

    }

    @Override
    public void init() {
        this.camera = new Camera(new Vector2f(0, 0));

        int xOffset = 10;
        int yOffset = 10;

        float totalWidth = (float)(600 - xOffset *2);
        float totalHeight = (float)(400 - yOffset *2);
        float sizeX = totalWidth / 100.0f;
        float sizeY = totalHeight / 100.0f;

        for (int x=0; x <100; x++) {
            for (int y=0; y <100; y++) {
                float xPosition = xOffset + (x * sizeX);
                float yPosition = yOffset + (y * sizeY);

                GameObject object = new GameObject("Obj" + x + "" + y, new Transform(new Vector2f(xPosition, yPosition), new Vector2f(sizeX, sizeY)));
                object.addComponent(new SpriteRenderer(new Vector4f(xPosition / totalWidth, yPosition / totalHeight, 1, 1)));
                this.addGameObjectToScene(object);
            }
        }
    }

    @Override
    public void update(float dt) {
        System.out.println("FPS: " + (1.0f / dt));

        for (GameObject gameObject : this.gameObjects) {
            gameObject.update(dt);
        }

        this.renderer.render();
    }

}
