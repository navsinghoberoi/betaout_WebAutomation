package EmailMarketingScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import EmailMarketingPages.EM_Send_Schedule;
import EmailMarketingPages.EM_Tageting_Page;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class EmailMarketing_Fallback {

	public static WebDriver driver;

	@Test
	public void EmailMarketing_BroadcastCampaignFallbackProperty() throws Exception {

		System.out.println("Scenario - Make a broadcast campaign with Fallback Property > Verify property");

		Setup_class set = new Setup_class(driver);
		String currentDate = set.getCurrentDateTime();
		
		driver = set.setup();

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

	//	String name = prop.getProperty("Email_Broadcast_Name") + System.currentTimeMillis();

		String name = prop.getProperty("Email_Broadcast_Name") + currentDate;
		obj1.Broadcast_campaign_title(name);
		Thread.sleep(3000);

		// obj1.mail_Betaout_server(); // needed when Mailchimp is Enabled from
		// Settings

		Thread.sleep(2000);
		obj1.Template();
		Thread.sleep(15000);

		EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);

//		String subject_data = prop.getProperty("FallbackProperty") + System.currentTimeMillis();   //{{elite,Automation Property Fallback}}
		String subject_data = prop.getProperty("FallbackProperty") + currentDate;   //{{elite,Automation Property Fallback}}
		System.out.println("Data entered in subject = " +subject_data);
		
		obj2.Campaign_Subject(subject_data);
		Thread.sleep(2000);
		
	//	obj2.Sender_Id(prop.getProperty("Email_SenderID"));
		
		obj2.Sender_Id(prop.getProperty("SES_SenderID"));         // Select SES account
				
		
	// Add fallback in email body
		
		driver.findElement(obj2.Target_CTA).click();
		
		Actions act = new Actions(driver);
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(obj2.Target_CTA)).sendKeys(Keys.chord(Keys.CONTROL,"a")).build().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(obj2.Target_CTA)).sendKeys(prop.getProperty("FallbackProperty")).build().perform();	
		
		
		obj2.Save_and_NextStep();
		Thread.sleep(2000);
		obj2.Linkurl_PopUp_OK();
		Thread.sleep(10000);

		EM_Tageting_Page obj3 = new EM_Tageting_Page(driver);
		String email = prop.getProperty("GmailQAValidUsername");
		System.out.println("Email is to be sent to = " + email.trim().toLowerCase());
		
/*		obj3.AddMoreEmailAddressClick(email);
		obj3.SaveandNextClick();
		Thread.sleep(10000);
*/
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

		obj4.SEND_NOWClick();
		Thread.sleep(2000);
		obj4.SEND_NOW_CONFIRMClick();
		Thread.sleep(10000);
	
		// Assert name of campaign
		
		List<org.openqa.selenium.WebElement> broadcast_campaigns = driver.findElements(obj1.broadcast_campaigns);
		System.out.println("Total number of campaigns are = " + broadcast_campaigns.size());
		String campaignname = ((org.openqa.selenium.WebElement) broadcast_campaigns.get(0)).getText();
		System.out.println("Name of the created campaign = " + campaignname);

		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(campaignname, name);
		Thread.sleep(6000);
	
		// Open new tab and verify subject of the email

				((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

				Thread.sleep(2000);

				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

				driver.switchTo().window(tabs.get(1)); // switches to first tab

				Thread.sleep(60000);           //Wait 1 min 
				
				// Open Gmail

				set.getGmailURL();

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

				String emailmessage = page_obj.printemailMessage();
				System.out.println("Message content of email = " + emailmessage.toLowerCase());
				System.out.println("---------------------------------------");

			//	s_assert.assertEquals(emailsubject, subject_data);
				
				boolean fallbackInSubject = emailsubject.contains("Automation Property Fallback");
				System.out.println("Boolean Result for subject comparison =  "+fallbackInSubject);
				s_assert.assertEquals(fallbackInSubject, true);
				System.out.println("Subject of the email is verified ");

				
				boolean fallbackInBody = emailmessage.contains("Automation Property Fallback");
				System.out.println("Boolean Result for email body comparison =  "+fallbackInBody);
				s_assert.assertEquals(fallbackInBody, true);
				System.out.println("Email body of the email is verified ");
				
				
				Thread.sleep(2000);
				page_obj.DeleteAllMails();
				Thread.sleep(2000);
				System.out.println("Email is deleted successfully");

				page_obj.accountClick();
				Thread.sleep(1500);
				page_obj.signout();
	
				s_assert.assertAll();
			
				System.out.println("Fallback property is displayed in subject and body");
			
				
	}

	@AfterMethod
	public void kill() {
		System.out.println("Closing the browser now");
		driver.quit();

	}

}

