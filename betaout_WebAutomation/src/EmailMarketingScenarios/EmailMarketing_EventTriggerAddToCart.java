package EmailMarketingScenarios;

import java.io.File;
import java.util.ArrayList;
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

import CartRecoveryPages.CartRecovery_Homepage;
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
public class EmailMarketing_EventTriggerAddToCart {
	
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
		
	//	String name = prop.getProperty("EventTriggerAddToCart_Name") + System.currentTimeMillis();
		String name = prop.getProperty("EventTriggerAddToCart_Name") + currentDate;
		
		eventobj.EventTrigger_CampaignName(name);
		
		eventobj.EventTrigger_SaveCampaign();
		Thread.sleep(5000);
		
		eventobj.SelectEventFromDropdown("added_to_cart");       // Add to cart event
		
		eventobj.Add_email_button();
		Thread.sleep(5000);
		
		eventobj.Template();
		Thread.sleep(8000);
		
	//	String subject_data = prop.getProperty("Email_EventTriggerAddToCart_Subject") + System.currentTimeMillis();
		
		String subject_data = prop.getProperty("Email_EventTriggerAddToCart_Subject") + currentDate;
		eventobj.Campaign_Subject(subject_data);
		
	//	eventobj.Sender_Id(prop.getProperty("EventTrigger_SenderID"));
		EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);
		obj2.Sender_Id(prop.getProperty("SES_SenderID"));  
		
		eventobj.Save_and_Exit();
		Thread.sleep(2000);
		
		eventobj.Linkurl_TickCheckbox();
		Thread.sleep(1000);
		eventobj.Linkurl_NewURL(prop.getProperty("EventTriggerAddToCartNewURL"));
		Thread.sleep(2000);
		eventobj.Linkurl_PopUp_OK();
		Thread.sleep(3000);
		
		eventobj.EventTrigger_MakeActive();
		Thread.sleep(2000);
		eventobj.EventTrigger_Save();
		
		
		// Print details of event
		
		String triggerName = eventobj.PrintEventTriggerName();
		String triggerEventName = eventobj.PrintEventTrigger_TriggerEvent();
		String triggerLifecycleName = eventobj.PrintEventTrigger_LifecycleStage();
		
		System.out.println("Trigger Name = "+triggerName +" "+"Event Name = "+triggerEventName +" "+"Lifecycle Name = "+triggerLifecycleName);
		
		
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
		
		Thread.sleep(60000);           //Wait 1 min 
		
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
	
		SoftAssert s_assert = new SoftAssert();
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

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));		
		System.out.println("Screenshot of email is taken successfully");
		
		s_assert.assertEquals(emailsubject,subject_data);
		
		System.out.println("Subject of the email is verified ");
		
		// Click on CTA and compare Short URL
	//	EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);
		
		obj2.CTAButtonClick();
		Thread.sleep(7000);
		
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		
		System.out.println("Number of tabs1 = "+tabs1.size());
		Thread.sleep(3000);
		
		driver.switchTo().window(tabs1.get(2)); // go to new tab

		String ShortURL = driver.getCurrentUrl();
		System.out.println("URL opened on click of CTA Button = "+ShortURL);
		
		s_assert.assertEquals(prop.getProperty("EventTriggerAddToCartNewURL"), ShortURL);
		Thread.sleep(2000);
		
		// Go back to tab1 and delete email
		
		driver.switchTo().window(tabs.get(1));  // go to gmail and delete mail 
		
		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		
		System.out.println("Email is deleted successfully");
	
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();
		
		Thread.sleep(60000);           //Wait 1 min 
		
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
