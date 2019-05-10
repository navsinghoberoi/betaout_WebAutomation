package MobilePushPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class mobilePush_TargetingPage {
	
	public WebDriver driver;
	By TargetingUserCount = By.xpath("//span[@class='runTime_user']/span");
	By refreshButton = By.xpath("//i[@title='refresh']");
	By sendToOnlyLimitedContacts = By.xpath("(//input[@id='1'])[1]");
	By sendToOnlyLimitedContactsTextField = By.xpath("//input[@id='pn_send_limit']");
	By andButton = By.xpath("(//a[contains(text(),'ADD NEW')])[1]");
	By orButton = By.xpath("(//a[contains(text(),'ADD NEW')])[2]");
	By editTimeIntervalLink = By.xpath("//a[@href='/pn/time-interval-between-pn']/span[text()='Edit Time Interval']");
	By andFirstDropDown = By.xpath("//select[@id='commonEnentPropertyDropDown_1']");
	By orFirstDropDown = By.xpath("//*[@id='commonEnentPropertyDropDownOrCondition_1']");
	By firstDropDownSegmentationOption = By.xpath("(//option[@value='segmentations'])[1]");
	By secondDropDownSegmentationOption = By.xpath("//select[@attr-data='segmentations']");
	By thirdDropDownOption = By.xpath("(//select[@id='changeDataByProprtyAndEvent_1'])[1]");
	By fourthDropDownOption = By.xpath("(//select[@id='eventAndPropertyCondition_1'])[1]");
	By segmentationSecondDropDownIsAMemberOfOption = By.xpath("(//option[@value='IsMemberOf'])[1]");
	By segmentationSecondDropDownIsNotAMemberOfOption = By.xpath("(//option[@value='IsNotMemebrOf'])[1]");
	By segmentationThirdDropDownLifecycleOption = By.xpath("(//option[@value='lifecycleid'])[1]");
	By segmentationThirdDropDownSegmentOption = By.xpath("(//option[@value='segmentid'])[1]");
	By segmentationThirdDropDownTagOption = By.xpath("(//option[@value='tagid'])[1]");
	By deleteConditionbutton = By.xpath("//i[@class='fa fa-minus-square delete-this-rule']");
	
	
	
	By ANDDropdown1 = By.xpath("(//*[@id = 'commonEnentPropertyDropDown_1'])");
	By ANDDropdown2 = By.xpath("(//*[@id = 'changeDataByProprtyAndEvent_1'])");
	By ANDDropdown3 = By.xpath("(//*[@id = 'eventAndPropertyCondition_1'])");
	By ANDDropdown4 = By.xpath("(//*[@id = 'parmanuTextBox_1'])");
	
	By ORDropdown1 = By.xpath("(//*[@id = 'commonEnentPropertyDropDownOrCondition_1'])");
	By ORDropdown2 = By.xpath("(//*[@id = 'changeDataByProprtyAndEventOrCondition_1'])");
	By ORDropdown3 = By.xpath("(//*[@id = 'eventAndPropertyConditionOrCondition_1'])");
	By ORDropdown4 = By.xpath("(//*[@id = 'parmanuTextBoxOrCondition_1'])");

	
	public mobilePush_TargetingPage(WebDriver driver)
	{
	
		
		
		this.driver = driver;// TODO Auto-generated constructor stub
	}
	
	public String getUserCount()
	{
		String count = driver.findElement(TargetingUserCount).getText();
		return count;
	}
	
	public void clickOnRefreshButton()
	{
		driver.findElement(refreshButton).click();
	}
	
	public void clickOnSendtoLimitedContactsCheckbox()
	{
		driver.findElement(sendToOnlyLimitedContacts).click();
	}
	
	public void setNumberofLimitedContacts(String numberOfContacts)
	{
		driver.findElement(sendToOnlyLimitedContactsTextField).clear();
		driver.findElement(sendToOnlyLimitedContactsTextField).sendKeys(numberOfContacts);
	}
	
	public void clickOnAddButton()
	{
		driver.findElement(andButton).click();
	}
	
	public void clickOnOrButton()
	{
		driver.findElement(orButton).click();
	}
	
	public void clickOnEditTimeIntervalLink()
	{
		driver.findElement(editTimeIntervalLink).click();
	}
	
/*	public void clickOnFirstAndDropDown()
	{
		Select dropdown = new Select(driver.findElement(andFirstDropDown));// Enter data in Address 
		dropdown.selectByIndex(5);
		driver.findElement(andFirstDropDown).click();
	}
	
	public void clickOnSegmentationOptionInFirstDropDownAnd()
	{
		driver.findElement(firstDropDownSegmentationOption).click();
	}
	
	public void clickOnSecondDropDownSegmentationOptionAND()
	{
		driver.findElement(secondDropDownSegmentationOption).click();
	}
	
	public void selectIsAMemberOfOptionSecondDropDown()
	{
		driver.findElement(segmentationSecondDropDownIsAMemberOfOption).click();
	}

	public void selectIsNotAMemberOfOptionSecondDropDown()
	{
		driver.findElement(segmentationSecondDropDownIsNotAMemberOfOption).click();
	}
	
	public void clickOnThirdDropDownSegmentationOptionAND()
	{
		driver.findElement(thirdDropDownOption).click();
	}
	
	public void clickOnFourthDropDownSegmentationOptionAND()
	{
		driver.findElement(fourthDropDownOption).click();
	}
	
	public void selectLifecycleOptionThirdDropDown()
	{
		driver.findElement(segmentationThirdDropDownLifecycleOption).click();
	}
	
	public void selectSegmentOptionThirdDropDown()
	{
		driver.findElement(segmentationThirdDropDownSegmentOption).click();
	}
	
	public void selectTagOptionThirdDropDown()
	{
		driver.findElement(segmentationThirdDropDownTagOption).click();
	}
*/	
	
	
	
	public void ANDDropdown1Click()
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown1));
		dropdown.selectByVisibleText("User Property");                  // Select User Property
		
		String name = driver.findElement(ANDDropdown1).getText();
		System.out.println("Name of all options from 1stDropdown = "+name);
		
	}
	
	public void ANDDropdown2Click()
	{
		Select dropdown = new Select(driver.findElement(ANDDropdown2));
		dropdown.selectByVisibleText("customer_id");                  // Select Customer ID
		
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
	
	
	
	
	
	public void deleteConditionforAND()
	{
		driver.findElement(deleteConditionbutton).click();
	}
}
