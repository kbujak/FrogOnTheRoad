package pl.edu.pk.frogOnTheRoad;
import static org.junit.Assert.*;

import org.junit.Test;

import pl.edu.pk.frogOnTheRoad.sprite.Sprite;
//trzeci test jednostkowy
public class getXTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,2);
		int testing_x = testing.getX();
		assertEquals(145,testing_x); // pierwsza wartosc oczekiwana, druga testowana
	}

}

