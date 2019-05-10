package EmailMarketingScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_Homepage;
import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import EmailMarketingPages.EM_EventTriggeredCreateCampaign;
import EmailMarketingPages.EM_Tageting_Page;
import EmailMarketingPages.EmailMarketing_RecurringActive;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class EmailMarketing_Recurring_Weekly {

	
	public static WebDriver driver;
	
	
	
	@Test
	public void RecurringCampaign_Daily() throws Exception{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		String currentDate = set.getCurrentDateTime();
		
		// Code to load the Property file
		
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
				
		Homepage homeobj = new Homepage(driver);
		homeobj.email_mktg_click();
		
		EM_Campains_Broadcast obj1 = new EM_Campains_Broadcast(driver);
		obj1.campaign_Tab();
		Thread.sleep(2000);
		obj1.RecurringClick();
		Thread.sleep(6000);
		
		obj1.Broadcast_Createcapmain();
		Thread.sleep(2000);
	
	//	String name = prop.getProperty("Email_RecurringWeekly_Name") +System.currentTimeMillis();
		
		String name = prop.getProperty("Email_RecurringWeekly_Name") +currentDate;
		obj1.Broadcast_campaign_title(name);
		Thread.sleep(5000);

		obj1.Template();
		Thread.sleep(15000);
	
		EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);

	//	String subject_data = prop.getProperty("Email_RecurringWeekly_Subject") +System.currentTimeMillis();
		
		String subject_data = prop.getProperty("Email_RecurringWeekly_Subject") +currentDate;
		obj2.Campaign_Subject(subject_data);
		
	//	obj2.Sender_Id(prop.getProperty("Email_SenderID"));
		
		obj2.Sender_Id(prop.getProperty("SES_SenderID"));
		
		obj2.Save_and_NextStep();
		Thread.sleep(2000);
		obj2.Linkurl_PopUp_OK();
		Thread.sleep(10000);
		
		
		EM_Tageting_Page obj3 = new EM_Tageting_Page(driver);
		String email = prop.getProperty("GmailQAValidUsername");
		
		/*obj3.AddMoreEmailAddressClick(email);
		obj3.SaveandNextClick();
		Thread.sleep(10000);*/

		obj3.ANDConditionClick();
		Thread.sleep(2000);
		obj3.ANDDropdown1Click("User Property");
		obj3.ANDDropdown2Click("email");
		obj3.ANDDropdown3Click("Exactly matches");
		obj3.ANDDropdown4Click(email);
		
		Thread.sleep(2000);
		obj3.RefreshContactsClick();
		Thread.sleep(5000);
		obj3.NumberOfContactsClick();
		
		Thread.sleep(5000);
		obj3.SaveandNextClick();
		Thread.sleep(10000);
		
		EmailMarketing_RecurringActive rec_obj = new EmailMarketing_RecurringActive(driver);
		
		rec_obj.RemoveDuplicateCheckboxClick();             // To Enable Remove Duplicate feature
		Thread.sleep(1000);
		
		rec_obj.WeeklyClick();
		
		rec_obj.Weekly_StartDateClick();
		rec_obj.Weekly_EndDateClick();
		rec_obj.EndDate_NextMonthClick();
		rec_obj.EndDate_SelectDateClick();
		rec_obj.Weekly_TimeClick();
		
		set.setScheduleDateAndTime();   // To increement 1 min
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
		
		String WeeklyCampName = driver.findElement(obj1.daliyCampName).getText();	
		
		System.out.println("Campaign Name = " +WeeklyCampName );
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(WeeklyCampName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");
		
		String campaigndetails = driver.findElement(obj1.dailyCampDetails).getText();
		System.out.println("Start Date, End date and Time of Campaign = "+campaigndetails);

		Thread.sleep(60000);           //Wait 1 min 
		
		// Open Gmail and verify subject of the email
		
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
			
		set.getGmailURL();
		
		Thread.sleep(60000);           // Wait for 2 min
		
		driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
		
		GmailLoginPages page_obj = new GmailLoginPages(driver);
		
		page_obj.enterUsername(prop.getProperty("GmailQAValidUsername"));   
		page_obj.nextButtonClick();
		
		Thread.sleep(2000);
		
		page_obj.enterPassword(prop.getProperty("GmailQAValidPassword"));
		page_obj.signInClick();
			
		Thread.sleep(7000);
		
		page_obj.openEmail();
	
		page_obj.showDetails();
		
		Thread.sleep(1000);
		String FROMName = page_obj.printFROMName();
		System.out.println("Name of the sender = "+FROMName);
		s_assert.assertEquals(FROMName, prop.getProperty("Email_FROMName"));
		System.out.println("Assertion of FROM Name is done");
				
		String FROMEmailAddress = page_obj.printFROMEmailAddress();
		System.out.println("EmailAddress of the sender = "+FROMEmailAddress);
		boolean val = prop.getProperty("SES_SenderID").contains(FROMEmailAddress);
				
		s_assert.assertEquals(val, true);        
		System.out.println("Assertion of FROM Email Address is done"); 
		
		String emailsubject = page_obj.printemailSubject();
		System.out.println("Subject of email = "+emailsubject);
	
		String emailmessage = page_obj.printemailMessage();
		System.out.println("Message content of email = "+emailmessage);
		System.out.println("---------------------------------------");

		s_assert.assertEquals(emailsubject,subject_data);
		System.out.println("Subject of the email is verified ");
		
		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		System.out.println("Email is deleted successfully");
	
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();
		
		Thread.sleep(60000);           //Wait 1 min 
		
		// Add code to verify counts and stats

		driver.switchTo().window(tabs.get(0)); // switches to first tab

		obj1.Broadcast_Tab();
		
		driver.navigate().refresh();

		String Count_Delivered = obj1.printDelivered();
		System.out.println("Count for Delivered = " + Count_Delivered);

		s_assert.assertEquals(Count_Delivered, "1");

		String Count_Recipients = obj1.printTotalRecipients();
		System.out.println("Count for Recipients = " + Count_Recipients);

	//	s_assert.assertEquals(Count_Recipients, "1");  // Cant match because it varies in case of Duplicate records

		String Count_OpenPercent = obj1.printOpenedPercent();
		System.out.println("Count for Opened Percent = " + Count_OpenPercent);

		s_assert.assertEquals(Count_OpenPercent, "100%");

		String Count_TotalOpen = obj1.printTotalOpened();
		System.out.println("Count for Total Opened = " + Count_TotalOpen);

		s_assert.assertEquals(Count_TotalOpen, "1");

		String Count_ClickPercent = obj1.printClickedPercent();
		System.out.println("Count for Clicked Percent = " + Count_ClickPercent);

		String Count_TotalClick = obj1.printTotalClicked();
		System.out.println("Count for Total Clicked = " + Count_TotalClick);

		String Count_BouncePercent = obj1.printBouncedPercent();
		System.out.println("Count for Bounced Percent = " + Count_BouncePercent);

		String Count_TotalBounced = obj1.printTotalBounced();
		System.out.println("Count for Total Bounced = " + Count_TotalBounced);

		String Count_UnsubscribedPercent = obj1.printUnsubscribedPercent();
		System.out.println("Count for Unsubscribed Percent = " + Count_UnsubscribedPercent);

		String Count_TotalUnsubscribed = obj1.printTotalUnsubscribed();
		System.out.println("Count for Total Unsubscribed = " + Count_TotalUnsubscribed);

		EM_EventTriggeredCreateCampaign eventobj = new EM_EventTriggeredCreateCampaign(driver);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(eventobj.EventTrigger_StatsCampaign)).build().perform();
		Thread.sleep(2000);

		eventobj.EventTrigger_StatsCampaignClick();
		Thread.sleep(3000);

		File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1,
				new File("./Screenshots/" + this.getClass() + System.currentTimeMillis() + ".png"));

		System.out.println("Screenshot of Stats page is taken successfully");

		boolean value = eventobj.EventTrigger_PrintContactsFromStats(prop.getProperty("GmailWoocommerceOneUsername"));
		System.out.println("Boolean value for Stats = " + value);

		if (value == true) {
			System.out.println("PASS , i.e. Required Gmail ID is contained in the Sent heading.");
		} else {
			System.out.println("FAIL , i.e. Required Gmail ID is NOT contained in Sent heading");
		}

		s_assert.assertAll();
	
		}

	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
}