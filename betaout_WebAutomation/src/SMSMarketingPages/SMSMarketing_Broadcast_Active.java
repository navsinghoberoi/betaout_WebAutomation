package SMSMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class SMSMarketing_Broadcast_Active {

	public WebDriver driver;
	
	
	By Exit = By.xpath("(//*[@id = 'saveTemplateAndMove'])");
	By Back = By.xpath("(//*[text() = 'Back'])");	
	
	By EditName = By.xpath("(//*[@class = 'fa fa-pencil editCampignNameIn '])");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameCampign_')]");
	By EditName_Save = By.xpath("(//*[text() = 'Save'])");
	By EditName_Cancel = By.xpath("(//*[text() = 'Cancel'])[1]");
	
	By SendNow = By.xpath("(//*[@id = 'send_now'])");
	By SendNow_ConfirmButton = By.xpath("(//*[@name = 'send'])");
	By Schedule = By.xpath("(//*[@id = 'schedule-popup-open'])");
	By Schedule_Date = By.xpath("(//*[@class = 'iconNew-send-sm'])");
	By Schedule_ConfirmButton = By.xpath("(//*[@id = 'schedule'])");
	
	
	public SMSMarketing_Broadcast_Active(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void ExitClick()
	{
		driver.findElement(Exit).click();
	}
	
	public void BackClick()
	{
		driver.findElement(Back).click();
	}
	
	public void EditNameClick()
	{
		driver.findElement(EditName).click();
		
		String CampaignName =	driver.findElement(EditName_Rename).getText();
		System.out.println("Name of the campaign = "+CampaignName);

			driver.findElement(EditName_Save).click();
	}
	
	public void EditName_CancelClick()
	{
		driver.findElement(EditName_Cancel).click();
	}
	
	public void SendNowClick() throws Exception
	{
		driver.findElement(SendNow).click();
		Thread.sleep(2000);
		driver.findElement(SendNow_ConfirmButton).click();
		
	}
	
	public void ScheduleClick()
	{
		driver.findElement(Schedule).click();
		driver.findElement(Schedule_Date).click();
		driver.findElement(Schedule_ConfirmButton).click();
	}
	

	
}
