package FirstSeleniumExercise;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class msntestcases extends BaseTest{
	  public static final WebDriver driver = new FirefoxDriver();
	  	  
	  
	 @BeforeSuite
	  public void beforeSuite() {
		 driver.get("http://www.msn.com/");
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 System.out.println("Page title ::" + driver.getTitle());
		 
		 }
	 
	 @Test(description="Click on News")
	  public void testcase1() throws NoSuchElementException, IOException {
		 try{
		 if(driver.getTitle().equals("MSN.com"))
			driver.findElement(By.xpath(".//*[@id='nav']/div[2]/div[1]/div/div/ul/li[1]/a")).click();
		 Assert.assertEquals(driver.getTitle(),"Latest US & world news on tech, crime, economy & obits - MSN News");
		 System.out.println("The page is in Latest US & world news on tech, crime, economy & obits - MSN News");
		 
		}
		 catch(Exception e){
			 ScreenShot(driver.getTitle(), driver);
			 Assert.fail("Did not tap on news");
		 }
		}
		
	 @Test(description = "Scrolldown the Page")
	 public void testcase2() throws Exception{
		 try{
			 Scrollpagedown(driver);	
			 Thread.sleep(1000); 
		 }
		 catch (Exception e){
			 System.out.println("Page was not able to Scroll down "+ e);
			 Assert.fail("Did not Scroll down the page");
		}
	 }
     @Test(description = "Scrollup the Page")
	 public void testcase3() throws Exception{
	 try{
				 Thread.sleep(1000);
				 Scrollpageup(driver);	
				  
			 }
			 catch (Exception e){
	 			 System.out.println("Page was not able to Scroll up " +e);
	 			 Assert.fail("Did not Scroll up the page");
			}
		 
	 }
	@Test(description="Search an item on News")
	public void testcase4() throws NoSuchElementException, IOException {
			 try{
			 if(driver.getTitle().equals("Latest US & world news on tech, crime, economy & obits - MSN News")){
				 driver.findElement(By.cssSelector("#q")).click();
				 WebElement element = driver.findElement(By.cssSelector("#q"));
				 String value = generaterandom();
				 element.sendKeys(value);
				 element.submit();
		    }
			}
			 catch(Exception e){
				 ScreenShot(driver.getTitle(), driver);
				 Assert.fail("Did not search an item from the given input");
			 }
			}		 
   
    @Test(description = "Click on Saved Locations to change it and handle the popup")
    public void testcase5() throws InterruptedException, IOException{
    	try{
    	goback(1,driver);
      	((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
      	Actions actions = new Actions(driver);
      	String windowbefore = driver.getWindowHandle();
      	WebElement menuhover = driver.findElement(By.cssSelector("span.loctog1"));
      	actions.moveToElement(menuhover).perform();
      	Thread.sleep(1000);
      	WebElement submenu = driver.findElement(By.xpath("//a[contains(text(),'Edit List')]"));
      	actions.moveToElement(submenu).click().perform();
      	for (String winhandle: driver.getWindowHandles()){
      		 driver.switchTo().window(winhandle);
      		 driver.manage().window().maximize();
      		 System.out.println("Title of the new window:: " + driver.getTitle());
      	}
      		driver.close();
            driver.switchTo().window(windowbefore);
    }
    catch(Exception e){
    	ScreenShot(driver.getTitle(), driver);
    	Assert.fail("Did not click on Edit button");
    }
    }
    	
    @Test(description = "Click on a Drop down List and Select a Value")
    public void testcase6() throws InterruptedException, IOException{
    	try{
    	Actions actions = new Actions(driver);
      	WebElement dropmenu = driver.findElement(By.cssSelector("#ddmake"));
      	actions.moveToElement(dropmenu).perform();
      	Thread.sleep(1000);
      	System.out.println("Drop down highlighted");
      	Select dropdown= new Select(driver.findElement(By.id("ddmake")));
      	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	dropdown.selectByValue("Lexus");
    	driver.findElement(By.cssSelector("#autofrm>div:nth-child(3)>input")).click();
          }
    	
     catch(Exception e){
				 ScreenShot("testcase6", driver);
				 Assert.fail("No Selection made from the drop down list");
			 }
    }
    		
    	
    
  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
