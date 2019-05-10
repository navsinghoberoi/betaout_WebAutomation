package Promocode_Scenarios;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
/**
 * @author - Navpreet
 */
public class Add_New_Promocode {
	
	public static WebDriver driver;
	
	
	@Test
	public void AddCouponList() throws Exception{

		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://pre-prod-102.betaout.com/");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("Woocommercetest@y0v.in");
		obj.upswd("Woocommercetest");
		obj.ulogin();
		
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
		
		add_coupons_obj.filepicker_click("C:\\Users\\Navpreet\\Desktop\\valid CSV.csv");  
		
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
		
		add_coupons_obj.enter_paste_codes_click("NAV1");
		
		driver.findElement(By.xpath("//textarea[@class = 'textarea']")).sendKeys(Keys.ENTER);
		
		add_coupons_obj.enter_paste_codes_click("NAV2");
		
	//	add_coupons_obj.save_button_click();    // not working

	driver.findElement(By.xpath("//*[@name = 'couponDataSubmit']")).click();
		
	//	Coupon_Config config = new Coupon_Config(driver);
		
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
		
		List<WebElement> allCampaignsName	=	driver.findElements(By.xpath("(//*[@class = 'selectable draft'])/td[2]"));
	
		String campaignName = allCampaignsName.get(0).getText();
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
	
	
	
	driver.quit();
		
													}



							}
