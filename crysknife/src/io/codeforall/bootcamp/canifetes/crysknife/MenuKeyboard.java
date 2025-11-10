package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.keyboard.*;

public class MenuKeyboard implements KeyboardHandler {

    private final AbstractMenuScreen screen;
    public static boolean activeControl = true;

    public MenuKeyboard(AbstractMenuScreen screen) {
        this.screen = screen;
        init();
    }

    private void init() {
        Keyboard keyboard = new Keyboard(this);

        int[] keys = {KeyboardEvent.KEY_UP, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_SPACE};
        for (int key : keys) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        if (!activeControl) return;
        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP -> screen.moveUp();
            case KeyboardEvent.KEY_DOWN -> screen.moveDown();
            case KeyboardEvent.KEY_SPACE -> screen.selectOption();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {}
}
