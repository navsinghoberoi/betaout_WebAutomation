package Scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common_Classes.*;
import common_Classes.Account_Settings;
import common_Classes.Loginpage;
import promocode_Pages.Onsite_CreateCampaign;
import common_Classes.Onsite_Design;
import common_Classes.Homepage;
import promocode_Pages.Onsite_Select_Template;
import common_Classes.Onsite_Target_Page;
/**
 * @author - Navpreet
 */
public class Login_Onsite_Create_Instance_Campaign {

	public static WebDriver driver;
	

	public static void main(String args[]) throws Exception
	
	{
		System.out.println("Scenario : Onsite Marketing > Select Template > Design > Target > Active");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://staging-102.betaout.com/");
	
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("sjs22858@gmail.com");
		obj.upswd("simranjeet");
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
		
		Homepage onsite_obj = new Homepage(driver);
		onsite_obj.onsite_click();
		
		Onsite_CreateCampaign calltoaction_obj = new Onsite_CreateCampaign(driver);
		
		calltoaction_obj.PrintNameOfFields();
		
		calltoaction_obj.createcampaign_click();
		calltoaction_obj.name("Auto_test7");
		Thread.sleep(1500);
		calltoaction_obj.save_click();
		Thread.sleep(3000);
		
		Onsite_Select_Template template_obj = new Onsite_Select_Template(driver);
		template_obj.CTAPopuptemplateClick();
		
		// Explicit wait for Save and Next after selecting template
		
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Save & Next']")));
	
	//	Thread.sleep(18000);
		
		Onsite_Design design = new Onsite_Design(driver);
		design.save_next();
		Thread.sleep(8000);
	
		
		Onsite_Target_Page target_obj = new Onsite_Target_Page(driver);
		target_obj.Target_Users_click();   
		Thread.sleep(1500);
		target_obj.Show_Instance_click();
		Thread.sleep(1500);
		target_obj.SI_Everytime_click();
		Thread.sleep(1500);
		target_obj.Target_Pages_click();
		Thread.sleep(1500);
		target_obj.TP_SpecificURL_click();           // enter url
		Thread.sleep(3000);
		target_obj.SaveAndNext_click();
		Thread.sleep(6000);
		
		
		Onsite_Activepage active_obj = new Onsite_Activepage(driver);
		active_obj.Active_click();
		active_obj.Save_click();
		Thread.sleep(5000);
		
		
		driver.quit();
		
	}
	
	
}
