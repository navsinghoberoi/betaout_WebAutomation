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
import DataImporting_Pages.OrderImporting;
import DataImporting_Pages.ProductImporting;
import DataImporting_Pages.UserImporting;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class ProductImport_QA {

	// Important - Need to change order_id as per the csv to be uploaded
	
public static WebDriver driver;
	
	public void getProductsURL()
{
	driver.get("https://qa.betaout.in/products/product-overview");
}


	@Test
	
	public void ProductImport() throws Exception
	
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
//		driver.findElement(By.xpath(prop.getProperty("SelectAccount"))).click();
		
		System.out.println("User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		
		homeobj.accnt_click();
		
		homeobj.settings_click();
	
		Thread.sleep(2500);
		Account_Settings settings_obj = new Account_Settings(driver);
		settings_obj.user_import__click();
		Thread.sleep(2000);
		
		ProductImporting ui = new ProductImporting(driver);
		ui.ProductsTabClick();
		
		Thread.sleep(5000);
		ui.AddImportClick();
		
		Thread.sleep(3000);
		ui.ChooseFileClick();
		
		Thread.sleep(3000);
	
		String path = set.uploadProductImportCSV();
		System.out.println(path);
		ui.ChooseFileButton(path);
		
//		ui.ChooseFileButton(prop.getProperty("ProductImport_FilePath"));
		Thread.sleep(5000);
		
		ui.UploadFileClick();
		Thread.sleep(3000);
		
		ui.enterImportName(prop.getProperty("ProductImportFileName") +System.currentTimeMillis());

		ui.SelectPropertyvalue1(prop.getProperty("ProductImport_UserProperty1"));         
		ui.SelectPropertyvalue2(prop.getProperty("ProductImport_UserProperty2"));         
		ui.SelectPropertyvalue3(prop.getProperty("ProductImport_UserProperty3"));        
		ui.SelectPropertyvalue4(prop.getProperty("ProductImport_UserProperty4"));        
		ui.SelectPropertyvalue5(prop.getProperty("ProductImport_UserProperty5"));        
		ui.SelectPropertyvalue6(prop.getProperty("ProductImport_UserProperty6"));        
		ui.SelectPropertyvalue7(prop.getProperty("ProductImport_UserProperty7"));        
	  
		Thread.sleep(3000);
		
		ui.startImporting();
	
		Thread.sleep(5000);
		
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		
		ui.printFileInfo();
		Thread.sleep(3000);

	// Perform add/view event on linked website to see product imported
	
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

		Thread.sleep(2000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
	
		set.getWoocommerceOneURL();
		
		CartRecovery_Homepage carthome_obj = new CartRecovery_Homepage(driver);
		
		driver.findElement(carthome_obj.WoocommerceAccount_MyAccount).click();  // My Account
		
		Thread.sleep(2000);
		driver.findElement(carthome_obj.WoocommerceAccount_Username).sendKeys(prop.getProperty("WoocommerceAccount_Username"));
		driver.findElement(carthome_obj.WoocommerceAccount_Password).sendKeys(prop.getProperty("WoocommerceAccount_Password"));
		
		driver.findElement(carthome_obj.WoocommerceAccount_Login).click();
		Thread.sleep(3000);
		
		driver.findElement(carthome_obj.WoocommerceAccount_Home).click();  // Home
		
		driver.findElement(carthome_obj.WoocommerceAccount_AddToCart).click();  // Add to cart
		Thread.sleep(3000);
		
		driver.findElement(carthome_obj.WoocommerceAccount_ViewCart).click();

		// Go to product catalogue > products page 
		
		
		getProductsURL();
		
		List<WebElement> allProductsName = driver.findElements(By.xpath("//*[contains(@class,'selectable')]/td[2]"));
		for(int i=0;i<allProductsName.size();i++)
		{
			System.out.println(allProductsName.get(i).getText());
		}
		
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}