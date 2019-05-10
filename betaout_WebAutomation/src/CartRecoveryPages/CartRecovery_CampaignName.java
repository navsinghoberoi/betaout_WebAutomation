package CartRecoveryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class CartRecovery_CampaignName {
	
	public WebDriver driver;
	
	
	By CampaignName = By.xpath("(//*[@name = 'campaignName'])");
	By SaveNext = By.xpath("(//*[@id = 'addCampaignBtn'])");
	By CampaignNameHeading = By.xpath("(//*[text() = 'Give a name to cart abandoned campaign?'])");
	
	public CartRecovery_CampaignName(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void CampaignNameClick(String name)
	{
		driver.findElement(CampaignName).sendKeys(name);
	}
	
	public void SaveNextClick()
	{
		driver.findElement(SaveNext).click();
	}
	

	public void PrintCampaignNameHeading()
	{
		
		String heading1 = driver.findElement(CampaignNameHeading).getText();
		System.out.println("Campaign Name Heading = "+heading1);
	}
	
	

}
