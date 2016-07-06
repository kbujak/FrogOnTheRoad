package pl.edu.pk.frogOnTheRoad.sprite;

public class Obstacle extends Sprite {

    private final int INITIAL_X_RIGHT = 1000;
    private final int INITIAL_X_LEFT = 0;
    
    private final int WAY_RIGHT = 0;
    private final int WAY_LEFT = 1;
    private final int COLOR_RED = 0;
    private final int COLOR_YELLOW = 1;
    private final int COLOR_SEA = 2;
    private final int COLOR_BLUE = 3;
    
     
    
    public Obstacle(int x, int y,int color) {
        super(x, y);
        //initObstacle(COLOR_RED,WAY_LEFT); //blad przy obroceniu obrazka carX.png - loadImageRotate()
        initObstacle(color);
    }

    
    private void initObstacle(int color) {
    			switch(color){
    			case COLOR_RED:
    				loadImage("carRed.png");
    				break;
    			case COLOR_YELLOW:
    				loadImage("carYellow.png");
    				break;
    			case COLOR_SEA:
    				loadImage("carSea.png");
    				break;
    			case COLOR_BLUE:
    				loadImage("carBlue.png");
    				break;
    			}
    	
        //loadImage("carYellow.png");
        getImageDimensions();
    }

    public void moveLeft(int speed){

        if (x < -100) {
            x = INITIAL_X_RIGHT;
        }
        
        x -= speed;
    }
    
    public void moveRight(int speed){
    	if (x > 1100) {
            x = INITIAL_X_LEFT;
        }
        
        x += speed;
    }
}