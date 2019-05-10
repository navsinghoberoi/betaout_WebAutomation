package SMSMarketingScenarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SMSMarketingPages.SMSMarketing_Broadcast_Active;
import SMSMarketingPages.SMSMarketing_CampaignType;
import SMSMarketingPages.SMSMarketing_Design;
import SMSMarketingPages.SMSMarketing_Homepage;
import SMSMarketingPages.SMSMarketing_Recurring_Active;
import SMSMarketingPages.SMSMarketing_Target;
import common_Classes.*;
import promocode_Pages.Onsite_CreateCampaign;
import promocode_Pages.Onsite_Select_Template;

public class Test1 {

	public static WebDriver driver;

	@Test
	public void SMS_OneToOneCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Overview");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://pre-prod-102.betaout.com/");
	
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("sjs22858@gmail.com");
		obj.upswd("simranjeet");
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
				
		driver.get("https://pre-prod-102.betaout.com/email/choose-template/nv/c1/14/cTypeId/18881");
		
		// apply code for wait
			By locator = By.xpath("(//*[@data-tid = '389'])");
			
			
	//	set.isElementPresnt(driver, "(//*[@data-tid = '389'])", 2).click();
		
			set.isElementPresnt(driver, locator, 2).click();
		
		
		
		
		
	}

}