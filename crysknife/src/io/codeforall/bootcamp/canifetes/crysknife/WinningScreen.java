package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.graphics.Color;

import static io.codeforall.bootcamp.canifetes.crysknife.Game.score;

public class WinningScreen extends AbstractMenuScreen {

    public WinningScreen() {
        super(Color.WHITE,
                "resources/backgrounds/game-win.jpg");
    }

    @Override
    protected String getTitleText() {
        return "YOU WIN!";
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

        if (score > 2000) {
            return "The Worms call you FATHER! " + score + " Points!";
        } else if (score > 1000) {
            return score + " Points! You can do better!";
        } else if (score < 500); {
            return "Barely made it alive! " + score + " Points!";
        }
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
