package DPNPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class DPN_Homepage {

	public WebDriver driver;
	
	By Overview = By.xpath("(//*[text() = 'Overview'])[2]");
	By Campaigns = By.xpath("(//*[text() = 'Campaigns'])[2]");
	By SubscribedUsers = By.xpath("(//*[text() = 'Subscribed Users'])[2]");
	
	// Campaign Subscription Locators
	By C_Subscription = By.xpath("(//*[text() = 'Subscription'])[1]");
	
	By CS_AddSuscriber = By.xpath("(//*[text() = 'ADD SUBSCRIBER'])[2]");
	
	By CS_CampaignName = By.xpath("//*[contains(@class,'camp-name')]");      // common for C & B
	By CS_TotalCount = By.xpath("//*[contains(@class,'selectable')]/td[2]");
	By CS_SubscribedCount = By.xpath("//*[contains(@class,'selectable')]/td[3]");
	By CS_CampaignStatus = By.xpath("//*[contains(@class,'Active') and text() = 'Active']");
	
	By CS_Stats = By.xpath("(//*[@class = 'iconAction-stats'])");         // common for C & B
	By CS_Clone = By.xpath("(//*[@class = 'iconAction-clone'])"); 	 	 // common for C & B
	By CS_Delete = By.xpath("(//*[@class = 'iconAction-delete'])");     // common for C & B
	By CS_Pause = By.xpath("(//*[@class = 'iconAction-pause'])");
	By CS_Edit = By.xpath("(//*[@class = 'iconAction-edit'])");        // common for C & B
	By CS_Active = By.xpath("(//*[@class = 'iconAction-active'])");
	
	
	By CS_Stats_Overview = By.xpath("//*[text() ='Overview']");
	By CS_Stats_Timeline = By.xpath("//*[text() ='Timeline']");
	
	
	
	
	
	
	// Campaign Broadcast Locators
	By C_Broadcast = By.xpath("(//*[text() = 'Broadcast'])[1]");
	By CB_CreateCamp = By.xpath("(//*[text() = 'CREATE CAMPAIGN'])[2]");
	By CB_Sent = By.xpath("//*[contains(@class,'selectable')]/td[2]");
	By CB_Delivered = By.xpath("//*[contains(@class,'selectable')]/td[3]");
	By CB_Viewed = By.xpath("//*[contains(@class,'selectable')]/td[4]");
	By CB_Clicked = By.xpath("//*[contains(@class,'selectable')]/td[5]");
	By CB_Failed = By.xpath("//*[contains(@class,'selectable')]/td[6]");
	

	
	public DPN_Homepage(WebDriver driver)
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
	
	public void SubscribedUsersClick()
	{
		driver.findElement(SubscribedUsers).click();
	}
	
	public void C_SubscriptionClick()
	{
		driver.findElement(C_Subscription).click();
	}
	public void CS_AddSuscriberClick()
	{
		driver.findElement(CS_AddSuscriber).click();
	}
	public String getCampaignName()        // common for C & B
	{
		String name = driver.findElement(CS_CampaignName).getText();
		return name;	
	}
	
	public String getCS_TotalCount()
	{
		String total = driver.findElement(CS_TotalCount).getText();
		return total;
	}
	
	public String getCS_SubscribedCount()
	{
		String count = driver.findElement(CS_SubscribedCount).getText();
		return count;
	}
	
	public String getCS_CampaignStatus()
	{
		String status = driver.findElement(CS_CampaignStatus).getText();
		return status;
	}
	
	public void CS_StatsClick()
	{
		driver.findElement(CS_Stats).click();
	}
	
	public void CS_CloneClick()
	{
		driver.findElement(CS_Clone).click();
	}
	
	public void CS_DeleteClick()
	{
		driver.findElement(CS_Delete).click();
	}
	
	public void CS_PauseClick()
	{
		driver.findElement(CS_Pause).click();
	}
	
	public void CS_EditClick()
	{
		driver.findElement(CS_Edit).click();
	}
	
	public void CS_ActiveClick()
	{
		driver.findElement(CS_Active).click();
	}
	
	public void CS_Stats_OverviewClick()
	{
		driver.findElement(CS_Stats_Overview).click();
	}
	
	public void CS_Stats_TimelineClick()
	{
		driver.findElement(CS_Stats_Timeline).click();
	}
	
	
	public void C_Broadcastclick()
	{
		driver.findElement(C_Broadcast).click();
	}
	
	
	public void CB_CreateCampclick()
	{
		driver.findElement(CB_CreateCamp).click();
	}
	
	public String getCB_Sent()
	{
		String sent = driver.findElement(CB_Sent).getText();
		return sent;
	}
	
	
	public String getCB_Delivered()
	{
		String delivered = driver.findElement(CB_Delivered).getText();
		return delivered;
	}
	
	public String getCB_Viewed()
	{
		String viewed = driver.findElement(CB_Viewed).getText();
		return viewed;
	}
	
	public String getCB_Clicked()
	{
		String clicked = driver.findElement(CB_Clicked).getText();
		return clicked;
	}
	
	public String getCB_Failed()
	{
		String failed = driver.findElement(CB_Failed).getText();
		return failed;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
