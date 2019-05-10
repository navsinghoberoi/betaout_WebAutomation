package CartRecoveryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * @author - Navpreet
 */

public class CartRecovery_SelectTemplate {

	
	public WebDriver driver;
	
	By Preview_GarmentsTemplate = By.xpath("(//*[@id = '339'])");
	By UseTemplate_EdibleTemplate = By.xpath("(//*[@data-tid = '332'])");
	By UseTemplate_GarmentsTemplate = By.xpath("(//*[@data-tid = '339'])");
	
	public CartRecovery_SelectTemplate(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void Preview_GarmentsTemplateClick()
	{
		driver.findElement(Preview_GarmentsTemplate).click();
	}
	

	public void UseTemplate_GarmentsTemplateClick()
	{
		driver.findElement(UseTemplate_EdibleTemplate).click();
	}

	public void UseGarmentsTemplateClick()
	{
		driver.findElement(UseTemplate_GarmentsTemplate).click();
	}
	
	
}
