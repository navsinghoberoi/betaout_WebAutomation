package MobilePushPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class mobilePush {

	public WebDriver driver;
	
	By campaignButton = By.xpath("(//a[@href='/pn/announcement/campaign']/span[text()='Campaigns'])[2]");
	By broadcastButton = By.xpath("//a[@href='/pn/announcement/campaign']/span[text()='Broadcast']");
	By eventTriggeredButton = By.xpath("//a[@href='/pn/transactional/active']/span[text()='Event Triggered']");
	By recurringButton = By.xpath("//a[@href='/pn/recurring/campaign']/span[text()='Recurring']");
	By selectStatusDropdown	 = By.xpath("//button[@id='dropdownMenu1']");
	By createCampaignButton = By.xpath("(//a[@href='/pn/announcement/campaign-type']/span[text()='Create  Campaign'])[2]");
	By editButton = By.xpath("(//a[@title = 'Edit'])[1]");//For the Edit button of the first campaign on the page
	By cloneButton = By.xpath("(//a[@title = 'Clone'])[1]");//For the Clone button of the first campaign on the page
	By deleteButton = By.xpath("(//a[@title = 'Delete'])[1]");//For the Delete button of the first campaign on the page
	
	public mobilePush(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void campaignButton()

	{
		
		driver.findElement(campaignButton).click();

	}
	
	public void broadcastButton()

	{
		
		driver.findElement(broadcastButton).click();

	}
	
	public void eventTriggeredButton()

	{
		
		driver.findElement(eventTriggeredButton).click();

	}
	
	public void recurringButton()

	{
		
		driver.findElement(recurringButton).click();

	}
	
	public void selectStatusDropdown()

	{
		
		driver.findElement(selectStatusDropdown).click();

	}
	
	public void createCampaignButton()

	{
		
		driver.findElement(createCampaignButton).click();

	}
	
	public void clickEditButton()
	
	{
		
		driver.findElement(editButton).click();

	}
	
	public void clickCloneButton()
	
	{
		
		driver.findElement(cloneButton).click();

	}

	public void clickDeleteButton()

	{
	
		driver.findElement(deleteButton).click();

	}
	
}
