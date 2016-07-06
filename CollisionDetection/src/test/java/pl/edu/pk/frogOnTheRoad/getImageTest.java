package pl.edu.pk.frogOnTheRoad;
import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Test;

import pl.edu.pk.frogOnTheRoad.sprite.Sprite;

//drugi test jednostkowy
public class getImageTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,56);
		testing.loadImage("carYellow.png");
		Image img = testing.getImage();
		assertEquals(testing.image,img);
	}

}
