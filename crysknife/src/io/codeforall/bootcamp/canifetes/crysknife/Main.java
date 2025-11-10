package io.codeforall.bootcamp.canifetes.crysknife;

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        // You could show a splash screen or logo here if desired
        System.out.println("Launching Dune Crysknife Game...");

        // Start the main menu (this will manage its own transitions)
        new MainMenu();

        // Center the game window after the menu initializes
        ScreenUtils.centerWindow();
    }
}
