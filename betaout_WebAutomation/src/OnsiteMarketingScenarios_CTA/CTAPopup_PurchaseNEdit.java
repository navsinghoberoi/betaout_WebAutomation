package OnsiteMarketingScenarios_CTA;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_Homepage;
import OnsiteMarketingPages.Onsite_CreateCampaign;
import OnsiteMarketingPages.Onsite_Design;
import OnsiteMarketingPages.Onsite_Select_Template;
import OnsiteMarketingPages.Onsite_Target_Page;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Onsite_Activepage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class CTAPopup_PurchaseNEdit {

	public static WebDriver driver;

	// Before running scenario, make changes on line number - 59

	@Test
	public void CallToActionPopupPurchaseAndEdit() throws Exception

	{
		System.out.println("Scenario : Onsite Marketing > CTAPopupTemplate  - Add Short URL > Purchase > Compare Stats and Counts > Edit Campaign");

		Setup_class set = new Setup_class(driver);

		Properties prop = set.loadPropertyFile();

		driver = set.setup();
		set.getQAURL();

		Loginpage obj = new Loginpage(driver);

		obj.loginbutton();
		obj.uname(set.getNavpreetQAUsername());
		obj.upswd(set.getNavpreetQAPassword());
		obj.ulogin();
		// Add code to select account
				set.selectAccountNav();
		System.out.println("User has logged in successfully");

		Homepage onsite_obj = new Homepage(driver);
		onsite_obj.onsite_click();

		Onsite_CreateCampaign calltoaction_obj = new Onsite_CreateCampaign(driver);

		calltoaction_obj.PrintNameOfFields();

		calltoaction_obj.createcampaign_click();

		String name = "Auto_ctapopuppurchase" + " " + System.currentTimeMillis();
		calltoaction_obj.name(name);
		Thread.sleep(1500);
		calltoaction_obj.save_click();
		Thread.sleep(3000);

		Onsite_Select_Template template_obj = new Onsite_Select_Template(driver);
		template_obj.CTAPopuptemplateClick(); // Select popup template

		// Explicit wait for Save and Next after selecting template

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Save & Next']")));

		Thread.sleep(8000);

		Onsite_Design design = new Onsite_Design(driver);

		Thread.sleep(2000);

		// Add Code For Short URL

		driver.switchTo().frame(driver.findElement(design.CTAButtonIframe));
		design.CTAButtonClickOnDesign();
		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		design.CTATargetURL(prop.getProperty("Onsite_ShortURL"));

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/" + this.getClass() + System.currentTimeMillis() + ".png"));

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
		String weburl = "CTAPopupPurchase";
		target_obj.TP_SpecificURL_click(weburl); // enter url
		Thread.sleep(3000);
		target_obj.SaveAndNext_click();
		Thread.sleep(8000);

		Onsite_Activepage active_obj = new Onsite_Activepage(driver);
		active_obj.Active_click();
		active_obj.Save_click();
		Thread.sleep(9000);

		// Assert name of campaign

		String ActiveInstanceName = driver.findElement(By.xpath("(//a[@class = 'camp-name'])[1]")).getText();
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(ActiveInstanceName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");

		Thread.sleep(6000);

		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1)); // switches to first tab

		String URL = set.getWoocommerceOneURL();

		// Add code to login on website

		CartRecovery_Homepage carthome_obj = new CartRecovery_Homepage(driver);

		driver.findElement(carthome_obj.WoocommerceAccount_MyAccount).click(); // My Account
																			
		Thread.sleep(2000);
		driver.findElement(carthome_obj.WoocommerceAccount_Username).sendKeys(prop.getProperty("GmailWoocommerceOneUsername"));
		driver.findElement(carthome_obj.WoocommerceAccount_Password).sendKeys(prop.getProperty("GmailWoocommerceOnePassword"));

		driver.findElement(carthome_obj.WoocommerceAccount_Login).click();
		Thread.sleep(3000);

		driver.get(URL + "/?" + weburl);

		Thread.sleep(12000);

		File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1,new File("./Screenshots/" + this.getClass() + System.currentTimeMillis() + ".png"));

		System.out.println("Screenshot 2 is taken successfully");

		// Switch to iframe

		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'iframePopup')]")));
		String PopupText = driver.findElement(By.xpath("(//*[@class = 'headp_1'])")).getText();
		System.out.println(PopupText);

		s_assert.assertEquals("HEADPHONES", PopupText);

		System.out.println("Popup is present on the URL");

		Thread.sleep(5000);

		// Click on CTA button and verify Short URL

		design.CTAButtonClickOnDesign();
		Thread.sleep(5000);
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of tabs1 = " + tabs1.size());

		driver.switchTo().window(tabs1.get(1)); // switches to first tab

		String NewURL = driver.getCurrentUrl();
		driver.get(NewURL);

		System.out.println("URL opened on click of CTA Button = " + NewURL);

		s_assert.assertEquals(prop.getProperty("Onsite_ShortURL"), NewURL);
		System.out.println("Assertion of Short URL is done successfully");

		// Purchase product on Woocommerce 

		driver.findElement(carthome_obj.WoocommerceAccount_Home).click(); // Home

		driver.findElement(carthome_obj.WoocommerceAccount_AddToCart).click(); // Add
																				// to
																				// cart
		Thread.sleep(3000);

		driver.findElement(carthome_obj.WoocommerceAccount_ViewCart).click();

		Thread.sleep(3000);

		driver.findElement(carthome_obj.WoocommerceAccount_ProceedToCheckout).click(); // Proceed
																						// to
																						// Checkout
		Thread.sleep(2000);

		driver.findElement(carthome_obj.WoocommerceAccount_PlaceOrder).click();
		Thread.sleep(2000);

		// Verify Stats and Counts and Inactive instance once the desired action is captured on the integrated website

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);

		Thread.sleep(3000);

		driver.switchTo().window(tabs.get(0));

		Thread.sleep(90000); // Wait for 1 min
		 
		driver.navigate().refresh();

		String ViewCounts = calltoaction_obj.printViewCounts();
		String ClickedCounts = calltoaction_obj.printClickCounts();
		String ConversionCounts = calltoaction_obj.printConversionCounts();
		String RevenueCounts = calltoaction_obj.printRevenueCounts();

		// Print Clicks and Views data as per Visitor and Contact
		
		String ViewCounts_Visitor = ViewCounts.split("\n")[0];
		String ViewCounts_Contact = ViewCounts.split("\n")[1];
		String ClickedCounts_Visitor = ClickedCounts.split("\n")[0];
		String ClickedCounts_Contact = ClickedCounts.split("\n")[1];       // Use this data below
		
		
		System.out.println("Campaign Count for Viewed = " + ViewCounts);
		System.out.println("Campaign Count for Clicked = " + ClickedCounts);
		System.out.println("Campaign Count for Conversion = " + ConversionCounts);
		System.out.println("Campaign Count for Revenue = " + RevenueCounts);

		s_assert.assertEquals(ViewCounts, "1");
		s_assert.assertEquals(ClickedCounts, "1");
		s_assert.assertEquals(ConversionCounts, "1");
	//	s_assert.assertEquals(RevenueCounts, "INR 2,250,000");

		System.out.println("Assertion of Counts of the campaign is done successfully");

		Thread.sleep(2000);

		calltoaction_obj.StatsClick();

		Thread.sleep(10000);

		String StatsDate = calltoaction_obj.printStatsDate();
		String StatsViewed = calltoaction_obj.printStatsViewed();
		String StatsClicked = calltoaction_obj.printStatsClicked();
		String StatsConversion = calltoaction_obj.printStatsConversion();
		String StatsGMV = calltoaction_obj.printStatsGMV();

		System.out.println("Stats :: Date for the Campaign = " + StatsDate);
		System.out.println("Stats :: Viewed Counts for the Campaign = " + StatsViewed);
		System.out.println("Stats :: Clicked Count for the Campaign = " + StatsClicked);
		System.out.println("Stats :: Conversion for the Campaign = " + StatsConversion);
		System.out.println("Stats :: GMV for the Campaign = " + StatsGMV);

		s_assert.assertEquals(StatsViewed, "1");
		s_assert.assertEquals(StatsClicked, "1");
		s_assert.assertEquals(StatsConversion, "1");
	//	s_assert.assertEquals(StatsGMV, "2250000");

		System.out.println("Assertion of Stats of the campaign is done successfully");

		driver.navigate().back();

	/*	calltoaction_obj.InactiveInstanceClick();
		Thread.sleep(5000);*/

		String url = driver.getCurrentUrl();
		System.out.println("URL currently opened is " + url);

		s_assert.assertAll();

		// Edit campaign and enable Visitors only on Target page
		Thread.sleep(2000);
		calltoaction_obj.EditClick();

		Thread.sleep(10000);

		design.save_next();

		Thread.sleep(12000);

		target_obj.Target_Users_click();
		Thread.sleep(1500);

		target_obj.TU_VisitorsOnly_click();
		Thread.sleep(1500);

		target_obj.TU_VO_AllVisiters_click();
		Thread.sleep(1500);
		
		target_obj.Save_click();
		Thread.sleep(5000);
		System.out.println("Clicked on Save button on Target page");
		target_obj.SaveAndExit_click();
		System.out.println("Clicked on Save and Exit button on Target page");
		Thread.sleep(5000);

		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		
		set.getWoocommerceOneURL();
		
		driver.get(URL + "/?" + weburl);
		
		// Find number of iframes on URL
		
		File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("./Screenshots/" + this.getClass() + System.currentTimeMillis() + ".png"));
		Thread.sleep(2000);
		
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total number of iframes on specific URL = "+size);
		
		boolean isDisplayed;
		if(size==0)
		{
			System.out.println("PASS, i.e. Total number of frames are = 0");
			isDisplayed =  true;
				}
		
		else
			
		{ System.out.println("FAIL, i.e.Total number of frames are greater than 0");	
			isDisplayed =  false;
				}
		
		
		s_assert.assertEquals(isDisplayed, true);
		System.out.println("Assertion for the presence of iframe is done successfully");
		
		Thread.sleep(2000);
		driver.switchTo().window(tabs1.get(0));
		
		calltoaction_obj.InactiveInstanceClick();
		Thread.sleep(5000);
		
		
		s_assert.assertAll();
	}

	/*
	 * @AfterMethod public void kill() { System.out.println(
	 * "Closing the browser now"); driver.quit();
	 * 
	 * 
	 * }
	 */

}
