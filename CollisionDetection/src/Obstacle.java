public class Obstacle extends Sprite {

    private final int INITIAL_X = 400;

    public Obstacle(int x, int y) {
        super(x, y);

        initObstacle();
    }

    private void initObstacle() {

        loadImage("car1.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}