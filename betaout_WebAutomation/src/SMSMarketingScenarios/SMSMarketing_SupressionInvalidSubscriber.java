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
public class SMSMarketing_SupressionInvalidSubscriber{

	// make changes on line number - 62
	
	public static WebDriver driver;

	@Test
	public void SMS_SupressionInvalidSubscriber() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Supression List > InvalidSubscriber > Export CSV");
		
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
		page_obj.SuppressionListClick();
		page_obj.SuppressionList_InvalidSubscriberClick(); 
		String ActualInvalidSubscriberNumber = "11001";
		page_obj.SuppressionList_InvalidSubscriber_AddInvalidNumbersClick(ActualInvalidSubscriberNumber);
		Thread.sleep(7000);
		
		String ExpectedInvalidSubscriberNumber = driver.findElement(By.xpath("//*[contains(@class,'selectable')]/td[1]")).getText();
		System.out.println("Supression List Data entered by user = "+ExpectedInvalidSubscriberNumber);
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(ExpectedInvalidSubscriberNumber, ActualInvalidSubscriberNumber);
		s_assert.assertAll();
		System.out.println("Assertion -> Invalid Subscriber Number is matched");
		Thread.sleep(7000);
		
		page_obj.SuppressionList_InvalidSubscriber_ExportClick();

	//	driver.quit();

	}
	
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}