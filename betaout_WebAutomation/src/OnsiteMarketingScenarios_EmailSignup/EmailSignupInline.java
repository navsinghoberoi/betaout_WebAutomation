package OnsiteMarketingScenarios_EmailSignup;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common_Classes.*;
import common_Classes.Account_Settings;
import common_Classes.Loginpage;
import OnsiteMarketingPages.Onsite_CreateCampaign;
import OnsiteMarketingPages.Onsite_Design;
import common_Classes.Homepage;
import OnsiteMarketingPages.Onsite_Select_Template;
import OnsiteMarketingPages.Onsite_Target_Page;
/**
 * @author - Navpreet
 */
public class EmailSignupInline {

	public static WebDriver driver;
	
	// Before running scenario, make changes on line number - 61
	
	@Test
	public void EmailInline() throws Exception
	
	
	{
		System.out.println("Scenario : Onsite Marketing > Select EmailInlineTemplate > Design > Target > Active");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
	//	driver.get("https://pre-prod-102.betaout.com/");
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
		calltoaction_obj.emailsignupclick(); 
		
		calltoaction_obj.PrintNameOfFields();
	//	calltoaction_obj.PrintCampaignPopupDetails();
		
		calltoaction_obj.createcampaign_click();
	//	Date date1 = set.getCurrentDateTime();
		String name = "Auto_emailinline"+" "+System.currentTimeMillis();
		calltoaction_obj.name(name);
		Thread.sleep(1500);
		calltoaction_obj.emailsave_click();  
		Thread.sleep(3000);
		
		Onsite_Select_Template template_obj = new Onsite_Select_Template(driver);
		template_obj.InlineClick();            // Select inline
		Thread.sleep(3000);
		template_obj.EmailSignupInlinetemplateClick();
		
		
		// Explicit wait for Save and Next after selecting template
		
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Save & Next']")));
	
	//	Thread.sleep(18000);
		 Thread.sleep(8000);
		 
		Onsite_Design design = new Onsite_Design(driver);
		
		design.EmailSignupEmailClick();
		design.EmailSignupSenderIDClick();
		design.EmailSignupSubjectClick("This is test subject for the email");
		

		Thread.sleep(2000);

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot 1 is taken successfully");
	
		design.save_next();
		Thread.sleep(12000);
	
		
		Onsite_Target_Page target_obj = new Onsite_Target_Page(driver);
		target_obj.Target_Users_click();   
		Thread.sleep(1500);
		target_obj.Show_Instance_click();
		Thread.sleep(1500);
		target_obj.SI_Everytime_click();
		Thread.sleep(1500);
		target_obj.Target_Pages_click();
		Thread.sleep(1500);
		
		String weburl = "EmailInline";
		target_obj.TP_SpecificURL_click(weburl);           // enter url
		Thread.sleep(3000);
		target_obj.SaveAndNext_click();
		Thread.sleep(9000);
		
		
		Onsite_Activepage active_obj = new Onsite_Activepage(driver);
		
		active_obj.PickSelectorCode_click("html>body.home.archive.post-type-archive.post-type-archive-product.woocommerce.woocommerce-page>div.container:eq(2)>div.row-fluid>div.span12>h1.page-title");
		Thread.sleep(1500);
		active_obj.Active_click();
		active_obj.Save_click();
		Thread.sleep(10000);
		
		
		// Assert name of campaign
		
		String ActiveInstanceName = driver.findElement(By.xpath("(//a[@class = 'camp-name'])[1]")).getText();
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(ActiveInstanceName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");
		
		
		Thread.sleep(10000);
		
	//	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,"t");   	// Open new tab
		
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

		
		// Switch to iframe

	    driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'iframeInline')]")));
	    
	    String InlineText = driver.findElement(By.xpath("//*[@class = 'focus']")).getText();
	    
	    driver.findElement(By.xpath("//*[@name = 'email']")).sendKeys("navpreet@socialcrawler.in");
	    
	    driver.findElement(By.xpath("(//*[@data-amplifylc-name = 'submitBtn'])")).click();
	    System.out.println(InlineText);
			
		s_assert.assertEquals("LIMITED OFFER", InlineText);
		s_assert.assertAll();
		
		System.out.println("Inline is present on the URL");
		Thread.sleep(5000);
		
		// Inactive instance once the desired action is captured on the integrated website
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		
		Thread.sleep(3000);

		driver.switchTo().window(tabs.get(0));
		
		calltoaction_obj.InactiveInstanceClick();
		
		Thread.sleep(5000);
		
		String url = driver.getCurrentUrl();
		System.out.println("URL currently opened is "+url);

	//	driver.quit();
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
	
}
