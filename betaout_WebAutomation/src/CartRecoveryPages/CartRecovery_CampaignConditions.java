package CartRecoveryPages;

/**
 * @author - Navpreet
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartRecovery_CampaignConditions {

	public WebDriver driver;

	By Overview = By.xpath("(//*[@href = '/carts/cart/'])");
	By Campaigns = By.xpath("(//*[@href = '/carts/cart-campaign/'])");
	By Cancel = By.xpath("(//*[text() = 'Cancel'])");
	
	By SaveNext = By.xpath("(//*[@data-action = 'saveAndNext'])[1]");
	By AddNewCondition = By.xpath("//*[contains(text(),'ADD NEW')]");

	By ANDDropdown1 = By.xpath("(//*[contains(@class,'frist-drop')])[1]");
	By ANDDropdown2 = By.xpath("(//*[contains(@class,'second-drop')])[1]");
	By ANDDropdown3 = By.xpath("//*[@id = 'third-dropinput_1']");
	
	By DeleteRule  = By.xpath("(//*[contains(@class,'delete-this-rule')])[1]");     // to delete first condition
	
	public CartRecovery_CampaignConditions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void OverviewClick()
	{
		driver.findElement(Overview).click();
	}
	

	public void CampaignsClick()
	{
		driver.findElement(Campaigns).click();
	}

	public void CancelClick()
	{
		driver.findElement(Cancel).click();
	}
	

	public void SaveNextClick()
	{
		driver.findElement(SaveNext).click();
	}
	

	public void AddNewConditionClick()
	{
		driver.findElement(AddNewCondition).click();
	}
	

	public void ANDDropdown1Click()
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown1));
		dropdown.selectByVisibleText("Cart Value");                 
		
		String name = driver.findElement(ANDDropdown1).getText();
		System.out.println("Name of all options from 1stDropdown = "+name);
	}
	

	public void ANDDropdown2Click()
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown2));
		dropdown.selectByVisibleText("Greater than");                  
		
		String name = driver.findElement(ANDDropdown2).getText();
		System.out.println("Name of all options from 2ndDropdown = "+name);
	}
	
	public void ANDDropdown3Click(String value)
	{
		driver.findElement(ANDDropdown3).sendKeys(value);
	}
	
	
	public void DeleteRuleClick()
	{
		driver.findElement(DeleteRule).click();
	}
	
	
}
