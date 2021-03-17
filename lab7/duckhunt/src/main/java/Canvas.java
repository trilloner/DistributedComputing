import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Canvas extends JPanel implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        onKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        onKeyUp(e);
    }

    public Canvas() {
        addKeyListener(Canvas.this);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        onDraw(g2D);
    }



    protected abstract void onKeyUp(KeyEvent event);

    protected abstract void onKeyPressed(KeyEvent event);

    protected abstract void onDraw(Graphics2D g2D);
}
