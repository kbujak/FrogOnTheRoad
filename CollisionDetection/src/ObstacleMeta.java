public class ObstacleMeta extends Sprite {

    
    public ObstacleMeta(int x, int y) {
        super(x, y);
        initObstacleMeta();
    }

    void initObstacleMeta() {
    	
        loadImage("meta.png");
        getImageDimensions();
    }


}