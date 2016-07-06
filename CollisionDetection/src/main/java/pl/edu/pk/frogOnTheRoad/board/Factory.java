package pl.edu.pk.frogOnTheRoad.board;

import pl.edu.pk.frogOnTheRoad.sprite.Sprite;

//interfejs reprezentuj¹cy abstrakcjê
public interface Factory {
	
	Sprite create(int width, int high, int color);

}
