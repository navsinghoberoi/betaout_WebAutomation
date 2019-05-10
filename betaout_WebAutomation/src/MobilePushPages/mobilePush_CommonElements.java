package MobilePushPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class mobilePush_CommonElements {
	
	public WebDriver driver;
	
	By designTab = By.xpath("//span[@class='text' and text()='DESIGN']");
	By customDesignTab = By.xpath("//span[@class='text' and text()='Custom Design']");
	By chooseRecipientTab = By.xpath("//span[@class='text' and text()='Choose Recipients']");
	By sendOrScheduleTab = By.xpath("//span[@class='text' and text()='Send or Schedule']");
	By backButton = By.xpath("(//button[@type='button'])/span[text()='Back']");
	By pencilEditIcon = By.xpath("(//i[@style='color:#2BA8D9;cursor:pointer;bottom:0px;font-size: 14px;margin-left: 16px;position: relative'])");
	By campaignNameInputField = By.xpath("//div[@class='col-sm-5 col-md-5 col-xs-5' and @style='padding-left: 0;']/input");
	By saveCampaignNameButton = By.xpath("//button[@type='button' and text()='Save']");
	By cancelCampaignNameButton =  By.xpath("//a[@type='button' and @class='cancel_campign_name' and text()='Cancel']");
	By exitButton = By.xpath("//a[@data-action='exit' and text()='Exit']");
	By saveButton = By.xpath("//a[@data-action='save' and text()='Save']");
	By saveAndExitButton = By.xpath("//a[@data-action='saveAndExit' and text()='Save & Exit']");
	By saveAndNextButton = By.xpath("(//a[@data-action='saveAndNext']/span[text()='Save & Next'])[1]");


	// Locators for Search

	
	
	
	public mobilePush_CommonElements(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnDesignTab()
	{
		driver.findElement(designTab).click();
	}
	
	public void clickOnCustomDesignTab()
	{
		driver.findElement(customDesignTab).click();
	}
	
	public void clickOnChooseRecipientTab()
	{
		driver.findElement(chooseRecipientTab).click();
	}

	public void clickOnSendOrScheduleTab()
	{
		driver.findElement(sendOrScheduleTab).click();
	}
	
	public void clickOnBackButton()
	{
		driver.findElement(backButton).click();
	}
	
	public void changeCampaignName(String campaignName)
	{
		driver.findElement(pencilEditIcon).click();		
		driver.findElement(campaignNameInputField).sendKeys(campaignName);
		driver.findElement(saveCampaignNameButton).click();
	}
	
	public void clickCancelCampaignNameLink()
	{
		driver.findElement(cancelCampaignNameButton).click();		

	}	
	
	public void clickOnExitButton()
	{
		driver.findElement(exitButton).click();
	}
	
	public void clickOnSaveButton()
	{
		driver.findElement(saveButton).click();
	}
	
	public void clickOnSaveAndExitButton()
	{
		driver.findElement(saveAndExitButton).click();
	}
	
	public void clickOnSaveAndNextButton()
	{
		driver.findElement(saveAndNextButton).click();
	}
}
	
	

