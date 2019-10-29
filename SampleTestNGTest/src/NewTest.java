import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("test");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

}
