package DataImporting_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class ProductImporting {
	
	public WebDriver driver;

	By Users_Tab = By.xpath("(//*[text() = 'Users'])[2]");
	By Orders_Tab = By.xpath("(//*[text() = 'Orders'])[2]");
	By Products_Tab = By.xpath("(//*[text() = 'Products'])[2]");
	By Categories_Tab = By.xpath("(//*[text() = 'Categories'])[2]");
	By SMSSuppression_Tab = By.xpath("(//*[text() = 'SMS Suppression List'])[2]");
	
	By AddImport = By.xpath("(//*[text() = 'Add New Import'])[2]");
	
	By NumberOfUsers = By.xpath("//*[contains(@class,'selectable')]");
	By FileName = By.xpath("(//*[contains(@class,'camp-name')])[1]");       
	By NumberOfContacts = By.xpath("//*[contains(@class,'selectable')]/td[3]");
	By TotalSuccessRows = By.xpath("//*[contains(@class,'selectable')]/td[4]");
	By TotalFailRows = By.xpath("//*[contains(@class,'selectable')]/td[5]");
	By Unprocessed  = By.xpath("//*[contains(@class,'selectable')]/td[6]");
	By Date = By.xpath("//*[contains(@class,'selectable')]/td[7]");
	
	// Upload File
	
	By DownloadSampleFile = By.xpath("//*[contains(text(),'DOWNLOAD SAMPLE FILE')]");
	By UploadFile = By.xpath("//*[contains(@name,'submitPicker')]");
	By ChooseFile = By.xpath("//*[contains(@id,'selectCsvFilePicker')]");
	By Filepicker_IFrame = By.xpath("//*[contains(@name,'filepicker_dialog')]");
	By ChooseFileButton = By.xpath("//*[contains(@name,'fileUpload')]");
	
	// Mapping
	
	
	By ImportName = By.xpath("//*[@name = 'csvname']");
	By SelectProperty1 = By.xpath("//*[contains(@name,'selectColMap[0]')]");
	By SelectProperty2 = By.xpath("//*[contains(@name,'selectColMap[1]')]");
	By SelectProperty3 = By.xpath("//*[contains(@name,'selectColMap[2]')]");
	By SelectProperty4 = By.xpath("//*[contains(@name,'selectColMap[3]')]");
	By SelectProperty5 = By.xpath("//*[contains(@name,'selectColMap[4]')]");
	By SelectProperty6 = By.xpath("//*[contains(@name,'selectColMap[5]')]");
	By SelectProperty7 = By.xpath("//*[contains(@name,'selectColMap[6]')]");
	By StartImporting = By.xpath("//*[contains(@name,'startImporting')]");
	

	
	
	public ProductImporting(WebDriver driver)
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

		String SuccessRows = driver.findElement(TotalSuccessRows).getText();
		System.out.println("Number of success rows = "+SuccessRows);

		String FailRows = driver.findElement(TotalFailRows).getText();
		System.out.println("Number of fail rows = "+FailRows);

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
	
	public void enterImportName(String name)
	{
		driver.findElement(ImportName).sendKeys(name);
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
	
	
	public void SelectPropertyvalue5(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty5));
		value1.selectByVisibleText(value);
	}
	
	public void SelectPropertyvalue6(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty6));
		value1.selectByVisibleText(value);
	}
	
	public void SelectPropertyvalue7(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty7));
		value1.selectByVisibleText(value);
	}
	
	public void startImporting()
	{
		driver.findElement(StartImporting ).click();
	}

	
	
}
