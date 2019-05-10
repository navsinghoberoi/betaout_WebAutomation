package MobilePushPages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class MobilePush_SendOrSchedulePage {
	
	public WebDriver driver;
	By sendNowButton = By.xpath("//button[@name='send_now']");
	By cancelButtonInSendNowPopUp2 = By.xpath("(//button[text()='Cancel'])[2]");
	By sendNowButtoninSendNowPopUp = By.xpath("//*[text()='Ok, Send Now']");
	By cancelButtonInSendNowPopUp1 = By.xpath("(//button[text()='Cancel'])[1]");
	By scheduleDateInputField = By.xpath("(//input[@name='scheduledTime'])[1]");
	By scheduleButton = By.xpath("(//button[@name='schedule'])[1]");
	By exitButton = By.xpath("(//a[@id='saveAndExit'])[1]");
	By calenderIcon = By.xpath("//i[@class='iconNew-send-sm']");
	
	
	public MobilePush_SendOrSchedulePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnSendNowButtonInPage()
	{
		driver.findElement(sendNowButton).click();
	}
	
	public void clickOnSendNowButtonInPopUp()
	{
		driver.findElement(sendNowButtoninSendNowPopUp).click();
	}
	
	public void cancelButtonInSendNowPopUpSuccessScenario()
	{
		driver.findElement(cancelButtonInSendNowPopUp1).click();
	}
	
	public void cancelButtonInSendNowPopUpNoUserScenario()
	{
		driver.findElement(cancelButtonInSendNowPopUp2).click();
	}
	
	public void setScheduleDateAndTime()
	{
		 		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Date scheduleDate = new Date((System.currentTimeMillis() - TimeUnit.HOURS.toMillis(5)) - TimeUnit.MINUTES.toMillis(27));

		System.out.println(dateFormat.format(scheduleDate));
		
		String date1 = dateFormat.format(scheduleDate);
		System.out.println(date1); 
		driver.findElement(scheduleDateInputField).sendKeys(date1);//Will set a campaign time after 3 minutes.
				
	}
	
	public void clickScheduleButton()
	{
		driver.findElement(scheduleButton).click();
	}
	
	public void clickExitButton()
	{
		driver.findElement(exitButton).click();
	}
	

}
