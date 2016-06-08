
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Frog extends Sprite {

    private int dx = getBounds().width;
    private int dy = getBounds().height;
	

    public Frog(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
        loadImage("newFrog.png");
        getImageDimensions();
    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;

        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }

    }
    
}
