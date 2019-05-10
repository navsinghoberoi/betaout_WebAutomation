package EmailBOEditorScenarios;

import java.io.File;
import java.util.ArrayList;
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

import CartRecoveryPages.CartRecovery_Homepage;
import EmailBOEditorPages.EmailBOCreatePage;
import EmailBOEditorPages.EmailBODesignPage;
import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import EmailMarketingPages.EM_EventTriggeredCreateCampaign;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class EmailBO_EventTrigger {

public static WebDriver driver;
	
	
	@Test
	public void EventTrigger_AddToCart() throws Exception{
		
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
		obj1.EventTriggeredClick();
		Thread.sleep(2000);

		EM_EventTriggeredCreateCampaign eventobj = new EM_EventTriggeredCreateCampaign(driver);
		
		eventobj.EventTrigger_CreateCampaignButton();
		Thread.sleep(5000);
		
		// Code for Create page
		
		EmailBOCreatePage createobj = new EmailBOCreatePage(driver);
		String campaignName = prop.getProperty("BOEventCampName") + " " +currentDate;
		createobj.CampaignName(campaignName);
		createobj.GatewayDropdown_Recurring();
		createobj.Subject(prop.getProperty("BOEventSubject"));
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
		Thread.sleep(5000);
	
		/*eventobj.EventTrigger_SaveCampaign();
		Thread.sleep(5000);*/
		
		eventobj.SelectEventFromDropdown("added_to_cart");       // Add to cart event
		Thread.sleep(2000);
		
		//First Save campaign and then activate
		
		eventobj.EventTrigger_Save();
		Thread.sleep(5000);
		
		eventobj.EventTrigger_ActiveCampaignClick();
		Thread.sleep(3000);
		
		// Print details of event
		
		String triggerName = eventobj.PrintEventTriggerName();     // compare with campname
		String triggerEventName = eventobj.PrintEventTrigger_TriggerEvent();
		String triggerLifecycleName = eventobj.PrintEventTrigger_LifecycleStage();
		
		System.out.println("Trigger Name = "+triggerName +" "+"Event Name = "+triggerEventName +" "+"Lifecycle Name = "+triggerLifecycleName);
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(triggerName, campaignName);
		
		// Now open new tab, login and add a product to cart
		
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
		
		set.getWoocommerceOneURL();
		
		CartRecovery_Homepage carthome_obj = new CartRecovery_Homepage(driver);
		
		driver.findElement(carthome_obj.WoocommerceAccount_MyAccount).click();  // My Account
		
		Thread.sleep(2000);
		driver.findElement(carthome_obj.WoocommerceAccount_Username).sendKeys(prop.getProperty("GmailWoocommerceOneUsername"));
		driver.findElement(carthome_obj.WoocommerceAccount_Password).sendKeys(prop.getProperty("GmailWoocommerceOnePassword"));
		
		driver.findElement(carthome_obj.WoocommerceAccount_Login).click();
		Thread.sleep(3000);
		
		driver.findElement(carthome_obj.WoocommerceAccount_Home).click();  // Home
		
		driver.findElement(carthome_obj.WoocommerceAccount_AddToCart).click();  // Add to cart
		
		Thread.sleep(30000);           //Wait 30 sec 
		
		// Open Gmail to verify email
	
		set.getGmailURL();

		Thread.sleep(5000); 		
		
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
		
		// Go to EventTrigger and Check Stats
		
		driver.get(prop.getProperty("EventTrigger_CampaignsURL"));
	
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
		
		
			
	}
	

	@AfterMethod
	public void kill() throws Exception
	{
		// Inactivate event trigger
		SoftAssert s_assert = new SoftAssert();
		Setup_class set = new Setup_class(driver);
		EM_EventTriggeredCreateCampaign eventobj = new EM_EventTriggeredCreateCampaign(driver);
		Properties prop = set.loadPropertyFile();
		driver.get(prop.getProperty("EventTrigger_CampaignsURL"));

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(eventobj.EventTrigger_InactiveCampaign)).build().perform();	
		Thread.sleep(2000);
	
		eventobj.EventTrigger_InactiveCampaignClick();
		Thread.sleep(3000);
		
		s_assert.assertAll();	
		
		System.out.println("Closing the browser now");

		driver.quit();
		
	}
	
	
	
	
	
	
}
