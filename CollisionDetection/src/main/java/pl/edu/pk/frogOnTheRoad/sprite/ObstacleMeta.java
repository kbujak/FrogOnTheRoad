package pl.edu.pk.frogOnTheRoad.sprite;

public class ObstacleMeta extends Sprite {


	public ObstacleMeta(int x, int y) {
        super(x, y);
        initObstacleMeta();
    }

	private void initObstacleMeta() {
    	
        loadImage("meta.png");
        getImageDimensions();
        
    }


}