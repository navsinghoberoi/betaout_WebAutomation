package EmailBOEditorScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import EmailBOEditorPages.EmailBOCreatePage;
import EmailBOEditorPages.EmailBODesignPage;
import EmailMarketingPages.EM_Campains_Broadcast;
import EmailMarketingPages.EM_EventTriggeredCreateCampaign;
import EmailMarketingPages.EM_Send_Schedule;
import EmailMarketingPages.EM_Tageting_Page;
import EmailMarketingPages.EmailMarketing_RecurringActive;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class EmailBO_RecurringDaily {

	public static WebDriver driver;

	@Test
	public void EmailMarketing_BroadcastCampaignUpdateProperty() throws Exception {

		System.out.println("Scenario - Make a recurring daily campaign with BO Editor  > Print counts and verify Stats ");

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

		System.out.println("User has logged in successfully");

		// Add code to select account
		set.selectAccountNav();
		
		Homepage homeobj = new Homepage(driver);
		homeobj.email_mktg_click();

		EM_Campains_Broadcast obj1 = new EM_Campains_Broadcast(driver);
		obj1.campaign_Tab();
		Thread.sleep(2000);
		
		obj1.RecurringClick();
		Thread.sleep(6000);
		
		obj1.Broadcast_Createcapmain();
		Thread.sleep(2000);
		
		// Code for Create page
		
		EmailBOCreatePage createobj = new EmailBOCreatePage(driver);
		String campaignName = prop.getProperty("BOCampNamRecurring") + " " +currentDate;
		createobj.CampaignName(campaignName);
		createobj.GatewayDropdown_Recurring();
		createobj.Subject(prop.getProperty("BOSubjectRecurring"));
		createobj.SaveNext();
		
		Thread.sleep(8000);
		
		// Code for Design page
		
		EmailBODesignPage designobj = new EmailBODesignPage(driver);
		
		designobj.Saved();
		Thread.sleep(2000);
		designobj.SavedTemplate();
		Thread.sleep(2000);
		
		WebElement source = driver.findElement(designobj.SavedTemplate);
		WebElement target = driver.findElement(designobj.BlankSpace);
		
		(new Actions(driver)).dragAndDrop(source, target).perform();
		Thread.sleep(2000);
		
		designobj.SaveNext();		
		
		Thread.sleep(2000);
		set.DynamicPrompt_Continue();
		Thread.sleep(2000);
		
		// Link Confirmation prompt
		
		set.LinkConfirmationPrompt();
		Thread.sleep(4000);
		
		EM_Tageting_Page obj3 = new EM_Tageting_Page(driver);
		String email = prop.getProperty("GmailQAValidUsername");
		System.out.println("Email is to be sent to = " + email.trim().toLowerCase());

		obj3.ANDConditionClick();
		Thread.sleep(2000);
		obj3.ANDDropdown1Click("User Property");
		obj3.ANDDropdown2Click("customer_id");
		obj3.ANDDropdown3Click("Exactly matches");
		
		obj3.ANDDropdown4Click(prop.getProperty("custIdForMail"));    
		Thread.sleep(2000);
		obj3.RefreshContactsClick();
		Thread.sleep(2000);
		obj3.NumberOfContactsClick();
		
		Thread.sleep(2000);
		obj3.SaveandNextClick();
		Thread.sleep(10000);
		
		EmailMarketing_RecurringActive rec_obj = new EmailMarketing_RecurringActive(driver);

		rec_obj.RemoveDuplicateCheckboxClick();             // To Enable Remove Duplicate feature
		Thread.sleep(1000);
		
		rec_obj.DailyClick();

		rec_obj.Daily_StartDateClick();
		rec_obj.Daily_EndDateClick();
		rec_obj.EndDate_NextMonthClick();
		rec_obj.EndDate_SelectDateClick();
		rec_obj.Daily_TimeClick();

		set.setScheduleDateAndTime(); // Increement 1 min only

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
		Thread.sleep(2000);
		Thread.sleep(5000);

		// Assert name of campaign

		String DailyCampName = driver.findElement(obj1.daliyCampName).getText();

		System.out.println("Campaign Name = " + DailyCampName);

		SoftAssert s_assert = new SoftAssert();

		boolean campName = DailyCampName.contains(campaignName);
		System.out.println("Boolean value for comparison of Campaign Name = "+campName);
		
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");

		String campaigndetails = driver.findElement(obj1.dailyCampDetails).getText();
		System.out.println("Start Date, End date and Time of Campaign = " + campaigndetails);

		// Open new tab and verify subject of the email

		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		Thread.sleep(2000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1)); // switches to first tab

		Thread.sleep(30000);           //Wait 30 sec 
		
		// Open Gmail

		set.getGmailURL();

		Thread.sleep(5000); // Wait for 5 sec

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
		System.out.println("Subject of email = " + emailsubject);
		boolean dynamicPPSubject = emailsubject.contains("Levis");
		boolean bracesinSubject = emailsubject.contains("{{");
	
		System.out.println("Boolean value for presence of dynamic properties in email subject= "+dynamicPPSubject);
		s_assert.assertEquals(dynamicPPSubject, true);
		s_assert.assertEquals(bracesinSubject, false);
		
		String emailmessage = page_obj.printemailMessage();
		System.out.println("Message content of email = " + emailmessage.toLowerCase());
		System.out.println("---------------------------------------");

		// Assert that dynamic property is displayed in email message 
		

		boolean dynamicPPMessage = emailmessage.contains("Levis");
		boolean bracesinMessage = emailmessage.contains("{{");
		
		System.out.println("Boolean value for presence of dynamic properties in email message = "+dynamicPPMessage);
		s_assert.assertEquals(dynamicPPMessage, true);
		s_assert.assertEquals(bracesinMessage, false);

		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		System.out.println("Email is deleted successfully");
		
		// Add code to verify counts and stats

		driver.switchTo().window(tabs.get(0)); // switches to first tab

		// Delete recur camp
		
		rec_obj.DeleteRecur();
		Thread.sleep(2000);
		rec_obj.Recur_EnterDeleteTextbox();
		Thread.sleep(1000);
		rec_obj.Recur_DeleteConfirm();
		Thread.sleep(5000);
		
		obj1.Broadcast_Tab();
		
		// Delete 2nd broadcast coz of recur
		
		rec_obj.DeleteBroadSecond();
		Thread.sleep(2000);
		rec_obj.Broad_EnterDeleteTextbox();
		Thread.sleep(1000);
		rec_obj.Broad_DeleteConfirm();
				
		Thread.sleep(5000);
		
		
		// Add code for Counts, Stats
		
		String Count_Delivered = obj1.printDelivered();
		System.out.println("Count for Delivered = " + Count_Delivered);

		s_assert.assertEquals(Count_Delivered, "1");         

		String Count_Recipients = obj1.printTotalRecipients();
		System.out.println("Count for Recipients = " + Count_Recipients);
		
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
	public void kill() {
		System.out.println("Closing the browser now");
		driver.quit();

	}
	
	
	
}
