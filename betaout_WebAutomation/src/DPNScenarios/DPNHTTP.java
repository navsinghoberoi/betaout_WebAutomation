package DPNScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import EmailMarketingPages.EM_Broadcast_Template;
import common_Classes.*;
import common_Classes.Account_Settings;
import common_Classes.Loginpage;
import OnsiteMarketingPages.Onsite_CreateCampaign;
import OnsiteMarketingPages.Onsite_Design;
import common_Classes.Homepage;
import OnsiteMarketingPages.Onsite_Select_Template;
import OnsiteMarketingPages.Onsite_Target_Page;

public class DPNHTTP {

	public static WebDriver driver;
	
	// Before running scenario, make changes on line number - 61
	
	
	@Test
	public void CallToActionBanner() throws Exception
	
	{
		System.out.println("Scenario : Onsite Marketing > Select CTABannerTemplate > Design > Target > Active");
		
	
		Setup_class set = new Setup_class(driver);
		
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
        
        // Set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 1);

        // Create object of ChromeOption class
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
        // Set the experimental option
		options.setExperimentalOption("prefs", prefs);

        // pass the options object in Chrome driver

		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// HTTP 
		 
		driver.get("http://qa-testing.betaout.in/?autonew");
		
		String originalWindow = driver.getWindowHandle();
		System.out.println(originalWindow);
		driver.findElement(By.xpath("//*[text() = 'ALLOW']")).click();
		
		Thread.sleep(12000);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to first tab
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("Moved to new tab");
		
		Thread.sleep(3000);
	
	//	driver.manage().window().maximize();
		
		Thread.sleep(60000);       // Wait 1 min for alert on QA

		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}