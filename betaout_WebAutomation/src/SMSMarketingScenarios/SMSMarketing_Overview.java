package SMSMarketingScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SMSMarketingPages.SMSMarketing_Broadcast_Active;
import SMSMarketingPages.SMSMarketing_CampaignType;
import SMSMarketingPages.SMSMarketing_Design;
import SMSMarketingPages.SMSMarketing_Homepage;
import SMSMarketingPages.SMSMarketing_Target;
import common_Classes.*;
import promocode_Pages.Onsite_CreateCampaign;
import promocode_Pages.Onsite_Select_Template;
/**
 * @author - Navpreet
 */
public class SMSMarketing_Overview {

	public static WebDriver driver;

	@Test
	public void SMS_OneToOneCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Overview");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		set.getQAURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getNavpreetQAUsername());
		obj.upswd(set.getNavpreetQAPassword());
		obj.ulogin();
		// Add code to select account
				set.selectAccountNav();
		System.out.println("User has logged in successfully");
		
		Homepage home_obj = new Homepage(driver);
		home_obj.sms_mktg_click();
		Thread.sleep(3000);
		
		SMSMarketing_Homepage page_obj = new SMSMarketing_Homepage(driver);
		page_obj.OverviewClick();
		page_obj.PrintOverviewInfoClick();
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}


}