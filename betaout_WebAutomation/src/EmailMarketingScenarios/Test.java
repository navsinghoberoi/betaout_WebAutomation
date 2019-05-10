package EmailMarketingScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import CartRecoveryPages.CartRecovery_Design;
import EmailMarketingPages.EM_Broadcast_Template;
import EmailMarketingPages.EM_Campains_Broadcast;
import GmailLogin.GmailLoginPages;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */

public class Test {

	public static WebDriver driver;

	@org.testng.annotations.Test
	
	public void EmailTest() throws Exception {

		System.out.println("Scenario - Make a broadcast campaign > Print counts and verify Stats > Update property on Send and verify it");

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

		System.out.println("User has logged in successfully");

		// Add code to select account
		set.selectAccountNav();
		
		Thread.sleep(2000);
		
		Homepage homeobj = new Homepage(driver);
		homeobj.email_mktg_click();

		EM_Campains_Broadcast obj1 = new EM_Campains_Broadcast(driver);
		obj1.campaign_Tab();
		Thread.sleep(2000);
		obj1.Broadcast_Createcapmain();
		Thread.sleep(2000);
		
		// Code for BO Editor
		
		driver.findElement(By.xpath("//*[@name = 'newsletterName']")).sendKeys("AutoBroad1");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("(//*[@class = 'BO_dropdown_arrw'])[2]")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("(//*[text() = 'shivangi@devrover.com(ses)'])")).click();
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@class = 'emoji-wysiwyg-editor BO_inputbox']")).sendKeys("AutoSubject");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@class = 'BO_savebtn']")).click();
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
