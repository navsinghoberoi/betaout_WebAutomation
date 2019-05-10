package MobilePushPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class mobilePush_CustomDesignPage {
	
	public WebDriver driver;
	
	By customPushNotificationJson = By.xpath("//textarea[@id='custom-data']");
	By delayWhileIdleCheckBox = By.xpath("//label[@class='mobile_label']");
	By collapseKeyInputField = By.xpath("//input[@name='collapseKey']");
	By timeToLiveInputField = By.xpath("//input[@id='time-to-live']");
	By chooseSenderDropDown = By.xpath("//select[@id='gateway-id']");
	By androidOption = By.xpath("//option[@value='42']");
	
	public mobilePush_CustomDesignPage(WebDriver driver)
	{
		this.driver = driver;// TODO Auto-generated constructor stub
	}
	
	public void setCustomPushNotificationJsonText(String Text)
	{
		driver.findElement(customPushNotificationJson).sendKeys(Text);
	}
	
	public void clickOnDelayWhileIdle()
	{
		driver.findElement(delayWhileIdleCheckBox).click();
	}
	
	public void setCustomDesignCollapseKeyInputField(String Text)
	{
		driver.findElement(customPushNotificationJson).sendKeys(Text);
	}
	
	public void setCustomDesignTimeToLiveInputField(String Text)
	{
		driver.findElement(timeToLiveInputField).sendKeys(Text);
	}
	
	public void clickOnSenderDropDown()
	{
		driver.findElement(chooseSenderDropDown).click();
	}
	
	public void selectAndroidOption()
	{
		driver.findElement(androidOption).click();
	}
	
}
