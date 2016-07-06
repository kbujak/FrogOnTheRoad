package pl.edu.pk.frogOnTheRoad.board;

import pl.edu.pk.frogOnTheRoad.sprite.Obstacle;
import pl.edu.pk.frogOnTheRoad.sprite.Sprite;

//polimorfizm
 class FactoryObstacle implements Factory{

	public Sprite create(int x, int y, int color) {
		
		return new Obstacle(x,y,color);
	}

}
