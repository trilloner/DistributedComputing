import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends Canvas implements Runnable {
    private Hunter hunter = new Hunter(1, 570, 50, this);
    private final Image background;
    public int MAX_WIDTH, MAX_HEIGHT;
    private ArrayList<Bird> birds = new ArrayList<>();
    Thread gameThread;
    private int score;

    public GamePanel(Image img) {
        this.background = img;
        this.MAX_WIDTH = img.getWidth(null);
        this.MAX_HEIGHT = img.getHeight(null);
        this.score = 0;
        setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));

    }

    @Override
    protected void onKeyUp(KeyEvent event) {

    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (gameThread == null) {
            gameThread = new Thread(GamePanel.this);
        }
        gameThread.start();
    }

    @Override
    protected void onKeyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            hunter.moveRight();
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            hunter.moveLeft();
        } else if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            hunter.shoot();
        }
        renderGame();
    }

    @Override
    protected void onDraw(Graphics2D g2D) {
        if (isGameOver()) {
            drawGameOver(g2D);
        } else {
            g2D.drawImage(this.background, 0, 0, null);
            for (Bird bird : birds) {
                bird.draw(g2D);
            }
            hunter.draw(g2D);
        }
    }

    private boolean isGameOver() {
        return birds.size() == 0;
    }

    private void renderGame() {
        try {
            repaint();
            for (Bird bird : birds) {
                for (Bullet bullet : hunter.bullets) {
                    if (bird.getBound().intersects(bullet.getBound())) {
                        System.out.println("INTERSECT");
                        birds.remove(bird);
                        bird.birdDead();
                        hunter.removeBullet();
                        score += 25;
                    }
                }
            }
        } catch (Exception e) {
        }
    }


    @Override
    public void run() {
        init();
        while (true) {

            long startTime = System.currentTimeMillis();
            renderGame();

            long endTime = System.currentTimeMillis() - startTime;
            long waitTime = (1000L / 40) - endTime / 1000L;

            try {
                Thread.sleep(waitTime);
            } catch (Exception e) {

            }
        }
    }

    private void init() {
        for (int i = 0; i < 5; i++) {
            birds.add(new Bird(new Random().nextInt(MAX_WIDTH), new Random().nextInt(100),
                    new Random().nextInt(40) * 5,
                    this));
        }
    }

    private void drawGameOver(Graphics g) {
        String msg = "Game Over. \n Your score: " + score;
        Font small = new Font("Helvetica", Font.BOLD, 25);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (MAX_WIDTH - fm.stringWidth(msg)) / 2,
                MAX_HEIGHT / 2);
    }
}
