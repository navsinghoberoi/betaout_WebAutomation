package CartRecoveryScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By.ByXPath;
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
public class CartRecovery_Campaign_2sequences{
	
	// make changes on line number - 64, 83

	public static WebDriver driver;

	@Test
	public void CartRecovery_2sequences() throws Exception
	
	{
		System.out.println("Scenario : Cart Recovery > Campaign > 2 sequences");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		Properties prop = set.loadPropertyFile();
		
	//	driver.get("https://pre-prod-102.betaout.com/");
		set.getPreProdURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getShivangiUsername());
		obj.upswd(set.getShivangiPassword());
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
		String Subject = System.currentTimeMillis() + prop.getProperty("CartRecovery_Subject1");
		design_obj.SubjectClick(Subject);
		design_obj.ChooseSenderClick(prop.getProperty("SES_SenderID"));
/*		design_obj.TimeOfSending_ValueClick("5");
		design_obj.TimeOfSending_MinutesClick();*/
		design_obj.SaveExitClick();
		Thread.sleep(15000);
		
		recovery_obj.AddEmailSequenceClick();
		Thread.sleep(5000);
		temp_obj.UseTemplate_GarmentsTemplateClick();
		Thread.sleep(15000);
		
		String Subject1 = System.currentTimeMillis() + prop.getProperty("CartRecovery_Subject2");
		design_obj.SubjectClick(Subject1);
		design_obj.ChooseSenderClick(prop.getProperty("SES_SenderID"));
	//	design_obj.TimeOfSending_ValueClick("2");
		design_obj.TimeOfSending_ValueClick(prop.getProperty("CartRecovery_TimeInterval"));
		design_obj.TimeOfSending_MinutesClick();
		design_obj.SaveExitClick();
		Thread.sleep(15000);
		
		recovery_obj.PriorityForCampaignCheckboxClick();
		recovery_obj.MakeActiveClick();


		List<org.openqa.selenium.WebElement> total_sequences = driver.findElements(carthome_obj.Campaigns_total_sequences);
		System.out.println("Total elements :"+total_sequences.size());

	    List<org.openqa.selenium.WebElement> total_subjects = driver.findElements(carthome_obj.Campaigns_total_subjects);
	
	    String subject1 = ((org.openqa.selenium.WebElement) total_subjects.get(1)).getText();
		System.out.println("Subject of 1st email = "+subject1);
		
		String subject2 = ((org.openqa.selenium.WebElement) total_subjects.get(8)).getText();
		System.out.println("Subject of 2nd email = "+subject2);
		
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
		/*carthome_obj.Campaigns_InactiveInstanceClick();
		Thread.sleep(3000);
		carthome_obj.Campaigns_DeleteInstanceClick();
	
		carthome_obj.Campaigns_CloneClick();
*/
		String clone_campaign_name = driver.findElement(By.xpath("(//*[@class = 'camp-name'])[1]")).getText();
		System.out.println("Name of the created campaign = "+clone_campaign_name);
		Thread.sleep(3000);
		
		
		// Woocommerceone -  Add products in cart of value greater than 100000
		
		set.getWoocommerceOneURL();
		
		driver.findElement(carthome_obj.WoocommerceAccount_MyAccount).click();  // My Account
		
		Thread.sleep(2000);
		driver.findElement(carthome_obj.WoocommerceAccount_Username).sendKeys(prop.getProperty("WoocommerceAccount_Username"));
		driver.findElement(carthome_obj.WoocommerceAccount_Password).sendKeys(prop.getProperty("WoocommerceAccount_Password"));
		
		driver.findElement(carthome_obj.WoocommerceAccount_Login).click();
		Thread.sleep(3000);
		
		driver.findElement(carthome_obj.WoocommerceAccount_Home).click();  // Home
		
		driver.findElement(carthome_obj.WoocommerceAccount_AddToCart).click();  // Add to cart
		Thread.sleep(3000);
		
		driver.findElement(carthome_obj.WoocommerceAccount_ViewCart).click();			
		
		
		
		// Open yopmail to verify email
		
		Thread.sleep(5000);
			
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
			
	//	driver.get("http://www.yopmail.com/en/");
		
		set.getYopmailURL();
		
		Thread.sleep(660000);    // Wait for 11 min	for 1st sequence
	
		driver.findElement(carthome_obj.YopmailAccount_Username).sendKeys(prop.getProperty("YopmailAccount_Username"));     // Enter username
		driver.findElement(carthome_obj.YopmailAccount_CheckInbox).click();   // Click on Check Inbox
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(carthome_obj.YopmailAccount_Iframe));
		
		List<org.openqa.selenium.WebElement> totalemails = driver.findElements(carthome_obj.YopmailAccount_TotalEmails);
		System.out.println("Total number of emails = "+totalemails.size());
		
		String firstemailsubject = ((org.openqa.selenium.WebElement) totalemails.get(0)).getText();
		System.out.println("Subject of the sent campaign = "+firstemailsubject);
		
		driver.switchTo().parentFrame();
		
		Thread.sleep(2000);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot of email is taken successfully");
		
		Thread.sleep(150000);    // Wait for 2 min	for 2nd sequence
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
	
		driver.findElement(carthome_obj.YopmailAccount_CheckInbox).click();   // Click on Check Inbox
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(carthome_obj.YopmailAccount_Iframe));
		
		List<org.openqa.selenium.WebElement> totalemails1 = driver.findElements(carthome_obj.YopmailAccount_TotalEmails);
		System.out.println("Total number of emails = "+totalemails1.size());
		
		String secondemailsubject = ((org.openqa.selenium.WebElement) totalemails.get(0)).getText();
		System.out.println("Subject of the sent campaign = "+secondemailsubject);
		
		driver.switchTo().parentFrame();
		
		Thread.sleep(2000);
		
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot of email sequence2 is taken successfully");

		Thread.sleep(2000);	
		
		// Pause the cart recovery campaign (switch to 0 tab and open URL)
		
		driver.switchTo().window(tabs.get(0)); //switches to tab
		
		set.getPreProdCartCampaignPage();
		
		carthome_obj.Campaigns_InactiveInstanceClick();
		
		
//		driver.quit();
		
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}
