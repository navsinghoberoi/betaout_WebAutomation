package ParallelTests;

import java.util.concurrent.TimeUnit;

/**
 * @author - Navpreet
 */


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
 
import org.testng.annotations.Test;
 
public class MultiBrowser {
 
	public WebDriver driver;
 
  @Parameters("browser")
 
  @BeforeClass
 
  // Passing Browser parameter from TestNG xml
 
  public void beforeTest(String browser) throws Exception {
  
	  System.out.println("Browser selected = "+browser);

	  // Here I am setting up the path for my FirefoxDriver
	  
	  if(browser.equalsIgnoreCase("firefox")) {
 
	  System.setProperty("webdriver.firefox.marionette", "D:\\Softwares and Jars\\geckodriver-v0.9.0-win64\\geckodriver.exe");	  
		  
	  driver = new FirefoxDriver();
 
	  System.out.println("User has selected firefox Browser");
	  
 
  }else if (browser.equalsIgnoreCase("chrome")) { 
 
	  // Here I am setting up the path for my ChromeDriver
 
	  System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
 
	  driver = new ChromeDriver();

	  System.out.println("User has selected Firefox Browser");
	  
  } 
  
  else
  {
      throw new Exception("Browser is not correct");
  }
 
  // Doesn't the browser type, lauch the Website
 
  driver.manage().window().maximize();
  
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  
  driver.get("http://www.store.demoqa.com"); 
 
  }
 
  
  // Once Before method is completed, Test method will start
 
  @Test 
  
  	public void login() throws InterruptedException {
	  
	System.out.println("Test method has started");
	  
	driver.findElement(By.xpath(".//*[@id='account']/a")).click();
 
    driver.findElement(By.id("log")).sendKeys("testuser_1");
 
    driver.findElement(By.id("pwd")).sendKeys("Test@123");
 
    System.out.println("Title of webpage = "+driver.getTitle());
    
    System.out.println("Page Source of webpage = "+driver.getPageSource());
    
	}  
 
  
  @AfterClass
  
  public void quit()
  {
	  System.out.println("Closing the browser");
	  
	  driver.quit();

  }

  
}