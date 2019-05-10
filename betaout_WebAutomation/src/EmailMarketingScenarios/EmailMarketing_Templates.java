package EmailMarketingScenarios;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class EmailMarketing_Templates {

	

public static WebDriver driver;
	
	
	@Test
	public void Email_Overview() throws Exception{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
				
		// Code to load the Property file
		
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
		homeobj.email_mktg_click();
	
		
		EM_Broadcast_Template obj1 = new EM_Broadcast_Template(driver);
		obj1.TemplatesClick();
		
		Thread.sleep(2000);
	
		EM_Campains_Broadcast objnew = new EM_Campains_Broadcast(driver);
		
		List<WebElement> allTemplates =  driver.findElements(objnew.allTemplates);
		
		System.out.println("Total number of templates = "+allTemplates.size());
		
	for(int i=0; i<allTemplates.size();i++)
	
	{
		System.out.println("Name of template "+ (i+1) +" = "+allTemplates.get(i).getText());	
	}
	
	//	driver.quit();
	
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}

}