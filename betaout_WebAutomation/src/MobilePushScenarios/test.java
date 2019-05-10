package MobilePushScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common_Classes.Loginpage;
import common_Classes.Setup_class;

public class test {
	
	public static WebDriver driver;
	
	
	@Test
	
	public void CreateBroadCastCampaign() throws Exception
	
	{
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://pre-prod-102.betaout.com/");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("betaoutpush.multiple@getamplify.com");
		obj.upswd("123456");
		obj.ulogin();

		Thread.sleep((long) 7.2e+6);
		
		System.out.println("User has logged in successfully");
	
	
	}
	
}	
