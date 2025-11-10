package io.codeforall.bootcamp.canifetes.crysknife;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture sprite;
    private double x, y;
    private double speed = 250;
    private int health = 100;
    private boolean movingUp, movingDown, movingLeft, movingRight;
    private final double maxWidth, maxHeight;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        this.maxWidth = 1050;  // Fixed width
        this.maxHeight = 1050;  // Fixed height

        sprite = new Picture(x, y,
                "resources/portraits/sahir.png");
        sprite.grow(30, 30);
        sprite.draw();
    }

    public void move(double deltaTime) {
        double dx = 0, dy = 0;
        if (movingUp) dy -= speed * deltaTime;
        if (movingDown) dy += speed * deltaTime;
        if (movingLeft) dx -= speed * deltaTime;
        if (movingRight) dx += speed * deltaTime;

        double newX = Math.max(0, Math.min(x + dx, maxWidth - sprite.getWidth()));
        double newY = Math.max(0, Math.min(y + dy, maxHeight - sprite.getHeight()));

        sprite.translate(newX - x, newY - y);
        x = newX;
        y = newY;
    }

    public void setMovingUp(boolean b) { movingUp = b; }
    public void setMovingDown(boolean b) { movingDown = b; }
    public void setMovingLeft(boolean b) { movingLeft = b; }
    public void setMovingRight(boolean b) { movingRight = b; }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public Picture getSprite() {
        return sprite;
    }

    public boolean isDead() {
        return health <= 0;
    }

//    public void takeDamage(int amount) { health = Math.max(0, health - amount); }

    public void clear() {
        sprite.delete();
    }
}
