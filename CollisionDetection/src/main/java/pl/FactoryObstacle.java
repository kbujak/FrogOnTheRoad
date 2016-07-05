package pl;

//polimorfizm
 class FactoryObstacle implements Factory{

	public Sprite create(int x, int y, int color) {
		
		return new Obstacle(x,y,color);
	}

}
