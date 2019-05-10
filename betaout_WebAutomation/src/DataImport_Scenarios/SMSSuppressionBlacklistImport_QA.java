package DataImport_Scenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_Homepage;
import DataImporting_Pages.SMSSuppressionImporting;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class SMSSuppressionBlacklistImport_QA {

	// Important - Need to change actualNumer as per the csv to be uploaded
	
public static WebDriver driver;
	
	public void getSMSBlacklistData()
{
	driver.get("https://qa.betaout.in/sms/suppression-list/blacklist");
}


	@Test
	
	public void SMSSuppressionImport() throws Exception
	
	{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		Properties prop = set.loadPropertyFile();

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
	
		Thread.sleep(2500);
		Account_Settings settings_obj = new Account_Settings(driver);
		settings_obj.user_import__click();
		Thread.sleep(2000);
		
		SMSSuppressionImporting ui = new SMSSuppressionImporting(driver);
		ui.SMSSuppressionTabClick();
		
		Thread.sleep(5000);
		ui.AddImportClick();
		
		Thread.sleep(3000);
	
		String path = set.uploadSMSSuppressionListCSV();
		System.out.println(path);
		ui.ChooseFileClick(path);
		
	//	ui.ChooseFileClick(prop.getProperty("SMSSuppressionBlacklistImport_FilePath"));
		
		Thread.sleep(5000);
		
		ui.UploadFileClick();
		Thread.sleep(3000);
		
		ui.SelectPropertyGroup1(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyGroup1"));
		ui.SelectPropertyvalue1(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyValue1"));
		ui.SelectPropertyGroup2(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyGroup2"));
		ui.SelectPropertyvalue2(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyValue2"));
		ui.SelectPropertyGroup3(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyGroup3"));
		ui.SelectPropertyvalue3(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyValue3"));        
		ui.SelectPropertyGroup4(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyGroup4"));
		ui.SelectPropertyvalue4(prop.getProperty("SMSSuppressionBlacklist_SelectPropertyValue4"));
		
	  
		Thread.sleep(3000);
		
		ui.startImporting();
	
		Thread.sleep(5000);
		
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		
		ui.printFileInfo();
		Thread.sleep(3000);
		
		// Go to SMS SuppressionList > Blacklist URL
		
		getSMSBlacklistData();
		
		String Number = driver.findElement(By.xpath("//*[contains(@class,'selectable')]/td[1]")).getText();
		System.out.println("Blacklist Number = "+Number);

		String actualNumer = "919990990993";                  // Needs to be updated as per csv uploaded
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualNumer, Number);
		
		
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}	
