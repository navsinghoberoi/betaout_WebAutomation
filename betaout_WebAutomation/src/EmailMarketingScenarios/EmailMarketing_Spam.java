package EmailMarketingScenarios;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EmailMarketing_Supression;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class EmailMarketing_Spam {

	public static WebDriver driver;
	
	
	
	@Test
	public void Email_Spam() throws Exception{
		
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
		
		EM_Broadcast_Template obj1 = new EM_Broadcast_Template(driver);
		obj1.SupressionListClick();
	
		
		EmailMarketing_Supression obj2 = new EmailMarketing_Supression(driver);
		obj2.Spam_ComplaintsClick();
		Thread.sleep(2000);
		
		obj2.Spam_AddNewClick();
		Thread.sleep(2000);
		
	//	String actualEmail = "navspam2@yopmail.com";
		String actualEmail = prop.getProperty("Email_Spam_EmailID") + System.currentTimeMillis();
		obj2.Spam_EnterEmailsClick(actualEmail);
		
		obj2.Spam_AddToUnsubscribeListClick();
		Thread.sleep(2000);

	/*	obj2.UnsubscribersClick();
		Thread.sleep(2000);
		*/
		
		String expectedEmail = 	obj2.PrintBouncedEmailAddress();
		
		obj2.PrintBouncedEmailTime();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualEmail, expectedEmail);
		sa.assertAll();
	
		System.out.println("Assertion of email address is done successfully");
		
		obj2.Spam_ComplaintsClick();
		Thread.sleep(2000);
		
		obj2.Spam_ExportCSVClick();
		Thread.sleep(2000);
		
//		driver.quit();
		
	}	
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
	
	
	
}
