package EmailMarketingScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import EmailMarketingPages.EM_Campains_Broadcast;
import EmailMarketingPages.EmailMarketing_OnetoOne;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class EmailMarketing_OneToOneCampaign {

public static WebDriver driver;
	
	
	@Test
	public void OneToOneCampaign() throws Exception{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		
		// Code to load the Property file
	
		Properties prop = set.loadPropertyFile();
		
		set.getQAURL();
		String currentDate = set.getCurrentDateTime();
		
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
		obj1.OneToOneClick();
		Thread.sleep(6000);
		
		EmailMarketing_OnetoOne obj11 = new EmailMarketing_OnetoOne(driver);
		String FromEmail = prop.getProperty("SES_SenderID");
		obj11.FromClick(FromEmail);
		obj11.TemplateClick();

		String Subject = prop.getProperty("Email_OneToOne_Subject") +currentDate;
		obj11.SubjectClick(Subject);
		
		String ToEmail =  prop.getProperty("GmailQAValidUsername");
		System.out.println("One to one email will be sent to = " +ToEmail);
		obj11.ToClick(ToEmail);
		
		String message = prop.getProperty("Email_OneToOne_Message") + currentDate;
		obj11.MessageClick(message);
 		
		obj11.SendClick();
		Thread.sleep(10000);
		
		List<org.openqa.selenium.WebElement> sent_campaigns = driver.findElements(obj1.sent_campaigns);
		System.out.println("Total number of sent campaigns are = "+sent_campaigns.size());

		SoftAssert s_assert = new SoftAssert();
		
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
	
		Thread.sleep(30000);           //Wait 30 sec 
		
		// Open gmail account
				
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

		s_assert.assertAll();

												}
		
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}
