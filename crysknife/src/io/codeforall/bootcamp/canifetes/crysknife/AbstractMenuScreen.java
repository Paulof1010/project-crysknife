package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractMenuScreen {

    protected Picture background;
    protected Text title;
    protected Text option1;
    protected Text option2;
    protected Text controls;
    protected Text winningScore;

    protected int selectedOption = 0; // 0 = first option, 1 = second option

    protected abstract String getTitleText();
    protected abstract String getOption1Text();
    protected abstract String getOption2Text();
    protected abstract String getControls();
    protected abstract String getWinningScore();


    protected abstract void onSelectOption1();
    protected abstract void onSelectOption2();

    public AbstractMenuScreen(Color titleColor, String backgroundPath) {
        setBackground(backgroundPath); // Set the background dynamically
        initMenu(titleColor);
        MenuKeyboard.activeControl = true;
        new MenuKeyboard(this);
    }

    /**
     * Sets the background picture for the menu screen.
     *
     * @param backgroundPath the path to the background image.
     */
    private void setBackground(String backgroundPath) {
        background = new Picture(5, 5, backgroundPath);
        background.draw();
    }

    private void initMenu(Color titleColor) {

        title = new Text(400, 500, getTitleText());
        title.setColor(titleColor);
        title.grow(300, 50);
        title.draw();

        option1 = new Text(777, 700, getOption1Text());
        option1.setColor(Color.WHITE);
        option1.grow(50, 25);
        option1.draw();

        option2 = new Text(777, 800, getOption2Text());
        option2.setColor(Color.WHITE);
        option2.grow(50, 25);
        option2.draw();

        controls = new Text(25, 1000, getControls());
        controls.setColor(Color.WHITE);
        controls.grow(10, 5);
        controls.draw();

        winningScore = new Text(200, 800, getWinningScore());
        winningScore.setColor(Color.GREEN);
        winningScore.grow(150, 80);
        winningScore.draw();

        updateHighlight();
    }

    public void moveUp() {
        selectedOption = (selectedOption - 1 + 2) % 2;
        updateHighlight();
    }

    public void moveDown() {
        selectedOption = (selectedOption + 1) % 2;
        updateHighlight();
    }

    public void selectOption() {
        if (selectedOption == 0) {
            clearScreen();         // Ensure screen is cleared before moving on
            onSelectOption1();
        } else {
            clearScreen();         // Ensure screen is cleared before moving on
            onSelectOption2();
        }
    }

    protected void updateHighlight() {
        option1.setColor(selectedOption == 0 ? Color.YELLOW : Color.WHITE);
        option2.setColor(selectedOption == 1 ? Color.YELLOW : Color.WHITE);
    }

    protected void clearScreen() {
        if (background != null) {
            background.delete();
            background = null;
        }

        if (title != null) {
            title.delete();
            title = null;
        }

        if (option1 != null) {
            option1.delete();
//            option1 = null;
        }
//
        if (option2 != null) {
            option2.delete();
//            option2 = null;
        }

        MenuKeyboard.activeControl = false; // Turn off menu input
    }
}
