package EmailMarketingScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_Homepage;
import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import EmailMarketingPages.EM_Send_Schedule;
import EmailMarketingPages.EM_Tageting_Page;
import EmailMarketingPages.EmailMarketing_Supression;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class EmailMarketing_VerifyEmailsToValidAndInvalid {


	public static WebDriver driver;
	
	
	
	@Test
	public void Email_SupressionAndBroadcast() throws Exception{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
				
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
		
		// Add Unsubscribed Contact
		
		EM_Broadcast_Template obj1 = new EM_Broadcast_Template(driver);
		obj1.SupressionListClick();
		
		EmailMarketing_Supression obj2 = new EmailMarketing_Supression(driver);
		obj2.Unsubscribers_AddNewClick();
		Thread.sleep(2000);
		
		String actualUnsubscribedEmail = prop.getProperty("GmailQAUnsubscribedUsername");
		obj2.Unsubscribe_EnterEmailsClick(actualUnsubscribedEmail);
		
		obj2.Unsubscribe_AddToUnsubscribeListClick();
		Thread.sleep(2000);
		
		String expectedUnsubscribedEmail = 	obj2.PrintUnsubscribedEmailAddress();
		
		obj2.PrintUnsubscribedEmailTime();
		
		SoftAssert sa_unsubscribe = new SoftAssert();
		sa_unsubscribe.assertEquals(actualUnsubscribedEmail, expectedUnsubscribedEmail);
		
	
		System.out.println("Assertion of Unsubscribed email address is done successfully");
	
		// Add Spam Contact
	
		obj2.Spam_ComplaintsClick();
		Thread.sleep(2000);
		
		obj2.Spam_AddNewClick();
		Thread.sleep(2000);
	
		String actualSpamEmail = prop.getProperty("GmailQASpamUsername");
		obj2.Spam_EnterEmailsClick(actualSpamEmail);
		
		obj2.Spam_AddToUnsubscribeListClick();
		Thread.sleep(2000);

		String expectedSpamEmail = 	obj2.PrintBouncedEmailAddress();
		
		obj2.PrintBouncedEmailTime();
		
		SoftAssert sa_spam = new SoftAssert();
		sa_spam.assertEquals(actualSpamEmail, expectedSpamEmail);
	
		System.out.println("Assertion of Spam email address is done successfully");
		
		// Add Bounced Contact
	
		obj2.BouncedClick();
		Thread.sleep(2000);
		
		obj2.Bounced_AddNewClick();
		Thread.sleep(2000);
		
		String actualBouncedEmail = prop.getProperty("GmailQABouncedUsername");		
		obj2.Bounced_EnterEmailsClick(actualBouncedEmail);
		
		obj2.Bounced_AddToUnsubscribeListClick();
		Thread.sleep(2000);
		
		String expectedBouncedEmail = 	obj2.PrintBouncedEmailAddress();
		
		obj2.PrintBouncedEmailTime();
		
		SoftAssert sa_bounced = new SoftAssert();
		sa_bounced.assertEquals(actualBouncedEmail, expectedBouncedEmail);

	
		System.out.println("Assertion of Bounced email address is done successfully");
	
		// Send Broadcast
		
		EM_Campains_Broadcast obj10 = new EM_Campains_Broadcast(driver);
		obj10.campaign_Tab();
		Thread.sleep(2000);
		obj10.Broadcast_Createcapmain();
		Thread.sleep(2000);
	
		
		String name = prop.getProperty("Email_Broadcast_Name") +System.currentTimeMillis();
				
		obj10.Broadcast_campaign_title(name);
		Thread.sleep(3000);
	
	//	obj10.mail_Betaout_server();
		Thread.sleep(2000);
		obj10.Template();
		Thread.sleep(15000);
	
		EM_Broadcast_Template obj20 = new EM_Broadcast_Template(driver);
	
		String subject_data =  prop.getProperty("Email_Broadcast_Subject") + System.currentTimeMillis();
		obj20.Campaign_Subject(subject_data);
	
	//	obj20.Sender_Id(prop.getProperty("Email_SenderID"));
		
		obj20.Sender_Id(prop.getProperty("SES_SenderID"));         // Select SES account
		
		obj20.Save_and_NextStep();
		Thread.sleep(2000);
		obj20.Linkurl_PopUp_OK();
		Thread.sleep(10000);
	
		EM_Tageting_Page obj30 = new EM_Tageting_Page(driver);
		String email1 = prop.getProperty("GmailQAValidUsername");
		String email2 = prop.getProperty("GmailQAValidUsernameOne");
		
		
		obj30.AddMoreEmailAddressClick(email1);
		driver.findElement(obj10.addEmailAddress).sendKeys(Keys.ENTER);		
		obj30.AddMoreEmailAddressClick(email2);
		driver.findElement(obj10.addEmailAddress).sendKeys(Keys.ENTER);	
		obj30.AddMoreEmailAddressClick(actualUnsubscribedEmail);
		driver.findElement(obj10.addEmailAddress).sendKeys(Keys.ENTER);	
		obj30.AddMoreEmailAddressClick(actualSpamEmail);
		driver.findElement(obj10.addEmailAddress).sendKeys(Keys.ENTER);	
		obj30.AddMoreEmailAddressClick(actualBouncedEmail);
		Thread.sleep(2000);
		
		// Add Supression List Emails
		
		obj30.SaveandNextClick();
		Thread.sleep(10000);
		
		EM_Send_Schedule obj40 = new EM_Send_Schedule(driver);
		obj40.SEND_NOWClick();
		Thread.sleep(2000);
		
		obj40.SEND_NOW_CONFIRMClick();
		Thread.sleep(10000);
		
		List<org.openqa.selenium.WebElement> broadcast_campaigns = driver.findElements(obj10.broadcast_campaigns);
		System.out.println("Total number of campaigns are = "+broadcast_campaigns.size());
		
		String campaignname = ((org.openqa.selenium.WebElement) broadcast_campaigns.get(0)).getText();
		System.out.println("Name of the created campaign = "+campaignname);
		
		
		SoftAssert sa_Broadcast = new SoftAssert();
		sa_Broadcast.assertEquals(campaignname,name);
		
		
		Thread.sleep(8000);
		
		// Open Gmail in new tab and verify subject of the 1st email
		
		
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		Thread.sleep(2000);
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs1.get(1)); //switches to first tab	
		
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
		
		List<org.openqa.selenium.WebElement> totalemails1 = driver.findElements(page_obj.openEmail);
		System.out.println("Total number of emails = "+totalemails1.size());
		
		page_obj.openEmail();
	
		String emailsubject1 = page_obj.printemailSubject();
		System.out.println("Subject of email = "+emailsubject1);
	
		String emailmessage1 = page_obj.printemailMessage();
		System.out.println("Message content of email = "+emailmessage1);
		System.out.println("---------------------------------------");

		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(emailsubject1,subject_data);
		System.out.println("Subject of the email is verified ");
		
		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		System.out.println("Email is deleted successfully");
	
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();

		System.out.println("Name of the subject is verified ");
		Thread.sleep(8000);

		
		// Open new tab 2 and verify subject of the 2nd email
			
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		Thread.sleep(2000);
				
				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				 
				driver.switchTo().window(tabs2.get(2)); //switches to second tab

				set.getGmailURL();
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
			
				page_obj.SignInDifferentAccount();
				Thread.sleep(1500);
				page_obj.AddNewAccount();
				Thread.sleep(1500);
				
				page_obj.enterUsername(prop.getProperty("GmailQANavUsername"));   
				page_obj.nextButtonClick();
				
				Thread.sleep(2000);
				
				page_obj.enterPassword(prop.getProperty("GmailQANavPassword"));
				page_obj.signInClick();
					
				Thread.sleep(7000);
				
				List<org.openqa.selenium.WebElement> totalemails2 = driver.findElements(page_obj.openEmail);
				System.out.println("Total number of emails = "+totalemails2.size());
				
				page_obj.openEmail();
			
				String emailsubject2 = page_obj.printemailSubject();
				System.out.println("Subject of email = "+emailsubject2);
			
				String emailmessage2 = page_obj.printemailMessage();
				System.out.println("Message content of email = "+emailmessage2);
				System.out.println("---------------------------------------");

				
				s_assert.assertEquals(emailsubject2,subject_data);
				System.out.println("Subject of the email is verified ");	
				Thread.sleep(2000);
			
				page_obj.DeleteAllMails();
				Thread.sleep(2000);
				System.out.println("Email is deleted successfully");
			
				page_obj.accountClick();
				Thread.sleep(1500);
				page_obj.signout();

				System.out.println("Name of the subject is verified ");
				Thread.sleep(8000);

				
				// Open new tab 3 and verify subject of the Unsubscribed email
			
				
				((JavascriptExecutor) driver).executeScript("window.open('','_blank');");	
				Thread.sleep(2000);
				
				ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
				 
				driver.switchTo().window(tabs3.get(3)); //switches to second tab
			
				set.getGmailURL();
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
				
		//		page_obj.SignInDifferentAccount();
				Thread.sleep(1500);
				page_obj.AddNewAccount();
				Thread.sleep(1500);
				
				
				page_obj.enterUsername(prop.getProperty("GmailQAUnsubscribedUsername"));   
				page_obj.nextButtonClick();
				
				Thread.sleep(2000);
				
				page_obj.enterPassword(prop.getProperty("GmailQAUnsubscribedPassword"));
				page_obj.signInClick();
					
				Thread.sleep(7000);
				
				List<org.openqa.selenium.WebElement> totalemails3 = driver.findElements(page_obj.openEmail);
				System.out.println("Total number of emails = "+totalemails3.size());
							
				Thread.sleep(2000);
			
				page_obj.accountClick();
				Thread.sleep(1500);
				page_obj.signout();

				if(totalemails3.size() == 0)
					
				{
					System.out.println("No email is present as user is Unsubscribed");
					
				}
				
				else
				{

					System.out.println("Emails are present for Unsubscribed user");
					
				}
	
				Thread.sleep(7000);
				
				// Open new tab 4 and verify subject of the Spam email
				
				
				
				((JavascriptExecutor) driver).executeScript("window.open('','_blank');");	
				Thread.sleep(2000);
				
				ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
				 
				driver.switchTo().window(tabs4.get(4)); //switches to second tab
				
				set.getGmailURL();
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
				
		//		page_obj.SignInDifferentAccount();
				Thread.sleep(1500);
				page_obj.AddNewAccount();
				Thread.sleep(1500);
				
				page_obj.enterUsername(prop.getProperty("GmailQABouncedUsername"));   
				page_obj.nextButtonClick();
				
				Thread.sleep(2000);
				
				page_obj.enterPassword(prop.getProperty("GmailQABouncedPassword"));
				page_obj.signInClick();
					
				Thread.sleep(7000);
				
				List<org.openqa.selenium.WebElement> totalemails4 = driver.findElements(page_obj.openEmail);
				System.out.println("Total number of emails = "+totalemails4.size());
				
				Thread.sleep(1500);
				page_obj.accountClick();
				Thread.sleep(1500);
				page_obj.signout();

				if(totalemails4.size() == 0)
					
				{
					System.out.println("No email is present as user is Bounced");
					
				}
				
				else
				{

					System.out.println("Emails are present for Bounced user");
					
				}
	
				Thread.sleep(7000);
				
				// Open new tab 5 and verify subject of the Bounced email
				
				
				((JavascriptExecutor) driver).executeScript("window.open('','_blank');");	
				Thread.sleep(2000);
				
				ArrayList<String> tabs5 = new ArrayList<String> (driver.getWindowHandles());
				 
				driver.switchTo().window(tabs5.get(5)); //switches to second tab
				
				set.getGmailURL();
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
				
		//		page_obj.SignInDifferentAccount();
				Thread.sleep(1500);
				page_obj.AddNewAccount();
				Thread.sleep(1500);
				
				page_obj.enterUsername(prop.getProperty("GmailQASpamUsername"));   
				page_obj.nextButtonClick();
				
				Thread.sleep(2000);
				
				page_obj.enterPassword(prop.getProperty("GmailQASpamPassword"));
				page_obj.signInClick();
					
				Thread.sleep(7000);
				
				List<org.openqa.selenium.WebElement> totalemails5 = driver.findElements(page_obj.openEmail);
				System.out.println("Total number of emails = "+totalemails5.size());
				
				Thread.sleep(2000);
				page_obj.accountClick();
				Thread.sleep(1500);
				page_obj.signout();


				if(totalemails5.size() == 0)
					
				{
					System.out.println("No email is present as user is Spam");
					
				}
				
				else
				{

					System.out.println("Emails are present for Spam user");
					
				}
	
				Thread.sleep(2000);
				
				
				/*sa_unsubscribe.assertAll();
				Thread.sleep(2000);
				sa_spam.assertAll();
				Thread.sleep(2000);
				sa_bounced.assertAll();
				Thread.sleep(2000);
				sa_Broadcast.assertAll();
				Thread.sleep(2000);
				s_assert.assertAll();*/
				
				
				
				
		}

	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
	
}