import javax.swing.*;
import java.awt.*;

public class Bullet extends Sprite implements Runnable {

    private Image image;
    private GamePanel gamePanel;
    Thread thread;
    private boolean isHurt;

    public Bullet(int x, int y, int speed, GamePanel panel) {
        super(x, y, speed);
        this.gamePanel = panel;
        this.image = new ImageIcon("bullet.png").getImage();
        new Thread(this).start();
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, getX(), getY(), null);
    }

    @Override
    public void run() {
        while (!isHurt) {
            if (getY() < 0) {
                isHurt = true;
            }
            try {
                Thread.sleep(100);
                move();
            } catch (InterruptedException e) {

            }
        }
    }
    public void move() {
        setY(getY() - 100);
        System.out.println(getY());
        this.gamePanel.repaint();
    }

    public synchronized Rectangle getBound() {
        return new Rectangle(getX(), getY(), this.image.getWidth(null), this.image.getHeight(null));
    }

    public void remove() {
        isHurt = true;
    }
}
