package FirstSeleniumExercise;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.jetty.html.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.util.Properties;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
public class BaseTest {
	
	public static Properties prop;
  
  public static void ScreenShot(String methodname,WebDriver driver ) throws IOException {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	  Date date = new Date();
	  //System.out.println(dateFormat.format(date));
	  File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(screenshotfile,new File("C:\\Users\\VNeelakandan\\workspace\\FirstSeleniumExercise\\ScreenShotImages\\" + methodname + dateFormat.format(date) + ".png")); 
	 
  }
  public static void Scrollpagedown(WebDriver driver){
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	 	  
  }
  public static void Scrollpageup(WebDriver driver){
	 ((JavascriptExecutor)driver).executeScript("window.scroll(800,0);");
  }
  public static String generaterandom(){
	  String [] textinput = {"Crime","Current trends","Sports","Dollar rate","New movies"};
	  String value = (textinput[new Random().nextInt(textinput.length)]);
	  return value;
  }
  public static void goback(int n,WebDriver driver){
	  for (int i =0;i<=n;i++){
		  driver.navigate().back();
	  }
	  
  }
  public static void handlewindows(WebDriver driver){
  for (String winhandle: driver.getWindowHandles()){
		 driver.switchTo().window(winhandle);
		 driver.manage().window().maximize();
		 System.out.println("Title of the new window:: " + driver.getTitle());
		
	}
 
}
	  }
 
