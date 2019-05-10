package GmailLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class GmailLogin {

	public static WebDriver driver;

	@Test
	public void LoginIntoGmail() throws Exception
	
	{
		
		System.out.println("Scenario : Cart Recovery > Campaign > Create Campaign > Delete Campaign > Clone Campaign");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();


		driver.get("https://www.google.com/gmail/about/");
		
		driver.findElement(By.xpath("//*[text() = 'Sign In']")).click();
	
		GmailLoginPages page_obj = new GmailLoginPages(driver);
		
		page_obj.enterUsername("qa@seomorpheus.com");
		page_obj.nextButtonClick();
		
		Thread.sleep(2000);
		
		page_obj.enterPassword("qa@betaout123");
		page_obj.signInClick();
			
		Thread.sleep(7000);
		
		page_obj.openEmail();
		page_obj.printemailSubject();
		page_obj.printemailMessage();
		
		Thread.sleep(2000);
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		System.out.println("Email is deleted successfully");
		
		//driver.get("https://mail.google.com/mail/#inbox");
		
		
	//	page_obj.clickBackArrow();
		/*Thread.sleep(2000);
		
		page_obj.SelectAllMails();
		
		System.out.println("Select all");
		
		Thread.sleep(2000);
		System.out.println("done");
		
		page_obj.DeleteAllMails();
		Thread.sleep(2000);
		*/
		
		page_obj.accountClick();
		page_obj.signout();
		
	}
	
}