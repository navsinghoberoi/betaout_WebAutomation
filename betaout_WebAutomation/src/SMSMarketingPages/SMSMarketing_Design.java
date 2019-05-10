package SMSMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

// elements are common for Broadcast and Recurring
/**
 * @author - Navpreet
 */
public class SMSMarketing_Design {

	public WebDriver driver;
	
	
	By Exit = By.xpath("(//*[@data-action = 'exit'])");           		// Common on Design and Target (on Broadcast and Recurring)
	By Save = By.xpath("(//*[@data-action = 'save'])");			  		// Common on Design and Target
	By SaveExit = By.xpath("(//*[@data-action = 'saveAndExit'])");		// Common on Design and Target	
	By SaveNext = By.xpath("(//*[@data-action = 'saveAndNext'])[3]");	// Common on Design and Target
	By Back = By.xpath("(//*[text() = 'Back'])");						// Common on Design and Target
	By Edit = By.xpath("(//*[@class = 'fa fa-pencil editCampignNameIn '])");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameCampign_')]");
	By EditName_Save = By.xpath("(//*[text() = 'Save'])[2]");
	By EditName_Cancel = By.xpath("(//*[text() = 'Cancel'])[2]");
	
	By ChooseGateway = By.xpath("(//*[@name = 'smsGateway'])");		
	By SMSText = By.xpath("(//*[@name = 'message'])");				
	
	public SMSMarketing_Design(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ExitClick()
	{
		driver.findElement(Exit).click();
	}
	
	public void SaveClick()
	{
		driver.findElement(Save).click();
	}
	
	public void SaveExitClick()
	{
		driver.findElement(SaveExit).click();
	}
	
	public void SaveNextClick()
	{
		driver.findElement(SaveNext).click();
	}
	
	public void BackClick()
	{
		driver.findElement(Back).click();
	}
	

	public void ChooseGatewayClick()
	{
		Select dropdown = new Select(driver.findElement(ChooseGateway));
		dropdown.selectByVisibleText("GolfLan -way2mint(GOLFLN)");
		
		String name = driver.findElement(ChooseGateway).getText();
		System.out.println("Name of the Selected SMS Gateway = "+name);
	}

	
	public void SMSTextClick(String message)
	{
		driver.findElement(SMSText).sendKeys(message);
	}
	

	public void EditNameClick()
	{
		driver.findElement(Edit).click();
		
		String CampaignName =	driver.findElement(EditName_Rename).getText();
		System.out.println("Name of the campaign = "+CampaignName);

			driver.findElement(EditName_Save).click();
	}
	
	
	public void EditName_CancelClick()
	{
		driver.findElement(EditName_Cancel).click();
	}
	
	
}
