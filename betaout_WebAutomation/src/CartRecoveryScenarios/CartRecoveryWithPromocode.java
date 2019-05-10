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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
import common_Classes.*;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
import promocode_Pages.Onsite_CreateCampaign;
import promocode_Pages.Onsite_Select_Template;
/**
 * @author - Navpreet
 */
public class CartRecoveryWithPromocode{


	public static WebDriver driver;

	@Test
	public void cartRecoveryWithPromocode() throws Exception
	
	{
		
		System.out.println("Scenario : Cart Recovery > Campaign > Create Campaign with Promocode > Check Mail > Clone, Edit and Delete campaign");
		
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
		
		// Add code to add new coupon list
		home_obj.accnt_click();
		
		home_obj.settings_click();
	
		Account_Settings settings_obj = new Account_Settings(driver);
		settings_obj.coupons_click();              // click on coupon list from settings page
		
		Coupon_Campaign campaign_obj = new Coupon_Campaign(driver);
		campaign_obj.add_coupon_codes_button();        //click add coupon codes button
		
		Coupon_Add_Coupon_Codes add_coupons_obj = new Coupon_Add_Coupon_Codes(driver);
		add_coupons_obj.create_new_coupon_campaign_tab_click();
		String couponName = "AutoCombo"+""+System.currentTimeMillis();
		add_coupons_obj.enter_name_coupon_campaign_click(couponName);         // Enter same data in assert and dropdown
				
		// Upload CSV
		
		add_coupons_obj.choose_csv_file_click();        // choose file
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.name("filepicker_dialog")));
		Thread.sleep(3000);

		String path = set.uploadPromocodeFileCSV();
		System.out.println(path);
		add_coupons_obj.filepicker_click(path);
	
		Thread.sleep(6000);
		
		add_coupons_obj.CSVFileNamePrint();
		
		add_coupons_obj.save_button_click();
		
		Coupon_Config config = new Coupon_Config(driver);
		
	//	config.multiple_usage_radiobutton_click();   // Uncomment to make Single Use Coupons
  		config.date_radiobutton_click();
		config.calendar_icon_click();   // Present date is picked by default
		config.nextMonthClick();
		Thread.sleep(2000);
		config.save_button_click();
		
		Thread.sleep(4000);
		
		// Paste Codes
		
		campaign_obj.add_coupon_codes_button();
		
		add_coupons_obj.add_existing_campaign_tab_click();
		
		Select select = new Select(driver.findElement(By.xpath("//*[@name = 'couponListId']")));
		select.selectByVisibleText(couponName);
		
		
		// Enter paste codes
		
		add_coupons_obj.paste_codes_tab_click();       
		
		add_coupons_obj.enter_paste_codes_click("A1");
		
		driver.findElement(By.xpath("//textarea[@class = 'textarea']")).sendKeys(Keys.ENTER);
		
		add_coupons_obj.enter_paste_codes_click("A1");
		
		driver.findElement(By.xpath("//*[@name = 'couponDataSubmit']")).click();
		
		config.date_radiobutton_click();
		config.calendar_icon_click();   // Present date is picked by default
		config.nextMonthClick();
		Thread.sleep(2000);
		config.save_button_click();
		Thread.sleep(5000);
		
		
		campaign_obj.totalcodesprint();
		Thread.sleep(2000);
		campaign_obj.distributedcodesprint();
		Thread.sleep(2000);
		campaign_obj.unusedcodesprint();
		Thread.sleep(2000);
		campaign_obj.dateofupload();
		Thread.sleep(2000);
		campaign_obj.CampaignsAssociatedPrint();
		Thread.sleep(2000);
		campaign_obj.totalCampaigns();
		Thread.sleep(2000);
			
		String campaignName = driver.findElement(By.xpath("(//*[contains(@class,'selectable')])/td[2]")).getText();
		System.out.println("Name of the campaign = "+campaignName);
		Thread.sleep(3000);
		
	// Active the campaign
	
	campaign_obj.activecampaign_click();
	Thread.sleep(3000);
	
	campaign_obj.resumecampaign_click();
	Thread.sleep(5000);

	SoftAssert sa = new SoftAssert();
	sa.assertEquals(couponName, campaignName);      
	sa.assertAll();
	
	System.out.println("Assertion of CouponList Name is done successfully");

		// Go to cart recovery	
		
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
	//	temp_obj.UseGarmentsTemplateClick();
		
		Thread.sleep(15000);
		
		CartRecovery_Design design_obj = new CartRecovery_Design(driver);
		
		// Add code to add coupon codes

		driver.switchTo().frame(driver.findElement(By.xpath("(//*[contains(@src,'/email-permalink/nv/peId')])")));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[contains(text(),'SALE')])")).click();
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//*[@id='mce_38']")).click();        // Click on Coupon Codes
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@src,'https://qa.betaout.in/tinymce/js/tinymce/plugins')]")));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class = 'couponcodeId']")).click();
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//*[contains(@class,'getSelectedCoupon')]")).click();  // Use Campaign button
		Thread.sleep(2000); 
		driver.switchTo().defaultContent();
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot 1 is taken successfully");
		Thread.sleep(2000);
	
		String Subject = System.currentTimeMillis() + prop.getProperty("CartRecovery_Subject1");
		design_obj.SubjectClick(Subject);
		design_obj.ChooseSenderClick(prop.getProperty("SES_SenderID"));
		/*design_obj.TimeOfSending_ValueClick("1");
		design_obj.TimeOfSending_MinutesClick();*/
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

				File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile1, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));		
				System.out.println("Screenshot of email is taken successfully");
				
				
				s_assert.assertEquals(emailsubject,Subject);
				System.out.println("Subject of the email is verified ");
				
				// Compare promocode from email 
			
				String firstWord = emailmessage.split(" ")[0];
				System.out.println("First word of the message content = "+firstWord);
				
				s_assert.assertEquals("A1SALE", firstWord);
				s_assert.assertAll();
				System.out.println("Promocode is displayed on the email");
				
				Thread.sleep(3000);
				page_obj.DeleteAllMails();
				Thread.sleep(3000);
				System.out.println("Email is deleted successfully");
			
				page_obj.accountClick();
				Thread.sleep(1500);
				page_obj.signout();
		
	}
	
	@AfterMethod
	public void kill() throws Exception
	{
		SoftAssert sa = new SoftAssert();
		Setup_class set = new Setup_class(driver);
		CartRecovery_CartRecoveryCampaign recovery_obj = new CartRecovery_CartRecoveryCampaign(driver);
		CartRecovery_Homepage carthome_obj = new CartRecovery_Homepage(driver);
		
		// Inactive instance once the desired action is captured on the integrated website
		
		Thread.sleep(3000);
				
		String url = driver.getCurrentUrl();
		System.out.println("URL currently opened is "+url);
		
		driver.get("https://qa.betaout.in/promocode/coupon-list/");		
		
		// Pause the coupon list
			
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//*[@class = 'iconAction-pause'])[1]"))).build().perform();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class = 'iconAction-pause'])[1]")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("(//*[@name = 'pauseCouponList'])")).click();
		Thread.sleep(7000);
	
		
		// Pause the cart recovery campaign (switch to 0 tab and open URL)
				
		set.getQACartCampaignPage();
		carthome_obj.Campaigns_InactiveInstanceClick();
				
		
		// Add code to clone, edit and delete campaign
		
		
		carthome_obj.Campaigns_CloneClick();
		Thread.sleep(2000);
		
		// Print and assert name of campaign
		String campaign_name = driver.findElement(carthome_obj.Campaigns_campaign_name).getText();
		System.out.println("Name of the cloned campaign = "+campaign_name);
		boolean CloneCamp= campaign_name.contains("Clone");
		System.out.println("Boolean result for creation of clone campaign = "+CloneCamp);
		sa.assertEquals(CloneCamp, true);
		System.out.println("Clone of campaign is created");
		
		carthome_obj.Campaigns_EditClick();
		Thread.sleep(2000);
	
		recovery_obj.DeleteClick();
		Thread.sleep(10000);
	
		// Verify that clone campaign is not displayed now
		String campaign_name1 = driver.findElement(carthome_obj.Campaigns_campaign_name).getText();
		
		boolean CloneCamp1= campaign_name1.contains("Clone");
		System.out.println("Boolean result for visibility of clone campaign after deletion = "+CloneCamp1);
		sa.assertEquals(CloneCamp1, false);
		System.out.println("Deleted campaign is not displayed");
	
		sa.assertAll();
		
	}
	

}
