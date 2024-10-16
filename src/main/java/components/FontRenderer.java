package components;

import engine.Component;

public class FontRenderer extends Component {

    private boolean firstTime = false;

    @Override
    public void start() {
        if (gameObject.getComponent(SpriteRenderer.class) != null) {
            System.out.println("Found Font Renderer!");
        }
    }

    @Override
    public void update(float dt) {
        if (!firstTime) {
            System.out.println("I am updating the FontRenderer component");
            firstTime = true;
        }
    }
}
