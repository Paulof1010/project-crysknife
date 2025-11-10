package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Game extends AbstractGameScreen implements Runnable {

    private final int FPS = 120;
    private final double FRAME_TIME = 500.0 / FPS;
    private Picture gameBackground;
    private Player player;
    private boolean gameOver = false;
    private boolean playerWon = false;

    private List<Enemy> enemies = new ArrayList<>();
    private double timer = 20.0;
    private Text timerText;
    public static int score = 4000;
    private Text scoreText;
    private Text controlsText;


    private Thread gameThread;

    public Game() {
        gameBackground = new Picture(5, 5,
                "resources/backgrounds/game.png");
        gameBackground.draw();
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        init();

        long lastTime = System.currentTimeMillis();
        while (running) {
            long currentTime = System.currentTimeMillis();
            double delta = (currentTime - lastTime) / 1000.0;
            lastTime = currentTime;

            update(delta);

            try {
                Thread.sleep((long) FRAME_TIME);
            } catch (InterruptedException ignored) {}
        }

        dispose();
    }

//    public void join() throws InterruptedException {
//        if (gameThread != null) gameThread.join();
//    }

    @Override
    public void init() {
        score = 4000;
        player = new Player(512, 512);
        ScreenUtils.centerWindow();
        MenuKeyboard.activeControl = false;
        new GameKeyboard(player);

        timerText = new Text(60, 20, "Time: " + (int) timer);
        timerText.setColor(Color.BLACK);
        timerText.grow(20, 10);
        timerText.draw();

        scoreText = new Text(512, 20, "Score: " + score);
        scoreText.setColor(Color.BLACK);
        scoreText.grow(20, 10);
        scoreText.draw();

        controlsText = new Text(15, 1000, "     CONTROLS: " +
                "      'W' to move up   ---" +
                "---   'S' to move down   ---" +
                "---   'D' to move right   ---" +
                "---   'A' to move left   ---" +
                "---   Press '0' to close the game.");
        controlsText.setColor(Color.BLACK);
        controlsText.draw();


        for (int i = 0; i < 10; i++) {
            enemies.add(new Enemy());
        }
    }

    @Override
    public void update(double deltaTime) {
        if (!running) return;

        player.move(deltaTime);
        for (Enemy enemy : enemies) enemy.update(deltaTime, player);

        timer -= deltaTime;
        timerText.setText("Time: " + (int) timer);

        score--;
        scoreText.setText("Score: " + score);

        if (timer <= 0) {
            running = false;
            gameOver = true;
        }

        if (enemies.stream().allMatch(Enemy::isDefeated)) {
            running = false;
            playerWon = true;
        }

        if (player.isDead()) {
            running = false;
            gameOver = true;
        }
    }

    @Override
    public void dispose() {
        // Ensure we clear everything before a restart or game over
        if (player != null) player.clear();
        enemies.forEach(Enemy::defeat);
        enemies.clear();
        if (timerText != null) timerText.delete();

        // If the player won or the game is over, show the corresponding screen
        if (playerWon) {
            new WinningScreen();
        } else if (gameOver) {
            new GameOver();
        } else {
            new MainMenu();
        }
    }


    public void stop() {
        running = false;
        MenuKeyboard.activeControl = true;
    }
}
