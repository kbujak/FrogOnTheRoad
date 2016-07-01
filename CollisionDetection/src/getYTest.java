import static org.junit.Assert.*;

import org.junit.Test;

public class getYTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,56);
		int testing_y = testing.getY();
		assertEquals(56,testing_y); // pierwsza wartosc oczekiwana, druga testowana
	}

}
