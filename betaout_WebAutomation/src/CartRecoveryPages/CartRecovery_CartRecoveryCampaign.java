package CartRecoveryPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class CartRecovery_CartRecoveryCampaign {
	
	public WebDriver driver;
	
	By Back = By.xpath("(//*[@src = '/css-img/back-arw.png'])");
	By Exit = By.xpath("(//*[@href = '/carts/cart-campaign/'])[2]");
	By MakeActive = By.xpath("(//*[@id = 'changeCartAbandonedCampaignStatus'])");
	By Delete = By.xpath("(//*[@id = 'delete_cartabandoned_campaign'])");
	By Delete_Confirm = By.xpath("(//*[@id = 'delet_behav'])");
	By SaveNext = By.xpath("(//*[@name = 'save'])");
	By AddEmail = By.xpath("(//*[@id = 'add_cartabandoned_email'])");
	By PriorityForCampaignCheckbox = By.xpath("(//*[@class = 'mobile_label'])");
	
	By EditName = By.xpath("(//*[@id = 'edit_campaign_name'])");
	By EditName_Rename = By.xpath("(//*[@id = 'cartabandoned_campaign_name_input'])");
	By EditName_Save = By.xpath("(//*[@id = 'save_campaign_name'])");
	By EditName_Cancel = By.xpath("(//*[@id = 'cancel_save_campaign_name'])");
	
	// After adding an email
	
	By AddEmailSequence = By.xpath("(//*[@id = 'add_behavioural_email'])");
	By EditEmailSequence = By.xpath("(//*[@title = 'Edit'])");
	By ViewEmailSequence = By.xpath("(//*[@title = 'View'])");
	By DeleteEmailSequence = By.xpath("(//*[@title = 'Delete Email Sequence'])");

	
	public By TargetURL = By.xpath("(//*[@target-name = 'targetUrl'])[2]");
	
	public By GoToCartFrame = By.xpath("(//*[contains(@src,'/email-permalink/nv/peId')])");
	
	public CartRecovery_CartRecoveryCampaign(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void BackClick()
	{
		driver.findElement(Back).click();
	}
	
		
	public void ExitClick()
	{
		driver.findElement(Exit).click();
	}
	

	public void MakeActiveClick()
	{
		driver.findElement(MakeActive).click();
	}
	

	public void DeleteClick() throws Exception
	{
		driver.findElement(Delete).click();
		Thread.sleep(2000);
		driver.findElement(Delete_Confirm).click();
	}
	

	public void SaveNextClick()
	{
		driver.findElement(SaveNext).click();
	}
	

	public void AddEmailIconClick()
	{
		driver.findElement(AddEmail).click();
	}
	

	public void PriorityForCampaignCheckboxClick()
	{
		driver.findElement(PriorityForCampaignCheckbox).click();
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
	
	
	// start from here
	
	public void AddEmailSequenceClick()
	{
		driver.findElement(AddEmailSequence).click();			 // directed to  Select Template page
	}
	
	public void EditEmailSequence_CancelClick() 
	{
		driver.findElement(EditEmailSequence).click();           // directed to  design page
	}
	
	public void ViewEmailSequenceClick()
	{
		driver.findElement(ViewEmailSequence).click();			 // Opens template in new tab
	}
	
	public void DeleteEmailSequenceClick()
	{
		driver.findElement(DeleteEmailSequence).click();        // Displays Confirmation alert with OK and Cancel button
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", DeleteEmailSequence);   // To operate on JS alert
		
		Alert confirmationAlert = driver.switchTo().alert();
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);
		confirmationAlert.accept();                // Click on OK button
	}
	
	
	
	
	
}
