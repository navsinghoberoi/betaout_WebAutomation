package OnsiteMarketingScenarios_CTA;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OnsiteMarketingPages.Onsite_CreateCampaign;
import OnsiteMarketingPages.Onsite_Design;
import OnsiteMarketingPages.Onsite_Select_Template;
import OnsiteMarketingPages.Onsite_Target_Page;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Onsite_Activepage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class CTAPopup_Timer {
	
	public static WebDriver driver;

	@Test
	public void CallToActionTimerPopup() throws Exception
	
	{
		System.out.println("Scenario : Onsite Marketing > Timer Template from CTA Popup > Design - OR > Target > Active");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		String currentDate = set.getCurrentDateTime();
		
		set.getQAURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getNavpreetQAUsername());
		obj.upswd(set.getNavpreetQAPassword());
		obj.ulogin();
	
		// Add code to select account
		set.selectAccountNav();
		System.out.println("User has logged in successfully");
		
		Homepage onsite_obj = new Homepage(driver);
		onsite_obj.onsite_click();
		
		Onsite_CreateCampaign calltoaction_obj = new Onsite_CreateCampaign(driver);
		
		calltoaction_obj.PrintNameOfFields();
		calltoaction_obj.createcampaign_click();
		String name = "Auto_Timerctapopup"+" "+currentDate;
		calltoaction_obj.name(name);
		Thread.sleep(1500);
		calltoaction_obj.save_click();
		Thread.sleep(3000);
		
		Onsite_Select_Template template_obj = new Onsite_Select_Template(driver);
		template_obj.CTAPopuptemplateClick();    // Select popup template
		
		// Explicit wait for Save and Next after selecting template
		
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Save & Next']")));
	
		Thread.sleep(8000);
		
		Onsite_Design design = new Onsite_Design(driver);
	
		// Add code for Timer
		
		driver.findElement(design.Countdown).click();              // Countdown tab
		
		Thread.sleep(3000);
    	
    	driver.switchTo().frame(driver.findElement(design.Timer_Iframe));        // Iframe of Clocks
    	
    	driver.findElement(design.Timer_SelectClock1).click();      // Select Clock 1
    	
    	driver.findElement(design.Timer_SaveNext1).click();
    	Thread.sleep(1500);
    	
   // 	driver.findElement(By.xpath("(//*[@placeholder = 'SELECT END DATE FROM COUNTDOWN'])")).click();       // Todays date by default
    	
    	
    	driver.findElement(design.Timer_OpenTime).click();     // Open time
    	
    	driver.findElement(design.Timer_IncreementHour).click();
    	Thread.sleep(1500);
    	driver.findElement(design.Timer_SaveNext2).click();
    	Thread.sleep(1500);
    	driver.findElement(design.Timer_SaveNext3).click();
    	
    	Thread.sleep(2000);

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot 1 is taken successfully");
		
        design.save_next();
		Thread.sleep(12000);
	
		Onsite_Target_Page target_obj = new Onsite_Target_Page(driver);
		
	/*	target_obj.ChooseCondition_ToggleClick();            // To Enable OR Condition
		Thread.sleep(1500);*/
		target_obj.Target_Users_click();   
		Thread.sleep(1500);
		target_obj.Show_Instance_click();
		Thread.sleep(1500);
		target_obj.SI_Everytime_click();
		Thread.sleep(1500);
		target_obj.Target_Pages_click();
		Thread.sleep(1500);
		String weburl = "CTATimerPopup";
		target_obj.TP_SpecificURL_click(weburl);           // enter url
		Thread.sleep(3000);
		target_obj.SaveAndNext_click();
		Thread.sleep(8000);
		
		
		Onsite_Activepage active_obj = new Onsite_Activepage(driver);
		active_obj.Active_click();
		active_obj.Save_click();
		Thread.sleep(9000);
		
		// Assert name of campaign
		
		String ActiveInstanceName = driver.findElement(By.xpath("(//a[@class = 'camp-name'])[1]")).getText();
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(ActiveInstanceName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");

		Thread.sleep(6000);
			
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
			
		String URL = set.getWoocommerceOneURL();
		driver.get(URL+"/?"+weburl);
		
	//	driver.navigate().refresh();
		
		Thread.sleep(12000);
		
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot 2 is taken successfully");

		
		// Switch to iframe and compare data from Timer

	    driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'iframePopup')]")));
	    String PopupText = driver.findElement(By.xpath("(//*[@class = 'headp_1'])")).getText();
	    System.out.println(PopupText);
		
	    boolean timerDisplayedOnOnsite = driver.findElement(By.xpath("//*[@id = 'digital_timer']")).isDisplayed();
	    System.out.println("Boolean value of Timer Displayed on Onsite Instance = "+timerDisplayedOnOnsite);
	    s_assert.assertEquals(timerDisplayedOnOnsite, true);
	    
	//	s_assert.assertEquals(PopupText,"HEADPHONES");
		
	   boolean textComparison = PopupText.contains("HEADPHONES");
	   System.out.println("Boolean value of Text Displayed on Onsite Instance =" +textComparison);  
	   s_assert.assertEquals(textComparison, true);
	   
	
		Thread.sleep(5000);
		
		// Inactive instance once the desired action is captured on the integrated website

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		
		Thread.sleep(3000);

		driver.switchTo().window(tabs.get(0));
		
		calltoaction_obj.InactiveInstanceClick();
				
		Thread.sleep(5000);
				
		String url = driver.getCurrentUrl();
		System.out.println("URL currently opened is "+url);
	
		s_assert.assertAll();
		
		System.out.println("Timer Popup is present on the URL");
		
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
	

}
