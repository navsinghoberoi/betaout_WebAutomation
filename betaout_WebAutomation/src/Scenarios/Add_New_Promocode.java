package Scenarios;
/**
 * @author - Navpreet
 */
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;

public class Add_New_Promocode {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception{

		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://staging-102.betaout.com/");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("sjs22858@gmail.com");
		obj.upswd("simranjeet");
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
		add_coupons_obj.enter_name_coupon_campaign_click("AutoCombo21");         // Enter same data in assert and dropdown
				
		// Upload CSV
		
		add_coupons_obj.choose_csv_file_click();        // choose file
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.name("filepicker_dialog")));
		Thread.sleep(3000);
		
		add_coupons_obj.filepicker_click("C:\\Users\\Navpreet\\Desktop\\valid CSV.csv");  
		
		Thread.sleep(6000);
		
		add_coupons_obj.save_button_click();
		
		Coupon_Config config = new Coupon_Config(driver);
		
		config.multiple_usage_radiobutton_click();
		config.date_radiobutton_click();
		config.calendar_icon_click();   // Present date is picked by default
		config.save_button_click();
		
		Thread.sleep(3000);
		
		// Paste Codes
		
		campaign_obj.add_coupon_codes_button();
		
		add_coupons_obj.add_existing_campaign_tab_click();
		
		Select select = new Select(driver.findElement(By.xpath("//*[@name = 'couponListId']")));
		select.selectByVisibleText("AutoCombo21");
		
		
		// Enter paste codes
		
		add_coupons_obj.paste_codes_tab_click();       
		
		add_coupons_obj.enter_paste_codes_click("NAV1");
		
		driver.findElement(By.xpath("//textarea[@class = 'textarea']")).sendKeys(Keys.ENTER);
		
		add_coupons_obj.enter_paste_codes_click("NAV2");
		
	//	add_coupons_obj.save_button_click();    // not working

	driver.findElement(By.xpath("//*[@name = 'couponDataSubmit']")).click();
		
	//	Coupon_Config config = new Coupon_Config(driver);
		
		config.multiple_usage_radiobutton_click();
		config.date_radiobutton_click();
		config.calendar_icon_click();   // Present date is picked by default
		config.save_button_click();
		
		// Print the list of all coupon lists
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//*[@style = 'width:200px; text-align:left;' and @class = '']"));     
		System.out.println("Total number of coupon lists - " +allLinks.size());        
		
		for (WebElement element: allLinks) {
		      System.out.println(element.getText());
		}
		
		
	String couponlistname =	allLinks.get(0).getText();
	
	Assert.assertEquals("AutoCombo21", couponlistname);      
	
	// Active the campaign
	
//	campaign_obj.activecampaign_click();
	Thread.sleep(3000);
	
	campaign_obj.resumecampaign_click();
	Thread.sleep(5000);
	
	campaign_obj.deletecampaign_click();
	Thread.sleep(1000);

	driver.quit();
		
													}



							}
