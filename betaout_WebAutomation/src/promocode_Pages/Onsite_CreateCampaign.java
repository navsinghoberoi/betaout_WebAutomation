package promocode_Pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
/**
 * @author - Navpreet
 */
public class Onsite_CreateCampaign {

	public WebDriver driver;

	By instancename = By.xpath(".//*[@id='instance_name']");
	By savebuttonCTA = By.xpath("(//*[@id = 'save-call-to-action'])");
	By savebuttonEmail = By.xpath("(//*[@id = 'save-emailSignup'])");
	By savebuttonMobile = By.xpath("(//*[@id = 'save-mobile-lead'])");
	
	By create_campaign = By.xpath("(//*[text() = 'CREATE CAMPAIGN'])[2]");
	By calltoaction = By.xpath("(//*[text() = 'Call to Action'])[2]");
	By emailsignup = By.xpath("(//*[text() = 'Email Signup & Lead Capture'])[2]");
	By mobilelead = By.xpath("(//*[text() = 'MOBILE LEAD CAPTURE'])[2]");

	By InactiveInstance = By.xpath("(//*[@title = 'InactiveAppInstance'])[1]");
	By DeleteInstance = 	By.xpath("(//*[@title = 'Delete App Instance'])[1]");
	By Edit = By.xpath("(//*[@title = 'Edit'])[1]");
	
	public Onsite_CreateCampaign(WebDriver driver)

	{
		this.driver = driver;

	}

	public void createcampaign_click() throws InterruptedException

	{

		driver.findElement(create_campaign).click();

	}

	public void name(String name)

	{

		driver.findElement(instancename).sendKeys(name);
		;

	}

	public void save_click()

	{

		driver.findElement(savebuttonCTA).click();

	}


	public void emailsave_click()

	{

		driver.findElement(savebuttonEmail).click();

	}

	public void mobilesave_click()

	{

		driver.findElement(savebuttonMobile).click();

	}
	
	
	
	
	
	
	public void emailsignupclick() {
		driver.findElement(emailsignup).click();
	}

	public void mobileleadclick() {
		driver.findElement(mobilelead).click();
	}


	public void PrintNameOfFields()

	{
		String heading1 = driver.findElement(calltoaction).getText();
		String heading2 = driver.findElement(emailsignup).getText();
		String heading3 = driver.findElement(mobilelead).getText();
		
		System.out.println("3 tabs on page are "+heading1+"  "+heading2+" "+heading3);
		
		String buttonname = driver.findElement(create_campaign).getText();
		System.out.println("Name of button = "+buttonname);
		
		String heading4 = driver.findElement(By.xpath("(//*[text() = 'Active Instances'])")).getText();
		String heading5 = driver.findElement(By.xpath("(//*[text() = 'Inactive Instances'])")).getText();
		
		System.out.println("2 Headings on the page are "+heading4+"  "+heading5);
		
	} 

/*	public void PrintCampaignPopupDetails()
	
	{
		String heading1 = driver.findElement(By.xpath("(//*[text() = 'CREATING AN NEW APP INSTANCE'])")).getText();
		String heading2 = driver.findElement(By.xpath("(//*[text() = 'Instance Name'])")).getText();
		String heading3 = driver.findElement(savebutton).getText();
	
		System.out.println("2 Headings on the page are = "+heading1+" "+heading2);
		System.out.println("Name of button = "+heading3);
	
	}
	*/

	public void InactiveInstanceClick() throws InterruptedException
	
	{
		List<org.openqa.selenium.WebElement> log = driver.findElements(By.xpath("//*[@title = 'InactiveAppInstance']"));
	    System.out.println("Total active instances before inactivating instance :"+log.size());
		
		String ActiveInstanceName = driver.findElement(By.xpath("(//a[@class = 'camp-name'])[1]")).getText();
		System.out.println("Name of the campaign created = "+ActiveInstanceName);
	    
	    driver.findElement(InactiveInstance).click();
		Thread.sleep(9000);
		
		List<org.openqa.selenium.WebElement> log1 = driver.findElements(By.xpath("//*[@title = 'InactiveAppInstance']"));
	    System.out.println("Total active instances after inactivating instance :"+log1.size());
		
	}

	public void DeleteInstanceClick() throws Exception
	
	{
		driver.findElement(DeleteInstance).click();
		
		// Delete Popup Up
		
		driver.findElement(By.xpath("(//*[@id = 'capsVal'])")).sendKeys("DELETE");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text() = 'Delete'])[2]")).click();
		Thread.sleep(2000);
	}


	public void EditClick()
	
	{
		driver.findElement(Edit).click();
		
	}












}
