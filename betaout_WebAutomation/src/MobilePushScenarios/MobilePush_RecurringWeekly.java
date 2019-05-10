package MobilePushScenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MobilePushPages.createCampaignPage;
import MobilePushPages.mobilePush_DesignPage;
import MobilePushPages.mobilePush_Recurring_SendOrSchedule;
import MobilePushPages.mobilePush_TargetingPage;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class MobilePush_RecurringWeekly {

	
	public static WebDriver driver;
	
	
	@Test
	
	public void Mobile_WeeklyCampaign() throws Exception
	
	{
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
	//	driver.get("https://pre-prod-102.betaout.com/");
		set.getPreProdURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getBetaoutpushUsername());
		obj.upswd(set.getBetaoutpushPassword());
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		homeobj.mobilepush_click();
		
		createCampaignPage obj1 = new createCampaignPage(driver);
		
		obj1.RecurringClick();
		obj1.Recurring_campaignsButtonClick();
		
		String campaignNameEntered = "Rec_weekly"+System.currentTimeMillis();
		obj1.broadcastImage();
		obj1.enterCampaignName(campaignNameEntered);
		obj1.clickOnSaveandNextButton();
		
		Thread.sleep(5000);
		
		mobilePush_DesignPage obj2 = new mobilePush_DesignPage(driver);
		
		String titleEntered = "Title"+System.currentTimeMillis();
		obj2.setMobilePushTitle(titleEntered);
		
		String messageEntered = "Message"+System.currentTimeMillis();
		obj2.setMobilePushMessageBody(messageEntered);
		obj2.clickOnSaveAndNextButton();
		
		Thread.sleep(5000);
		
		mobilePush_TargetingPage obj3 = new mobilePush_TargetingPage(driver);
		
		obj3.clickOnAddButton();
		obj3.ANDDropdown1Click();
		obj3.ANDDropdown2Click();
		obj3.ANDDropdown3Click();
		obj3.ANDDropdown4Click("eCgM_hU7guc:APA91bHcLJYwPJi-EXNdGnETjH3ShFNfzgCNuAZyrlhx6jVwVa4B0pTShXOE5paaIjuQW4Fw0X9y65SqAqhKYgZQpx2VpmcnVoDodhuAwx8NKizKn6GDJwLNUFqcrSHP55Cez42_MbQF");   // GCM id 
		
		obj3.clickOnRefreshButton();
		Thread.sleep(5000);
		
		obj2.clickOnSaveAndNextButton();
		Thread.sleep(5000);
		
		mobilePush_Recurring_SendOrSchedule rec_obj = new mobilePush_Recurring_SendOrSchedule(driver);
	
		rec_obj.WeeklyClick();
		
		rec_obj.Weekly_StartDateClick();
		rec_obj.Weekly_EndDateClick();
	//	driver.findElement(By.xpath(("(//*[@class = 'next'])[4]"))).click();  // Next Month
		rec_obj.EndDate_NextMonthClick();
	//	driver.findElement(By.xpath(("(//*[@class = 'day' and text()='10'])"))).click();  // Select 10th 
		rec_obj.EndDate_SelectDateClick();
		rec_obj.Weekly_TimeClick();
		
		set.setScheduleDateAndTime();   // To calculate -5:30hrs
		Thread.sleep(2000);
		rec_obj.Weekly_ExclusionDateClick();
		Thread.sleep(2000);
		rec_obj.Weekly_ExclusionDate_SelectDateClick();
	//	driver.findElement(By.xpath(("(//*[@class = 'next'])[7]"))).click();  // Next Month
		rec_obj.Exclusion_NextMonthClick();
	//	driver.findElement(By.xpath(("(//*[@class = 'day' and text()='10'])"))).click();  // Select 10th 
		rec_obj.Exclusion_SelectDateClick();
		rec_obj.Weekly_ExclusionDate_SaveClick();
		Thread.sleep(3000);
		
		rec_obj.Weekly_DaysToSendClick();
		Thread.sleep(3000);
		rec_obj.Weekly_DaysToSend_Weekdays_MonClick();
		rec_obj.Weekly_DaysToSend_Weekdays_TuesClick();		
		rec_obj.Weekly_DaysToSend_Weekdays_WedClick();
		rec_obj.Weekly_DaysToSend_Weekdays_ThursClick();
		rec_obj.Weekly_DaysToSend_Weekdays_FriClick();
		rec_obj.Weekly_DaysToSend_Weekdays_SaveClick();
		Thread.sleep(3000);
		
		rec_obj.Weekly_PreviewClick();
		rec_obj.Weekly_ExcludingPreviewClick();
		rec_obj.Weekly_ScheduleClick();
		Thread.sleep(5000);
		

		// Assert name of campaign
		
		String WeeklyCampName = driver.findElement(By.xpath("(//*[@title = 'view design'])[1]")).getText();
		
		System.out.println("Campaign Name = " +WeeklyCampName );
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(WeeklyCampName, campaignNameEntered);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");
		
		String campaigndetails = driver.findElement(By.xpath("(//*[@class = 'hp-btn-container'])[1]")).getText();
		System.out.println("Start Date, End date and Time of Campaign = "+campaigndetails);
	
		Thread.sleep(6000);
		
	
	   // Open Contact DB > Properties to verify data of 'pn_last_sent_date' field
		
		
		homeobj.contact_db_click();
		
		driver.findElement(By.xpath("//*[@id = 'search-trigger']")).click();     // Search box
		driver.findElement(By.xpath("(//*[@name = 'search'])[3]")).sendKeys("latest123");   // Enter in Search box
		
		driver.findElement(By.xpath("(//*[@class = 'boicon-search'])[3]")).click();   // Click on Search
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//*[contains(@href,'/users/user-permalink/nv/userId')])[1]")).click();  // Open Contact
		Thread.sleep(5000);
		
		// Add timer for 2 hours
	//	Thread.sleep((long) 7.2e+6);
		
	//	Thread.sleep(7200000);
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("(//*[text() = 'Properties'])[2]")).click(); // Properties
		Thread.sleep(5000);
 		
		String pn_lastsentdate = driver.findElement(By.xpath("(//*[text()='pn_last_sent_date']/../td)[2]")).getText();
		System.out.println("pn_last_sent_date = "+pn_lastsentdate);
	
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}
