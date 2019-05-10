package promocode_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class Coupon_Config {


	public WebDriver driver;

	By multiple_usage_radiobutton = By.xpath("//span[@class = 'onoffswitch-switch-sm']");
	By date_radiobutton = By.xpath("//label[@class = 'radio-label' and @for = 'open']");
	By calendar_icon = By.xpath("//img[@class = 'calendar' and @src = '/css-img/calandar-icon.png']");
//	By select_date_calendar = By.xpath("//td[@class = 'day' and text() = '30']");
	By save_button = By.xpath("//button[@value = 'saveCouponCampaign']");
	
	By nextMonth = By.xpath("(//*[@class = 'next'])[1]");
	
	By selectDate = By.xpath("(//*[@class = 'day' and text() = '10'])");
	
	
	public Coupon_Config(WebDriver driver)

	{
		this.driver = driver;

	}
	
	public void multiple_usage_radiobutton_click()
	{
		driver.findElement(multiple_usage_radiobutton).click();	
		
	}
	
	public void date_radiobutton_click()
	{
		driver.findElement(date_radiobutton).click();	
		
	}
	
	public void calendar_icon_click()
	{
		driver.findElement(calendar_icon).click();	
		
	}
	
	public void save_button_click()
	{
		driver.findElement(save_button).click();	
		
	}
	
	
	public void nextMonthClick()
	{
		
		driver.findElement(nextMonth).click();
		driver.findElement(selectDate).click();
	}
	
	
	
	
	
/*	public void select_date_calendar_click()
	
	{
		
		driver.findElement(select_date_calendar).click();
	}
*/	
	
	
	
}
