package pl.edu.pk.frogOnTheRoad.sprite;


import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    public Image image;

    public void set(int x,int y,int width,int height, boolean vis)
    {
    	this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vis = vis;
        
    }
    
    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        vis = true;
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();

    }
    
    protected void loadImageRotate(String imageName) { //NIE DZIALA!
    	
        ImageIcon ii = new ImageIcon(imageName);
        RotatedIcon r1 = new RotatedIcon(ii, RotatedIcon.Rotate.UPSIDE_DOWN);
        
        //image =  r1.getIcon();
        //ii.setImage( r1 );
        
        
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}