package DataImporting_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class BounceListImporting {
	
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
	By Unprocessed = By.xpath("//*[contains(@class,'selectable')]/td[4]");
	By Date = By.xpath("//*[contains(@class,'selectable')]/td[5]");
	
	// Upload File
	
	By DownloadSampleFile = By.xpath("//*[contains(text(),'DOWNLOAD SAMPLE FILE')]");
	By UploadFile = By.xpath("//*[contains(@name,'submitPicker')]");
	By ChooseFile = By.xpath("//*[contains(@id,'selectCsvFilePicker')]");
	By Filepicker_IFrame = By.xpath("//*[contains(@name,'filepicker_dialog')]");
	By ChooseFileButton = By.xpath("//*[contains(@name,'fileUpload')]");
	
	By DownloadIcon = By.xpath("(//*[contains(@class,'iconAction-download')])[1]");
	By DeleteIcon = By.xpath("(//*[contains(@class,'iconAction-delete')])[1]");
	
	
	
	
	public BounceListImporting(WebDriver driver)
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
		
		String totalContacts = driver.findElement(NumberOfContacts).getText();
		System.out.println("Number of contacts of file = "+totalContacts);
		
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
		driver.findElement(UploadFile ).click();
	}
	
	
	public void ChooseFileClick()
	{
		driver.findElement(ChooseFile).click();
	}
	
	public void ChooseFileButton(String path)
	{
		driver.switchTo().frame(driver.findElement(Filepicker_IFrame));
		driver.findElement(ChooseFileButton).sendKeys(path);;
	}
	
		
	
	
}
