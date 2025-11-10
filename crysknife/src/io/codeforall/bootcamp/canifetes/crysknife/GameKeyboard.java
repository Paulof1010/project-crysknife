package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.keyboard.*;

public class GameKeyboard implements KeyboardHandler {

    private final Player player;

    public GameKeyboard(Player player) {
        this.player = player;
        init();
    }

    private void init() {
        Keyboard keyboard = new Keyboard(this);

        int[] keys = {
                KeyboardEvent.KEY_W,
                KeyboardEvent.KEY_S,
                KeyboardEvent.KEY_A,
                KeyboardEvent.KEY_D,
                KeyboardEvent.KEY_0,
        };

        for (int key : keys) {
            KeyboardEvent pressed = new KeyboardEvent();
            pressed.setKey(key);
            pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(pressed);

            KeyboardEvent released = new KeyboardEvent();
            released.setKey(key);
            released.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboard.addEventListener(released);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_W -> player.setMovingUp(true);
            case KeyboardEvent.KEY_S -> player.setMovingDown(true);
            case KeyboardEvent.KEY_A -> player.setMovingLeft(true);
            case KeyboardEvent.KEY_D -> player.setMovingRight(true);
            case KeyboardEvent.KEY_0 -> System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_W -> player.setMovingUp(false);
            case KeyboardEvent.KEY_S -> player.setMovingDown(false);
            case KeyboardEvent.KEY_A -> player.setMovingLeft(false);
            case KeyboardEvent.KEY_D -> player.setMovingRight(false);
        }
    }
}
