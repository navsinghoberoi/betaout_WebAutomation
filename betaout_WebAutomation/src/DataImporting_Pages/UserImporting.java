package DataImporting_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class UserImporting {
	
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
	By Unprocessed  = By.xpath("//*[contains(@class,'selectable')]/td[4]");
	By Date = By.xpath("(//*[contains(@class,'hp-main-figure')])[1]");
	
	// Upload File
	
	By DownloadSampleFile = By.xpath("//*[contains(text(),'DOWNLOAD SAMPLE FILE')]");
	By UploadFile = By.xpath("//*[contains(@name,'submitPicker')]");
	By ChooseFile = By.xpath("//*[contains(@id,'selectCsvFilePicker')]");
	By Filepicker_IFrame = By.xpath("//*[contains(@name,'filepicker_dialog')]");
	By ChooseFileButton = By.xpath("//*[contains(@name,'fileUpload')]");
	
	// Mapping
	
	
	By ImportName = By.xpath("//*[@name = 'csvname']");
	By SelectTag = By.xpath("(//*[@class = 'customSelectWhite'])[1]"); 
	By SelectPropertyGroup1 = By.xpath("(//*[@class = 'customSelectWhite'])[2]");
	By SelectPropertyGroup2 = By.xpath("(//*[@class = 'customSelectWhite'])[3]");
	By SelectPropertyGroup3 = By.xpath("(//*[@class = 'customSelectWhite'])[4]");
	By SelectPropertyGroup4 = By.xpath("(//*[@class = 'customSelectWhite'])[5]");
	By SelectProperty1 = By.xpath("//*[contains(@name,'selectColMap[0]')]");
	By SelectProperty2 = By.xpath("//*[contains(@name,'selectColMap[1]')]");
	By SelectProperty3 = By.xpath("//*[contains(@name,'selectColMap[2]')]");
	By SelectProperty4 = By.xpath("//*[contains(@name,'selectColMap[3]')]");
	By StartImporting = By.xpath("//*[contains(@name,'startImporting')]");
	
	// Adding a new tag
	
	By AddNewTag = By.xpath("//*[contains(text(),'add new')]");
	By TagName = By.xpath("//*[contains(@id,'tag_name')]");
	By TagDesciption = By.xpath("//*[contains(@id,'tag_description')]");
	By Savetag = By.xpath("(//*[contains(@id,'add_new_tag')])[2]");
	
	
	
	public UserImporting(WebDriver driver)
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
	
	public void printNumberofContacts()
	{
		String number =  driver.findElement(NumberOfContacts).getText();
		System.out.println("Number of contacts of uploaded file = "+number);
	}
	
	public void printNumberOfUnprocessed()
	{
		String number =  driver.findElement(Unprocessed).getText();
		System.out.println("Number of unprocessed contacts of uploaded file = "+number);
	}
	
	public void printDateOfUpload()
	{
		String date =  driver.findElement(Date).getText();
		System.out.println("Number of unprocessed contacts of uploaded file = "+date);
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
	
	public void selectTag(String tagName)
	{
		Select tag = new Select(driver.findElement(SelectTag));
		tag.selectByVisibleText(tagName);
	}
	
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
	
	
	
	
	public void addNewTag(String tagName,String tagDescription) throws Exception
	{
		driver.findElement(AddNewTag).click();
		Thread.sleep(2000);
		driver.findElement(TagName).sendKeys(tagName);
		driver.findElement(TagDesciption).sendKeys(tagDescription);
		Thread.sleep(2000);
		driver.findElement(Savetag).click();
		
	}
	
	
	
}
