package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.graphics.Color;

import static io.codeforall.bootcamp.canifetes.crysknife.Game.score;

public class GameOver extends AbstractMenuScreen {

    public GameOver() {
        super(Color.WHITE,
                "resources/backgrounds/game-over.png");
    }

    @Override
    protected String getTitleText() {
        return "GAME OVER!";
    }

    @Override
    protected String getOption1Text() {
        return "Restart";
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
        GameManager.restartGame();
    }

    @Override
    protected void onSelectOption2() {
        System.exit(0);
    }
}
