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

import ContactDatabasePagesAndScenarios.ConntactDB_ViewContactDetails;
import EmailBOEditorPages.EmailBOCreatePage;
import EmailBOEditorPages.EmailBODesignPage;
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
public class EmailBO_Broadcast {

	public static WebDriver driver;

	@Test
	public void EmailMarketing_BroadcastCampaignUpdateProperty() throws Exception {

		System.out.println("Scenario - Make a broadcast campaign with BO Editor  > Update PP >> Print counts and verify Stats ");

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
		
		// Code for Create page
		
		EmailBOCreatePage createobj = new EmailBOCreatePage(driver);
		String campaignName = prop.getProperty("BOCampName") + " " +currentDate;
		createobj.CampaignName(campaignName);
		createobj.GatewayDropdown();
		createobj.Subject(prop.getProperty("BOSubject"));
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
		s_assert.assertEquals(campaignname, campaignName);

		Thread.sleep(2000);
		
		
		// Add code for comparing the updated property data from contact database
		
		
		homeobj.search_click();
		Thread.sleep(1500);
		homeobj.Search_1stDropdown();
		homeobj.Search_ByUser();
		homeobj.Search_UserSubDropdown();
		homeobj.Search_User_ByEmail();
		homeobj.EnterDataToSearch(prop.getProperty("GmailQAValidUsername"));
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
		
		Thread.sleep(40000);           //Wait 40 sec 
		
		
		for(int i=0; i<3; i++)

		{	driver.navigate().back();
			Thread.sleep(1000);
		}
		
		
		driver.navigate().refresh();
		
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
