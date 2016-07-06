package pl.edu.pk.frogOnTheRoad.sprite;


import java.awt.event.KeyEvent;
import java.util.ArrayList;

import pl.edu.pk.frogOnTheRoad.board.Delays;

public class Frog extends Sprite {

    private int dx = getBounds().width;
    private int dy = getBounds().height;
    private int life = 3;
    private int speed = 5;
	Delays myDel = new Delays(0);
    
    
    public Frog(int x, int y) {
        super(x, y);
        initCraft();
    }
    public void initFrog(int x, int y){
    	this.x=x;
    	this.y=y;
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
        
        if (x > 900) {
            x = 900;
        }

        if (y > 710) {
            y = 710;
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
            dx = -speed;
            
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = speed;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -speed;

        }

        if (key == KeyEvent.VK_DOWN) {
            dy = speed;
        }

    }
    
    public int getLife(){
    	
    	return this.life;
    }
    
    public void setLife(){
    	
    	this.life--;
    }
}
