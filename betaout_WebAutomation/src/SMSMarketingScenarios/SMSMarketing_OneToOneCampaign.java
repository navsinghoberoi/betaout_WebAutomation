package SMSMarketingScenarios;

import java.util.Properties;
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
import common_Classes.Account_Settings;
import common_Classes.Loginpage;
import promocode_Pages.Onsite_CreateCampaign;
import common_Classes.Onsite_Design;
import common_Classes.Homepage;
import promocode_Pages.Onsite_Select_Template;
import common_Classes.Onsite_Target_Page;
/**
 * @author - Navpreet
 */
public class SMSMarketing_OneToOneCampaign{

	
	public static WebDriver driver;

	@Test
	public void SMS_OneToOneCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Campaigns > One To One > Create Campaign");
		
		Setup_class set = new Setup_class(driver);
		Properties prop = set.loadPropertyFile();
		
		driver = set.setup();

		set.getQAURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getRishabhQAUsername());
		obj.upswd(set.getRishabhQAPassword());
		obj.ulogin();
		
		// Add code to select account
		set.selectAccountRishabh();;
		
		System.out.println("User has logged in successfully");
		
		Homepage home_obj = new Homepage(driver);
		home_obj.sms_mktg_click();
		Thread.sleep(3000);
		
		SMSMarketing_Homepage page_obj = new SMSMarketing_Homepage(driver);
		page_obj.Campaigns_OnetoOneClick();
		
		page_obj.Campaigns_OnetoOne_GatewayClick();
	
		page_obj.Campaigns_OnetoOne_ToClick(prop.getProperty("rishabhPhone"));
		
		page_obj.Campaigns_OnetoOne_MessageClick(prop.getProperty("SMSBOOneToOneText"));
		
		page_obj.Campaigns_OnetoOne_SendClick();
	
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
	}

	
}