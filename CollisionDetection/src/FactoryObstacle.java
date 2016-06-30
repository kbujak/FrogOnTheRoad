
class FactoryObstacle implements Factory{

	public Sprite create(int x, int y, Colors color) {
		
		return new Obstacle(x,y,color);
	}

}
