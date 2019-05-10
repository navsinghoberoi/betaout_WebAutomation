package promocode_Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CartRecoveryPages.CartRecovery_CampaignConditions;
import CartRecoveryPages.CartRecovery_CampaignName;
import CartRecoveryPages.CartRecovery_Homepage;
import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
public class Test {
	
	public static WebDriver driver;
	
	@org.testng.annotations.Test
	
	public void Func() throws Exception{
		
		
		
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://pre-prod-102.betaout.com/");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("Woocommercetest@y0v.in");
		obj.upswd("Woocommercetest");
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
	
		
		driver.get("https://pre-prod-102.betaout.com/promocode/coupon-list/");

		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//*[@class = 'resumeCouponCampign'])[1]"))).build().perform();
		driver.findElement(By.xpath("(//*[@class = 'resumeCouponCampign'])[1]")).click();
		
		
		
	//	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id = 'content-1__textArea_ifr']")));
	
	//	driver.findElement(By.xpath("//*[@class = 'headp_1']")).click();
		
	//	driver.findElement(By.xpath("//*[@id = 'mce_53']")).click();
	
/*	
		// JS Code	
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("tinyMCE.activeEditor.setContent('Verifying Popup Data12');");
		  
		//  js.executeScript("document.getElementById('content-1__textArea_ifr').click();");
		  js.executeScript("document.getElementById('content-1__textArea_ifr').keypress()");
		  
		  String e = "$.Event('keypress')"; 
		  e.which = 13;
		  $("form").trigger(e);
		  
		  js.executeScript("tinyMCE.activeEditor.setContent('Verifying Popup DataNew');");
		  
          Thread.sleep(2000);*/
        
        
        
        //    driver.findElement(By.xpath("//*[text() = 'Select Animation']")).ge
   
      /*  Select sel = new Select(driver.findElement(By.xpath("//*[@class = 'customSelect-sm animationvalue']")));
        sel.selectByIndex(1);*/
        
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
        
        
        
        /*driver.switchTo().frame(driver.findElement(By.id("iframe")));
        
        driver.findElement(By.xpath("//*[@id = 'content-1']")).click();*/
        
        /*var e = js.Event("keypress");
        e.which = 13; //choose the one you want
        e.keyCode = 13;
        $("#theInputToTest").trigger(e);
        */
	/*
        driver.findElement(By.xpath("//*[text() = 'GET HTML CODE']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class = 'close'])[3]")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text() = 'Save & Next']")).click();
		*/
        
        
        /*
		WebElement content= driver.findElement(By.xpath("//*[@class = 'headp_1']"));
		
	    content.clear();
		*/
	
		
		//driver.quit();
		

																		}



							}
