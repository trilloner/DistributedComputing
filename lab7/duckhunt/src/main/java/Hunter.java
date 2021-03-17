import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hunter extends Sprite {
    private final Image img;
    private GamePanel gamePanel;
    private boolean shot = false;
    Bullet bullet = new Bullet(getX(), getY(), 40, gamePanel);
    public Queue<Bullet> bullets = new LinkedList<Bullet>();

    public Hunter(int x, int y, int speed, GamePanel gamePanel) {
        super(x, y, speed);
        this.gamePanel = gamePanel;
        this.img = new ImageIcon("Demonhunter.png").getImage();
    }


    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(img, getX(), getY(), null);
        if (shot) {
            for (Bullet bullet : bullets) {
                bullet.draw(graphics2D);
            }
        }
    }

    public void moveLeft() {
        if (getX() < 0) {
            return;
        }
        setX(getX() - getSpeed());
        System.out.println("moveLeft");
    }

    public void moveRight() {
        if (getX() > gamePanel.MAX_WIDTH - 250) {
            return;
        }

        setX(getX() + getSpeed());
        System.out.println("moved right");
    }

    public void shoot() {
        shot = true;
        bullets.add(new Bullet(getX(), getY(), 10, gamePanel));
    }

    public void removeBullet() {
        bullets.poll();
    }
}
