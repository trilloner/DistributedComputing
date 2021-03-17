import javax.swing.*;
import java.awt.*;

public class Bird extends Sprite implements Runnable {
    private final Image img;
    private GamePanel gamePanel;
    private boolean flightWay; // true = right, false = left
    Thread thread;
    private boolean isAlive;

    public Bird(int x, int y, int speed, GamePanel gamePanel) {
        super(x, y, speed);
        this.gamePanel = gamePanel;
        this.img = new ImageIcon("bird1.png").getImage();
        this.flightWay = true;
        this.isAlive = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(img, getX(), getY(), null);
    }

    @Override
    public void run() {
        while (isAlive) {
            try {
                Thread.sleep(200);
                move();
            } catch (InterruptedException e) {
                System.out.println("Score + 1");
            }
        }
    }

    public synchronized void move() {
        if (flightWay) {
            moveRight();
        } else {
            moveLeft();
        }
        gamePanel.repaint();
    }


    public void moveLeft() {
        if (getX() < 0) {
            flightWay = true;
            return;
        }
        setX(getX() - getSpeed());
    }

    public void moveRight() {
        if (getX() > gamePanel.MAX_WIDTH - 250) {
            flightWay = false;
            return;
        }
        setX(getX() + getSpeed());
    }

    public Rectangle getBound() {
        return new Rectangle(getX(), getY(), this.img.getWidth(null), this.img.getHeight(null));
    }

    public void birdDead() {
        isAlive = false;
    }
}
