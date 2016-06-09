
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Frog extends Sprite {

    private int dx = getBounds().width;
    private int dy = getBounds().height;
	Delays myDel = new Delays();
    
    
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
        //myDel.uspij(30); //nie da sie tak po prostu zrobic, trzeba by na oddzielnym watku zabe zrobic
        y += dy;
        //myDel.uspij(30);
        
        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
        
        if (x > 999) {
            x = 999;
        }

        if (y > 799) {
            y = 799;
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
            dx = -3;
            
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 3;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -3;

        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 3;
        }

    }
    
}
