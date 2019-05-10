package ContactDatabasePagesAndScenarios;

import org.apache.regexp.recompile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
/**
 * @author - Navpreet
 */
public class ConntactDB_ViewContactDetails {
	
	public WebDriver driver;
	
	
	By OpenUser = By.xpath("(//*[contains(@class,'selectable')])/td");
	
	By Overview = By.xpath("(//*[contains(@href,'/users/user-permalink/nv/userId')])[2]");
	By Activities = By.xpath("(//*[contains(@href,'/users/user-permalink-activities/nv/userId')])[2]");
	By Properties = By.xpath("(//*[contains(@href,'/users/user-permalink-properties/nv/userId')])[2]");
	By Products = By.xpath("(//*[contains(@href,'/users/user-product-permalink/nv/userId')])[2]");
	By Campaigns = By.xpath("(//*[contains(@href,'/users/user-permalink-campaigns/nv/userId')])[2]");
	By DeviceProperties = By.xpath("(//*[contains(@href,'/users/user-permalink-devices/nv/userId')])[2]");
	By Timeline = By.xpath("(//*[contains(@href,'/users/user-segment-growth/nv/userId')])[2]");
	
	By UpdatetextPropertyData = By.xpath("(//*[text()='updatetext']/../td)[2]");
	
	
	
	public ConntactDB_ViewContactDetails(WebDriver driver) 
	{
		this.driver = driver;

	}

	public void OpenUser() throws Exception
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(OpenUser)).build().perform();
		Thread.sleep(3000);
		driver.findElement(OpenUser).click();
	}
	
	public void Overview()
	{
		driver.findElement(Overview).click();
	}
	
	public void Activities()
	{
		driver.findElement(Activities).click();
	}
	
	public void Properties()
	{
		driver.findElement(Properties).click();
	}
	
	public void Products()
	{
		driver.findElement(Products).click();
	}
	
	public void Campaigns()
	{
		driver.findElement(Campaigns).click();
	}
	
	public void DeviceProperties()
	{
		driver.findElement(DeviceProperties).click();
	}
	
	public void Timeline()
	{
		driver.findElement(Timeline).click();
	}
	
	
	public String printUpdatetextPropertyData()
	{
		String data = driver.findElement(UpdatetextPropertyData).getText();
		System.out.println("Updated Property displayed in Properties tab =  "+data);
		return data;
	}
	
	
	
	
	
}
