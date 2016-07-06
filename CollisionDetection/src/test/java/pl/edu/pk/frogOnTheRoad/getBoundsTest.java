package pl.edu.pk.frogOnTheRoad;
import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.Rectangle;

import org.junit.Test;

import pl.edu.pk.frogOnTheRoad.sprite.Sprite;

//pierwszy test jednostkowy
public class getBoundsTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,56);
		testing.set(5, 10, 20, 40, true);
		
		
		Rectangle rect_test = new Rectangle(5, 10, 20, 40);
		Rectangle rect = testing.getBounds();
		
		assertEquals(rect_test,rect);
	}

}