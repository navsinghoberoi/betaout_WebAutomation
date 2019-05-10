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
import DataImporting_Pages.SpamComplaintsListImporting;
import DataImporting_Pages.UnsubscribeListImporting;
import DataImporting_Pages.UserImporting;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class UnsubscribeListImport_QA {

	
public static WebDriver driver;
	
	public void getunsubscribeEmailURL()
	{
		driver.get("https://qa.betaout.in/email/unsubscribers");
	}


	@Test
	
	public void UnsubscribeImport() throws Exception
	
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
		settings_obj.unsubscribe_import_click();
		Thread.sleep(2000);
		
		UnsubscribeListImporting ui = new UnsubscribeListImporting(driver);
	
		Thread.sleep(2000);
		ui.AddImportClick();
		
		Thread.sleep(3000);
		ui.ChooseFileClick();
		
		Thread.sleep(3000);
		
		String path = set.uploadUnsubscribeListCSV();
		System.out.println(path);
		ui.ChooseFileButton(path);

		ui.ChooseFileButton(prop.getProperty("UnsubscribeListImport_FilePath"));
		Thread.sleep(5000);
		
		ui.UploadFileClick();
		Thread.sleep(3000);
		
		Thread.sleep(5000);
		
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		
		ui.printFileInfo();
		
		// Open EMail > Suppression > Unsubscribe 
		
		getunsubscribeEmailURL();
		
		String unsubscribeEmail = driver.findElement(By.xpath(prop.getProperty("UnsubscribeEmailID"))).getText();
		System.out.println("Unsubscribe email address = "+unsubscribeEmail);
	
		String unsubscribeEmailTime = driver.findElement(By.xpath(prop.getProperty("UnsubscribeEmailIDTime"))).getText();
		System.out.println("Time of adding unsubscribe email address = "+unsubscribeEmailTime);

	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}