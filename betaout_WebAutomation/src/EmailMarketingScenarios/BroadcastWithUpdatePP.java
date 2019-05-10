package EmailMarketingScenarios;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Buffer;

import ContactDatabasePagesAndScenarios.ConntactDB_ViewContactDetails;
import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import EmailMarketingPages.EM_EventTriggeredCreateCampaign;
import EmailMarketingPages.EM_Send_Schedule;
import EmailMarketingPages.EM_Tageting_Page;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */

public class BroadcastWithUpdatePP {

// This scenario is obsolete [contains dynamic property code] >> Copy the code in Broadcast
	
	
	public static WebDriver driver;

	@Test
	public void EmailMarketing_BroadcastCampaignUpdateProperty() throws Exception {

		System.out.println("Scenario - Make a broadcast campaign with Dynamic Property > Print counts and verify Stats > Update property on Send and verify it");

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
		obj1.Broadcast_Createcapmain();
		Thread.sleep(2000);

		String name = prop.getProperty("Email_Broadcast_Name") + System.currentTimeMillis();

		obj1.Broadcast_campaign_title(name);
		Thread.sleep(3000);

		// obj1.mail_Betaout_server(); // needed when Mailchimp is Enabled from
		// Settings

		Thread.sleep(2000);
		obj1.Template();
		Thread.sleep(15000);

		EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);

		String subject_data = prop.getProperty("Email_Broadcast_Subject") + System.currentTimeMillis();

		obj2.Campaign_Subject(subject_data);
		Thread.sleep(2000);
	//	obj2.Sender_Id(prop.getProperty("Email_SenderID"));
		
		obj2.Sender_Id(prop.getProperty("SES_SenderID"));         // Select SES account
		
		
		// Add code for adding dynamic property
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // Scroll till bottom of page
		
		Actions act0 = new Actions(driver);
		act0.moveToElement(driver.findElement(By.xpath("//*[text() = 'Create a win-win situation for your customers.']")));
		act0.perform();
		driver.findElement(By.xpath("//*[text() = 'Create a win-win situation for your customers.']")).click();
		
		Thread.sleep(1500);	
		driver.findElement(By.xpath("//*[@aria-label = 'personalized tags']")).click(); 
		Thread.sleep(1500);	
		driver.findElement(By.xpath("//*[@data-mce-url1 = '{{email}}']")).click(); 
		Thread.sleep(1500);
		
		obj2.Save_and_NextStep();
		Thread.sleep(2000);
		obj2.Linkurl_PopUp_OK();
		Thread.sleep(10000);

		EM_Tageting_Page obj3 = new EM_Tageting_Page(driver);
		String email = prop.getProperty("GmailQAValidUsername");
		System.out.println("Email is to be sent to = " + email.trim().toLowerCase());       // To remove whitespaces
		obj3.AddMoreEmailAddressClick(email);
		obj3.SaveandNextClick();
		Thread.sleep(10000);

		EM_Send_Schedule obj4 = new EM_Send_Schedule(driver);
		
		// Add code for Update Property at Send
		
		obj4.UpdatePropertiesCheckbox();
		Thread.sleep(1500);
		obj4.Send_AddRow();
		obj4.Send_Drodown(prop.getProperty("Send_UpdatePropertyName"));
		String UpdatePPText = prop.getProperty("Send_UpdatePropertyText") + " "+currentDate ;
		obj4.Send_EnterText(UpdatePPText);
		Thread.sleep(1500);
		obj4.SEND_NOWClick();
		Thread.sleep(2000);
		obj4.SEND_NOW_CONFIRMClick();
		Thread.sleep(10000);

		// Start making changes from here

		List<org.openqa.selenium.WebElement> broadcast_campaigns = driver.findElements(obj1.broadcast_campaigns);

		System.out.println("Total number of campaigns are = " + broadcast_campaigns.size());

		String campaignname = ((org.openqa.selenium.WebElement) broadcast_campaigns.get(0)).getText();
		System.out.println("Name of the created campaign = " + campaignname);

		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(campaignname, name);

		Thread.sleep(6000);

		// Add code for comparing the updated property data from contact database
		
		
		homeobj.search_click();
		Thread.sleep(1500);
		homeobj.Search_1stDropdown();
		homeobj.Search_ByUser();
		homeobj.Search_UserSubDropdown();
		homeobj.Search_User_ByPhone();
		homeobj.EnterDataToSearch(prop.getProperty("QA_PhoneNumber"));
		homeobj.SearchSubmitButton();
		Thread.sleep(5000);
		
		ConntactDB_ViewContactDetails contact_obj = new ConntactDB_ViewContactDetails(driver);
		contact_obj.OpenUser();           // Not able to open user
		
		Thread.sleep(3000);
		contact_obj.Properties();          // Open Properties tab
	
		Thread.sleep(3000);
		
		String UpdatedPropertyText = contact_obj.printUpdatetextPropertyData();
		
		s_assert.assertEquals(UpdatePPText, UpdatedPropertyText);
		System.out.println("Assertion of text of updated property is done");
		Thread.sleep(2000);
		
		// Open new tab and verify subject of the email

		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		Thread.sleep(2000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1)); // switches to first tab
		
		
		// Open Gmail

		set.getGmailURL();

		Thread.sleep(10000); // Wait for 10 sec

		driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();

		GmailLoginPages page_obj = new GmailLoginPages(driver);

		page_obj.enterUsername(prop.getProperty("GmailQAValidUsername"));
		page_obj.nextButtonClick();

		Thread.sleep(2000);

		page_obj.enterPassword(prop.getProperty("GmailQAValidPassword"));
		page_obj.signInClick();

		Thread.sleep(7000);

		page_obj.openEmail();

		String emailsubject = page_obj.printemailSubject();
		System.out.println("Subject of email = " + emailsubject);

		String emailmessage = page_obj.printemailMessage();
		System.out.println("Message content of email = " + emailmessage.toLowerCase());        // convert to lower case
		System.out.println("---------------------------------------");

		// Assert that dynamic property is displayed in email message 
		
		boolean dynamicPP = emailmessage.contains(email);
		System.out.println("Boolean value for presence of dynamic property in email = "+dynamicPP);
		s_assert.assertEquals(dynamicPP, true);
		
		s_assert.assertEquals(emailsubject, subject_data);
		System.out.println("Subject of the email is verified ");

		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		System.out.println("Email is deleted successfully");

		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();

		// Add code to verify counts and stats

		driver.switchTo().window(tabs.get(0)); // switches to first tab

		Thread.sleep(2000);
		
		for(int i=0;i<3;i++)
		{
			driver.navigate().back();
		}
	
		Thread.sleep(5000);
		
		String CurrentURL = driver.getCurrentUrl();
		driver.get(CurrentURL);
		
		String Count_Delivered = obj1.printDelivered();
		System.out.println("Count for Delivered = " + Count_Delivered);

		s_assert.assertEquals(Count_Delivered, "1");

		String Count_Recipients = obj1.printTotalRecipients();
		System.out.println("Count for Recipients = " + Count_Recipients);

		s_assert.assertEquals(Count_Recipients, "1");

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
