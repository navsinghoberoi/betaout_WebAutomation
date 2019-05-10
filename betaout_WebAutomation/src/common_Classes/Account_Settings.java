package common_Classes;

import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
/**
 * @author - Navpreet
 */
public class Account_Settings {

	public WebDriver driver;
	
	// General
	By team_members = By.xpath("//div[text() = 'Team Members']");
	By team_members_activity = By.xpath("//div[text() = 'Team Members Activity']");
	By time_zone = By.xpath("//div[text() = 'Time-zone']");
	By referral_exclusion = By.xpath("//div[text() = 'Referral Exclusion List']");
	By rfm_analysis = By.xpath("//div[text() = 'RFM Analysis']");
	By lookup_window = By.xpath("//div[text() = 'Lookup Window']");
	By account_setting = By.xpath("//div[text() = 'Account Setting']");
	By change_language = By.xpath("//div[text() = 'Change Language']");
	By user_role = By.xpath("(//*[@href='/configurations/settings/user-role'])[2]");
	
	
	// Add locators for Settings page additional locators
	
	By AS_TimeZone = By.xpath("(//*[@href = '/configurations/settings/timezone'])[1]");
	By AS_ChangeLanguage = By.xpath("(//*[@href = '/configurations/settings/language'])[1]");
	By AS_CurrencyFormat = By.xpath("(//*[@href = '/configurations/settings/currency-format'])[1]");
	By AS_OTP = By.xpath("(//*[@href = '/configurations/settings/otp-setting'])[1]");
	
	By Setting = By.xpath("(//*[@href = '/configurations/settings/tracking'])");
	
	
	// Data Import
	By user_import = By.xpath("//div[text() = 'User Import']");
	By bouncelist_import = By.xpath("//div[text() = 'Bounce List Import']");
	By unsubscribe_import = By.xpath("//div[text() = 'Unsubscribe List Import']");
	By order_transaction_import = By.xpath("//div[text() = 'Order/Transaction Imports']");
	By spam_complaints_import = By.xpath("//div[text() = 'Spam complaints List Import']");
	By sms_suppression_import = By.xpath("//div[text() = 'SMS suppression list import']");
	
	// Order Import
	By order_property_schema = By.xpath("//div[text() = 'Order Property Schema']");
	
	// Contact Database
	By user_property_schema = By.xpath("//div[text() = 'User Property Schema']");
	By events_schema = By.xpath("//div[text() = 'Event Schema']");
	
	// Email Mktg
	By time_interval_emails = By.xpath("//div[text() = 'Time Interval between Emails']");
	By time_interval_cart_emails = By.xpath("//div[text() = 'Time Interval between Cart Emails']");
	By email_spam_info = By.xpath("//div[text() = 'Email Can-Spam Information']");
	By add_remove_verified_senders = By.xpath("//div[text() = 'Add/Remove Verified Senders']");
	By email_gateway_integration = By.xpath("//div[text() = 'Email Gateway integration']");
	By mailchimp_server_setting = By.xpath("//div[text() = 'Mailchimp Server Setting']");
	
	// SMS Mktg
	By sms_gateway_integration = By.xpath("//div[text() = 'SMS Gateway integration']");
	By add_remove_sms_senders = By.xpath("//div[text() = 'Add/Remove SMS Senders']");
	By time_interval_sms = By.xpath("//div[text() = 'Time Interval between SMS']");
	By time_interval_cart_sms = By.xpath("//div[text() = 'Time Interval between Cart SMS']");
	
	// Mobile Push
	By mobile_services = By.xpath("//*[@href='/push/setup']");      
	By time_bw_GCM_notifications = By.xpath("//div[text() = 'Time Interval between GCM Push Notification']");		
	By time_bw_cart_GCM_notifications = By.xpath("//div[text() = 'Time Interval between Cart GCM Push Notification']");
	By advance_push = By.xpath("//div[text() = 'Advance Push']");
	By apn_gcm_nestedproperties = By.xpath("//div[text() = 'APN/GCM Nested Property Schema']");
	By add_geofencing = By.xpath("//*[text() = 'Add Geofencing']");
	
	
	//FB Ads Targeting
	
	By fb_setup = By.xpath("//*[@href='/configurations/settings/fb-ads-targeting']");  
	By fb_mktg = By.xpath("//div[text() = 'Facebook Marketing']");
	
	// Recommendation 
	By recommendation_setup = By.xpath("//*[@href='/configurations/settings/machine-learning-configuration']");  
	
	//Coupon Lists
	By coupon_lists = By.xpath("//div[text() = 'Coupon Lists']"); 
	
	// Browser Push
	By browser_services = By.xpath("//*[@href='/bn/setting/setup2']");             
	By time_bw_browser_push_notifications = By.xpath("//div[text() = 'Time Interval between browser push notification']");
	
	
	public Account_Settings(WebDriver driver)
	
	{
		this.driver = driver;
		
	}
	

	/*
	@Test
	
	public void test_click()
		
		{
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://staging-102.betaout.com/");
		
		driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/nav[1]/div/a[2]")).click(); // Login
		
		driver.findElement(By.xpath(".//*[@id='user_name']")).sendKeys("sjs22858@gmail.com");   // username
		
		driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys("simranjeet"); // password
		
		driver.findElement(By.xpath(".//*[@id='login']/div[4]/button")).click();  // submit
		
		driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul[3]/li[2]/a/span[2]")).click(); // accounts
		
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[3]/li[2]/ul/li[2]/a/span")).click();

		
		driver.findElement(team_members).click();
		
			}
	*/

	public void team_members_click()

	{
		
	driver.findElement(team_members).click();

	}

	public void team_members_activity_click()

	{
		
	driver.findElement(team_members_activity).click();

	}
	
	public void time_zone_click()

	{
		
	driver.findElement(time_zone).click();

	}

	public void referal_exclusion_click()

	{
		
	driver.findElement(referral_exclusion).click();

	}
	
	public void rfm_click()

	{
		
	driver.findElement(rfm_analysis).click();

	}
	
	public void lookup_window_click()

	{
		
	driver.findElement(lookup_window).click();

	}
	
	public void account_setting_click()

	{
		
	driver.findElement(account_setting).click();

	}
	
	public void change_language_click()

	{
		
	driver.findElement(change_language).click();

	}
	
	public void user_role_click()

	{
		
	driver.findElement(user_role).click();

	}
	
	public void AS_TimeZoneClick()
	{
		driver.findElement(AS_TimeZone).click();
	}
	
	
	public void AS_ChangeLanguageClick()
	{
		driver.findElement(AS_ChangeLanguage).click();
	}
	
	
	public void AS_CurrencyFormatClick()
	{
		driver.findElement(AS_CurrencyFormat).click();
	}
	
	public void AS_OTPClick()
	{
		driver.findElement(AS_OTP).click();
	}
	
	public void SettingClick()
	{
		driver.findElement(Setting).click();
	}
	
	
	public void user_import__click()

	{
		
	driver.findElement(user_import).click();

	}
	
	public void bounce_list_import_click()

	{
		
	driver.findElement(bouncelist_import).click();

	}
	
	public void unsubscribe_import_click()

	{
		
	driver.findElement(unsubscribe_import).click();

	}
	
	public void order_transactions_import_click()

	{
		
	driver.findElement(order_transaction_import).click();

	}
	
	public void spam_complaints_import_click()

	{
		
	driver.findElement(spam_complaints_import).click();

	}
	
	public void sms_suppression_import_click()

	{
		
	driver.findElement(sms_suppression_import).click();

	}
	
	public void oder_pp_schema_click()

	{
		
	driver.findElement(order_property_schema).click();

	}
	
	public void user_pp_schema_click()

	{
		
	driver.findElement(user_property_schema).click();

	}
	
	public void event_schema_click()

	{
		
	driver.findElement(events_schema).click();

	}
	
	public void time_bw_emails_click()

	{
		
	driver.findElement(time_interval_emails).click();

	}
	
	public void time_bw_cart_emails_click()

	{
		
	driver.findElement(time_interval_cart_emails).click();

	}
	
	public void email_spam_info_click()

	{
		
	driver.findElement(email_spam_info).click();

	}
	
	public void email_add_remove_verified_senders_click()

	{
		
	driver.findElement(add_remove_verified_senders).click();

	}
	
	public void email_gateway_integration_click()

	{
		
	driver.findElement(email_gateway_integration).click();

	}
	
	public void mailchimp_server_setting_click()

	{
		
	driver.findElement(mailchimp_server_setting).click();

	}
	
	public void sms_gateway_integration_click()

	{
		
	driver.findElement(sms_gateway_integration).click();

	}
	

	public void sms_add_remove_verified_senders_click()

	{
		
	driver.findElement(add_remove_sms_senders).click();

	}
	
	public void time_bw_sms_click()

	{
		
	driver.findElement(time_interval_sms).click();

	}

	public void time_bw_cart_sms_click()

	{
		
	driver.findElement(time_interval_cart_sms).click();

	}

	public void mobile_services_click()

	{
		
	driver.findElement(mobile_services).click();

	}

	public void mobile_time_bw_GCM()

	{
		
	driver.findElement(time_bw_GCM_notifications).click();

	}

	public void mobile_time_bw_cart_GCM()

	{
		
	driver.findElement(time_bw_cart_GCM_notifications).click();

	}

	public void advance_push_click()

	{
		
	driver.findElement(advance_push).click();

	}

	
	public void apn_gcm_nestedproperties_click()
	{
		driver.findElement(apn_gcm_nestedproperties).click();
	}
	
	public void add_geofencing_click()
	{
		driver.findElement(add_geofencing).click();
	}
	
	public void fb_setup_click()

	{
		
	driver.findElement(fb_setup).click();

	}

	public void fb_mktg_click()

	{
		
	driver.findElement(fb_mktg).click();

	}

	public void recommendation_setup_click()

	{
		
	driver.findElement(recommendation_setup).click();

	}
	
	public void coupons_click()

	{
		
	driver.findElement(coupon_lists).click();

	}

	public void browser_services_click()

	{
		
	driver.findElement(browser_services).click();

	}


	public void browser_timeinterval_click()

	{
		
	driver.findElement(time_bw_browser_push_notifications).click();

	}


}

