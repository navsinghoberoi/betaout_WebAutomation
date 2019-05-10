package SMSBOEditorScenarios;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SMSBOEditorPages.SMSBOCreatePage;
import SMSBOEditorPages.SMSBODesignPage;
import SMSMarketingPages.SMSMarketing_Homepage;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class SMSBO_TestSMS {

	
	public static WebDriver driver;

	@Test
	public void SMS_BroadcastCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Create SMS Test SMS from BO");
		
		Setup_class set = new Setup_class(driver);
		Properties prop = set.loadPropertyFile();
		
		driver = set.setup();
		
		String currentDate = set.getCurrentDateTime();
		
		set.getQAURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getRishabhQAUsername());
		obj.upswd(set.getRishabhQAPassword());
		obj.ulogin();
		
		// Add code to select account
		set.selectAccountRishabh();
		System.out.println("User has logged in successfully");
		
		Homepage home_obj = new Homepage(driver);
		home_obj.sms_mktg_click();
		Thread.sleep(3000);
		
		SMSMarketing_Homepage page_obj = new SMSMarketing_Homepage(driver);
		page_obj.Campaigns_BroadCast_CreateCampaignClick();
		
	
		SMSBOCreatePage createobj = new SMSBOCreatePage(driver);
		String campName = prop.getProperty("SMSBOTestCampaignName") + " " +currentDate;
		createobj.Title(campName);
		createobj.GatewayDropdown();
		Thread.sleep(1500);
		createobj.SaveNext();
		Thread.sleep(5000);
		
		
		SMSBODesignPage designobj = new SMSBODesignPage(driver);
		designobj.EnterSMSText(prop.getProperty("SMSBOTestText"));
		Thread.sleep(1500);
		designobj.MoreOptions();
		Thread.sleep(2000);
		designobj.SendTestSMS();
		Thread.sleep(3000);
		designobj.TestSMS_EnterMobile(prop.getProperty("rishabhPhone"));
		Thread.sleep(1000);
		designobj.TestSMS_Send();
		Thread.sleep(3000);
		designobj.Exit();
		Thread.sleep(4000);
		
		String testCampName = page_obj.printCampaignName();
		System.out.println("Campaign Name = " +testCampName );
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(testCampName, campName);
		System.out.println("Assertion -> Name of the campaign is matched");

	}

/*	@AfterMethod
	public void kill() {
		System.out.println("Closing the browser now");
		driver.quit();

	}*/
	
}	