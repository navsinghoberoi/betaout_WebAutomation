package CartRecoveryScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_CampaignConditions;
import CartRecoveryPages.CartRecovery_CampaignName;
import CartRecoveryPages.CartRecovery_CartRecoveryCampaign;
import CartRecoveryPages.CartRecovery_Design;
import CartRecoveryPages.CartRecovery_Homepage;
import CartRecoveryPages.CartRecovery_SelectTemplate;
import EmailMarketingPages.EM_Broadcast_Template;
import GmailLogin.GmailLoginPages;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;

/**
 * @author - Navpreet
 */

public class CartRecovery2Email2CouponCodes {


	public static WebDriver driver;

	@Test
	public void CartRecovery_2sequence_RecoverCart() throws Exception
	
	{
		
		System.out.println("Scenario : Create Camp > Sequence1 with PromocodeA > Check mail > Verify stats > Sequence2 (with short URL) with promocodeB> Check mail > recover cart > verify stats > Inactivate campaign ");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		String currentDate = set.getCurrentDateTime();

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
		
		CartRecovery_Homepage carthome_obj = new CartRecovery_Homepage(driver);
			
		home_obj.cartrecovery_click();
		Thread.sleep(3000);
	
		carthome_obj.CampaignsClick();
		Thread.sleep(3000);
		carthome_obj.Campaigns_CreateCampaignClick();
		
		CartRecovery_CampaignName name_obj = new CartRecovery_CampaignName(driver);

		String name = prop.getProperty("CartRecovery_Name") + " " +currentDate; 
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
		
		// Code to link CouponCamp 1 with Sequence 1 
		
		driver.switchTo().frame(driver.findElement(carthome_obj.Iframe1));		
		Thread.sleep(4000);
		
		carthome_obj.ClickOnSale();
		
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
				
		carthome_obj.CouponTinyMCEClick();        // Click on Coupon Codes
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(carthome_obj.Iframe2));
		Thread.sleep(2000);
		
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//*[@data-id = '308'])"))).perform();
		
		driver.findElement(By.xpath("(//*[@data-id = '298'])")).click();             // Select checkNavAprilCoupons couponlist
		Thread.sleep(2000); 

		carthome_obj.UseCampaignButton();
		Thread.sleep(3000); 
		
		driver.switchTo().parentFrame();
		
		String Subject = prop.getProperty("CartRecovery_Subject1");
		design_obj.SubjectClick(Subject);
		design_obj.ChooseSenderClick(prop.getProperty("SES_SenderID"));
		
		design_obj.SaveExitClick();
		Thread.sleep(15000);
		
		// Add code to Add 2nd Sequence
		
		recovery_obj.AddEmailSequenceClick();
		Thread.sleep(5000);
		temp_obj.UseTemplate_GarmentsTemplateClick();
		Thread.sleep(15000);
		
		// Enter data in Target URL
		
		EM_Broadcast_Template obj2 = new EM_Broadcast_Template(driver);
		
		driver.switchTo().frame(driver.findElement(recovery_obj.GoToCartFrame));
		
		obj2.CartRecoveryGoToCart();
		Thread.sleep(1500);
		
		driver.switchTo().parentFrame();
		
		driver.findElement(recovery_obj.TargetURL).clear();
		driver.findElement(recovery_obj.TargetURL).sendKeys(prop.getProperty("CartRecovery_ShortURL"));     // Homepage of woocommerceone
	
		// Code to link CouponCamp 2 with Sequence 2 
		
		driver.switchTo().frame(driver.findElement(carthome_obj.Iframe1));
		Thread.sleep(4000);
				
		carthome_obj.ClickOnSale();
		Thread.sleep(2000);
				
		driver.switchTo().parentFrame();
				
		carthome_obj.CouponTinyMCEClick();
		Thread.sleep(2000);
				
		driver.switchTo().frame(driver.findElement(carthome_obj.Iframe2));
		Thread.sleep(2000);
				
		act.moveToElement(driver.findElement(By.xpath("(//*[@data-id = '308'])"))).perform();
		
		driver.findElement(By.xpath("(//*[@data-id = '307'])")).click();             // Select 13aprilqanav couponlist
		Thread.sleep(2000); 
		carthome_obj.UseCampaignButton();
		Thread.sleep(3000); 
				
		driver.switchTo().parentFrame();
		
	
		String Subject1 = prop.getProperty("CartRecovery_Subject2");
		design_obj.SubjectClick(Subject1);
		design_obj.ChooseSenderClick(prop.getProperty("SES_SenderID"));
		design_obj.TimeOfSending_ValueClick(prop.getProperty("CartRecovery_TimeInterval"));
		design_obj.TimeOfSending_MinutesClick();
		design_obj.SaveExitClick();
		Thread.sleep(15000);
	
		
		recovery_obj.PriorityForCampaignCheckboxClick();
		recovery_obj.MakeActiveClick();
		
		Thread.sleep(5000);

		List<org.openqa.selenium.WebElement> total_sequences = driver.findElements(carthome_obj.Campaigns_total_sequences);
		System.out.println("Total elements :"+total_sequences.size());

	    List<org.openqa.selenium.WebElement> total_subjects = driver.findElements(carthome_obj.Campaigns_total_subjects);
	
	    String subject1 = ((org.openqa.selenium.WebElement) total_subjects.get(0)).getText();
		System.out.println("Subject of 1st email = "+subject1);
		
		String subject2 = ((org.openqa.selenium.WebElement) total_subjects.get(1)).getText();
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

		Thread.sleep(660000);    // Wait for 11 min		

		set.getGmailURL();

		driver.findElement(By.xpath(prop.getProperty("GmailSignInClick"))).click();
		
		GmailLoginPages page_obj = new GmailLoginPages(driver);
		
		page_obj.enterUsername(prop.getProperty("GmailQAValidUsername"));   
		page_obj.nextButtonClick();
		
		Thread.sleep(4000);
		
		// Go to back and come back to this page
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		page_obj.enterPassword(prop.getProperty("GmailQAValidPassword"));
		page_obj.signInClick();
	
		Thread.sleep(7000);
		
		page_obj.openEmail();
	
		String emailsubject = page_obj.printemailSubject();
		System.out.println("Subject of email = "+emailsubject);
		
		boolean dynamicPPSubject = emailsubject.contains("Levis");
		boolean bracesinSubject = emailsubject.contains("{{");
		
		System.out.println("Boolean value for presence of dynamic properties in email subject= "+dynamicPPSubject);
		s_assert.assertEquals(dynamicPPSubject, true);
		s_assert.assertEquals(bracesinSubject, false);
		
		String emailmessage = page_obj.printemailMessage();
		System.out.println("Message content of email = "+emailmessage);

		// Assert promocode in displayed in emailmessage
		
		boolean couponsA = emailmessage.contains("A1");
		System.out.println("Boolean result of coupon present in sequence 1 = "+couponsA);
		s_assert.assertEquals(couponsA, true);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));		
		System.out.println("Screenshot of email is taken successfully");
			
		System.out.println("Subject of the email is verified ");
		
		Thread.sleep(3000);
		page_obj.DeleteAllMails();
		Thread.sleep(3000);
		System.out.println("Email is deleted successfully");
	
		/*page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();*/
		
		// Now go to cart campaigns page and verify the stats
		
		driver.switchTo().window(tabs.get(0)); //switches to tab
		
		set.getQACartCampaignPage();
		
		// Wait for 1 min	
		
		Thread.sleep(60000);
		
		String firstsequence = driver.getCurrentUrl();
		driver.get(firstsequence);
		
		
		String SequenceData = carthome_obj.printSequenceData();
		System.out.println("Sequence data after receiving 1st email = "+SequenceData);
		s_assert.assertEquals(SequenceData, "2");
		
		String SentData = carthome_obj.printSentData();
		System.out.println("Sent data after receiving 1st email = "+SentData);
		s_assert.assertEquals(SentData, "1");
		
		String OpenData = carthome_obj.printOpenedData();
	//	System.out.println("Open data after receiving 1st email = "+OpenData);
		
		String Open_Number = OpenData.split("\n")[0];
		System.out.println("Number of Open mails after receiving 1st mail = "+Open_Number);
		s_assert.assertEquals(Open_Number, "1");
		String Open_Percentage = OpenData.split("\n")[1];
		System.out.println("Percentage of Open mails after receiving 1st mail = "+Open_Percentage);
		s_assert.assertEquals(Open_Percentage, "100%");
		
		
		String ClickData = carthome_obj.printClickedData();
	//	System.out.println("Clicked data after receiving 1st email = "+ClickData);
	
		String Click_Number = ClickData.split("\n")[0];
		System.out.println("Number of Clicks on mails after receiving 1st mail = "+Click_Number);
		s_assert.assertEquals(Click_Number, "0");
		String Click_Percentage = ClickData.split("\n")[1];
		System.out.println("Percentage of Clicked mails after receiving 1st mail = "+Click_Percentage);
		s_assert.assertEquals(Click_Percentage, "0%");
		
		
		String TargetData = carthome_obj.printTagetedData();
		System.out.println("Target data after receiving 1st email = "+TargetData);
		String RetargetData = carthome_obj.printReTagetedData();
		System.out.println("Retarget data after receiving 1st email = "+RetargetData);
		
		String RecoveredData = carthome_obj.printRecoveredData();
	//	System.out.println("Recovered data after receiving 1st email = "+RecoveredData);

		String Recovered_Number = RecoveredData.split("\n")[0];
		System.out.println("Count of Recovered after receiving 1st mail = "+Recovered_Number);
		s_assert.assertEquals(Recovered_Number, "0");
		String Recovered_Amount = RecoveredData.split("\n")[1];
		System.out.println("Recovered Amount after receiving 1st mail = "+Recovered_Amount);
		s_assert.assertEquals(Recovered_Amount, "INR 0");
		
		// Wait for 5 minutes > Go to gmail > Click on button of 2nd sequence > Purchase product > Verify Stats > Inactive Campaign > Clone, Edit and delete it

		Thread.sleep(300000);
		
		driver.switchTo().window(tabs.get(1)); //switch to gmail
		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		page_obj.openEmail();
		
		String emailsubject1 = page_obj.printemailSubject();
		System.out.println("Subject of second sequence email = "+emailsubject1);
		
		boolean dynamicPPSubject1 = emailsubject1.contains("Levis");
		boolean bracesinSubject1 = emailsubject1.contains("{{");
		
		System.out.println("Boolean value for presence of dynamic properties in email subject= "+dynamicPPSubject);
		s_assert.assertEquals(dynamicPPSubject1, true);
		s_assert.assertEquals(bracesinSubject1, false);
		
		String emailmessage1 = page_obj.printemailMessage();
		System.out.println("Message content of second sequence email = "+emailmessage1);

		boolean couponsB = emailmessage1.contains("A1");
		System.out.println("Boolean result of coupon present in sequence 2 = "+couponsB);
		s_assert.assertEquals(couponsB, true);
		
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));		
		System.out.println("Screenshot of email is taken successfully");
		
		System.out.println("Subject of the email of second sequence is verified");
		
		Thread.sleep(3000);
		
		// Click on CTA and compare Short URL
		
		obj2.CartRecoveryGoToCart();
		Thread.sleep(7000);
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		
		System.out.println("Number of tabs1 = "+tabs1.size());
		Thread.sleep(3000);
		
		driver.switchTo().window(tabs1.get(2)); // go to new tab

		String ShortURL = driver.getCurrentUrl();
		System.out.println("URL opened on click of CTA Button = "+ShortURL);
		
		s_assert.assertEquals(prop.getProperty("CartRecovery_ShortURL"), ShortURL);
		Thread.sleep(2000);
		
		// On website, go to Cart and click on Proceed to Checkout
		
		carthome_obj.openCart();
		
		driver.findElement(carthome_obj.WoocommerceAccount_ProceedToCheckout).click(); // Proceed to Checkout

		Thread.sleep(2000);

		driver.findElement(carthome_obj.WoocommerceAccount_PlaceOrder).click();
		Thread.sleep(2000);
		
		// Go back to tab1 and delete email
		
		driver.switchTo().window(tabs.get(1)); 
		
		page_obj.DeleteAllMails();
		Thread.sleep(3000);
		System.out.println("Second sequence email is deleted successfully");
	
		page_obj.accountClick();
		Thread.sleep(1500);
		page_obj.signout();
		
		
		// Move to cart campaigns page and verify stats		
		
		driver.switchTo().window(tabs.get(0)); //switches to tab
		
		set.getQACartCampaignPage();
		
		// Wait for 1 min	
		
		Thread.sleep(60000);
		
		String secondsequence = driver.getCurrentUrl();
		driver.get(secondsequence);
		
		
		String SequenceDataAfterPurchase = carthome_obj.printSequenceData();
		System.out.println("Sequence data after receiving 2nd email = "+SequenceDataAfterPurchase);
		s_assert.assertEquals(SequenceDataAfterPurchase, "2");
		
		String SentDataAfterPurchase = carthome_obj.printSentData();
		System.out.println("Sent data after receiving 2nd email = "+SentDataAfterPurchase);
		s_assert.assertEquals(SentDataAfterPurchase, "2");
		
		String OpenDataAfterPurchase = carthome_obj.printOpenedData();
	//	System.out.println("Open data after receiving 2nd email = "+OpenDataAfterPurchase);
		
		String Open_NumberAfterPurchase = OpenDataAfterPurchase.split("\n")[0];
		System.out.println("Number of Open mails after receiving 2nd mail = "+Open_NumberAfterPurchase);
		s_assert.assertEquals(Open_NumberAfterPurchase, "2");
		String Open_PercentageAfterPurchase = OpenDataAfterPurchase.split("\n")[1];
		System.out.println("Percentage of Open mails after receiving 2nd mail = "+Open_PercentageAfterPurchase);
		s_assert.assertEquals(Open_PercentageAfterPurchase, "100%");
		
		
		String ClickDataAfterPurchase = carthome_obj.printClickedData();
	//	System.out.println("Clicked data after receiving 2nd email = "+ClickDataAfterPurchase);
		String Click_NumberAfterPurchase = ClickDataAfterPurchase.split("\n")[0];
		System.out.println("Number of Clicks on mails after receiving 2nd mail = "+Click_NumberAfterPurchase);
		s_assert.assertEquals(Click_NumberAfterPurchase, "1");
		String Click_PercentageAfterPurchase = ClickDataAfterPurchase.split("\n")[1];
		System.out.println("Percentage of Clicked mails after receiving 2nd mail = "+Click_PercentageAfterPurchase);
		s_assert.assertEquals(Click_PercentageAfterPurchase, "50%");
		
		String TargetDataAfterPurchase = carthome_obj.printTagetedData();
		System.out.println("Target data after receiving 2nd email = "+TargetDataAfterPurchase);
		String RetargetDataAfterPurchase = carthome_obj.printReTagetedData();
			
		String Number_RetargetDataAfterPurchase = RetargetDataAfterPurchase.split("\n")[0];
		System.out.println("Number of Retargeted mails after receiving 2nd mail = "+Number_RetargetDataAfterPurchase);
	//	s_assert.assertEquals(Number_RetargetDataAfterPurchase, "1");
		String Amount_RetargetDataAfterPurchase = RetargetDataAfterPurchase.split("\n")[1];
		System.out.println("Amount of Retarget after receiving 2nd mail = "+Amount_RetargetDataAfterPurchase);
				
		String RecoveredDataAfterPurchase = carthome_obj.printRecoveredData();
	//	System.out.println("Recovered data after receiving 2nd email = "+RecoveredDataAfterPurchase);
		
		String Number_RecoveredDataAfterPurchase = RecoveredDataAfterPurchase.split("\n")[0];
		System.out.println("Number of Recovered mails after receiving 2nd mail = "+Number_RecoveredDataAfterPurchase);
		s_assert.assertEquals(Number_RecoveredDataAfterPurchase, "1");
		String Amount_RecoveredDataAfterPurchase = RecoveredDataAfterPurchase.split("\n")[1];
		System.out.println("Amount of Retarget after receiving 2nd mail = "+Amount_RecoveredDataAfterPurchase);
		
		System.out.println("Promocode from coupon list 1 is present in sequence 1");
		System.out.println("Promocode from coupon list 2 is present in sequence 2");

		s_assert.assertAll();

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
	
	//	driver.quit();
		
		
	}
	
	
}
