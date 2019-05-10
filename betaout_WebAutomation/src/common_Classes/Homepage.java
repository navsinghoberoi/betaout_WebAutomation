package common_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class Homepage {

	public WebDriver driver;
	
	By insights = By.xpath("//div[text() = 'Insights']");
	By cust_segments = By.xpath("//div[text() = 'Customer Segments']");
	By email_marketing = By.xpath("//div[text() = 'Email Marketing']");
	By mobile_push = By.xpath("//div[text() = 'Mobile Push']");
	By onsite = By.xpath("//div[text() = 'On-site Marketing']");
	By sms_marketing = By.xpath("//div[text() = 'SMS Marketing']");
	By cart_recovery = By.xpath("//div[text() = 'Cart Recovery']");
	By browser_push = By.xpath("//div[text() = 'Browser Push']");
	By contact_database = By.xpath("//div[text() = 'Contact Database']");
	By product_catalog = By.xpath("//div[text() = 'Product Catalog']");
	By ideas_docs = By.xpath("//div[text() = 'Ideas & Docs']");

//	By accounts = By.xpath("//span[@class = 'icon-angle-down pull-right visible-lg visible-md']");
	By accounts = By.xpath("//*[@class = 'dropdown-toggle ']");

	By search = By.xpath("(//*[@title = 'Search for users....'])[2]");

	By settings = By.xpath("(//*[@href = '/configurations/settings/team'])[2]");
	
	By logout = By.xpath("(//*[text() = 'Logout'])[2]");		

	// Add locators for Searching and finding user in Contact Database
	
	By Search_1stDropdown = By.xpath("(//*[@id = 'dLabel1'])");
	By Search_ByUser = By.xpath("(//*[@data-select = 'user'])");
	By Search_ByOrder = By.xpath("(//*[@data-select = 'order'])");
	By Search_ByCampaign = By.xpath("(//*[@data-select = 'email'])");
	
	By Search_UserSubDropdown = By.xpath("(//*[@id = 'dLabel3'])");
	By Search_User_ByPhone = By.xpath("(//*[@data-select = 'phone'])");
	By Search_User_ByEmail = By.xpath("(//*[@data-select = 'email'])[2]");
	
	By EnterDataToSearch = By.xpath("(//*[@name = 'search'])");
	By SearchSubmitButton = By.xpath("(//*[@id = 'searchButton'])[1]");
	
	By EnterSearchDataInternal = By.xpath("(//*[@placeholder = 'search for users ...'])");
	By InternalSearchSubmit = By.xpath("//*[contains(@class,'searchButtonIn1')]");
	By PropertiesTab = By.xpath("(//*[text() = 'Properties'])[2]");
	By PnSentDate = By.xpath("(//*[text()='pn_last_sent_date']/../td)[2]");
	
	
	public By OpenContact = By.xpath("(//*[contains(@href,'/users/user-permalink/nv/userId')])[1]");
	
	
	public Homepage(WebDriver driver)

	{
		this.driver = driver;

	}

	public void insight_click()

	{

		driver.findElement(insights).click();

	}

	public void cust_segments_click()

	{

		driver.findElement(cust_segments).click();

	}

	public void email_mktg_click()

	{

		driver.findElement(email_marketing).click();

	}

	public void mobilepush_click()

	{

		driver.findElement(mobile_push).click();

	}

	public void onsite_click()

	{

		driver.findElement(onsite).click();

	}

	public void sms_mktg_click()

	{

		driver.findElement(sms_marketing).click();

	}

	public void cartrecovery_click()

	{

		driver.findElement(cart_recovery).click();

	}

	public void browserpush_click()

	{

		driver.findElement(browser_push).click();

	}

	public void contact_db_click()

	{

		driver.findElement(contact_database).click();

	}

	public void product_catalog_click()

	{

		driver.findElement(product_catalog).click();

	}

	public void ideas_docs_click()

	{

		driver.findElement(ideas_docs).click();

	}

	public void accnt_click()

	{
		driver.findElement(accounts).click();

	}

	
	public void search_click()

	{
		driver.findElement(search).click();

	}
	
	
	public void settings_click()
	
	{

	/*List<org.openqa.selenium.WebElement> set = driver.findElements(settings);
    System.out.println("Total elements :"+set.size());
              
        ((org.openqa.selenium.WebElement) set.get(1)).click();*/
        
		driver.findElement(settings).click();
		
	}
	
	public void logout_click()
	
	{

	List<org.openqa.selenium.WebElement> log = driver.findElements(logout);
    System.out.println("Total elements :"+log.size());
              
        ((org.openqa.selenium.WebElement) log.get(1)).click();
        
	}
		
    
	public void Search_1stDropdown()
	{
		driver.findElement(Search_1stDropdown).click();
	}
	
	public void Search_ByUser()
	{
		driver.findElement(Search_ByUser).click();
	}
	
	
	public void Search_ByOrder()
	{
		driver.findElement(Search_ByOrder).click();
	}
	

	public void Search_ByCampaign()
	{
		driver.findElement(Search_ByCampaign).click();
	}

	public void Search_UserSubDropdown()
	{
		driver.findElement(Search_UserSubDropdown).click();
	}

	public void Search_User_ByPhone()
	{
		driver.findElement(Search_User_ByPhone).click();
	}

	public void Search_User_ByEmail()
	{
		driver.findElement(Search_User_ByEmail).click();
	}

	public void EnterDataToSearch(String data)
	{
		driver.findElement(EnterDataToSearch).sendKeys(data);
	}

	public void SearchSubmitButton() 
	{
		driver.findElement(SearchSubmitButton).click();
	}
	
	
	public void EnterSearchDataInternalClick(String id)
	{
		driver.findElement(EnterSearchDataInternal).sendKeys(id);
	}

	public void InternalSearchSubmitClick()
	{
		driver.findElement(InternalSearchSubmit).click();		
	}
	
	
	public void PropertiesTabClick()
	{
		driver.findElement(PropertiesTab).click();		
	}
	
	
	public String printPnSentDate()
	{
		
		String pnDate = driver.findElement(PnSentDate).getText();
		return pnDate;
	}
}
