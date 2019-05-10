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
import SMSMarketingPages.SMSMarketing_Homepage;
import SMSMarketingPages.SMSMarketing_Recurring_Active;
import SMSMarketingPages.SMSMarketing_Target;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class SMSBO_RecurringDaily {


	public static WebDriver driver;

	@Test
	public void SMS_BroadcastCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Create SMS Recurring Daily campaign from BO > Print counts and stats > Export CSV");
		
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
		
		page_obj.Campaigns_RecurringClick();
		Thread.sleep(5000);	
		page_obj.Campaigns_Recurring_CreateCampaignClick();
		
	
		SMSBOCreatePage createobj = new SMSBOCreatePage(driver);
		String campName = prop.getProperty("SMSBORecurringCampaignName") + " " +currentDate;
		createobj.Title(campName);
		createobj.GatewayDropdown();
		Thread.sleep(1500);
		createobj.SaveNext();
		Thread.sleep(5000);
		
		
		SMSBODesignPage designobj = new SMSBODesignPage(driver);
		designobj.EnterSMSText(prop.getProperty("SMSBORecurText"));
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
		
		SMSMarketing_Recurring_Active rec_obj = new SMSMarketing_Recurring_Active(driver);
		rec_obj.DailyClick();
		
		rec_obj.Daily_StartDateClick();
		rec_obj.Daily_EndDateClick();
		rec_obj.EndDate_NextMonthClick();
		rec_obj.EndDate_SelectDateClick();
		rec_obj.Daily_TimeClick();
	
		set.setScheduleDateAndTime();   // To calculate +1 min
		
		Thread.sleep(2000);
		
		rec_obj.Daily_ExclusionDateClick();
		Thread.sleep(2000);
		rec_obj.Daily_ExclusionDate_SelectDateClick();
		rec_obj.Exclusion_NextMonthClick();
		rec_obj.Exclusion_SelectDateClick();
		rec_obj.Daily_ExclusionDate_SaveClick();
		Thread.sleep(2000);
		rec_obj.Daily_PreviewClick();
		rec_obj.Daily_ExcludingPreviewClick();
		rec_obj.Daily_ScheduleClick();
		Thread.sleep(5000);
		

		// Assert name of campaign
		
		String DailyCampName = page_obj.RecurringCampaignName();
		System.out.println("Campaign Name = " +DailyCampName);
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(DailyCampName, campName);
		System.out.println("Assertion -> Name of the campaign is matched");
		
		String campaigndetails = page_obj.RecurringCampaignDetails();
		
		System.out.println("Start Date, End date and Time of Campaign = "+campaigndetails);
	
		Thread.sleep(60000); // Wait for 1 min
		
		driver.navigate().refresh();
		
		// Code to Delete Recur campaign
		
		rec_obj.DeleteRecur();
		Thread.sleep(2000);
		rec_obj.Recur_EnterDeleteTextbox();
		Thread.sleep(1000);
		rec_obj.Recur_DeleteConfirm();
		Thread.sleep(5000);
		
		page_obj.Campaigns_BroadCastClick();            // Move to broadcast page
		
		// Delete 2nd broadcast camp created coz of Recurring
		
		rec_obj.DeleteBroadSecond();
		Thread.sleep(2000);
		rec_obj.Broad_EnterDeleteTextbox();
		Thread.sleep(1000);
		rec_obj.Broad_DeleteConfirm();

		// Add code for Counts, Stats
				
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

		s_assert.assertAll();
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
	}
	
	
}
