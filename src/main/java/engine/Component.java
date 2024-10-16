package engine;

public abstract class Component {

    protected GameObject gameObject = null;

    public void start() {

    }

    public abstract void update(float dt);
}
