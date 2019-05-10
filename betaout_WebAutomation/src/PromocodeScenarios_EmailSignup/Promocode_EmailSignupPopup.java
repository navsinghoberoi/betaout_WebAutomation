package PromocodeScenarios_EmailSignup;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OnsiteMarketingPages.Onsite_CreateCampaign;
import OnsiteMarketingPages.Onsite_Design;
import OnsiteMarketingPages.Onsite_Select_Template;
import OnsiteMarketingPages.Onsite_Target_Page;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Onsite_Activepage;
import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
/**
 * @author - Navpreet
 */
public class Promocode_EmailSignupPopup {

	public static WebDriver driver;
	
	@Test
	
	public void PromocodeOnEmailSignupPopup() throws Exception
	
	{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		Properties prop = set.loadPropertyFile();
		
	//	driver.get("https://pre-prod-102.betaout.com/");
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
		homeobj.accnt_click();
		
		homeobj.settings_click();
	
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
		
	//	add_coupons_obj.filepicker_click(prop.getProperty("Promocode_FilePath"));  
		
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
		
		Select select = new Select(driver.findElement(campaign_obj.ExistingCouponCamp));
		select.selectByVisibleText(couponName);
		
		
		// Enter paste codes
		
		add_coupons_obj.paste_codes_tab_click();       
		
		add_coupons_obj.enter_paste_codes_click("A1");
		
		driver.findElement(campaign_obj.EnterCode).sendKeys(Keys.ENTER);
		
		add_coupons_obj.enter_paste_codes_click("A1");
		
		driver.findElement(campaign_obj.PasteCodesSave).click();
	
	//	config.multiple_usage_radiobutton_click();
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
		
		String campaignName = driver.findElement(campaign_obj.CouponCampaignName).getText();
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
	
	// Now add code of Email Popup
	
	Homepage onsite_obj = new Homepage(driver);
	onsite_obj.onsite_click();
	
	Onsite_CreateCampaign calltoaction_obj = new Onsite_CreateCampaign(driver);
	calltoaction_obj.emailsignupclick();        // to open emailsignup 
		
//	calltoaction_obj.PrintNameOfFields();
//	calltoaction_obj.PrintCampaignPopupDetails();
	
	calltoaction_obj.createcampaign_click();
//	Date date1 = set.getCurrentDateTime();
	String name = "Auto_emailpopup"+" "+System.currentTimeMillis();
	calltoaction_obj.name(name);
	Thread.sleep(1500);
	calltoaction_obj.emailsave_click();                // different for every tab
	Thread.sleep(3000);
	
	Onsite_Select_Template template_obj = new Onsite_Select_Template(driver);
	template_obj.EmailSignupPopuptemplateClick();      // Select popup template
	
	// Explicit wait for Save and Next after selecting template
	
	 WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Save & Next']")));

	Thread.sleep(8000);
	
	Onsite_Design design = new Onsite_Design(driver);
	
	Thread.sleep(2000);
	
	
	driver.findElement(campaign_obj.CouponCodeDesignPage).click();    // Click on CouponCode
	Thread.sleep(6000);
	
	driver.switchTo().frame(driver.findElement(campaign_obj.TinyMCE));
	
	driver.findElement(campaign_obj.SelectCampRadioButton).click();
	Thread.sleep(2000); 
	
	driver.findElement(campaign_obj.UseCampaignButton).click();  // Use Campaign button
	Thread.sleep(2000); 
	driver.switchTo().defaultContent();
	
	Thread.sleep(2000);
	
	
	
	design.EmailSignupEmailClick();
	design.EmailSignupSenderIDClick();
	design.EmailSignupSubjectClick("This is test subject for the email");
	Thread.sleep(2000);
	
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
	
	System.out.println("Screenshot 1 is taken successfully");
	
	design.save_next();
	Thread.sleep(12000);

	
	Onsite_Target_Page target_obj = new Onsite_Target_Page(driver);
	target_obj.Target_Users_click();   
	Thread.sleep(1500);
	target_obj.Show_Instance_click();
	Thread.sleep(1500);
	target_obj.SI_Everytime_click();
	Thread.sleep(1500);
	target_obj.Target_Pages_click();
	Thread.sleep(1500);
	
	String weburl = "EmailPopup_Promocode";
	target_obj.TP_SpecificURL_click(weburl);           // enter url
	Thread.sleep(3000);
	target_obj.SaveAndNext_click();
	Thread.sleep(9000);
	
	
	Onsite_Activepage active_obj = new Onsite_Activepage(driver);
	active_obj.Active_click();
	active_obj.Save_click();
	Thread.sleep(10000);
	
	
	// Assert name of campaign
	
	String ActiveInstanceName = driver.findElement(campaign_obj.ActiveCampName).getText();
	SoftAssert s_assert = new SoftAssert();
	s_assert.assertEquals(ActiveInstanceName, name);
	s_assert.assertAll();
	System.out.println("Assertion -> Name of the campaign is matched");
	
	Thread.sleep(6000);
	
//	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,"t");   	// Open new tab
	
	((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	 
	driver.switchTo().window(tabs.get(1)); //switches to first tab
		
	String URL = set.getWoocommerceOneURL();
	driver.get(URL+"/?"+weburl);

	
//	driver.navigate().refresh();
	
	Thread.sleep(12000);
	
	File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile1, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
	
	System.out.println("Screenshot 2 is taken successfully");

	// Switch to iframe

    driver.switchTo().frame(driver.findElement(campaign_obj.PopupIframe));
    
    String PopupText = driver.findElement(By.xpath("//*[@class = 'focus']")).getText();
    
    driver.findElement(By.xpath("//*[@name = 'email']")).sendKeys(prop.getProperty("GmailQAValidUsername"));
    
    driver.findElement(By.xpath("(//*[@data-amplifylc-name = 'submitBtn'])")).click();
    
   
    System.out.println(PopupText);
		
	s_assert.assertEquals("A1LIMITED OFFER", PopupText);
	s_assert.assertAll();
	
	System.out.println("Popup with promocode is present on the URL");
	Thread.sleep(5000);
	
	// Inactive instance once the desired action is captured on the integrated website

	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
	
	Thread.sleep(3000);

	driver.switchTo().window(tabs.get(0));
	
	calltoaction_obj.InactiveInstanceClick();
			
	Thread.sleep(5000);
			
	String url = driver.getCurrentUrl();
	System.out.println("URL currently opened is "+url);
	
	set.getCouponListURL();
	
	// Pause the coupon list
	
	campaign_obj.totalcodesprint();
	Thread.sleep(2000);
	campaign_obj.distributedcodesprint();
	Thread.sleep(2000);
	campaign_obj.unusedcodesprint();
	Thread.sleep(2000);
	campaign_obj.CampaignsAssociatedPrint();
	Thread.sleep(5000);
		
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(campaign_obj.InactiveCouponCampIcon)).build().perform();	
	Thread.sleep(3000);
	driver.findElement(campaign_obj.InactiveCouponCampIcon).click();
	Thread.sleep(2000);
	
	
	driver.findElement(campaign_obj.PauseCouponCmap).click();
	Thread.sleep(7000);

	
//	driver.quit();

	
	}
	
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}
