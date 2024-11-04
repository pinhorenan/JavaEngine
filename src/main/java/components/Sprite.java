package components;

import org.joml.Vector2f;
import renderer.Texture;

@SuppressWarnings("FieldMayBeFinal")
public class Sprite {
    private Texture texture;
    private Vector2f[] textureCoordinates;


    // Constructor for a sprite with default texture coordinates
    public Sprite(Texture texture) {
        this.texture = texture;
        Vector2f[] textureCoordinates = {
                new Vector2f(1,1), // top right
                new Vector2f(1,0), // bottom right
                new Vector2f(0,0), // bottom left
                new Vector2f(0,1)  // top left
        };
        this.textureCoordinates = textureCoordinates;
    }

    // Constructor for a sprite with custom texture coordinates
    public Sprite(Texture texture, Vector2f[] textureCoordinates) {
        this.texture = texture;
        this.textureCoordinates = textureCoordinates;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public Vector2f[] getTextureCoordinates() {
        return this.textureCoordinates;
    }
}
