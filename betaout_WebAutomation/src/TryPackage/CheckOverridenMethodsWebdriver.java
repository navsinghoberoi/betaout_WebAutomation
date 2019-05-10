package TryPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class CheckOverridenMethodsWebdriver extends WebdriverInterface {
	
	public static WebDriver driver;
	
	@Test
	public void getmethod() throws Exception
	{
	
		Setup_class set = new Setup_class(driver);

		driver = set.setup();
	
	//	driver.get("https://www.youtube.com/"); // basic get command because it is Chromedriver's method

		WebdriverInterface obj1 = new WebdriverInterface();
		
		obj1.get("https://www.youtube.com/");       // new ovveridden method
		
	
	}
	
	
	
	
	
}
