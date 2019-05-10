package DataImport_Scenarios;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import DataImporting_Pages.BounceListImporting;
import DataImporting_Pages.UserImporting;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class BounceListImport_QA {

	
public static WebDriver driver;
	
	public void getBouncedEmailURL()
	{
		driver.get("https://qa.betaout.in/email/bounce");
	}


	@Test
	
	public void BounceListImport() throws Exception
	
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
		settings_obj.bounce_list_import_click();
		Thread.sleep(2000);
		
		BounceListImporting ui = new BounceListImporting(driver);
	
		Thread.sleep(2000);
		ui.AddImportClick();
		
		Thread.sleep(3000);
		ui.ChooseFileClick();
		
		Thread.sleep(3000);
		
		String path = set.uploadBounceListImportCSV();
		System.out.println(path);
		ui.ChooseFileButton(path);
		
	//	ui.ChooseFileButton(prop.getProperty("BounceListImport_FilePath"));
		
		Thread.sleep(5000);
		
		ui.UploadFileClick();
		Thread.sleep(3000);
		
		Thread.sleep(5000);
		
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		
		ui.printFileInfo();
		
		// Open EMail > Suppression > Bounced 
		
		getBouncedEmailURL();
		
		String bouncedEmail = driver.findElement(By.xpath(prop.getProperty("BounceEmailID"))).getText();
		System.out.println("Bounced email address = "+bouncedEmail);
	
		String bouncedEmailTime = driver.findElement(By.xpath(prop.getProperty("BounceEmailIDTime"))).getText();
		System.out.println("Time of adding bounced email address = "+bouncedEmailTime);
	

	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}