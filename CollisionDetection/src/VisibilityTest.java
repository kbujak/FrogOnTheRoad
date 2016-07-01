import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Test;

public class VisibilityTest {

	@Test
	public void test() {
		Sprite testing = new Sprite(145,56);
		testing.vis = true;
		Boolean testing_vis = testing.isVisible();
		assertEquals(testing_vis,true);
		
		testing.vis = false;
		testing_vis = testing.isVisible();
		assertEquals(testing_vis,false);
	}

}
