package pl.edu.pk.frogOnTheRoad;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ getBoundsTest.class, getImageTest.class, getXTest.class, getYTest.class, VisibilityTest.class })
public class AllTests {

}
