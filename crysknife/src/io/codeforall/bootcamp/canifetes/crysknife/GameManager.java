package io.codeforall.bootcamp.canifetes.crysknife;

public class GameManager {

    private static Game currentGame;

    public synchronized static void startGame() {
        // ensure previous game is cleaned
        currentGame = new Game(); // constructor launches thread
    }

//    public synchronized static void stopGame() {
//        if (currentGame != null) {
//            currentGame.stop(); // safely stop game loop
//            try {
//                currentGame.join(); // wait for loop to finish
//            } catch (InterruptedException ignored) {}
//            currentGame = null;
//        }
//    }

    public synchronized static void restartGame() {
        currentGame.stop();// Make sure to clean up the previous game state
        currentGame = new Game();  // Start a new instance of the game
        currentGame.init();  // Start the game thread to run the game loop
    }
}
