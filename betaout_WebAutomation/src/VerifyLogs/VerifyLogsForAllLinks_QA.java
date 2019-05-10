package VerifyLogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class VerifyLogsForAllLinks_QA {

public static WebDriver driver;
	
	public void getHomeURL()
	{
		driver.get("https://qa.betaout.in/insight-overview");	   
	}

	public void getCustomerSegmentURL()
	{
		driver.get("https://qa.betaout.in/segmentation");	     
	}

	public void getEmailMarketingURL()
	{
		driver.get("https://qa.betaout.in/email/overview");	     
	}

	public void getMobilePushURL()
	{
		driver.get("https://qa.betaout.in/pn/announcement/campaign");	     
	}

	public void getOnsiteMarketingURL()
	{
		driver.get("https://qa.betaout.in/apps/call-to-action");	     
	}

	public void getSMSMarketingURL()
	{
		driver.get("https://qa.betaout.in/sms/campaign");	     
	}

	public void getCartRecoveryURL()
	{
		driver.get("https://qa.betaout.in/carts/cart");	     
	}

	public void getBrowserPushURL()
	{
		driver.get("https://qa.betaout.in/bn/overview");	     
	}

	public void getContactDatabaseURL()
	{
		driver.get("https://qa.betaout.in/users/identifed-users");	     
	}
	
	public void getProductCatalogURL()
	{
		driver.get("https://qa.betaout.in/products/product-categories");	     
	}
	
	public void getIdeasDocsURL()
	{
		driver.get("https://qa.betaout.in/ideas/api-v2");	     
	}
	
	

	@Test
	public void VerifyLogs() throws Exception{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
				
		// Code to load the Property file
	
		set.getQAURL();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getNavpreetQAUsername());
		obj.upswd(set.getNavpreetQAPassword());
		
		obj.ulogin();
		
		Thread.sleep(2000);
		// Add code to select account
		set.selectAccountNav();
		
		System.out.println("User has logged in successfully");
				
		Homepage homeobj = new Homepage(driver);
		
		Account_Settings as = new Account_Settings(driver);
		
		// Insights
		
		homeobj.insight_click();
		
		String InsightsOverview_URL = driver.getCurrentUrl();            // Insights_Overview
		driver.get("view-source:"+InsightsOverview_URL); 
	//	driver.get("https://stag.betaout.in/fb/overview");
		System.out.println("Below line is for the URL = "+InsightsOverview_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[text() = 'Revenue & Orders'])[2]")).click();          // Insights_Revenue
		String InsightsRevenue_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+InsightsRevenue_URL);    
		System.out.println("Below line is for the URL = "+InsightsRevenue_URL);
		set.verifyLogs();
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[text() = 'Events'])[2]")).click();          // Insights_Events
		String InsightsEvents_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+InsightsEvents_URL);    
		System.out.println("Below line is for the URL = "+InsightsEvents_URL);
		set.verifyLogs();
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[text() = 'Conversion Booster'])[2]")).click();          // Insights_ConversionBooster
		String ConversionBooster_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+ConversionBooster_URL);    
		System.out.println("Below line is for the URL = "+ConversionBooster_URL);
		set.verifyLogs();
		
	
		// Customer Segments
		getCustomerSegmentURL();
		Thread.sleep(1500);
		String CustomerSegmentsLifecycle_URL = driver.getCurrentUrl();            // CustomerSegmentsLifecycle_URL
		driver.get("view-source:"+CustomerSegmentsLifecycle_URL); 
		System.out.println("Below line is for the URL = "+CustomerSegmentsLifecycle_URL);
		set.verifyLogs();
		
		getCustomerSegmentURL();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Segment(s)'])[2]")).click();          // CustomerSegments_Segments
		String CustomerSegments_Segments = driver.getCurrentUrl(); 
		driver.get("view-source:"+CustomerSegments_Segments);    
		System.out.println("Below line is for the URL = "+CustomerSegments_Segments);
		set.verifyLogs();
		
		driver.findElement(By.xpath("(//*[text() = 'Lifecycle(s)'])[2]")).click();          // CustomerSegments_Lifecycle
		String CustomerSegments_Lifecycle = driver.getCurrentUrl(); 
		driver.get("view-source:"+CustomerSegments_Lifecycle);    
		set.verifyLogs();
		
		
		// Email Marketing
		
		getEmailMarketingURL();
		Thread.sleep(1500);
		String EmailMarketingOverview_URL = driver.getCurrentUrl();            // EmailMarketingOverview_URL
		driver.get("view-source:"+EmailMarketingOverview_URL); 
		System.out.println("Below line is for the URL = "+EmailMarketingOverview_URL);
		set.verifyLogs();
	
		getEmailMarketingURL();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Campaigns'])[2]")).click();          // EmailMarketing_Campaigns
		String EmailMarketingCampaigns_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+EmailMarketingCampaigns_URL);    
		System.out.println("Below line is for the URL = "+EmailMarketingCampaigns_URL);
		set.verifyLogs();
		
		getEmailMarketingURL();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Suppression List'])[2]")).click();          // EmailMarketing_Suppression
		String EmailMarketingSuppression_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+EmailMarketingSuppression_URL);    
		System.out.println("Below line is for the URL = "+EmailMarketingSuppression_URL);
		set.verifyLogs();
		
		
		// Mobile Push
		getMobilePushURL();
		Thread.sleep(1500);
		String MobilePush_URL = driver.getCurrentUrl();            // MobilePush_URL
		driver.get("view-source:"+MobilePush_URL); 
		System.out.println("Below line is for the URL = "+MobilePush_URL);
		set.verifyLogs();

		getMobilePushURL();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Advance Push '])")).click();          // MobilePushAdvance
		String MobilePushAdvance_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+MobilePushAdvance_URL);    
		System.out.println("Below line is for the URL = "+MobilePushAdvance_URL);
		set.verifyLogs();
		
		// Onsite Marketing
	
		getOnsiteMarketingURL();
		Thread.sleep(1500);
		String Onsite_CTA = driver.getCurrentUrl();            // OnsiteCTA
		driver.get("view-source:"+Onsite_CTA); 
		System.out.println("Below line is for the URL = "+Onsite_CTA);
		set.verifyLogs();
		
		getOnsiteMarketingURL();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Email Signup & Lead Capture'])[2]")).click();          // OnsiteEmail
		String OnsiteEmail_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+OnsiteEmail_URL);    
		System.out.println("Below line is for the URL = "+OnsiteEmail_URL);
		set.verifyLogs();
	
		getOnsiteMarketingURL();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'MOBILE LEAD CAPTURE'])[2]")).click();          // OnsiteMobile
		String OnsiteMobile_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+OnsiteMobile_URL);    
		System.out.println("Below line is for the URL = "+OnsiteMobile_URL);
		set.verifyLogs();
		
		
		
		// SMS Marketing
		
		getSMSMarketingURL();                                            // SMSCampaignsBroadcast
		Thread.sleep(1500);
		String SMSCampaignsBroadcast_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+SMSCampaignsBroadcast_URL);    
		System.out.println("Below line is for the URL = "+SMSCampaignsBroadcast_URL);
		set.verifyLogs();
		
		
		getSMSMarketingURL();                                           
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'One To One'])[1]")).click();          // SMSCampaignsOnetoOne
		String SMSCampaignsOneToOne_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+SMSCampaignsOneToOne_URL);    
		System.out.println("Below line is for the URL = "+SMSCampaignsOneToOne_URL);
		set.verifyLogs();
		
		
		getSMSMarketingURL();                                           
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Recurring'])[1]")).click();          // SMSCampaignsRecurring
		String SMSCampaignsRecurring_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+SMSCampaignsRecurring_URL);    
		System.out.println("Below line is for the URL = "+SMSCampaignsRecurring_URL);
		set.verifyLogs();
		
		
		getSMSMarketingURL();                                           
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Overview'])[2]")).click();          // SMSOverview_URL
		String SMSOverview_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+SMSOverview_URL);    
		System.out.println("Below line is for the URL = "+SMSOverview_URL);
		set.verifyLogs();
		
		getSMSMarketingURL();                                           
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Suppression List'])[2]")).click();          // SMSSuppressionDND_URL
		String SMSSuppressionDND_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+SMSSuppressionDND_URL);    
		System.out.println("Below line is for the URL = "+SMSSuppressionDND_URL);
		set.verifyLogs();
		
		
		getSMSMarketingURL();                                           
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Suppression List'])[2]")).click();   
		driver.findElement(By.xpath("(//*[text() = 'Blacklist'])[1]")).click();          // SMSSuppressionBlacklist_URL
		String SMSSuppressionBlacklist_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+SMSSuppressionBlacklist_URL);    
		System.out.println("Below line is for the URL = "+SMSSuppressionBlacklist_URL);
		set.verifyLogs();
		
		
		getSMSMarketingURL();                                           
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Suppression List'])[2]")).click();   
		driver.findElement(By.xpath("(//*[text() = 'Invalid Subscriber'])[1]")).click();          // SMSSuppressionInvalid_URL
		String SMSSuppressionInvalid_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+SMSSuppressionInvalid_URL);    
		System.out.println("Below line is for the URL = "+SMSSuppressionInvalid_URL);
		set.verifyLogs();
		
		
		
		
		//Cart Recovery
		
		getCartRecoveryURL();                                                // CartRecoveryOverview_URL
		Thread.sleep(1500);
		String CartRecoveryOverview_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+CartRecoveryOverview_URL);    
		System.out.println("Below line is for the URL = "+CartRecoveryOverview_URL);
		set.verifyLogs();

		getCartRecoveryURL();                                               
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Campaigns'])[2]")).click();           // CartRecoveryCampaigns_URL
		String CartRecoveryCampaigns_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+CartRecoveryCampaigns_URL);    
		System.out.println("Below line is for the URL = "+CartRecoveryCampaigns_URL);
		set.verifyLogs();


		
		// Browser Push
		
		getBrowserPushURL();                                          // BrowserPushOverview_URL
		Thread.sleep(1500);
		String BrowserPushOverview_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+BrowserPushOverview_URL);    
		System.out.println("Below line is for the URL = "+BrowserPushOverview_URL);
		set.verifyLogs();

		getBrowserPushURL();                                         
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Campaigns'])[2]")).click();           // BrowserPushCampaignsSubscricption_URL
		String BrowserPushCampaignsSubscricption_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+BrowserPushCampaignsSubscricption_URL);    
		System.out.println("Below line is for the URL = "+BrowserPushCampaignsSubscricption_URL);
		set.verifyLogs();
	
		getBrowserPushURL();                                         
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Campaigns'])[2]")).click();  
		driver.findElement(By.xpath("(//*[text() = 'Broadcast'])[1]")).click();           // BrowserPushCampaignsBroadcast_URL
		String BrowserPushCampaignsBroadcast_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+BrowserPushCampaignsBroadcast_URL);    
		System.out.println("Below line is for the URL = "+BrowserPushCampaignsBroadcast_URL);
		set.verifyLogs();
		
		getBrowserPushURL();                                         
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Subscribed Users'])[2]")).click();           // BrowserPushSubscribedUsers_URL
		String BrowserPushSubscribedUsers_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+BrowserPushSubscribedUsers_URL);    
		System.out.println("Below line is for the URL = "+BrowserPushSubscribedUsers_URL);
		set.verifyLogs();
		
		
		
		
		
		// Contact DB
		
		
		getContactDatabaseURL();                                      
		Thread.sleep(1500);          // ContactDBContacts_URL
		String ContactDBContacts_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+ContactDBContacts_URL);    
		System.out.println("Below line is for the URL = "+ContactDBContacts_URL);
		set.verifyLogs();
		
		
		getContactDatabaseURL();                                      
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[@href = '/users/segment/tags'])[2]")).click();      // ContactDBTags_URL
		String ContactDBTags_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+ContactDBTags_URL);    
		System.out.println("Below line is for the URL = "+ContactDBTags_URL);
		set.verifyLogs();
		

		
		// Product Catalog
		
		

		getProductCatalogURL();                                   
		Thread.sleep(1500);          // ProductCatalogCategories_URL
		String ProductCatalogCategories_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+ProductCatalogCategories_URL);    
		System.out.println("Below line is for the URL = "+ProductCatalogCategories_URL);
		set.verifyLogs();
		
		
		getProductCatalogURL();                                   
		Thread.sleep(1500);        
		driver.findElement(By.xpath("(//*[@href = '/products/product-brands'])[2]")).click();      // ProductCatalogBrands_URL																// ProductCatalogBrands_URL
		String ProductCatalogBrands_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+ProductCatalogBrands_URL);    
		System.out.println("Below line is for the URL = "+ProductCatalogBrands_URL);
		set.verifyLogs();
		
		getProductCatalogURL();                                   
		Thread.sleep(1500);        
		driver.findElement(By.xpath("(//*[@href = '/products/product-overview'])[2]")).click();      // ProductCatalogProducts_URL																// ProductCatalogBrands_URL
		String ProductCatalogProducts_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+ProductCatalogProducts_URL);    
		System.out.println("Below line is for the URL = "+ProductCatalogProducts_URL);
		set.verifyLogs();
		
		getProductCatalogURL();                                   
		Thread.sleep(1500);        
		driver.findElement(By.xpath("(//*[@href = '/products/product-orders'])[2]")).click();      // ProductCatalogOrders_URL																// ProductCatalogBrands_URL
		String ProductCatalogOrders_URL = driver.getCurrentUrl(); 
		driver.get("view-source:"+ProductCatalogOrders_URL);    
		System.out.println("Below line is for the URL = "+ProductCatalogOrders_URL);
		set.verifyLogs();
		
	
		// Ideas & Docs
		
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		String IdeasDocsAPIJSMultipage_URL = driver.getCurrentUrl(); 					// IdeasDocsAPIJSMultipage_URL
		driver.get("view-source:"+IdeasDocsAPIJSMultipage_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPIJSMultipage_URL);
		set.verifyLogs();
		
	
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[contains(@href,'api-singlepage')])[1]")).click();  // IdeasDocsAPIJSSinglepage_URL      
		String IdeasDocsAPIJSSinglepage_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsAPIJSSinglepage_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPIJSSinglepage_URL);
		set.verifyLogs();
		
		
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[contains(@href,'/ideas/api-http-v2')])[1]")).click();  			// IdeasDocsAPIHTTP_URL      
		String IdeasDocsAPIHTTP_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsAPIHTTP_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPIHTTP_URL);
		set.verifyLogs();
		
	
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[contains(@href,'/ideas/api-curl-v2')])[1]")).click();  // IdeasDocsAPICurl_URL      
		String IdeasDocsAPICurl_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsAPICurl_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPICurl_URL);
		set.verifyLogs();
		
	
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[contains(@href,'/ideas/read-api')])[1]")).click();  // IdeasDocsAPIReadAPI_URL      
		String IdeasDocsAPIReadAPI_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsAPIReadAPI_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPIReadAPI_URL);
		set.verifyLogs();
		
	
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[contains(@href,'/ideas/android')])[1]")).click();  // IdeasDocsAPIAndroid_URL      
		String IdeasDocsAPIAndroid_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsAPIAndroid_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPIAndroid_URL);
		set.verifyLogs();
		
	
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[contains(@href,'/ideas/ios')])[1]")).click();  // IdeasDocsAPIiOS_URL      
		String IdeasDocsAPIiOS_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsAPIiOS_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPIiOS_URL);
		set.verifyLogs();
		
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[text() = 'Resources'])[2]")).click();  // IdeasDocsResources_URL      
		String IdeasDocsResources_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsResources_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsResources_URL);
		set.verifyLogs();
		
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[text() = 'Plugins & Extensions'])[2]")).click();  // IdeasDocsPlugins_URL      
		String IdeasDocsPlugins_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsPlugins_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsPlugins_URL);
		set.verifyLogs();
	
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[text() = 'API Key'])[3]")).click();  // IdeasDocsAPIKey_URL      
		String IdeasDocsAPIKey_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsAPIKey_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsAPIKey_URL);
		set.verifyLogs();
	
	
		getIdeasDocsURL();                                	
		Thread.sleep(1500);         
		driver.findElement(By.xpath("(//*[text() = 'Glossary'])[2]")).click();  // IdeasDocsGlossary_URL      
		String IdeasDocsGlossary_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+IdeasDocsGlossary_URL);    
		System.out.println("Below line is for the URL = "+IdeasDocsGlossary_URL);
		set.verifyLogs();

	// Now add code for Settings page	 
		
	
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // TeamMembersURL dropdown
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.team_members_click();
		String TeamMembers_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+TeamMembers_URL);    
		System.out.println("Below line is for the URL = "+TeamMembers_URL);
		set.verifyLogs();
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // TeamMembersActivity_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.team_members_activity_click();
		String TeamMembersActivity_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+TeamMembersActivity_URL);    
		System.out.println("Below line is for the URL = "+TeamMembersActivity_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // ReferralExclusion_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.referal_exclusion_click();
		String ReferralExclusion_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+ReferralExclusion_URL);    
		System.out.println("Below line is for the URL = "+ReferralExclusion_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // RFMAnalysis_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.rfm_click();
		String RFMAnalysis_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+RFMAnalysis_URL);    
		System.out.println("Below line is for the URL = "+RFMAnalysis_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // LookupWindow_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.lookup_window_click();
		String LookupWindow_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+LookupWindow_URL);    
		System.out.println("Below line is for the URL = "+LookupWindow_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // AccountSettingsAPIKey_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.account_setting_click();
		String AccountSettings_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+AccountSettings_URL);    
		System.out.println("Below line is for the URL = "+AccountSettings_URL);
		set.verifyLogs();
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // AccountSettingsTimezone_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.account_setting_click();
		Thread.sleep(2000);
		as.AS_TimeZoneClick();
		String TimeZone_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+TimeZone_URL);    
		System.out.println("Below line is for the URL = "+TimeZone_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // AccountSettingsChangeLanguage_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.account_setting_click();
		Thread.sleep(2000);
		as.AS_ChangeLanguageClick();
		String ChangeLanguage_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+ChangeLanguage_URL);    
		System.out.println("Below line is for the URL = "+ChangeLanguage_URL);
		set.verifyLogs();
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // AccountSettingsCurrencyFormat_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.account_setting_click();
		Thread.sleep(2000);
		as.AS_CurrencyFormatClick();
		String CurrencyFormat_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+CurrencyFormat_URL);    
		System.out.println("Below line is for the URL = "+CurrencyFormat_URL);
		set.verifyLogs();
		

		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // AccountSettingsOTP_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.account_setting_click();
		Thread.sleep(2000);
		as.AS_OTPClick();
		String OTP_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+OTP_URL);    
		System.out.println("Below line is for the URL = "+OTP_URL);
		set.verifyLogs();
		
		//Setting on Settings page
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // Setting_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.SettingClick();;
		String Setting_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+Setting_URL);    
		System.out.println("Below line is for the URL = "+Setting_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // UserRole_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.user_role_click();
		String UserRole_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+UserRole_URL);    
		System.out.println("Below line is for the URL = "+UserRole_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // UserImport_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.user_import__click();
		String UserImport_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+UserImport_URL);    
		System.out.println("Below line is for the URL = "+UserImport_URL);
		set.verifyLogs();
		
	
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // BounceList_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.bounce_list_import_click();
		String BounceList_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+BounceList_URL);    
		System.out.println("Below line is for the URL = "+BounceList_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // UnsubscribeImport_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.unsubscribe_import_click();
		String UnsubscribeImport_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+UnsubscribeImport_URL);    
		System.out.println("Below line is for the URL = "+UnsubscribeImport_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // OrderImport_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.order_transactions_import_click();
		String OrderImport_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+OrderImport_URL);    
		System.out.println("Below line is for the URL = "+OrderImport_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // SpamImport_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.spam_complaints_import_click();
		String SpamImport_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+SpamImport_URL);    
		System.out.println("Below line is for the URL = "+SpamImport_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // SMSSuppressionImport_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.sms_suppression_import_click();
		String SMSSuppressionImport_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+SMSSuppressionImport_URL);    
		System.out.println("Below line is for the URL = "+SMSSuppressionImport_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // OrderPropertySchema_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.oder_pp_schema_click();
		String OrderPropertySchema_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+OrderPropertySchema_URL);    
		System.out.println("Below line is for the URL = "+OrderPropertySchema_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // UserPropertySchema_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.user_pp_schema_click();
		String UserPropertySchema_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+UserPropertySchema_URL);    
		System.out.println("Below line is for the URL = "+UserPropertySchema_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // EventSchema_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.event_schema_click();
		String EventSchema_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+EventSchema_URL);    
		System.out.println("Below line is for the URL = "+EventSchema_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // TimeIntervalEmails_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.time_bw_emails_click();
		String TimeIntervalEmails_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+TimeIntervalEmails_URL);    
		System.out.println("Below line is for the URL = "+TimeIntervalEmails_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // TimeIntervalCartEmails_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.time_bw_cart_emails_click();
		String TimeIntervalCartEmails_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+TimeIntervalCartEmails_URL);    
		System.out.println("Below line is for the URL = "+TimeIntervalCartEmails_URL);
		set.verifyLogs();
		

		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // EmailSpamInfo_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.email_spam_info_click();
		String EmailSpamInfo_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+EmailSpamInfo_URL);    
		System.out.println("Below line is for the URL = "+EmailSpamInfo_URL);
		set.verifyLogs();
		
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // EmailAddSenders_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.email_add_remove_verified_senders_click();
		String EmailAddSenders_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+EmailAddSenders_URL);    
		System.out.println("Below line is for the URL = "+EmailAddSenders_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // EmailGatewayIntegration_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.email_gateway_integration_click();
		String EmailGatewayIntegration_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+EmailGatewayIntegration_URL);    
		System.out.println("Below line is for the URL = "+EmailGatewayIntegration_URL);
		set.verifyLogs();
		
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // MailchimpSettings_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.mailchimp_server_setting_click();
		String MailchimpSettings_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+MailchimpSettings_URL);    
		System.out.println("Below line is for the URL = "+MailchimpSettings_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // SMSGatewayIntegration_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.sms_gateway_integration_click();
		String SMSGatewayIntegration_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+SMSGatewayIntegration_URL);    
		System.out.println("Below line is for the URL = "+SMSGatewayIntegration_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // SMSAddVerifiedSenders_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.sms_add_remove_verified_senders_click();
		String SMSAddVerifiedSenders_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+SMSAddVerifiedSenders_URL);    
		System.out.println("Below line is for the URL = "+SMSAddVerifiedSenders_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // TimeBetweenSMS_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.time_bw_sms_click();
		String TimeBetweenSMS_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+TimeBetweenSMS_URL);    
		System.out.println("Below line is for the URL = "+TimeBetweenSMS_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // MobileServices_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.mobile_services_click();
		String MobileServices_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+MobileServices_URL);    
		System.out.println("Below line is for the URL = "+MobileServices_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // MobileTimeBetweenGCMPush_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.mobile_time_bw_GCM();
		String MobileTimeBetweenGCMPush_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+MobileTimeBetweenGCMPush_URL);    
		System.out.println("Below line is for the URL = "+MobileTimeBetweenGCMPush_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // AdvancePush_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.advance_push_click();
		String AdvancePush_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+AdvancePush_URL);    
		System.out.println("Below line is for the URL = "+AdvancePush_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // Apn_Gcm_nestedProperties_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.apn_gcm_nestedproperties_click();
		String Apn_Gcm_nestedProperties_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+Apn_Gcm_nestedProperties_URL);    
		System.out.println("Below line is for the URL = "+Apn_Gcm_nestedProperties_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // Geofencing_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.add_geofencing_click();
		String Geofencing_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+Geofencing_URL);    
		System.out.println("Below line is for the URL = "+Geofencing_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // FbSetup_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.fb_setup_click();
		String FbSetup_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+FbSetup_URL);    
		System.out.println("Below line is for the URL = "+FbSetup_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // FbMarketing_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.fb_mktg_click();
		String FbMarketing_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+FbMarketing_URL);    
		System.out.println("Below line is for the URL = "+FbMarketing_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // Recommendation_Setup_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.recommendation_setup_click();
		String Recommendation_Setup_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+Recommendation_Setup_URL);    
		System.out.println("Below line is for the URL = "+Recommendation_Setup_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // Coupon_Lists_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.coupons_click();
		String Coupon_Lists_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+Coupon_Lists_URL);    
		System.out.println("Below line is for the URL = "+Coupon_Lists_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // BrowserServices_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.browser_services_click();
		String BrowserServices_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+BrowserServices_URL);    
		System.out.println("Below line is for the URL = "+BrowserServices_URL);
		set.verifyLogs();
		
		
		getHomeURL();
		driver.findElement(By.xpath("(//*[@class = 'dropdown'])[1]")).click();     // Browser_timeinterval_URL
		homeobj.settings_click();
		Thread.sleep(1500); 
		as.browser_timeinterval_click();
		String Browser_timeinterval_URL = driver.getCurrentUrl(); 					
		driver.get("view-source:"+Browser_timeinterval_URL);    
		System.out.println("Below line is for the URL = "+Browser_timeinterval_URL);
		set.verifyLogs();
		
		
		
		
	}

	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

	
}
