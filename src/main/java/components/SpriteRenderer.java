package components;

import engine.Component;

public class SpriteRenderer extends Component {

    private boolean firstTime = false;

    @Override
    public void start() {
        System.out.println("I am starting the SpriteRenderer component");
    }

    @Override
    public void update(float dt) {
        if (!firstTime) {
            System.out.println("I am updating the SpriteRenderer component");
            firstTime = true;
        }
    }
}
