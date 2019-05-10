package SMSBOEditorScenarios;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_Homepage;
import SMSMarketingPages.SMSMarketing_EventTrigger;
import SMSMarketingPages.SMSMarketing_Homepage;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class SMSBO_EventAddtocart {

	
	public static WebDriver driver;

	@Test
	public void SMS_BroadcastCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Create SMS Broadcast campaign from BO > Print counts and stats > Export CSV");
		
		Setup_class set = new Setup_class(driver);
		Properties prop = set.loadPropertyFile();
		
		driver = set.setup();
		String currentDate = set.getCurrentDateTime();
		
		set.getQAURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getNavpreetQAUsername());
		obj.upswd(set.getNavpreetQAPassword());
		obj.ulogin();
		
		// Add code to select account
		set.selectAccountNav();
		System.out.println("User has logged in successfully");
		
		Homepage home_obj = new Homepage(driver);
		home_obj.sms_mktg_click();
		Thread.sleep(3000);
		
		SMSMarketing_Homepage page_obj = new SMSMarketing_Homepage(driver);
		page_obj.Campaigns_EventTrigger();
		Thread.sleep(5000);
		
		page_obj.Campaigns_EventCreateCampaign();
		Thread.sleep(5000);

		
		SMSMarketing_EventTrigger eventobj = new SMSMarketing_EventTrigger(driver);
		
		String CampaignName = prop.getProperty("SMSBOEventCampName") + " " +currentDate;
		eventobj.CampaignName(CampaignName);
		eventobj.SaveNext();
		
		Thread.sleep(5000);
	
		eventobj.ChooseGateway("Synic-sys -sinfini(TNDRCT)");
		eventobj.SMSTextBox(prop.getProperty("SMSBOEventText"));
		eventobj.SaveNNext();
		Thread.sleep(5000);
		
		eventobj.SelectEvent("added_to_cart");
		
		eventobj.SaveAndExit();
		Thread.sleep(5000);
		
		page_obj.Campaigns_EventActiveCamp();
		
		// Go to active camp URL
		
		driver.navigate().refresh();
		
		set.SMSEventActiveURL();
	
		String campName = page_obj.getCampaigns_CreatedCampName();
		System.out.println("Name of the created campaign = "+campName);	

		//	Assert camp name
			
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(campName, CampaignName);
		
		// Now open new tab, login and add a product to cart
		
		Thread.sleep(5000);
				
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		Thread.sleep(2000);
				
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				 
		driver.switchTo().window(tabs.get(1)); //switches to second tab
				
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
		
		Thread.sleep(3000);
		
		driver.switchTo().window(tabs.get(0)); //switches to first tab
		
		Thread.sleep(30000);    // wait for 30 sec
		
		//	Verify Stats of campaign		
		
		driver.navigate().refresh();
		
		String eventName = page_obj.getCampaigns_Campaigns_EventName();
		System.out.println("Name of the campaign = "+eventName);
		sa.assertEquals(eventName, "added_to_cart");
		
		String total = page_obj.Campaigns_Total();
		System.out.println("Count of total = "+total);
		
		int totalInt = Integer.parseInt(total);
		if(totalInt>0)
		{
			System.out.println("Count for Total is greater than 0, ie PASS");
		}
		else
		{
			System.out.println("Count for Total is equal to 0, ie FAIL");
		}
		
		
		String sent = page_obj.Campaigns_Sent();
		System.out.println("Count of sent = "+sent);
		
		int totalSent = Integer.parseInt(sent);
		if(totalSent>0)
		{
			System.out.println("Count for Sent is greater than 0, ie PASS");
		}
		else
		{
			System.out.println("Count for Sent is equal to 0, ie FAIL");
		}
	
		sa.assertNotEquals(sent, 0); // Sent should be greater than 0
		
		sa.assertAll();	
		
	}

}
