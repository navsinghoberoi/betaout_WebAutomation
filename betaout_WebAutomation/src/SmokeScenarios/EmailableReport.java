package SmokeScenarios;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class EmailableReport {


public WebDriver driver;
	
@Test
	public void OpenReport() throws Exception
	{

	Setup_class set = new Setup_class(driver);
	driver = set.setup();
	driver.get("file:///C:/Users/Navpreet/Desktop/Notepad%20files/Onsite-report.html");
	
	}
	
	
}
