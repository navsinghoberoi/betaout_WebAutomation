package MobilePushPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/**
 * @author - Navpreet
 */
public class mobilePush_DesignPage {
	

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
	By titleInputField =  By.xpath("//input[@id='title']");
	By composePushMessage =  By.xpath("//textarea[@id='message']");
	By uploadImageField = By.xpath("//input[@id='customUploadImageFile']");
	By removeImageFile = By.xpath("//a[@class='removeImage']");
	By actionHandlerDropDown = By.xpath("//select[@id='action_handler']");
	By actionHandlerDropDownAppOption = By.xpath("//option[text()='Apps ']");
	By actionHandlerDropDownClickEventOption = By.xpath("//option[text()='Click Event ']");
	By actionHandlerDropDownDeepLinkOption = By.xpath("//option[text()='Deep Link ']");
	By valueInputField = By.xpath("//input[@class='form-control' and @style='padding:5px 15px;display:{display_key};height: 32px']");
	By addAnotherKeyandValueButton = By.xpath("//a[@id='addnew']");
	By deleteKeyAndValuePair = By.xpath("//a[@class='deletekey']");
	By delayWhileIdleCheckBox = By.xpath("//input[@id='1' and @name='delayWhileidle']");
	By collapseKeyInputField = By.xpath("//input[@name='collaspeKey']");
	By timeToLiveInputField = By.xpath("//input[@name='timeToLive']");
	By exitButton = By.xpath("//a[@data-action='exit' and text()='Exit']");
	By saveButton = By.xpath("//a[@data-action='save' and text()='Save']");
	By saveAndExitButton = By.xpath("//a[@data-action='saveAndExit' and text()='Save & Exit']");
	By saveAndNextButton = By.xpath("(//a[@data-action='saveAndNext'])[3]");

	
	public mobilePush_DesignPage(WebDriver driver)
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
	
	public void setMobilePushTitle(String titleName)
	{
		driver.findElement(titleInputField).sendKeys(titleName);
	}
	
	public void setMobilePushMessageBody(String messageBody)
	{
		driver.findElement(composePushMessage).sendKeys(messageBody);
	}
	
	public void uploadImageInNotification(String imagePath)
	{
		driver.findElement(uploadImageField).sendKeys(imagePath);
		WebElement element1 = driver.findElement(uploadImageField);
		String fileName = element1.getAttribute("property value");
		String Actual = "Screenshot (1).png";
		Assert.assertEquals(Actual, fileName,"Error in UploadFunction");		
	}
	
	public void clickOnRemoveUploadedImage()
	{
		driver.findElement(removeImageFile).click();	
	}
	
	public void clickOnActionHandlerDropdown()
	{
		driver.findElement(actionHandlerDropDown).click();
	}
	
	public void selectAppsOptionInDropDown()
	{
		driver.findElement(actionHandlerDropDownAppOption).click();
	}
	
	public void selectClickEventOptionInDropDown()
	{
		driver.findElement(actionHandlerDropDownClickEventOption).click();
	}
	
	public void selectDeepLinkOptionInDropDown()
	{
		driver.findElement(actionHandlerDropDownDeepLinkOption).click();
	}
	
	public void setValueforActionHandler(String value)
	{
		driver.findElement(valueInputField).sendKeys(value);
	}
	
	public void clickOnAddAnotherKeyValuePairButton()
	{
		driver.findElement(addAnotherKeyandValueButton).click();
	}
	
	public void deleteKeyValuePair()
	{
		driver.findElement(deleteKeyAndValuePair).click();
	}
	
	public void clickOnDelayWhileIdle()
	{
		driver.findElement(delayWhileIdleCheckBox).click();
	}
	
	public void setCollapseKeyValue(String collapseKey)
	{
		driver.findElement(collapseKeyInputField).sendKeys(collapseKey);

	}
	
	public void setTimeToLiveValue(String ttlSeconds)
	{
		driver.findElement(timeToLiveInputField).sendKeys(ttlSeconds);

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
