package DataImporting_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class OrderImporting {
	
	public WebDriver driver;

	By Users_Tab = By.xpath("(//*[text() = 'Users'])[2]");
	By Orders_Tab = By.xpath("(//*[text() = 'Orders'])[2]");
	By Products_Tab = By.xpath("(//*[text() = 'Products'])[2]");
	By Categories_Tab = By.xpath("(//*[text() = 'Categories'])[2]");
	By SMSSuppression_Tab = By.xpath("(//*[text() = 'SMS Suppression List'])[2]");
	
	By AddImport = By.xpath("(//*[text() = 'Add New Import'])[2]");
	
	By NumberOfUsers = By.xpath("//*[contains(@class,'selectable')]");
	By FileName = By.xpath("//*[contains(@class,'selectable')]/td[2]");
	By ImportedOrders = By.xpath("//*[contains(@class,'selectable')]/td[3]");
	By TotalSuccessRows = By.xpath("//*[contains(@class,'selectable')]/td[4]");
	By TotalFailRows = By.xpath("//*[contains(@class,'selectable')]/td[5]");
	By Unprocessed = By.xpath("//*[contains(@class,'selectable')]/td[6]");
	By Date = By.xpath("//*[contains(@class,'selectable')]/td[7]");
	By Status = By.xpath("//*[contains(@class,'selectable')]/td[8]");
	
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
	By SelectProperty8 = By.xpath("//*[contains(@name,'selectColMap[7]')]");
	By SelectProperty9 = By.xpath("//*[contains(@name,'selectColMap[8]')]");
	By SelectProperty10 = By.xpath("//*[contains(@name,'selectColMap[9]')]");
	By SelectProperty11 = By.xpath("//*[contains(@name,'selectColMap[10]')]");
	By SelectProperty12 = By.xpath("//*[contains(@name,'selectColMap[11]')]");
	By SelectProperty13 = By.xpath("//*[contains(@name,'selectColMap[12]')]");
		
	By StartImporting = By.xpath("//*[contains(@name,'startImporting')]");
	
		
	By ProcessIcon = By.xpath("(//*[contains(@class,'iconAction-active')])[1]");
	By DownloadIcon = By.xpath("(//*[contains(@class,'iconAction-download')])[1]");
	By DeleteIcon = By.xpath("(//*[contains(@class,'iconAction-delete')])[1]");
	
	
	
	
	public OrderImporting(WebDriver driver)
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
	
	
	public void printTotalUploadedFiles()
	{
		int total = driver.findElements(NumberOfUsers).size();
		System.out.println("Total number of files uploaded = "+total);
	}

	
	public void printFileName()
	{
		String name = driver.findElement(FileName).getText();
		System.out.println("Name of file is = "+ name);
	}
	
	public void printFileInfo()
	{
		
		int totalFiles = driver.findElements(NumberOfUsers).size();
		System.out.println("Total files uploaded = "+totalFiles);
		
		String fileName = driver.findElement(FileName).getText();
		System.out.println("Name of file = "+fileName);

		String Imported = driver.findElement(ImportedOrders).getText();
		System.out.println("Number of imported orders = "+Imported);

		String SuccessRows = driver.findElement(TotalSuccessRows).getText();
		System.out.println("Number of success rows = "+SuccessRows);

		String FailRows = driver.findElement(TotalFailRows).getText();
		System.out.println("Number of fail rows = "+FailRows);

		String Unprocess = driver.findElement(Unprocessed).getText();
		System.out.println("Number of unprocessed contacts = "+Unprocess);

		String date = driver.findElement(Date).getText();
		System.out.println("Date of file = "+date);

		String status = driver.findElement(Status).getText();
		System.out.println("Status of file = "+status);


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

	public void SelectPropertyvalue8(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty8));
		value1.selectByVisibleText(value);
	}

	public void SelectPropertyvalue9(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty9));
		value1.selectByVisibleText(value);
	}

	public void SelectPropertyvalue10(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty10));
		value1.selectByVisibleText(value);
	}

	public void SelectPropertyvalue11(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty11));
		value1.selectByVisibleText(value);
	}

	public void SelectPropertyvalue12(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty12));
		value1.selectByVisibleText(value);
	}

	public void SelectPropertyvalue13(String value)
	{
		
		Select value1 = new Select(driver.findElement(SelectProperty13));
		value1.selectByVisibleText(value);
	}
	
	
	
	public void startImporting()
	{
		driver.findElement(StartImporting ).click();
	}
	
	
	public void ProcessFile() throws Exception
	{
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(ProcessIcon)).build().perform();
		Thread.sleep(1500);
		driver.findElement(ProcessIcon).click();
	//	act1.click();
		
	}
	
	
	
}
