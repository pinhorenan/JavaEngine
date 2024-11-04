package components;

import engine.Component;
import org.joml.Vector2f;
import org.joml.Vector4f;
import renderer.Texture;

@SuppressWarnings("FieldMayBeFinal")
public class SpriteRenderer extends Component {

    private Vector4f color;
    private Sprite sprite;

    // Constructor for a sprite with a color
    public SpriteRenderer(Vector4f color) {
        this.color = color;
        this.sprite = new Sprite(null); // No texture and default texture coordinates
    }

    // Constructor for a sprite with a texture
    public SpriteRenderer(Sprite sprite) {
        this.sprite = sprite;
        this.color = new Vector4f(1, 1, 1, 1); // White
    }

    @Override
    public void start() {
    }

    @Override
    public void update(float dt) {
    }

    public Vector4f getColor() {
        return this.color;
    }

    public Texture getTexture() {
        return sprite.getTexture();
    }

    public Vector2f[] getTextureCoordinates() {
        return sprite.getTextureCoordinates();
    }
}
