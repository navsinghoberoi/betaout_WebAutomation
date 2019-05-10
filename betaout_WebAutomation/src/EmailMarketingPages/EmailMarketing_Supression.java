package EmailMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class EmailMarketing_Supression {

	
public 	WebDriver driver;
	
	
	
	By Unsubscribers = By.xpath("(//*[@href = '/email/unsubscribers'])[3]");
	By Unsubscribers_AddNew = By.xpath("(//*[contains(@class,'addNewUnsubscriber')])[2]");
	By Unsubscribe_ExportCSV = By.xpath("(//*[@href = '/email/export/nv/expType/unsubscribe'])");
	By Unsubscribe_EnterEmails = By.xpath("(//*[@id = 'unSubscribeName'])");						// xpath changed
	By Unsubscribe_AddToUnsubscribeList = By.xpath("(//*[contains(@class,'saveUnSubscribeList')])");		// xpath changed
	
	
	By Spam_Complaints = By.xpath("(//*[@href = '/email/spam'])[1]");
	By Spam_AddNew = By.xpath("(//*[contains(@class,'addNewUnsubscriber')])[2]");
	By Spam_ExportCSV = By.xpath("(//*[@href = '/email/spam/nv/csv/1'])");
	By Spam_EnterEmails = By.xpath("(//*[@id = 'emails'])");				 // xpath changed
	By Spam_AddToUnsubscribeList = By.xpath("(//*[contains(@class,'suppressEmails')])");		 // xpath changed
	
	
	By Bounced = By.xpath("(//*[@href = '/email/bounce'])[1]");
	By Bounced_AddNew = By.xpath("(//*[contains(@class,'addNewUnsubscriber')])[2]");
	By Bounced_ExportCSV = By.xpath("(//*[@href = '/email/bounce/nv/csv/1'])");
	By Bounced_EnterEmails = By.xpath("(//*[@id = 'emails'])");                                     // xpath changed
	By Bounced_AddToUnsubscribeList = By.xpath("(//*[contains(@class,'suppressEmails')])");			// xpath changed
	
	
	
	public EmailMarketing_Supression(WebDriver driver)
	
	{
		this.driver = driver;
		
	}
	
	
	public String PrintUnsubscribedEmailAddress()
	{
		String ExpectedUnsubscriber = driver.findElement(By.xpath("//*[contains(@class,'selectable')]/td[1]")).getText();
		System.out.println("Unsubscribed Contact's Email ID entered by user = "+ExpectedUnsubscriber);
		return ExpectedUnsubscriber;
	
	}
	

	public void PrintUnsubscribedEmailTime()
	{
		String ExpectedUnsubscribeTime = driver.findElement(By.xpath("//*[contains(@class,'selectable')]/td[4]")).getText();
		System.out.println("Unsubscribed Contact's Time entered by user = "+ExpectedUnsubscribeTime);
	}
	
	
	

	public String PrintBouncedEmailAddress()
	{
		String ExpectedBouncedID = driver.findElement(By.xpath("//*[contains(@class,'selectable')]/td[1]")).getText();
		System.out.println("Bounced Contact's Email ID entered by user = "+ExpectedBouncedID);
		return ExpectedBouncedID;
	
	}
	

	public void PrintBouncedEmailTime()
	{
		String ExpectedBouncedTime = driver.findElement(By.xpath("//*[contains(@class,'selectable')]/td[2]")).getText();
		System.out.println("Bounced Contact's Time entered by user = "+ExpectedBouncedTime);
	}
	
	
	
	public void UnsubscribersClick()
	{
		
		driver.findElement(Unsubscribers).click();
	}
	
	
	public void Unsubscribers_AddNewClick()
	{
		
		driver.findElement(Unsubscribers_AddNew).click();
	}
	
	
	public void Unsubscribe_ExportCSVClick()
	{
		
		driver.findElement(Unsubscribe_ExportCSV).click();
	}
	
	
	public void Unsubscribe_EnterEmailsClick(String email)
	{
		
		driver.findElement(Unsubscribe_EnterEmails).sendKeys(email);
	}
	
	
	public void Unsubscribe_AddToUnsubscribeListClick()
	{
		
		driver.findElement(Unsubscribe_AddToUnsubscribeList).click();
	}
	
	
	public void Spam_ComplaintsClick()
	{
		
		driver.findElement(Spam_Complaints).click();
	}
	
	
	public void Spam_AddNewClick()
	{
		
		driver.findElement(Spam_AddNew).click();
	}
	
	
	public void Spam_ExportCSVClick()
	{
		
		driver.findElement(Spam_ExportCSV).click();
	}
	
	
	public void Spam_EnterEmailsClick(String email)
	{
		
		driver.findElement(Spam_EnterEmails).sendKeys(email);
	}
	
	
	public void Spam_AddToUnsubscribeListClick()
	{
		
		driver.findElement(Spam_AddToUnsubscribeList).click();
	}
	
	
	public void BouncedClick()
	{
		
		driver.findElement(Bounced).click();
	}
	
	
	public void Bounced_AddNewClick()
	{
		
		driver.findElement(Bounced_AddNew).click();
	}
	
	
	public void Bounced_ExportCSVClick()
	{
		
		driver.findElement(Bounced_ExportCSV).click();
	}
	
	
	public void Bounced_EnterEmailsClick(String email)
	{
		
		driver.findElement(Bounced_EnterEmails).sendKeys(email);
	}
	
	
	public void Bounced_AddToUnsubscribeListClick()
	{
		
		driver.findElement(Bounced_AddToUnsubscribeList).click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
