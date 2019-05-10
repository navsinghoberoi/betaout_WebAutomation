package SMSBOEditorScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import EmailMarketingPages.EM_Tageting_Page;
import SMSBOEditorPages.SMSBOCreatePage;
import SMSBOEditorPages.SMSBODesignPage;
import SMSMarketingPages.SMSMarketing_Broadcast_Active;
import SMSMarketingPages.SMSMarketing_CampaignType;
import SMSMarketingPages.SMSMarketing_Design;
import SMSMarketingPages.SMSMarketing_Homepage;
import SMSMarketingPages.SMSMarketing_Target;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class SMSBO_Broadcast {

	public static WebDriver driver;

	@Test
	public void SMS_BroadcastCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Create SMS Broadcast campaign from BO > Print counts and stats > Export CSV");
		
		Setup_class set = new Setup_class(driver);
		Properties prop = set.loadPropertyFile();
		
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
		
		Homepage home_obj = new Homepage(driver);
		home_obj.sms_mktg_click();
		Thread.sleep(3000);
		
		SMSMarketing_Homepage page_obj = new SMSMarketing_Homepage(driver);
		page_obj.Campaigns_BroadCast_CreateCampaignClick();
		
	
		SMSBOCreatePage createobj = new SMSBOCreatePage(driver);
		String campName = prop.getProperty("SMSBOCampaignName") + " " +currentDate;
		createobj.Title(campName);
		createobj.GatewayDropdown();
		Thread.sleep(1500);
		createobj.SaveNext();
		Thread.sleep(5000);
		
		
		SMSBODesignPage designobj = new SMSBODesignPage(driver);
		designobj.EnterSMSText(prop.getProperty("SMSBOBroadcastText"));
		Thread.sleep(1500);
		designobj.SelectCouponList();
		Thread.sleep(1500);
		designobj.SaveNext();
		Thread.sleep(2000);
		set.DynamicPrompt_Continue();
		
		Thread.sleep(4000);
		
		SMSMarketing_Target target_obj = new SMSMarketing_Target(driver);
		EM_Tageting_Page obj3 = new EM_Tageting_Page(driver);
		
		target_obj.ANDConditionClick();
		target_obj.ANDDropdown1Click();
		obj3.ANDDropdown2Click("customer_id");
		target_obj.ANDDropdown3Click();
		obj3.ANDDropdown4Click(prop.getProperty("custIdForSMS"));
		target_obj.RefreshContactsClick();
		Thread.sleep(2000);
		designobj.SaveNext();
		Thread.sleep(5000);
		
		SMSMarketing_Broadcast_Active active_obj = new SMSMarketing_Broadcast_Active(driver);
		active_obj.SendNowClick();
		Thread.sleep(9000);
		
		// Assert name of campaign
		
		String BroadcastCampName = page_obj.printCampaignName();
		System.out.println("Campaign Name = " +BroadcastCampName );
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(BroadcastCampName, campName);
		System.out.println("Assertion -> Name of the campaign is matched");
	
		
		// Add code for Counts, Stats
		
		Thread.sleep(60000);        // Wait for 1 min
		
		driver.navigate().refresh();
		
		String Sent = page_obj.printSent();
		s_assert.assertEquals(Sent, "1");
		System.out.println("Assertion for the count of Sent data is done");
		String Recipients = page_obj.printRecipients();
		String Delivered = page_obj.printDelivered();
		String DeliveredPercent = page_obj.printDeliveredPercent();
		String Clicked =page_obj.printClicked();
		String Discarded = page_obj.printDiscarded();
		String DiscardedPercent = page_obj.printDiscardedPercent();
		String Failed = page_obj.printFailed();
		
		page_obj.Campaigns_BroadCast_Stats();
		
		Thread.sleep(3000);
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File("./Screenshots/" + this.getClass() + System.currentTimeMillis() + ".png"));

		System.out.println("Screenshot of Stats page is taken successfully");

		boolean value = page_obj.SMS_PrintContactsFromStats(prop.getProperty("SMSNumber"));
		System.out.println("Boolean value for Stats = " + value);

		if (value == true) {
			System.out.println("PASS , i.e. Required Phone Number is contained in the Sent heading.");
		} else {
			System.out.println("FAIL , i.e. Required Phone Number is NOT contained in Sent heading");
		}

		s_assert.assertEquals(value, true);
		
		// Click on Export CSV from Sent heading
		driver.switchTo().frame(driver.findElement(page_obj.SentIframe));
		
		page_obj.ExportCSVclick();
		Thread.sleep(3000);
		
		// Move to new tab and click on download icon, capture screenshot
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		
		page_obj.DownloadCSVclick();
		
		Thread.sleep(3000);
		
		File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1,
				new File("./Screenshots/" + this.getClass() + System.currentTimeMillis() + ".png"));
		
		System.out.println("Screenshot is taken after clicking on download icon");
		
		s_assert.assertAll();
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
	}
	

	
}
