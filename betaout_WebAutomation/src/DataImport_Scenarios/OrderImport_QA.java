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

import DataImporting_Pages.OrderImporting;
import DataImporting_Pages.UserImporting;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class OrderImport_QA {

	// Important - Need to change order_id as per the csv to be uploaded
	
public static WebDriver driver;
	
	
	@Test
	
	public void OrderImport() throws Exception
	
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
		
		OrderImporting ui = new OrderImporting(driver);
		ui.OrdersTabClick();
		
		Thread.sleep(5000);
		ui.AddImportClick();
		
		Thread.sleep(3000);
		ui.ChooseFileClick();
		
		Thread.sleep(3000);
	
		String path = set.uploadOrderImportCSV();
		System.out.println(path);
		ui.ChooseFileButton(path);
		
//		ui.ChooseFileButton(prop.getProperty("OrderImport_FilePath"));
		Thread.sleep(5000);
		
		ui.UploadFileClick();
		Thread.sleep(3000);
		
		ui.enterImportName(prop.getProperty("OrderImportFileName") +System.currentTimeMillis());

		ui.SelectPropertyvalue1(prop.getProperty("OrderImport_UserProperty1"));         
		ui.SelectPropertyvalue2(prop.getProperty("OrderImport_UserProperty2"));         
		ui.SelectPropertyvalue3(prop.getProperty("OrderImport_UserProperty3"));        
		ui.SelectPropertyvalue4(prop.getProperty("OrderImport_UserProperty4"));        
		ui.SelectPropertyvalue5(prop.getProperty("OrderImport_UserProperty5"));        
		ui.SelectPropertyvalue6(prop.getProperty("OrderImport_UserProperty6"));        
		ui.SelectPropertyvalue7(prop.getProperty("OrderImport_UserProperty7"));        
		ui.SelectPropertyvalue8(prop.getProperty("OrderImport_UserProperty8"));        
		ui.SelectPropertyvalue9(prop.getProperty("OrderImport_UserProperty9"));        
		ui.SelectPropertyvalue10(prop.getProperty("OrderImport_UserProperty10"));        
		ui.SelectPropertyvalue11(prop.getProperty("OrderImport_UserProperty11"));        
		ui.SelectPropertyvalue12(prop.getProperty("OrderImport_UserProperty12"));        
		ui.SelectPropertyvalue13(prop.getProperty("OrderImport_UserProperty13"));        
		
		Thread.sleep(3000);
		
		ui.startImporting();
	
		Thread.sleep(5000);
		
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		
		ui.printFileInfo();
		Thread.sleep(3000);
		
		ui.ProcessFile();
		Thread.sleep(3000);
	
		// Search for order id
		
		Thread.sleep(30000);
		
		String order_id = "ord_951";                 // Change from csv file
		
		homeobj.search_click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text() = 'Everything'])[1]")).click();
		driver.findElement(By.xpath("//*[contains(@class,'search-selector3')]")).click();     // Click on Order option
		
		driver.findElement(By.xpath("//*[@id = 'searchField']")).sendKeys(order_id);
		driver.findElement(By.xpath("(//*[@id = 'searchButton'])[1]")).click();            // search button
		Thread.sleep(5000);
		
		String getOrderId =  driver.findElement(By.xpath("(//*[@class = 'camp-name'])")).getText();
		System.out.println("Order ID = "+getOrderId);		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}