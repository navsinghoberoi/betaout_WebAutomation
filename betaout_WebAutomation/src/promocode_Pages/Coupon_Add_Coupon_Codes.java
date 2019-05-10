package promocode_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class Coupon_Add_Coupon_Codes {

	public WebDriver driver;

	By create_new_coupon_campaign_tab = By.xpath("//span[text() = 'Create New Coupon Campaign']");
	By add_existing_campaign_tab = By.xpath("//span[text() = 'Add Coupon Codes To Existing List']");
	By upload_csv_tab = By.xpath("//a[text() = 'Upload via CSV']");
	By paste_codes_tab = By.xpath("//a[text() = 'Paste codes in text area']");

	By enter_name_coupon_campaign = By.xpath("//input[@name = 'couponListNewName']");
	By choose_csv_file = By.xpath("//a[@id = 'selectCsvFilePicker']");
	By enter_paste_codes = By.xpath("//textarea[@class = 'textarea']");
	By save_button = By.xpath("//*[@value = 'couponImportPicker']");

	By select_existing_coupon_dropdown = By.xpath("//select[@name = 'couponListId']");
	By filepicker = By.xpath("//input[@name = 'fileUpload']");
	
	
	By CSVFileName = By.xpath("(//*[@id = 'spanFileName'])");
	
	public Coupon_Add_Coupon_Codes(WebDriver driver)

	{
		this.driver = driver;

	}

	public void create_new_coupon_campaign_tab_click() {
		driver.findElement(create_new_coupon_campaign_tab).click();
	}

	public void add_existing_campaign_tab_click() {
		driver.findElement(add_existing_campaign_tab).click();
	}

	public void upload_csv_tab_click() {
		driver.findElement(upload_csv_tab).click();
	}

	public void paste_codes_tab_click() {
		driver.findElement(paste_codes_tab).click();
	}

	public void enter_name_coupon_campaign_click(String campaign_name) {
		driver.findElement(enter_name_coupon_campaign).sendKeys(campaign_name);;
	}

	public void choose_csv_file_click() {
		driver.findElement(choose_csv_file).click();
	}

	public void filepicker_click(String path) {
		driver.findElement(filepicker).sendKeys(path);
	}
	
	public void enter_paste_codes_click(String coupon) {
		driver.findElement(enter_paste_codes).sendKeys(coupon);
	}

	public void save_button_click() {
		driver.findElement(save_button).click();
	}

	public void select_existing_coupon_dropdown_click() {
		Select select = new Select(driver.findElement(select_existing_coupon_dropdown));
		select.selectByIndex(0);

	}

	
	public void CSVFileNamePrint()
	{
		
	String fileName	= driver.findElement(CSVFileName).getText();
	System.out.println("Name of the CSV file = "+fileName);
	
	}
	
}
