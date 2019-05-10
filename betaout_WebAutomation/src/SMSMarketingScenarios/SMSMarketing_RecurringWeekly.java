package SMSMarketingScenarios;

import java.util.Date;
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
import SMSMarketingPages.SMSMarketing_Recurring_Active;
import SMSMarketingPages.SMSMarketing_Target;
import common_Classes.*;
import promocode_Pages.Onsite_CreateCampaign;
import promocode_Pages.Onsite_Select_Template;
/**
 * @author - Navpreet
 */
public class SMSMarketing_RecurringWeekly {
	
	// make changes on line number - 63, 82

	public static WebDriver driver;

	@Test
	public void SMS_RecurringWeekly() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Campaigns > Recurring> Weekly > Create Campaign> Print counts and stats > Export CSV");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		Properties prop = set.loadPropertyFile();

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
		
		
		SMSMarketing_CampaignType type_obj = new SMSMarketing_CampaignType(driver);
		type_obj.CampaignTypeClick();
	//	Date date1 = set.getCurrentDateTime();
		String name = "Auto_rec_weekly"+" "+System.currentTimeMillis();
		type_obj.CampaignNameClick(name);
		type_obj.PrintChooseCampaignHeading();
		type_obj.PrintCampaignNameHeading();
		type_obj.SaveNextClick();
		Thread.sleep(5000);
		
		SMSMarketing_Design design_obj = new SMSMarketing_Design(driver);
		design_obj.ChooseGatewayClick();
		design_obj.SMSTextClick("This is test message for Recurring SMS Marketing -> Weekly");
		design_obj.SaveNextClick();
		Thread.sleep(5000);
		
		SMSMarketing_Target target_obj = new SMSMarketing_Target(driver);
		
		target_obj.ANDConditionClick();
		target_obj.ANDDropdown1Click();
		target_obj.ANDDropdown2Click("phone");
		target_obj.ANDDropdown3Click();
		target_obj.ANDDropdown4Click(prop.getProperty("SMSNumber"));
		target_obj.RefreshContactsClick();
		Thread.sleep(20000);
		design_obj.SaveNextClick();
		Thread.sleep(5000);
	
		SMSMarketing_Recurring_Active rec_obj = new SMSMarketing_Recurring_Active(driver);
		rec_obj.WeeklyClick();
		
		rec_obj.Weekly_StartDateClick();
		rec_obj.Weekly_EndDateClick();
		rec_obj.EndDate_NextMonthClick();
		rec_obj.EndDate_SelectDateClick();
		rec_obj.Weekly_TimeClick();

		set.setScheduleDateAndTime();   // To calculate -5:30hrs
		Thread.sleep(2000);
		
		rec_obj.Weekly_ExclusionDateClick();
		Thread.sleep(2000);
		rec_obj.Weekly_ExclusionDate_SelectDateClick();
		rec_obj.Exclusion_NextMonthClick();
		rec_obj.Exclusion_SelectDateClick();
		rec_obj.Weekly_ExclusionDate_SaveClick();
		Thread.sleep(3000);
		
		rec_obj.Weekly_DaysToSendClick();
		Thread.sleep(3000);
		rec_obj.Weekly_DaysToSend_Weekdays_MonClick();
		rec_obj.Weekly_DaysToSend_Weekdays_WedClick();
		rec_obj.Weekly_DaysToSend_Weekdays_FriClick();
		rec_obj.Weekly_DaysToSend_Weekdays_SaveClick();
		Thread.sleep(3000);
		
		rec_obj.Weekly_PreviewClick();
		rec_obj.Weekly_ExcludingPreviewClick();
		rec_obj.Weekly_ScheduleClick();
		Thread.sleep(5000);
		

		// Assert name of campaign
		
	//	String WeeklyCampName = driver.findElement(By.xpath("(//*[@title = 'view design'])[1]")).getText();
		String WeeklyCampName = page_obj.RecurringCampaignName();
		
		System.out.println("Campaign Name = " +WeeklyCampName );
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(WeeklyCampName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");
		
	//	String campaigndetails = driver.findElement(By.xpath("(//*[@class = 'hp-btn-container'])[1]")).getText();
		String campaigndetails = page_obj.RecurringCampaignDetails();
		System.out.println("Start Date, End date and Time of Campaign = "+campaigndetails);
		
	
		}

	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}
	

