package MachineLearningScenarios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import MachineLearningPages.MachineLearning_Setup;
import OnsiteMarketingPages.Onsite_CreateCampaign;
import OnsiteMarketingPages.Onsite_Design;
import OnsiteMarketingPages.Onsite_Select_Template;
import OnsiteMarketingPages.Onsite_Target_Page;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Onsite_Activepage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class ViewedAlsoViewed_CTAPopup {

	public static WebDriver driver;
	
	
	@org.testng.annotations.Test
	public void ViewedAlsoViewed_CtaPopup() throws Exception{
		
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
		
		machinesetup.ViewedAlsoViewedTemplate();          // Click on ViewedAlsoViewed template
		Thread.sleep(2000);
		
	/*	machinesetup.ViewedAlsoViewedToggle();
		Thread.sleep(2000);*/
		
		machinesetup.RecEnginePrint();
		boolean result = machinesetup.IsRecEngineDisplayed();
		System.out.println("Recommendation Engine Main Toggle Button Displayed Or Not = "+result);
		
		if(result = true)
		{
			
			System.out.println("Main toggle button is present on setup page");
		}
			
		else
		{
			System.out.println("Main toggle button is NOT present on setup page");
			
		}
		
		machinesetup.printTemplateNames();
		Thread.sleep(2000);
/*		machinesetup.ViewedAlsoViewedStatus();
		Thread.sleep(2000);
*/		
		String numberOnSettingsPage = machinesetup.NoOfProductsViewedAlsoViewedPrint();
		System.out.println("Number of products of ViewedAlsoViewed template on Settings Page = "+numberOnSettingsPage);
		Thread.sleep(2000);
	
		machinesetup.ViewedAlsoViewedSave();
		Thread.sleep(2000);
		
		
		// Make CTA Popup instance
		
		Homepage onsite_obj = new Homepage(driver);
		onsite_obj.onsite_click();
		
		Onsite_CreateCampaign calltoaction_obj = new Onsite_CreateCampaign(driver);
		
		calltoaction_obj.PrintNameOfFields();
		
		calltoaction_obj.createcampaign_click();
	
		String name = "Recommendation_ctapopup"+" "+System.currentTimeMillis();
		calltoaction_obj.name(name);
		Thread.sleep(1500);
		calltoaction_obj.save_click();
		Thread.sleep(3000);
		
	//	Onsite_Select_Template template_obj = new Onsite_Select_Template(driver);
	//	template_obj.CTAPopuptemplateClick();      // Select popup template
		
		driver.findElement(By.xpath("(//*[@data-tid = '403'])")).click(); // Select Recommendation Popup3
		
		// Explicit wait for Save and Next after selecting template
		
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Save & Next']")));
	
		Thread.sleep(8000);
		
		Onsite_Design design = new Onsite_Design(driver);
	
		driver.findElement(By.xpath("(//*[@class = 'recom_gray'])")).click(); // Enable Recommendation Engine	
		Thread.sleep(2000);
		
		String numberOfProductsOnDesign = driver.findElement(By.xpath("(//*[@data-templatecount = 'viewed_also_viewed'])")).getText();
		System.out.println("Number of products are = "+numberOfProductsOnDesign);
		Thread.sleep(2000);
		
		if(numberOfProductsOnDesign.contains(numberOnSettingsPage))
		
		{
			
			System.out.println("Number of products are matching ");
			System.out.println("Pass");
		}
			
		else
		{
			System.out.println("Number of products are not matching ");
			System.out.println("Fail");
		}
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "D://Screenshot//"+System.currentTimeMillis()+".png";
        FileUtils.copyFile(scrFile, new File(path));
		
		System.out.println("Screenshot 1 is taken successfully");
		
        design.save_next();
		Thread.sleep(12000);
	
		Onsite_Target_Page target_obj = new Onsite_Target_Page(driver);
		target_obj.Target_Users_click();   
		Thread.sleep(1500);
		target_obj.Show_Instance_click();
		Thread.sleep(1500);
		target_obj.SI_Everytime_click();
		Thread.sleep(1500);
		target_obj.Target_Pages_click();
		Thread.sleep(1500);
		
		String weburl = "CTAPopupwithMachineLearning";
		target_obj.TP_SpecificURL_click(weburl);           // enter url
		Thread.sleep(3000);
		target_obj.SaveAndNext_click();
		Thread.sleep(8000);
		
		
		Onsite_Activepage active_obj = new Onsite_Activepage(driver);
		active_obj.Active_click();
		active_obj.Save_click();
		Thread.sleep(9000);
		
		// Assert name of campaign
		
		String ActiveInstanceName = driver.findElement(By.xpath("(//a[@class = 'camp-name'])[1]")).getText();
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(ActiveInstanceName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");

		Thread.sleep(6000);
		
	//	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");   	// Open new tab
		
		((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		driver.switchTo().window(tabs.get(1)); //switches to first tab
			
		driver.get("http://woocommerce.basera.com/?"+""+weburl);
		
		//	driver.navigate().refresh();
		
		Thread.sleep(10000);
		
		// View a product (Acura concept)
		
		driver.findElement(By.xpath("(//*[@src = '//woocommerce.basera.com/wp-content/uploads/2016/06/Acura-NSX-concept-01-626x382-1-150x150.jpg'])")).click();
		
		Thread.sleep(10000);
		
		driver.get("http://woocommerce.basera.com/product/acura-concept/?CTAPopup");
		
		Thread.sleep(10000);
		
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File(path));
		
		System.out.println("Screenshot 2 is taken successfully");
		// Switch to iframe

	    driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'iframePopup')]")));
	    
	    String PopupText = driver.findElement(By.xpath("//*[text() = 'HI ARUN']")).getText();
	    System.out.println(PopupText);
		
	    List<WebElement> total =  driver.findElements(By.xpath("//*[@class = 'recom_edit_title']"));
	    System.out.println("Total number of products on recommendation popup = "+total.size());
	    System.out.println("Name of products are given below");
	    
	    
	    for(int i=0;i<4;i++)
	    {
	    	System.out.println(total.get(i).getText());
	    	Thread.sleep(500);
	    }
	    	
	    for(int j=0;j<3;j++)
	    {
	    	driver.findElement(By.xpath("//*[@class = 'boutRecomNext']")).click();
	    	Thread.sleep(500);
	    }	
	    

	    for(int i=4;i<total.size();i++)
	    {
	    	System.out.println(total.get(i).getText());
	    	Thread.sleep(500);
	    }
	    
	    
		s_assert.assertEquals("HI ARUN", PopupText);
		s_assert.assertAll();
		
		System.out.println("Recommendation Popup is present on the URL");
		Thread.sleep(5000);
		
		// Inactive instance once the desired action is captured on the integrated website

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		
		Thread.sleep(3000);

		driver.switchTo().window(tabs.get(0));
		
		calltoaction_obj.InactiveInstanceClick();
				
		Thread.sleep(5000);
				
		String url = driver.getCurrentUrl();
		System.out.println("URL currently opened is "+url);	
	
		/*driver.get("https://pre-prod-102.betaout.com/configurations/settings/machine-learning-configuration");	
		machinesetup.ViewedAlsoViewedToggle();
		Thread.sleep(2000);*/
				
		driver.quit();
		
	}

}	
	
