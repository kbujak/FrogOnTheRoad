package pl.edu.pk.frogOnTheRoad;
import static org.junit.Assert.*;

import org.junit.Test;

import pl.edu.pk.frogOnTheRoad.sprite.Sprite;

//czwarty test jednostkowy
public class getYTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,56);
		int testing_y = testing.getY();
		assertEquals(56,testing_y); // pierwsza wartosc oczekiwana, druga testowana
	}

}
