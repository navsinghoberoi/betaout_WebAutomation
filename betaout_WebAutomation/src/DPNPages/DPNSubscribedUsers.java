package DPNPages;

import org.apache.regexp.recompile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class DPNSubscribedUsers {

	
	public WebDriver driver;
	
	By DPD_ID = By.xpath("//*[contains(@class,'selectable')]/td[5]");
	By DPD_Location = By.xpath("//*[contains(@class,'selectable')]/td[8]");
	

	
	public DPNSubscribedUsers(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public String DPN_ID()
	{
		String dpn_id = driver.findElement(DPD_ID).getText();
		return dpn_id;
	}
	
	
	public String DPN_Location()
	{
		String location = driver.findElement(DPD_Location).getText();
		return location;
	}
	
	
}
