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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
public class EmailMarketing_DuplicateScenarios {

public static WebDriver driver;
	
	
	@Test
	public void EmailMarketing_DuplicateCampaign() throws Exception{
		
		System.out.println("Scenario - Create campaign with Remove Duplicate check on > clone it and now untick the Remove Duplicate check > Verify Stats ");
		
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
		obj1.Broadcast_Createcapmain();
		Thread.sleep(2000);
		
	//	String name = prop.getProperty("EmailDuplicate_Broadcast_Name") + System.currentTimeMillis();
		String name = prop.getProperty("EmailDuplicate_Broadcast_Name") + currentDate;
		
		obj1.Broadcast_campaign_title(name);
		Thread.sleep(3000);
	
//		obj1.mail_Betaout_server();       // needed when Mailchimp is Enabled from Settings
		
		Thread.sleep(2000);
		obj1.Template();
		Thread.sleep(15000);
	
		EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);
		
	//	String subject_data = prop.getProperty("Email_Duplicate_Subject") + System.currentTimeMillis();
		String subject_data = prop.getProperty("Email_Duplicate_Subject") + currentDate;
		
		obj2.Campaign_Subject(subject_data);
		Thread.sleep(2000);
//		obj2.Sender_Id(prop.getProperty("Email_SenderID"));
	
		obj2.Sender_Id(prop.getProperty("SES_SenderID"));  
		
		obj2.Save_and_NextStep();
		Thread.sleep(2000);
		obj2.Linkurl_PopUp_OK();
		Thread.sleep(10000);
	
		EM_Tageting_Page obj3 = new EM_Tageting_Page(driver);
		String email =  prop.getProperty("GmailQAValidUsername");
		System.out.println("Email is to be sent to = " +email);
		
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
		
		EM_Send_Schedule obj4 = new EM_Send_Schedule(driver);
		
		// By default Remove Duplicates is enabled
		
		obj4.SEND_NOWClick();
		Thread.sleep(2000);
		
		obj4.SEND_NOW_CONFIRMClick();
		Thread.sleep(10000);
	
		List<org.openqa.selenium.WebElement> broadcast_campaigns = driver.findElements(obj1.broadcast_campaigns);
		System.out.println("Total number of campaigns are = "+broadcast_campaigns.size());
		
		String campaignname = ((org.openqa.selenium.WebElement) broadcast_campaigns.get(0)).getText();
		System.out.println("Name of the created campaign = "+campaignname);
		
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(campaignname,name);
		
		Thread.sleep(6000);
		
		// Open new tab and verify subject of the email
	
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		
		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
		
		Thread.sleep(60000);           //Wait 1 min 
		
		// Open Gmail
		
		set.getGmailURL();
		
		Thread.sleep(20000);           // Wait for 20 sec
		
		driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
	
		GmailLoginPages page_obj = new GmailLoginPages(driver);
		
		page_obj.enterUsername(prop.getProperty("GmailQAValidUsername"));   
		page_obj.nextButtonClick();
		
		Thread.sleep(2000);
		
		page_obj.enterPassword(prop.getProperty("GmailQAValidPassword"));
		page_obj.signInClick();
			
		Thread.sleep(7000);
		
		String UsernameOnGmailDuplicateRemoved = page_obj.printUsername();
		System.out.println("Username on Gmail = "+UsernameOnGmailDuplicateRemoved);
		
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
		
		boolean DuplicateRemoved = UsernameOnGmailDuplicateRemoved.matches(".*\\d+.*");    // Check if username contains numbers
		System.out.println("Boolean Result of Duplicates Removed = "+DuplicateRemoved);
	
		s_assert.assertEquals(false, DuplicateRemoved);
		System.out.println("Boolean result of the duplicates removed is verified ");
		
		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		System.out.println("Email is deleted successfully");
		Thread.sleep(2000);
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();
		
		
		// [Use Data from Test class ]Add code to clone, edit campaign, tick remove duplicates and verify email 
		
		driver.switchTo().window(tabs.get(0)); //switches to first tab
		
		obj1.CloneCampaignClick();
		
		Thread.sleep(8000);
		
		obj1.EditCampaignClick();
		
		Thread.sleep(6000);
		
		obj2.Save_and_NextStep();
		Thread.sleep(2000);
		obj2.Linkurl_PopUp_OK();
		Thread.sleep(10000);
		
		obj3.SaveandNextClick();
		Thread.sleep(10000);
		
		obj4.Remove_Duplicate_CheckboxClick();                       // User should receive multiple emails
		obj4.SEND_NOWClick();
		Thread.sleep(2000);
			
		obj4.SEND_NOW_CONFIRMClick();
		Thread.sleep(10000);
		
		List<org.openqa.selenium.WebElement> broadcast_campaigns1 = driver.findElements(obj1.broadcast_campaigns);
		System.out.println("Total number of campaigns are = "+broadcast_campaigns1.size());
			
		String campaignname1 = ((org.openqa.selenium.WebElement) broadcast_campaigns1.get(0)).getText();
		System.out.println("Name of the created campaign = "+campaignname1);
			
		boolean CloneCampName = campaignname1.contains("Clone");
		s_assert.assertEquals(true, CloneCampName);
		System.out.println("Assertion of Cloned Campaign Name is done");
		
		
		driver.switchTo().window(tabs.get(1)); //switch to Gmail
	
		Thread.sleep(60000);           //Wait 1 min 
		
		// Open Gmail
		
		Thread.sleep(10000);           // Wait for 10 sec
			
		page_obj.enterPassword(prop.getProperty("GmailQAValidPassword"));
		page_obj.signInClick();
			
		Thread.sleep(7000);
		
		String UsernameOnGmailDuplicateNotRemoved = page_obj.printUsername();
		System.out.println("Username on Gmail = "+UsernameOnGmailDuplicateNotRemoved);
		
		page_obj.openEmail();
	
		String emailsubject1 = page_obj.printemailSubject();
		System.out.println("Subject of Cloned email = "+emailsubject1);
	
		String emailmessage1 = page_obj.printemailMessage();
		System.out.println("Message content of Cloned email = "+emailmessage1);
		System.out.println("---------------------------------------");
		
		s_assert.assertEquals(emailsubject1,subject_data);
		System.out.println("Subject of the email is verified ");
		
		boolean DuplicateNotRemoved = UsernameOnGmailDuplicateNotRemoved.matches(".*\\d+.*");    // Check if username contains numbers
		System.out.println("Boolean Result of Duplicates Not Removed = "+DuplicateNotRemoved);
	
		s_assert.assertEquals(true, DuplicateNotRemoved);
		System.out.println("Boolean result of the duplicates not removed is verified ");
		
		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		System.out.println("Email is deleted successfully");
		Thread.sleep(2000);
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();
	
		
		driver.switchTo().window(tabs.get(0)); //switch to Betaout
		
		Thread.sleep(60000);           //Wait 1 min 
		
		// Add code to print and compare data of Counts and Stats
	
		EM_EventTriggeredCreateCampaign eventobj = new EM_EventTriggeredCreateCampaign(driver);
		
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(eventobj.EventTrigger_StatsCampaign)).build().perform();	
		Thread.sleep(2000);
	
		eventobj.EventTrigger_StatsCampaignClick();
		Thread.sleep(3000);
	
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot of Stats page is taken successfully");
		
		boolean value = eventobj.EventTrigger_PrintContactsFromStats(prop.getProperty("GmailWoocommerceOneUsername"));
		System.out.println("Boolean value for Stats = "+value);
			
		if (value == true) {
			   System.out.println("PASS , i.e. Required Gmail ID is contained in the Sent heading.");
			   }
			   else {
			   System.out.println("FAIL , i.e. Required Gmail ID is NOT contained in Sent heading");
			   }
	
	
		driver.navigate().back();

		driver.navigate().refresh();
		
		s_assert.assertAll();
	
												}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}
