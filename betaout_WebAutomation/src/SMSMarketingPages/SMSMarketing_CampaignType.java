package SMSMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// elements are common for Broadcast and Recurring
/**
 * @author - Navpreet
 */
public class SMSMarketing_CampaignType {

	
	public WebDriver driver;
	
	
	By CampaignType = By.xpath("(//*[@href = '#camp_name'])");                  // Common for Broadcast and Recurring
	By CampaignName = By.xpath("(//*[@id = 'news_letter_name'])");				// Common for Broadcast and Recurring
	By SaveNext = By.xpath("(//*[@id = 'news_letter_sub_button'])");			// Common for Broadcast and Recurring
	By ChooseCampaignHeading = By.xpath("(//*[text() = '1. Choose the campaign type?'])");		// Common for Broadcast and Recurring
	By CampaignNameHeading = By.xpath("(//*[text() = '2. Give a name to this campaign?'])");	// Common for Broadcast and Recurring

	
	public SMSMarketing_CampaignType(WebDriver driver)
	{
		this.driver = driver;
	}
		

	
	public void CampaignTypeClick()
	{
		driver.findElement(CampaignType).click();
	}
	
	public void CampaignNameClick(String Name)
	{
		driver.findElement(CampaignName).sendKeys(Name);
	}
	
	public void SaveNextClick()
	{
		driver.findElement(SaveNext).click();

	}

	public void PrintChooseCampaignHeading()
	{
		String heading1 = driver.findElement(ChooseCampaignHeading).getText();
		System.out.println("Choose Campaign Heading = "+heading1);
		
	}
	
	public void PrintCampaignNameHeading()
	{
		String heading1 = driver.findElement(CampaignNameHeading).getText();
		System.out.println("Choose Campaign Heading = "+heading1);
	}
	
	
}
