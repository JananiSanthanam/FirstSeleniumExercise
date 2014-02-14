package FirstSeleniumExercise;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class msntestcases {
	 @Test
	  public void testcase1() {
		  System.out.println("in testcase1");
	  }
		//test case 2
	  
  
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("hello");
  }

  @AfterSuite
  public void afterSuite() {
  }

}
