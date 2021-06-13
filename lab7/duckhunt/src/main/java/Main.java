import javax.swing.*;
import java.awt.*;

public class Main {
    static Image background = new ImageIcon("back.png").getImage();

    public static void run() {

        JFrame gameFrame = new JFrame("Crash The Jet");
        gameFrame.add(new GamePanel(background));

        gameFrame.setResizable(false);
        gameFrame.setResizable(false);
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }


    public static void main(String[] args) {
        run();
    }
}
