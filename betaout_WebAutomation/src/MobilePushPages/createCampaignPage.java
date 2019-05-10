package MobilePushPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * @author - Navpreet
 */
public class createCampaignPage {
	
	public WebDriver driver;
	
	By campaignButton = By.xpath("(//a[@href='/pn/announcement/campaign-type'])[2]");
	By broadcastImage = By.xpath("//a[@href='#camp_name']");
	By titleText = By.xpath("//h1[text()='1. Choose the campaign type?']");
	By campaignTitleTextField = By.xpath("//input[@id='news_letter_name']");
	By saveAndNextButton = By.xpath("//button[@id='news_letter_sub_button' and @type='submit']");
	
	
	By CampaignName = By.xpath("//*[contains(@class,'campaign-heading')]");          // Save it in a List
	By ConditionsOfCampaign = By.xpath("(//*[@class = 'iconAction-caret'])[1]");
	By EditCampaign = By.xpath("(//*[@class = 'iconAction-edit'])[1]");
	By CloneCampaign = By.xpath("(//*[@class = 'iconAction-clone'])[1]");
	By CloneConfirmCampaign = By.xpath("(//*[@name = 'clone'])");
	
	By DeleteCampaign = By.xpath("(//*[@class = 'iconAction-delete'])[2]");
	By DeleteCampaign_Entertext = By.xpath("(//*[@id = 'capsVal'])");
	By DeleteCampaign_Confirm = By.xpath("//*[contains(@class,'ConfirmDeletedcampignTyp')]");
	
	
	By BroadCast = By.xpath("(//*[text() = 'Broadcast'])[1]");
	By EventTriggered = By.xpath("(//*[text() = 'Event Triggered'])[1]");
	By Recurring = By.xpath("(//*[text() = 'Recurring'])[1]");
	
	
	By Recurring_campaignsButton = By.xpath("(//*[contains(@href,'/pn/announcement/campaign-type')])[2]");
	
	public createCampaignPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void campaignButton()
	{
		
		driver.findElement(campaignButton).click();

	}
	
	public void broadcastImage()
	{
		
		driver.findElement(broadcastImage).click();

	}
	
	public void enterCampaignName(String campaignName)
	{
		
		driver.findElement(campaignTitleTextField).sendKeys(campaignName);

	}
	
	public void clickOnSaveandNextButton()
	{
		
		driver.findElement(saveAndNextButton).click();
		
	}
	
	
	public String CampaignNamePrint()
	{
		List<WebElement> allNames = driver.findElements(CampaignName);
	
		System.out.println("Total number of campaigns are = "+allNames.size());
	
		System.out.println("Name of the campaigns are -");
		
	    for(int i=0;i<allNames.size();i++)
	    {
	    	System.out.println((i+1)+" "+allNames.get(i).getText());
	    }
	    
	    String NewCampName = allNames.get(0).getText();
	    System.out.println("Name of the created campaign is = " +NewCampName);
	    
	    return NewCampName;
	}
	
	
	public void ConditionsOfCampaignClick()
	{
		driver.findElement(ConditionsOfCampaign).click();
	}
	
	
	public void EditCampaignClick()
	{
		driver.findElement(EditCampaign).click();
	}
	
	public void CloneCampaignClick() throws Exception
	{
		driver.findElement(CloneCampaign).click();
		Thread.sleep(2000);
		driver.findElement(CloneConfirmCampaign).click();
	}
	
	
	
	public void DeleteCampaignClick() throws Exception
	{
		driver.findElement(DeleteCampaign).click();
		Thread.sleep(2000);
		driver.findElement(DeleteCampaign_Entertext).sendKeys("DELETE");
		driver.findElement(DeleteCampaign_Confirm).click();
	}
		
	
	public void BroadCastClick()
	{
		driver.findElement(BroadCast).click();
	}
	
	public void EventTriggeredClick()
	{
		driver.findElement(EventTriggered).click();
	}
	
	public void RecurringClick()
	{
		driver.findElement(Recurring).click();
	}
	
	
	
	public void Recurring_campaignsButtonClick()
	{
		
		driver.findElement(Recurring_campaignsButton).click();
	}
	
	
	
	
	

}
