package DataImport_Scenarios;

import java.io.File;
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
import DataImporting_Pages.UserImporting;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class SpamComplaintsListImport_TryDynamicPath {

	
public static WebDriver driver;
	
	public void getSpamComplaintsEmailURL()
	{
		driver.get("https://qa.betaout.in/email/spam");
	}


	@Test
	
	public void SpamImport() throws Exception
	
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
		
		SpamComplaintsListImporting ui = new SpamComplaintsListImporting(driver);
	
		driver.get("https://qa.betaout.in/import/upload-complained-email/");
		
		Thread.sleep(3000);
		ui.ChooseFileClick();
		Thread.sleep(3000);
		
		/*String opf = System.getProperty("user.dir");
		System.out.println(opf);
		File fp = new File(opf + "/Resources/valid_CSV.csv");
		System.out.println(fp.exists());
		System.out.println(fp.getAbsolutePath());
		String path = fp.getAbsolutePath();
		*/	
	
		//	ui.ChooseFileButton(prop.getProperty("SpamComplaintsListImport_FilePath"));
		
	/*	String path = set.uploadFileSpamComplaints();
		System.out.println(path);
	
		ui.ChooseFileButton(path);*/
		
		Thread.sleep(5000);
		
		ui.UploadFileClick();
		Thread.sleep(3000);
		
		Thread.sleep(5000);
		
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		
		ui.printFileInfo();
		
		// Open EMail > Suppression > Spam 
		
		getSpamComplaintsEmailURL();
		
		String spamEmail = driver.findElement(By.xpath(prop.getProperty("SpamEmailID"))).getText();
		System.out.println("Spam email address = "+spamEmail);
	
		String spamEmailTime = driver.findElement(By.xpath(prop.getProperty("SpamEmailIDTime"))).getText();
		System.out.println("Time of adding spam email address = "+spamEmailTime);

	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}