package SMSBOEditorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class SMSBOCreatePage {

	WebDriver driver;
	
	By Title = By.xpath("//*[@id = 'news_letter_name']");
	By GatewayDropdown = By.xpath("//*[@class = 'BO_dropdown_arrw']");
	
	By Exit = By.xpath("//*[text() = 'Exit']");
	By Save = By.xpath("//*[@data-action = 'save']");
	By SaveExit = By.xpath("//*[@data-action = 'saveAndExit']");
	By SaveNext = By.xpath("//*[@class = 'BO_savebtn']");
	
	
	
	
	public SMSBOCreatePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	public void Title(String title)
	{
		driver.findElement(Title).sendKeys(title);
	}
	
	public void GatewayDropdown() throws Exception
	{
		driver.findElement(GatewayDropdown).click();;
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//*[text() = 'Synic-sys -sinfini(TNDRCT)']")).click();
	}
	
	
	public void Exit()
	{
		driver.findElement(Exit).click();
	}
	
	public void Save()
	{
		driver.findElement(Save).click();
	}
	
	public void SaveExit()
	{
		driver.findElement(SaveExit).click();
	}
	
	public void SaveNext()
	{
		driver.findElement(SaveNext).click();
	}
	
	
	
	
}
