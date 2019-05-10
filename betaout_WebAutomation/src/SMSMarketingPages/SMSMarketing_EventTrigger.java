package SMSMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author - Navpreet
 */
public class SMSMarketing_EventTrigger {

	
	public WebDriver driver;
	
	//CampName page
	By CampaignName = By.xpath("(//*[@name = 'campaignName'])");
	By SaveNext = By.xpath("(//*[@id = 'campaign_submit_button'])");
	
	//Gateway Page
	By ChooseGateway = By.xpath("(//*[@name = 'smsGateway'])");
	By SMSTextBox = By.xpath("(//*[@id = 'smsText'])");
	By Exit = By.xpath("(//*[text() = 'Exit'])");
	By Options = By.xpath("(//*[text() = 'Options'])");
	By SaveExit = By.xpath("(//*[@name = 'save_and_exit'])");
	By SaveNNext = By.xpath("(//*[@name = 'save_and_next'])");
	
	//EventPage
	By SelectEvent = By.xpath("(//*[@id = 'eventTypeId'])");
	By ChooseDelay = By.xpath("(//*[@name = 'delayInterval'])");
	
	By ChooseTag = By.xpath("(//*[@title = 'None selected'])[1]");
	By ChooseSegment = By.xpath("(//*[@title = 'None selected'])[2]");
	By ChooseLifecycle = By.xpath("(//*[@title = 'None selected'])[3]");
	By MakeActive = By.xpath("(//*[@id = 'change_campaign_status'])");
	By Delete = By.xpath("(//*[text() = 'Delete'])");
	By SaveAndExit = By.xpath("(//*[@name = 'save'])");
	
	
	public SMSMarketing_EventTrigger(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void CampaignName(String name)
	{
		driver.findElement(CampaignName).sendKeys(name);
	}
	
	
	public void SaveNext()
	{
		driver.findElement(SaveNext).click();
	}
	
	
	public void ChooseGateway(String gateway)
	{
		Select sel = new Select(driver.findElement(ChooseGateway));
		sel.selectByVisibleText(gateway);
	}
	
	
	public void SMSTextBox(String message)
	{
		driver.findElement(SMSTextBox).sendKeys(message);
	}
	
	public void Exit()
	{
		driver.findElement(Exit).click();
	}
	
	
	public void Options()
	{
		driver.findElement(Options).click();
	}
	
	public void SaveExit()
	{
		driver.findElement(SaveExit).click();
	}
	
	
	public void SaveNNext()
	{
		driver.findElement(SaveNNext).click();
	}
	
	
	
	public void SelectEvent(String event)
	{
		Select sel = new Select(driver.findElement(SelectEvent));
		sel.selectByVisibleText(event);
	}
	
	
	public void ChooseDelay(String gateway)
	{
		Select sel = new Select(driver.findElement(ChooseDelay));
		sel.selectByVisibleText(gateway);
	}
	
	
	public void ChooseTag()
	{
		driver.findElement(ChooseTag).click();
	}
	
	public void ChooseSegment()
	{
		driver.findElement(ChooseSegment).click();
	}
	
	
	public void ChooseLifecycle()
	{
		driver.findElement(ChooseLifecycle).click();
	}
	
	public void MakeActive()
	{
		driver.findElement(MakeActive).click();
	}
	
	public void Delete()
	{
		driver.findElement(Delete).click();
	}
	
	public void SaveAndExit()
	{
		driver.findElement(SaveAndExit).click();
	}
	


}
