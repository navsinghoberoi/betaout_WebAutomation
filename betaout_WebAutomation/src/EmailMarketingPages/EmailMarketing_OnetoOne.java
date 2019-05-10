package EmailMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class EmailMarketing_OnetoOne {

	public WebDriver driver;
	
	By From = By.xpath("(//*[@name='senderEmailId'])");
	By Template = By.xpath("(//*[@name='emailTemplateId'])");
	By Subject = By.xpath("(//*[@name='subject'])");
	By To = By.xpath("(//*[@name='receiverEmail'])");
	By Message = By.xpath("(//*[@id='tinymce'])");
	By Send = By.xpath("(//*[@name='send'])");
	By Schedule = By.xpath("(//*[@id='schedule-popup-open'])");
	By Schedule_SelectDate = By.xpath("(//*[@name='scheduledTime'])[2]");
	By Schedule_Close = By.xpath("(//*[@data-dismiss='modal'])[3]");
	By Schedule_Schedule = By.xpath("(//*[@name='schedule'])");
	
	
	public EmailMarketing_OnetoOne(WebDriver driver)
	{	
		this.driver = driver;
	}
	
	public void FromClick(String email)
	{
		Select select = new Select(driver.findElement(From));
	//	select.selectByVisibleText("navpreet@socialcrawler.in (GMAIL)");
		select.selectByVisibleText(email);
		
	}
	
	
	public void TemplateClick()
	{
		Select select = new Select(driver.findElement(Template));
		select.selectByVisibleText("Basic");
	}
	
	
	public void SubjectClick(String subject)
	{
		driver.findElement(Subject).sendKeys(subject);
	}
	
	public void ToClick(String email)
	{
		driver.findElement(To).sendKeys(email);
	}
	
	
	public void MessageClick(String message)
	{
		driver.switchTo().frame(driver.findElement(By.id("email_ifr")));		
		driver.findElement(Message).sendKeys(message);
		driver.switchTo().parentFrame();
		
	}
	
	public void SendClick()
	{
		driver.findElement(Send).click();
	}
	
	public void ScheduleClick()
	{
		driver.findElement(Schedule).click();
		driver.findElement(Schedule_SelectDate).click();
		driver.findElement(Schedule_Schedule).click();
		
	}
	
	
	
}
