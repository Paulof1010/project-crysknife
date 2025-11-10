package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Random;

import static io.codeforall.bootcamp.canifetes.crysknife.Game.score;

public class Enemy {

    private static final int WIDTH = 20, HEIGHT = 5, DEFEAT_RADIUS = 60;
    private Picture shapeAlive;
    private Picture shapeDead;
    private double speed = 150;
    private boolean defeated = false;
    private final double maxWidth, maxHeight;
    private double dirX, dirY, directionTimer;
    static final Random random = new Random();


    public Enemy() {
        this.maxWidth = 900;  // Fixed width
        this.maxHeight = 900;  // Fixed height

        double x = random.nextInt((int) (maxWidth - WIDTH));
        double y = random.nextInt((int) (maxHeight - HEIGHT));
        shapeAlive = new Picture(x, y,
                "resources/portraits/worms.png");
        shapeAlive.draw();

        randomizeDirection();
    }

    private void randomizeDirection() {
        double angle = random.nextDouble() * Math.PI * 2;
        dirX = Math.cos(angle);
        dirY = Math.sin(angle);
        directionTimer = 1.5 + random.nextDouble() * 2.5;
    }

    public void update(double deltaTime, Player player) {
        if (defeated) return;

        directionTimer -= deltaTime;
        if (directionTimer <= 0) randomizeDirection();

        double moveX = dirX * speed * deltaTime;
        double moveY = dirY * speed * deltaTime;

        double newX = Math.max(0, Math.min(shapeAlive.getX() + moveX, maxWidth - WIDTH));
        double newY = Math.max(0, Math.min(shapeAlive.getY() + moveY, maxHeight - HEIGHT));

        if (newX <= 0 || newX >= maxWidth - WIDTH) dirX *= -1;
        if (newY <= 0 || newY >= maxHeight - HEIGHT) dirY *= -1;

        shapeAlive.translate(newX - shapeAlive.getX(), newY - shapeAlive.getY());

        double dx = (player.getX() + player.getSprite().getWidth()/2.0) - (shapeAlive.getX() + WIDTH/2.0);
        double dy = (player.getY() + player.getSprite().getHeight()/2.0) - (shapeAlive.getY() + HEIGHT/2.0);
        if (Math.sqrt(dx*dx + dy*dy) < DEFEAT_RADIUS) defeat();
    }

    public void defeat() {
        if (defeated) return;
        defeated = true;

        SoundPlayer soundPlayer =  new SoundPlayer();
        SoundPlayer soundPlayer1 = new SoundPlayer();
        //soundPlayer.playSound("/Users/codecadet/Downloads/cfa-crysknife(final-working-version-gameplay)/cfa-crysknife/crysknife/resources/sounds/sword_sound.wav");
        //soundPlayer1.playSound("/Users/codecadet/Downloads/cfa-crysknife(final-working-version-gameplay)/cfa-crysknife/crysknife/resources/sounds/monsters.wav");
//        score = score + 1000;
        shapeAlive.delete();
    }

    public boolean isDefeated() { return defeated; }
}
