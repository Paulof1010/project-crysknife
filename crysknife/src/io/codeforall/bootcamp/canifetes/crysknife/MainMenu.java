package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class MainMenu extends AbstractMenuScreen {

    public MainMenu() {
        super(Color.WHITE,
                "resources/backgrounds/main-menu.png");
    }

    @Override
    protected String getTitleText() {
        return "CRYSKNIFE GAME";
    }

    @Override
    protected String getOption1Text() {
        return "Start Game";
    }

    @Override
    protected String getOption2Text() {
        return "Exit";
    }

    @Override
    protected String getControls() {
        return "Use arrows to navigate options and 'SPACE' to confirm.";
    }

    @Override
    protected String getWinningScore() {
        return null;
    }

    @Override
    protected void onSelectOption1() {
        clearScreen();
        GameManager.startGame();
    }

    @Override
    protected void onSelectOption2() {
        System.exit(0);
    }
}
