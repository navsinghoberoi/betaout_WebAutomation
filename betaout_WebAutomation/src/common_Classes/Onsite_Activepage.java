package common_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class Onsite_Activepage {

	public WebDriver driver;

	By Active = By.xpath(".//*[@for='active']");
	By Schedule = By.xpath(".//*[@for='Schedule']");
	By Inactive = By.xpath(".//*[@for='inaction']");
	By Save = By.xpath(".//*[@name='saveActivation']");
	By Back = By.xpath(".//*[text()='Back']");
	By Exit = By.xpath(".//*[text()='Exit']");

	By EditName = By.xpath("(//*[@class = 'fa fa-pencil editInstanceNameIn '])");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameInstance_')]");
	By EditName_Save = By.xpath("(//*[text() = 'Save'])");
	By EditName_Cancel = By.xpath("(//*[text() = 'Cancel'])[1]");
	
	
	By PickSelectorCode = By.xpath("//*[@id = 'ElementSelectorWizardInputBox']");
	
	public String CustomCode = "html>body.home.archive.post-type-archive.post-type-archive-product.woocommerce.woocommerce-page>div.container:eq(2)>div.row-fluid>div.span12>h1.page-title";
	By MobileInlineEnterPhone = By.xpath("//*[@name = 'phone']");
	By MobileInlineSubmit = By.xpath("(//*[text() = 'SUBMIT'])");
	
	
	// Changing locators (Additional)
	public By ActiveInstanceName = By.xpath("(//a[@class = 'camp-name'])[1]");
	
	
	
	
	
	public Onsite_Activepage(WebDriver driver)

	{
		this.driver = driver;
	}
	
	public void PickSelectorCode_click(String path)

	{
		driver.findElement(PickSelectorCode).sendKeys(path);
	}

	public void Active_click()

	{
		driver.findElement(Active).click();
	}

	public void Schedule_click()

	{
		driver.findElement(Schedule).click();
	}

	public void Inactive_click()

	{
		driver.findElement(Inactive).click();
	}

	public void Save_click()

	{
		driver.findElement(Save).click();
	}

	public void Exit_click()

	{

		List<org.openqa.selenium.WebElement> pins = driver.findElements(Exit);
		System.out.println("Total elements :" + pins.size());

		((org.openqa.selenium.WebElement) pins.get(1)).click();

	}

	public void Back_click()

	{
		driver.findElement(Back).click();
	}

	public void EditNameClick() {
		driver.findElement(EditName).click();

		String CampaignName = driver.findElement(EditName_Rename).getText();
		System.out.println("Name of the campaign = " + CampaignName);

		driver.findElement(EditName_Save).click();
	}

	public void MobileInlineEnterPhone(String number)
	{
		driver.findElement(MobileInlineEnterPhone).sendKeys(number);
	}

	public void MobileInlineSubmit()
	{
		driver.findElement(MobileInlineSubmit).click();
	}



}
