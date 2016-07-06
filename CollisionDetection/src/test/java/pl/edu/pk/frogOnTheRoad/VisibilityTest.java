package pl.edu.pk.frogOnTheRoad;
import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Test;

import pl.edu.pk.frogOnTheRoad.sprite.Sprite;

//pi¹ty test jednostkowy
public class VisibilityTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,56);
		testing.setVisible(true);
		Boolean testing_vis = testing.isVisible();
		assertEquals(testing_vis,true);
		
		testing.setVisible(false);
		testing_vis = testing.isVisible();
		assertEquals(testing_vis,false);
	}

}
