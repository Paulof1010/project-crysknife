package io.codeforall.bootcamp.canifetes.crysknife;

public abstract class AbstractGameScreen {

    protected boolean running = true;

    public abstract void init();
    public abstract void update(double deltaTime);
    public abstract void dispose();

    public void onExit() {

    }
}
