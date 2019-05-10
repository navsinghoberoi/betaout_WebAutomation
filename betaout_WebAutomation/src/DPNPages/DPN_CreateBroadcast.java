package DPNPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author - Navpreet
 */
public class DPN_CreateBroadcast {

	public WebDriver driver;
	
	// Design Page

	By SaveAndNext = By.xpath("//*[text() = 'Save & Next']");
	By SaveAndExit = By.xpath("//*[text() = 'Save & Exit']");
	By Save =	By.xpath("//*[text() = 'Save']");
	By Exit = By.xpath("//*[text() = 'Exit']");
	
	
	By CampaginsTitle = By.xpath("(//*[@name = 'campaignName'])");
	By Cancel = By.xpath("(//*[@class = 'cancel'])");
	By SaveNext = By.xpath("(//*[@name = 'saveCampaignBtn'])");
	
	
	By NotificationTitle = By.xpath("(//*[@id = 'noteTitle'])");
	By PushMessage = By.xpath("(//*[@id = 'noteMessage'])");
	By LandingURL = By.xpath("(//*[@name = 'landing_page_url'])");
	By UploadImageURL = By.xpath("(//*[text() = 'Add Icon URL'])");
	By ImageURL = By.xpath("(//*[@id = 'icon_url'])");
	By UploadIcon = By.xpath("(//*[text() = 'Upload Icon'])");
	By SelectIconForUploading = By.xpath("(//*[@src = 'https://s3.amazonaws.com/www.betaoutcdn.com/300212016/06/1467283908.png'])");
	
	
	By AddButtons = By.xpath("//*[@id = 'addButtons']");
	By DelayWithIdle = By.xpath("//*[@for = 'delay_with_idle']");
	By RequireInteraction = By.xpath("//*[@for = 'requires_interaction']");
	
	By NotificationTag = By.xpath("//*[@name = 'notification_tag']");
	
	
	
	
	
	

	//Target Page     (Same as Email Marketing)

	By ChromeEnabled = By.xpath("//*[@for = 'chromeEnabled']");
	By FirefoxEnabled = By.xpath("//*[@for = 'firefoxEnabled']");
	
	By ANDCondition = By.xpath("(//a[contains(text(),'ADD NEW')])[1]");
	By ORCondition = By.xpath("(//a[contains(text(),'ADD NEW')])[2]");
	
	By ANDDropdown1 = By.xpath("(//*[@id = 'commonEnentPropertyDropDown_1'])");
	By ANDDropdown2 = By.xpath("(//*[@id = 'changeDataByProprtyAndEvent_1'])");
	By ANDDropdown3 = By.xpath("(//*[@id = 'eventAndPropertyCondition_1'])");
	By ANDDropdown4 = By.xpath("(//*[@id = 'parmanuTextBox_1'])");
	
	By ORDropdown1 = By.xpath("(//*[@id = 'commonEnentPropertyDropDownOrCondition_1'])");
	By ORDropdown2 = By.xpath("(//*[@id = 'changeDataByProprtyAndEventOrCondition_1'])");
	By ORDropdown3 = By.xpath("(//*[@id = 'eventAndPropertyConditionOrCondition_1'])");
	By ORDropdown4 = By.xpath("(//*[@id = 'parmanuTextBoxOrCondition_1'])");
	
	By DeleteRule  = By.xpath("(//*[contains(@class,'delete-this-rule')])[1]");     // to delete first condition
	
	By RefreshContacts = By.xpath("//*[@title ='refresh']");
		
	By NumberOfContacts = By.xpath("(//*[@class = 'pull-left fs-23 runtime_userCount'])");
	
	//Active Page 
		
	By Activate = By.xpath("(//*[@value = 'active'])");
	By Schedule = By.xpath("//*[contains(text(),'SCHEDULE NOW')]");		
	
	
	public DPN_CreateBroadcast(WebDriver driver)
	{
		this.driver = driver;
	}
	

	
	
	
	
	
	
		
	public void RefreshContactsClick()
	{
		driver.findElement(RefreshContacts).click();
	}
	
	public void ANDConditionClick()
	{
		driver.findElement(ANDCondition).click();
	}
	
	public void ORConditionClick()
	{
		driver.findElement(ORCondition).click();
	}
	
	public void ANDDropdown1Click(String select)
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown1));
		dropdown.selectByVisibleText(select);                  // Select User Property
		
		String name = driver.findElement(ANDDropdown1).getText();
		System.out.println("Name of the Selected 1stDropdown = "+name);
		
	}
	
	public void ANDDropdown2Click(String phone)
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown2));
		dropdown.selectByVisibleText(phone);                  // Select Phone
		
		String name = driver.findElement(ANDDropdown2).getText();
		System.out.println("Name of the Selected 2ndDropdown = "+name);
	}
	
	public void ANDDropdown3Click(String matches)
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown3));
		dropdown.selectByVisibleText(matches);                // Select Exactly Matches
		
		String name = driver.findElement(ANDDropdown3).getText();
		System.out.println("Name of the Selected 3rdDropdown = "+name);
	}
	
	public void ANDDropdown4Click(String number)
	{
		driver.findElement(ANDDropdown4).sendKeys(number);
	}
	
	public void ORDropdown1Click()
	{
		Select dropdown = new Select(driver.findElement(ORDropdown1));
		dropdown.selectByVisibleText("User Property");                  // Select User Property
		
		String name = driver.findElement(ORDropdown1).getText();
		System.out.println("Name of the Selected 1stDropdown = "+name);
	}
	
	public void ORDropdown2Click()
	{
		Select dropdown = new Select(driver.findElement(ORDropdown2));
		dropdown.selectByVisibleText("phone");                  // Select Phone
		
		String name = driver.findElement(ORDropdown2).getText();
		System.out.println("Name of the Selected 2ndDropdown = "+name);
	}
	
	public void ORDropdown3Click()
	{
		Select dropdown = new Select(driver.findElement(ORDropdown3));
		dropdown.selectByVisibleText("Exactly matches");                // Select Exactly Matches
		
		String name = driver.findElement(ORDropdown3).getText();
		System.out.println("Name of the Selected 3rdDropdown = "+name);
	}
	
	public void ORDropdown4Click(String number)
	{
		driver.findElement(ORDropdown4).sendKeys(number);
	}
	
	public void NumberOfContactsClick()
	{
		String NumOfContacts = driver.findElement(NumberOfContacts).getText();
		System.out.println("Number of contacts after refreshing are = "+NumOfContacts);
	}
	
	
	public void DeleteRuleClick()
	{
		driver.findElement(DeleteRule).click();
	}
	
	
	
	
}
