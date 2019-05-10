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
public class CTAPopupORConditions {
	
	public static WebDriver driver;

	@Test
	public void CallToActionPopupORConditions() throws Exception
	
	{
		System.out.println("Scenario : Onsite Marketing > Check OR Conditions > Target page - Visitors only and specific URL, Login on website and go to specific URL");
		
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
		String name = "Auto_orconditions"+" "+System.currentTimeMillis();
		calltoaction_obj.name(name);
		Thread.sleep(1500);
		calltoaction_obj.save_click();
		Thread.sleep(3000);
		
		Onsite_Select_Template template_obj = new Onsite_Select_Template(driver);
		template_obj.CTAPopuptemplateClick();    // Select popup template
		
		// Explicit wait for Save and Next after selecting template
		
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Save & Next']")));
	
		Thread.sleep(8000);
		
		Onsite_Design design = new Onsite_Design(driver);
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot 1 is taken successfully");
		
        design.save_next();
		Thread.sleep(12000);
	
		Onsite_Target_Page target_obj = new Onsite_Target_Page(driver);
		
		SoftAssert s_assert = new SoftAssert();
		
		// Verify that AND condition is displayed
		
		String ANDtext = target_obj.printANDtext();
		s_assert.assertEquals(ANDtext, "ALL");
		s_assert.assertAll();
		System.out.println("Assertion of AND text is completed");
		
		target_obj.ChooseCondition_ToggleClick();            // To Enable OR Condition
		Thread.sleep(1500);
		
		target_obj.Target_Users_click();
		Thread.sleep(1500);
		target_obj.TU_VisitorsOnly_click();
		Thread.sleep(1500);
		target_obj.TU_VO_AllVisiters_click();
		Thread.sleep(1500);
		target_obj.Save_click();
		Thread.sleep(5000);
		System.out.println("Clicked on Save button on Target page");
		
		// Verify that OR condition is displayed
	
		String ORtext = target_obj.printORtext();
		s_assert.assertEquals(ORtext, "ANY ONE");
		s_assert.assertAll();
		System.out.println("Assertion of OR text is completed");
		
		target_obj.Target_Pages_click();
		Thread.sleep(1500);
		String weburl = "CTApopupcheckor";
		target_obj.TP_SpecificURL_click(weburl);           // enter url
		Thread.sleep(3000);
		target_obj.SaveAndNext_click();
		Thread.sleep(9000);
		
		Onsite_Activepage active_obj = new Onsite_Activepage(driver);
		active_obj.Active_click();
		active_obj.Save_click();
		Thread.sleep(9000);
		
		// Assert name of campaign
		
		String ActiveInstanceName = driver.findElement(By.xpath("(//a[@class = 'camp-name'])[1]")).getText();
		
		s_assert.assertEquals(ActiveInstanceName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");

		Thread.sleep(6000);
			
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
			
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
		
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./Screenshots/"+this.getClass()+System.currentTimeMillis()+".png"));
		
		System.out.println("Screenshot 2 is taken successfully");

		
		// Switch to iframe and check onsite instance is displayed or not
		
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total number of iframes on specific URL = "+size);
		
		boolean isDisplayed;
		if(size==0)
		{
			System.out.println("FAIL, i.e. Total number of frames are = 0");
			isDisplayed =  false;
				}
		
		else
			
		{
			System.out.println("PASS, i.e.Total number of frames are  = "+size);
			System.out.println("Onsite instance is being displayed because 1 condition (out of all) is met from Target Page");
			isDisplayed =  true;
				}
		
		
		s_assert.assertEquals(isDisplayed, true);
		System.out.println("Assertion for the presence of iframe is done successfully");
		
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
		
		calltoaction_obj.InactiveInstanceClick();
		Thread.sleep(5000);
		
		s_assert.assertAll();

	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
	

}
