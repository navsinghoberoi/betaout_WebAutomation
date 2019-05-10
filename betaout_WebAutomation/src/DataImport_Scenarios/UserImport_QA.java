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

import DataImporting_Pages.UserImporting;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class UserImport_QA {

	
public static WebDriver driver;
	
	
	@Test
	
	public void UserImport() throws Exception
	
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
	//	driver.findElement(By.xpath(prop.getProperty("SelectAccount"))).click();
		
		System.out.println("User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		homeobj.accnt_click();
		
		homeobj.settings_click();
	
		Thread.sleep(2500);
		Account_Settings settings_obj = new Account_Settings(driver);
		settings_obj.user_import__click();
		Thread.sleep(2000);
		
		UserImporting ui = new UserImporting(driver);
	
		Thread.sleep(2000);
		ui.AddImportClick();
		
		Thread.sleep(3000);
		ui.ChooseFileClick();
		
		Thread.sleep(3000);
	
		String path = set.uploadUserImportCSV();
		System.out.println(path);
		ui.ChooseFileButton(path);
	
//		ui.ChooseFileButton(prop.getProperty("UserImport_FilePath"));
		Thread.sleep(5000);
		
		ui.UploadFileClick();
		Thread.sleep(3000);
		
		// Add tag
		String tagName = prop.getProperty("TagName") + System.currentTimeMillis();
		String tagDescription = prop.getProperty("TagDescription") + System.currentTimeMillis(); 	
		ui.addNewTag(tagName, tagDescription);
		
		Thread.sleep(3000);
		ui.selectTag(tagName);
		
		ui.enterImportName(prop.getProperty("ImportFileName") +System.currentTimeMillis());
		
		ui.SelectPropertyGroup1(prop.getProperty("SelectPropertyGroup1"));
		ui.SelectPropertyvalue1(prop.getProperty("SelectPropertyValue1"));         
		
		ui.SelectPropertyGroup2(prop.getProperty("SelectPropertyGroup2"));
		ui.SelectPropertyvalue2(prop.getProperty("SelectPropertyValue2"));         
		
		ui.SelectPropertyGroup3(prop.getProperty("SelectPropertyGroup3"));
		ui.SelectPropertyvalue3(prop.getProperty("SelectPropertyValue3"));        
		
		ui.SelectPropertyGroup4(prop.getProperty("SelectPropertyGroup4"));
		ui.SelectPropertyvalue4(prop.getProperty("SelectPropertyValue4"));        
		Thread.sleep(3000);
		
		ui.startImporting();
	
		Thread.sleep(5000);
		
		ui.printTotalUploadedFiles();
		ui.printFileName();
		ui.printNumberofContacts();
		ui.printNumberOfUnprocessed();
		ui.printDateOfUpload();
		
		
		// Search contact 
		
		homeobj.contact_db_click();
		driver.findElement(By.xpath(prop.getProperty("TagsXpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("OpenTag"))).click();
		Thread.sleep(5000);
		
		String CD_TagName =  driver.findElement(By.xpath(prop.getProperty("TagNameArray"))).getText();
		String CD_TagCustId =  driver.findElement(By.xpath(prop.getProperty("TagCustomerIdArray"))).getText();
		String CD_TagEmail =  driver.findElement(By.xpath(prop.getProperty("TagCustomerIdEmail"))).getText();
		String CD_TagPhone =  driver.findElement(By.xpath(prop.getProperty("TagCustomerIdPhone"))).getText();
		
		System.out.println("Data of the contact from the tag = "+CD_TagName +" "+CD_TagCustId+" "+CD_TagEmail+" "+CD_TagPhone);
		SoftAssert sa = new SoftAssert();

		String TagNameOnTags = driver.findElement(By.xpath(prop.getProperty("OpenTag"))).getText();
		sa.assertEquals(TagNameOnTags, tagName);		

		sa.assertAll();
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}