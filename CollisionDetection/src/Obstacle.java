public class Obstacle extends Sprite {

    private final int INITIAL_X_RIGHT = 1000;
    private final int INITIAL_X_LEFT = 0;
    
    private final int WAY_RIGHT = 0;
    private final int WAY_LEFT = 1;
    
    private final int COLOR_RED = 0;
    private final int COLOR_YELLOW = 1;
    private final int COLOR_SEA = 2;
    private final int COLOR_BLUE = 3;
    
    
    
    public Obstacle(int x, int y) {
        super(x, y);
        //initObstacle(COLOR_RED,WAY_LEFT);
        initObstacle(COLOR_RED,WAY_RIGHT);
    }

    private void initObstacle(int color, int way) {
    	if(way == WAY_RIGHT)
    			switch(color){
    			case 0:
    				loadImage("carRed.png");
    				break;
    			case 1:
    				loadImage("carYellow.png");
    				break;
    			case 2:
    				loadImage("carSea.png");
    				break;
    			case 3:
    				loadImage("carBlue.png");
    				break;
    			}
    	else if(way == WAY_LEFT){
    	
    		switch(color){
			case 0:
				loadImageRotate("carRed.png");
				break;
			case 1:
				loadImageRotate("carYellow.png");
				break;
			case 2:
				loadImageRotate("carSea.png");
				break;
			case 3:
				loadImageRotate("carBlue.png");
				break;
    		}
    	}
        //loadImage("carYellow.png");
        getImageDimensions();
    }

    public void moveLeft(){

        if (x < -100) {
            x = INITIAL_X_RIGHT;
        }
        
        x -= 3;
    }
    
    public void moveRight(){
    	if (x > 1100) {
            x = INITIAL_X_LEFT;
        }
        
        x += 3;
    }
}