package MachineLearningScenarios;

import org.openqa.selenium.WebDriver;

import MachineLearningPages.MachineLearning_Setup;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class MachineLearning_EnableAllTemplates {

	
	public static WebDriver driver;
	
	
	@org.testng.annotations.Test
	
	public void ToggleTemplates() throws Exception{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		
		driver.get("https://pre-prod-102.betaout.com/");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("Woocommercetest@y0v.in");
		obj.upswd("Woocommercetest");
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
		
	//	logger.log(LogStatus.INFO, "User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		homeobj.accnt_click();
		homeobj.settings_click();
		
		
		Account_Settings settings = new Account_Settings(driver);

		settings.recommendation_setup_click();
		
		MachineLearning_Setup machinesetup = new MachineLearning_Setup(driver);
		
		machinesetup.ViewedAlsoViewedTemplate();
		Thread.sleep(1000);
		machinesetup.ViewedAlsoViewedToggle();
		Thread.sleep(1000);
		
		
		machinesetup.BoughtAlsoBoughtTemplate();
		Thread.sleep(1000);
		machinesetup.BoughtAlsoBoughtToggle();
		Thread.sleep(1000);
		
		machinesetup.TopSellingTemplate();
		Thread.sleep(1000);
		machinesetup.TopSellingToggle();
		Thread.sleep(1000);
		
		machinesetup.TopViewedTemplate();
		Thread.sleep(1000);
		machinesetup.TopViewedToggle();
		Thread.sleep(1000);

		machinesetup.TopSellingInCategoryTemplate();
		Thread.sleep(1000);
		machinesetup.TopSellingInCategoryToggle();
		Thread.sleep(1000);

		machinesetup.TopViewedInCategoryTemplate();
		Thread.sleep(1000);
		machinesetup.TopViewedInCategoryToggle();
		Thread.sleep(1000);
		
		machinesetup.TopSellingInBrandTemplate();
		Thread.sleep(1000);
		machinesetup.TopSellingInBrandToggle();
		Thread.sleep(1000);
		
		machinesetup.TopViewedInBrandTemplate();
		Thread.sleep(1000);
		machinesetup.TopViewedInBrandToggle();
		Thread.sleep(1000);
		
		machinesetup.CrossSellTemplate();
		Thread.sleep(1000);
		machinesetup.CrossSellToggle();
		Thread.sleep(1000);

		machinesetup.UpSellTemplate();
		Thread.sleep(1000);
		machinesetup.UpSellToggle();
		Thread.sleep(1000);
		
		driver.quit();
	}

}	
