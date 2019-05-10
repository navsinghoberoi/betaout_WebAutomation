package EmailMarketingScenarios;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class EmailMarketing_TestMail {

public static WebDriver driver;
	
	
	@Test
	public void EM_TestMail() throws Exception{
		
		System.out.println("Scenario - Add a CTA button > Test Mail with Short URL on 2 CTA buttons");
		
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
		
	//	String name = prop.getProperty("Email_Broadcast_Name") + System.currentTimeMillis();
		
		String name = prop.getProperty("Email_Broadcast_Name") + currentDate;
		obj1.Broadcast_campaign_title(name);
		Thread.sleep(3000);
	
//		obj1.mail_Betaout_server();       // needed when Mailchimp is Enabled from Settings
		
		Thread.sleep(2000);
		obj1.Template();
		Thread.sleep(15000);
	
		EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);
		
	//	String subject_data = prop.getProperty("Email_Test_Subject") + System.currentTimeMillis();
		
		String subject_data = prop.getProperty("Email_Test_Subject") + currentDate;
		obj2.Campaign_Subject(subject_data);
		
		Thread.sleep(2000);
		obj2.Sender_Id(prop.getProperty("Email_SenderID"));
		Thread.sleep(2000);
		
		// Add code for adding CTA button
		
		driver.findElement(obj2.RightArrowOnDesign).click();
		Thread.sleep(1000);
		driver.findElement(obj2.RightArrowOnDesign).click();
		Thread.sleep(1000);

		driver.findElement(obj2.SelectButton).click();
		
		WebElement source = driver.findElement(obj2.Source_CTA);
		WebElement target = driver.findElement(obj2.Target_CTA);
		
		(new Actions(driver)).dragAndDrop(source, target).perform();
		Thread.sleep(2000);
		
		// Add code for Test Mail and Short URL
		
		obj2.Side_Menu_Option();
		Thread.sleep(2000);
		obj2.Side_Menu_Send_Test_Email();
		Thread.sleep(2000);
		
		obj2.Linkurl_TickCheckbox();
		obj2.Linkurl_NewURL(prop.getProperty("Email_ShortURL"));
		Thread.sleep(2000);
		obj2.Linkurl_PopUp_OK();
		Thread.sleep(6000);
	
		obj2.TestMail_EnterEmail(prop.getProperty("GmailQAValidUsername"));
		obj2.TestMail_SendButton();
		
		Thread.sleep(12000);
		
		// Open new tab and verify subject of the email
	
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		
		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
		
		Thread.sleep(60000);           //Wait 1 min 
		
		// Open Gmail
		
		SoftAssert s_assert = new SoftAssert();
		
		set.getGmailURL();
		
		Thread.sleep(10000);           // Wait for 10 sec 
		
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
		System.out.println("Subject of email = "+emailsubject);
	
		String emailmessage = page_obj.printemailMessage();
		System.out.println("Message content of email = "+emailmessage);
		System.out.println("---------------------------------------");
		
		s_assert.assertEquals(emailsubject,subject_data);
		System.out.println("Subject of the email is verified ");
		
		Thread.sleep(2000);
		
		// Click on CTA and compare Short URL
		
		int totalButtons = obj2.PrintAllCTAButton();
		s_assert.assertEquals(totalButtons, 2, "Assertion of total buttons");
		
		obj2.CTAButtonClick();
		Thread.sleep(7000);
	
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	
		System.out.println("Number of tabs1 = "+tabs1.size());
		Thread.sleep(3000);
		
		driver.switchTo().window(tabs1.get(2));
	 	
		String ShortURL = driver.getCurrentUrl();
		System.out.println("URL opened on click of CTA Button = "+ShortURL);
		
		s_assert.assertEquals(prop.getProperty("Email_ShortURL"), ShortURL);
		Thread.sleep(2000);
		
		// Go back to gmail and click on CTA button 2
		
		driver.switchTo().window(tabs1.get(1));  // Gmail
		
		obj2.CTAButtonNewClick();
		Thread.sleep(7000);
	
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	
		System.out.println("Number of tabs2 = "+tabs2.size());
		Thread.sleep(3000);
		
		driver.switchTo().window(tabs2.get(3));
	 	
		String NewShortURL = driver.getCurrentUrl();
		System.out.println("URL opened on click of 2nd CTA Button= "+NewShortURL);
		
		s_assert.assertEquals(prop.getProperty("Email_ShortURL"), NewShortURL);
		Thread.sleep(2000);
		
		// Go back to tab1 and delete email
		
		driver.switchTo().window(tabs.get(1));  // go to gmail and delete mail 
		
		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		
		System.out.println("Email is deleted successfully");
	
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();
		
		s_assert.assertAll();

	
	}

	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");	
		driver.quit();
		
		
	}
	
	
}