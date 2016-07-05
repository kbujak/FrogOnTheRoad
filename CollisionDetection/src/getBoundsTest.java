import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.Rectangle;

import org.junit.Test;
//pierwszy test jednostkowy
public class getBoundsTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,56);
		testing.x=5;
		testing.y=10;
		testing.width=20;
		testing.height=40;
		
		
		Rectangle rect_test = new Rectangle(5, 10, 20, 40);
		Rectangle rect = testing.getBounds();
		
		assertEquals(rect_test,rect);
	}

}