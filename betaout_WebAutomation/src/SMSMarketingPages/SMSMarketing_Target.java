package SMSMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

// elements are common for Broadcast and Recurring
/**
 * @author - Navpreet
 */
public class SMSMarketing_Target {
	
	public WebDriver driver;

	By SendTestSMS = By.xpath("(//*[@id = 'open_test_sms_popup'])");
	By SendTestSMS_Number = By.xpath("(//*[@name = 'mobiles'])[2]");
	By SendTestSMS_Send = By.xpath("(//*[@name = 'send_test_sms'])");
	
	By AddMobileNumbers = By.xpath("(//*[@id = 'textString'])");
	By RefreshContacts = By.xpath("(//*[@style = 'position: relative; top: -4px;'])");
	By ANDCondition = By.xpath("(//*[@style = 'margin-bottom: 5px'])[1]");
	By ORCondition = By.xpath("(//*[@style = 'margin-bottom: 5px'])[2]");
	
	By ANDDropdown1 = By.xpath("(//*[@id = 'commonEnentPropertyDropDown_1'])");
	By ANDDropdown2 = By.xpath("(//*[@id = 'changeDataByProprtyAndEvent_1'])");
	By ANDDropdown3 = By.xpath("(//*[@id = 'eventAndPropertyCondition_1'])");
	By ANDDropdown4 = By.xpath("(//*[@id = 'parmanuTextBox_1'])");
	
	By ORDropdown1 = By.xpath("(//*[@id = 'commonEnentPropertyDropDownOrCondition_1'])");
	By ORDropdown2 = By.xpath("(//*[@id = 'changeDataByProprtyAndEventOrCondition_1'])");
	By ORDropdown3 = By.xpath("(//*[@id = 'eventAndPropertyConditionOrCondition_1'])");
	By ORDropdown4 = By.xpath("(//*[@id = 'parmanuTextBoxOrCondition_1'])");
	
	By DeleteRule  = By.xpath("(//*[contains(@class,'delete-this-rule')])[1]");     // to delete first condition
	
	By NumberOfContacts = By.xpath("(//*[@class = 'pull-left fs-23 runtime_userCount'])");
	By EditName = By.xpath("(//*[@class = 'fa fa-pencil editCampignNameIn '])");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameCampign_')]");
	By EditName_Save = By.xpath("(//*[text() = 'Save'])[2]");
	By EditName_Cancel = By.xpath("(//*[text() = 'Cancel'])");
	
 //	By EditTimeInterval = By.xpath("(//*[@href = '/sms/time-interval-between-sms'])");
		
	public SMSMarketing_Target(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void SendTestSMSClick(String number) throws Exception
	{
		driver.findElement(SendTestSMS).click();
		Thread.sleep(2000);
		driver.findElement(SendTestSMS_Number).sendKeys(number);
		driver.findElement(SendTestSMS_Send).click();
		
	}
	
	public void AddMobileNumbersClick(String number)
	{
		driver.findElement(AddMobileNumbers).click();
		driver.findElement(AddMobileNumbers).sendKeys(number);
		
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
	
	public void ANDDropdown1Click()
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown1));
		dropdown.selectByVisibleText("User Property");                  // Select User Property
		
		String name = driver.findElement(ANDDropdown1).getText();
		System.out.println("Name of all options from 1stDropdown = "+name);
		
	}
	
	public void ANDDropdown2Click(String name1)
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown2));
		dropdown.selectByVisibleText(name1);                  // Select Phone
		
		String name = driver.findElement(ANDDropdown2).getText();
		System.out.println("Name of all options from 2ndDropdown = "+name);
	}
	
	public void ANDDropdown3Click()
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown3));
		dropdown.selectByVisibleText("Exactly matches");                // Select Exactly Matches
		
		String name = driver.findElement(ANDDropdown3).getText();
		System.out.println("Name of all options from 3rdDropdown = "+name);
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
	
	public void EditNameClick()
	{
		driver.findElement(EditName).click();
		
		String CampaignName =	driver.findElement(EditName_Rename).getText();
		System.out.println("Name of the campaign = "+CampaignName);

			driver.findElement(EditName_Save).click();
	}
	
	/*public void EditTimeIntervalClick(String time)
	{
		driver.findElement(EditTimeInterval).click();
		
		driver.findElement(By.xpath("(//*[@name = 'timeIntervalBetweenSms'])")).sendKeys(time); 
		driver.findElement(By.xpath("(//*[@name = 'save'])")).click();            // Click on Save
	}*/
	
	
	
	public void DeleteRuleClick()
	{
		driver.findElement(DeleteRule).click();
	}
	
}
