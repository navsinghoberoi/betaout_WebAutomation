package DataImporting_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class SMSSuppressionImporting {
	
	public WebDriver driver;

	By Users_Tab = By.xpath("(//*[text() = 'Users'])[2]");
	By Orders_Tab = By.xpath("(//*[text() = 'Orders'])[2]");
	By Products_Tab = By.xpath("(//*[text() = 'Products'])[2]");
	By Categories_Tab = By.xpath("(//*[text() = 'Categories'])[2]");
	By SMSSuppression_Tab = By.xpath("(//*[text() = 'SMS Suppression List'])[2]");
	
	By AddImport = By.xpath("(//*[text() = 'Add New Import'])[2]");
	
	By NumberOfUsers = By.xpath("//*[contains(@class,'selectable')]");
	By FileName = By.xpath("//*[contains(@class,'selectable')]/td[2]");       
	By NumberOfContacts = By.xpath("//*[contains(@class,'selectable')]/td[3]");
	By Unprocessed  = By.xpath("//*[contains(@class,'selectable')]/td[4]");
	By Date = By.xpath("//*[contains(@class,'selectable')]/td[5]");
	
	// Upload File
	
	By DownloadSampleFile = By.xpath("//*[contains(text(),'DOWNLOAD SAMPLE FILE')]");
	By UploadFile = By.xpath("//*[contains(@name,'submit')]");
	By ChooseFile = By.xpath("(//*[contains(@id,'selectCsvFile')])[2]");
	By Filepicker_IFrame = By.xpath("//*[contains(@name,'filepicker_dialog')]");
	By ChooseFileButton = By.xpath("//*[contains(@name,'fileUpload')]");
	
	// Mapping
	By SelectPropertyGroup1 = By.xpath("(//*[@class = 'customSelectWhite'])[1]");
	By SelectPropertyGroup2 = By.xpath("(//*[@class = 'customSelectWhite'])[2]");
	By SelectPropertyGroup3 = By.xpath("(//*[@class = 'customSelectWhite'])[3]");
	By SelectPropertyGroup4 = By.xpath("(//*[@class = 'customSelectWhite'])[4]");
	By SelectProperty1 = By.xpath("//*[contains(@name,'property_0')]");
	By SelectProperty2 = By.xpath("//*[contains(@name,'property_1')]");
	By SelectProperty3 = By.xpath("//*[contains(@name,'property_2')]");
	By SelectProperty4 = By.xpath("//*[contains(@name,'property_3')]");
	By StartImporting = By.xpath("//*[contains(@name,'startImporting')]");
	

	
	
	public SMSSuppressionImporting(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void UsersTabClick()
	{
		
		driver.findElement(Users_Tab).click();
	}
	
	public void OrdersTabClick()
	{
		
		driver.findElement(Orders_Tab).click();
	}
	
	public void ProductsTabClick()
	{
		
		driver.findElement(Products_Tab).click();
	}
	
	public void CategoriesTabClick()
	{
		
		driver.findElement(Categories_Tab).click();
	}
	
	public void SMSSuppressionTabClick()
	{
		
		driver.findElement(SMSSuppression_Tab).click();
	}
	
	
	public void AddImportClick()
	{
		driver.findElement(AddImport).click();
	}
	
	
	public void printFileInfo()
	{
		
		int totalFiles = driver.findElements(NumberOfUsers).size();
		System.out.println("Total files uploaded = "+totalFiles);
		
		String fileName = driver.findElement(FileName).getText();
		System.out.println("Name of file = "+fileName);

		String NoOfContacts = driver.findElement(NumberOfContacts).getText();
		System.out.println("Number Of Contacts = "+NoOfContacts);

		String Unprocess = driver.findElement(Unprocessed).getText();
		System.out.println("Number of unprocessed contacts = "+Unprocess);

		String date = driver.findElement(Date).getText();
		System.out.println("Date of file = "+date);


	}	
	
	public void DownloadFileClick()
	{
		driver.findElement(DownloadSampleFile).click();
	}
	
	public void UploadFileClick()
	{
		driver.findElement(UploadFile).click();
	}
	
	
	public void ChooseFileClick(String path)
	{
		driver.findElement(ChooseFile).sendKeys(path);;
	}
	
/*	public void ChooseFileButton(String path)
	{
		driver.switchTo().frame(driver.findElement(Filepicker_IFrame));
		driver.findElement(ChooseFileButton).sendKeys(path);;
	}
*/	

	public void SelectPropertyGroup1(String text)
	{
		Select group1 = new Select(driver.findElement(SelectPropertyGroup1));
		group1.selectByVisibleText(text);
	}
	
	public void SelectPropertyGroup2(String text)
	{
		Select group2 = new Select(driver.findElement(SelectPropertyGroup2));
		group2.selectByVisibleText(text);
	}

	public void SelectPropertyGroup3(String text)
	{
		Select group3 = new Select(driver.findElement(SelectPropertyGroup3));
		group3.selectByVisibleText(text);
	}

	public void SelectPropertyGroup4(String text)
	{
		Select group4 = new Select(driver.findElement(SelectPropertyGroup4));
		group4.selectByVisibleText(text);
	}

	
	public void SelectPropertyvalue1(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty1));
		value1.selectByVisibleText(value);
	}
	
	public void SelectPropertyvalue2(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty2));
		value1.selectByVisibleText(value);
	}

	public void SelectPropertyvalue3(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty3));
		value1.selectByVisibleText(value);
	}

	public void SelectPropertyvalue4(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty4));
		value1.selectByVisibleText(value);
	}
	
	
	
	public void startImporting()
	{
		driver.findElement(StartImporting ).click();
	}

	
	
}
