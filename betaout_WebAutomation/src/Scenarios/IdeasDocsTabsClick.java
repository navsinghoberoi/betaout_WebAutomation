package Scenarios;
/**
 * @author - Navpreet
 */
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ContactDatabasePagesAndScenarios.ContactDatabase;
import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
import promocode_Pages.IdeasDocs;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;

public class IdeasDocsTabsClick {

	
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception{

		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://staging-102.betaout.com/");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("sjs22858@gmail.com");
		obj.upswd("simranjeet");
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		homeobj.ideas_docs_click();
		
		IdeasDocs docsobj = new IdeasDocs(driver);
		docsobj.ResourcesClick();
		Thread.sleep(5000);
		docsobj.APIDocsClick();
		Thread.sleep(5000);
		docsobj.PluginsNExtensionsClick();
		Thread.sleep(5000);
		docsobj.APIKeyClick();
		Thread.sleep(5000);
		docsobj.GlossaryClick();
		Thread.sleep(5000);
		docsobj.TemplatesClick();
		Thread.sleep(15000);
		
		driver.quit();
		
}

}