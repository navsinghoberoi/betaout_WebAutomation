package CartRecoveryScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_CampaignConditions;
import CartRecoveryPages.CartRecovery_CampaignName;
import CartRecoveryPages.CartRecovery_CartRecoveryCampaign;
import CartRecoveryPages.CartRecovery_Design;
import CartRecoveryPages.CartRecovery_Homepage;
import CartRecoveryPages.CartRecovery_SelectTemplate;
import GmailLogin.GmailLoginPages;
import SMSMarketingPages.SMSMarketing_Broadcast_Active;
import SMSMarketingPages.SMSMarketing_CampaignType;
import SMSMarketingPages.SMSMarketing_Design;
import SMSMarketingPages.SMSMarketing_Homepage;
import SMSMarketingPages.SMSMarketing_Target;
import common_Classes.*;
import common_Classes.Account_Settings;
import common_Classes.Loginpage;
import promocode_Pages.Onsite_CreateCampaign;
import common_Classes.Onsite_Design;
import common_Classes.Homepage;
import promocode_Pages.Onsite_Select_Template;
import common_Classes.Onsite_Target_Page;
/**
 * @author - Navpreet
 */

public class CartRecovery_Campaign_1sequence_Fallback{


	public static WebDriver driver;

	@Test
	public void CartRecovery_1sequence() throws Exception
	
	{
		
		System.out.println("Scenario : Cart Recovery > Campaign > Create Campaign with Dynamic Property and Fallback Property in Subject > Check Mail");
			
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		set.getQAURL();
		
		Properties prop = set.loadPropertyFile();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getNavpreetQAUsername());
		obj.upswd(set.getNavpreetQAPassword());
		obj.ulogin();
		
		// Add code to select account
		set.selectAccountNav();
		System.out.println("User has logged in successfully");
		
		Homepage home_obj = new Homepage(driver);
		home_obj.cartrecovery_click();
		Thread.sleep(3000);
	
		CartRecovery_Homepage carthome_obj = new CartRecovery_Homepage(driver);
		carthome_obj.CampaignsClick();
		Thread.sleep(3000);
		carthome_obj.Campaigns_CreateCampaignClick();
		
		CartRecovery_CampaignName name_obj = new CartRecovery_CampaignName(driver);

		String name = System.currentTimeMillis() + prop.getProperty("CartRecovery_Name"); 
		name_obj.CampaignNameClick(name);
		
		name_obj.PrintCampaignNameHeading();
		name_obj.SaveNextClick();
		Thread.sleep(5000);
		
		CartRecovery_CampaignConditions conditions_obj = new CartRecovery_CampaignConditions(driver);
		conditions_obj.AddNewConditionClick();
		
		conditions_obj.ANDDropdown1Click();
		conditions_obj.ANDDropdown2Click();
		conditions_obj.ANDDropdown3Click(prop.getProperty("CartRecovery_CartValue"));
		conditions_obj.SaveNextClick();
		Thread.sleep(5000);
		
		CartRecovery_CartRecoveryCampaign recovery_obj = new CartRecovery_CartRecoveryCampaign(driver);
		recovery_obj.AddEmailIconClick();
		Thread.sleep(12000);
		
		CartRecovery_SelectTemplate temp_obj = new CartRecovery_SelectTemplate(driver);
		temp_obj.UseTemplate_GarmentsTemplateClick();
		Thread.sleep(15000);
		
		CartRecovery_Design design_obj = new CartRecovery_Design(driver);
		
/*
		// Code to add dynamic property
		
		driver.switchTo().frame(driver.findElement(By.xpath("(//*[contains(@src,'/email-permalink/nv/peId')])")));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[contains(text(),'SALE')])")).click();
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1200)");
		Thread.sleep(1500);
		js.executeScript("tinyMCE.editors[0].setContent('{{email}}')");           // Add 'email' dynamic property in tinyMCE
*/		
		
		String dynamicProperty = prop.getProperty("emailPP");
		Thread.sleep(1000);
		
		String Subject = (prop.getProperty("CartRecovery_Subject1") + dynamicProperty + prop.getProperty("FallbackProperty") + "{{jeans}},{{fullname}}" + System.currentTimeMillis()).trim();	// Add PP >> email,jeans,fullname
		System.out.println("Subject entered in the cart recovery template = "+Subject);
		design_obj.SubjectClick(Subject);
		design_obj.ChooseSenderClick(prop.getProperty("SES_SenderID"));
		design_obj.SaveExitClick();
		Thread.sleep(15000);
		
		recovery_obj.PriorityForCampaignCheckboxClick();
		recovery_obj.MakeActiveClick();

	//	recovery_obj.ViewEmailSequenceClick();
		
		 Thread.sleep(5000);

		List<org.openqa.selenium.WebElement> total_sequences = driver.findElements(carthome_obj.Campaigns_total_sequences);
		System.out.println("Total elements :"+total_sequences.size());

	    String  subject = driver.findElement(carthome_obj.Campaigns_total_subjects).getText();
		System.out.println("Subject of 1st email = "+subject);
		
		recovery_obj.ExitClick();
		Thread.sleep(5000);
	
		List<org.openqa.selenium.WebElement> total_campaigns = driver.findElements(carthome_obj.Campaigns_totalcampaigns);
	    System.out.println("Total cart recovery campaigns :"+total_campaigns.size());
		
	    String campaign_name = driver.findElement(carthome_obj.Campaigns_campaign_name).getText();
		System.out.println("Name of the created campaign = "+campaign_name);
	    
		String campaign_createdinfo = driver.findElement(carthome_obj.Campaigns_campaign_createdinfo).getText();
		System.out.println("Created info of the campaign = "+campaign_createdinfo);
	    
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertTrue(campaign_name.equalsIgnoreCase(name));
	//	s_assert.assertEquals(campaign_name, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");
		
		Thread.sleep(2000);

		// Woocommerceone -  Add products in cart of value greater than 100000
		
		set.getWoocommerceOneURL();
		
		driver.findElement(carthome_obj.WoocommerceAccount_MyAccount).click();  // My Account
		
		Thread.sleep(2000);
		driver.findElement(carthome_obj.WoocommerceAccount_Username).sendKeys(prop.getProperty("GmailWoocommerceOneUsername"));
		driver.findElement(carthome_obj.WoocommerceAccount_Password).sendKeys(prop.getProperty("GmailWoocommerceOnePassword"));
		
		driver.findElement(carthome_obj.WoocommerceAccount_Login).click();
		Thread.sleep(3000);
		
		driver.findElement(carthome_obj.WoocommerceAccount_Home).click();  // Home
		
		driver.findElement(carthome_obj.WoocommerceAccount_AddToCart).click();  // Add to cart
		Thread.sleep(3000);
		
		driver.findElement(carthome_obj.WoocommerceAccount_ViewCart).click();
			
		// Open Gmail to verify email
		
		Thread.sleep(5000);
			
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
			
		set.getGmailURL();

		Thread.sleep(660000);    // Wait for 11 min		
		
	//	Thread.sleep(5000);
	
		driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
		
		GmailLoginPages page_obj = new GmailLoginPages(driver);
		
		page_obj.enterUsername(prop.getProperty("GmailQAValidUsername"));   
		page_obj.nextButtonClick();
		
		Thread.sleep(2000);
		
		page_obj.enterPassword(prop.getProperty("GmailQAValidPassword"));
		page_obj.signInClick();
			
		Thread.sleep(7000);
		
		page_obj.openEmail();
	
		String emailsubject = (page_obj.printemailSubject()).trim();
		System.out.println("Subject of email = "+emailsubject);
		
		boolean dynamicPP =  emailsubject.contains(prop.getProperty("GmailQAValidUsername"));   // check dynamic pp [email] is fetched in subject
		System.out.println("Boolean result of presence of dynamic property in subject = "+dynamicPP);
		s_assert.assertEquals(dynamicPP, true);
		System.out.println("Assertion of boolean result of presence of dynamic property in subject is done");
		
		boolean fallbackPP = emailsubject.contains("Automation Property Fallback");
		System.out.println("Boolean result of presence of fallback property in subject = " +fallbackPP);
		s_assert.assertEquals(fallbackPP, true);
		System.out.println("Assertion of boolean result of presence of fallback property in subject is done");
		
		String emailmessage = (page_obj.printemailMessage()).toLowerCase();
		System.out.println("Message content of email = "+emailmessage.toLowerCase());

		/*boolean messageValue =  emailmessage.contains(prop.getProperty("GmailQAValidUsername")); // check email is fetched in message
		System.out.println("Boolean result of presence of dynamic property in email message = "+messageValue);
		s_assert.assertEquals(messageValue, true);
		System.out.println("Assertion of boolean result of presence of dynamic property in email message is done");*/
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));		
		System.out.println("Screenshot of email is taken successfully");
		
	//	s_assert.assertEquals(emailsubject,Subject);
		s_assert.assertAll();
		System.out.println("Subject of the email is verified ");
		
		Thread.sleep(3000);
		page_obj.DeleteAllMails();
		Thread.sleep(3000);
		System.out.println("Email is deleted successfully");
	
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();
		
		System.out.println("Dynamic Property and Fallback Property are displayed in the subject of the recovery email");
		System.out.println("-----------------------------------------------------------------------------------------");
	}
	
	@AfterMethod
	public void kill()
	{
		
		// Pause the cart recovery campaign (switch to 0 tab and open URL)
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		Setup_class set = new Setup_class(driver);
		CartRecovery_Homepage carthome_obj = new CartRecovery_Homepage(driver);
		
		
		driver.switchTo().window(tabs.get(0)); //switches to tab
				
		set.getQACartCampaignPage();
		
		carthome_obj.Campaigns_InactiveInstanceClick();
		
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}
