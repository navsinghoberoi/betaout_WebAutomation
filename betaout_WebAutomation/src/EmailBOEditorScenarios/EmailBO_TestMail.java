package EmailBOEditorScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import EmailBOEditorPages.EmailBOCreatePage;
import EmailBOEditorPages.EmailBODesignPage;
import EmailMarketingPages.EM_Campains_Broadcast;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class EmailBO_TestMail {

	public static WebDriver driver;

	@Test
	public void EmailMarketing_BroadcastCampaignUpdateProperty() throws Exception {

		System.out.println("Scenario - Make a broadcast Test Mail campaign with BO Editor > Verify the email and content");

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
		String campaignName = prop.getProperty("BOTestCampName") + " " +currentDate;
		createobj.CampaignName(campaignName);
		createobj.GatewayDropdown();
		createobj.Subject(prop.getProperty("BOTestSubject"));
		createobj.SaveNext();
		
		Thread.sleep(8000);
		
		// Code for Design page
		
		EmailBODesignPage designobj = new EmailBODesignPage(driver);
		
		designobj.Saved();
		Thread.sleep(2000);
		designobj.SavedTemplate();
		Thread.sleep(4000);
		
		WebElement source = driver.findElement(designobj.SavedTemplate);
		WebElement target = driver.findElement(designobj.BlankSpace);
		
		(new Actions(driver)).dragAndDrop(source, target).perform();
		Thread.sleep(2000);
		
		designobj.MoreOptions();
		Thread.sleep(2000);
		designobj.SendTestMail();
		Thread.sleep(5000);
		
		// Dynamic Property prompt
		set.DynamicPrompt_Continue();
		Thread.sleep(2000);
		
		// Link Confirmation prompt
		
		set.LinkConfirmationPrompt();
		Thread.sleep(4000);
		
		designobj.SendTestMail_EnterEmail(prop.getProperty("GmailQAValidUsername"));
		Thread.sleep(1000);
		designobj.SendTestMail_Send();
		Thread.sleep(5000);
		
		designobj.Exit();
		Thread.sleep(5000);
		
		// Compare campaign name
		
		List<org.openqa.selenium.WebElement> broadcast_campaigns = driver.findElements(obj1.broadcast_campaigns);

		System.out.println("Total number of campaigns are = " + broadcast_campaigns.size());

		String campaignname = ((org.openqa.selenium.WebElement) broadcast_campaigns.get(0)).getText();
		System.out.println("Name of the created campaign = " + campaignname);

		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(campaignname, campaignName);

		Thread.sleep(6000);
		
		
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
		
	}
	
	
	@AfterMethod
	public void kill() {
		System.out.println("Closing the browser now");
		driver.quit();

	}
	
}
