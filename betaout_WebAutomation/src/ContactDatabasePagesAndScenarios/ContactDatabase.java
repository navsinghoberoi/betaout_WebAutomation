package ContactDatabasePagesAndScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/**
 * @author - Navpreet
 */
public class ContactDatabase {

	public WebDriver driver;

	By Contacts = By.xpath("(//*[@href = '/users/identifed-users'])[3]");
	By Contacts_CreateNewContact = By.xpath("(//*[text() = 'CREATE NEW CONTACT'])[2]");
	By Contacts_FirstName = By.xpath("//*[@placeholder = 'first name']");
	By Contacts_LastName = By.xpath("//*[@placeholder = 'last name']");
	By Contacts_Email = By.xpath("//*[@placeholder = 'email']");
	By Contacts_Save = By.xpath("//*[@class = 'btn-submit-blue addNewContact_save']");
	By Contacts_CrossPopup = By.xpath("(//*[@class = 'close desktop_pop_close'])");

	By Tags = By.xpath("(//*[@href = '/users/segment/tags'])[2]");
	By Tags_CreateNewTag = By.xpath("(//*[text() = 'CREATE NEW TAGS'])[2]");
	By Tags_TagName = By.xpath("(//*[@id = 'tag_name'])");
	By Tags_Description = By.xpath("(//*[@id = 'tag_description'])");
	By Tags_Save = By.xpath("(//*[@id = 'add_new_tag'])");
	By Tags_CrossPopup = By.xpath("(//*[@class = 'close desktop_pop_close'])[1]");

	public ContactDatabase(WebDriver driver)

	{
		this.driver = driver;

	}

	public void ContactsClick()

	{
		driver.findElement(Contacts).click();
	}

	public void Contacts_CreateNewContactClick()

	{
		driver.findElement(Contacts_CreateNewContact).click();
	}

	public void Contacts_FirstNameClick(String fname)

	{
		driver.findElement(Contacts_FirstName).sendKeys(fname);
		;
	}

	public void Contacts_LastNameClick(String lname)

	{
		driver.findElement(Contacts_LastName).sendKeys(lname);
	}

	public void Contacts_EmailClick(String email)

	{
		driver.findElement(Contacts_Email).sendKeys(email);
		
	}

	public void Contacts_SaveClick()

	{
		driver.findElement(Contacts_Save).click();
	}

	public void Contacts_CrossPopupClick() {
		driver.findElement(Contacts_CrossPopup).click();
	}

	public void TagsClick() {
		driver.findElement(Tags).click();
	}

	public void Tags_CreateNewTagClick() {
		driver.findElement(Tags_CreateNewTag).click();
	}

	public void Tags_TagNameClick(String tname) {
		driver.findElement(Tags_TagName).sendKeys(tname);
	}

	public void Tags_DescriptionClick(String tdescription) {
		driver.findElement(Tags_Description).sendKeys(tdescription);
	}

	public void Tags_SaveClick() {
		driver.findElement(Tags_Save).click();
	}

	public void Tags_CrossPopupClick() {
		driver.findElement(Tags_CrossPopup).click();
	}
	
	/*public void VerifyTagsInfo()				// mention this function in scenario
	{
		
		List<WebElement> allTags = driver.findElements(By.xpath("//*[contains(@href,'/users/segment-permalink/nv/segmentId')]"));     
		System.out.println("Total number of contacts - " +allTags.size());    
		
		for (WebElement element: allTags) {
		      System.out.println("Name of all tags are = "+element.getText());
		}
		
		String tagname = allTags.get(0).getText();
		System.out.println("Name of first tag = "+tagname);
		
		Assert.assertEquals("autoemail3@yopmail.com", tagname); 
		
		allTags.get(0).click();     // Open first tag
		
		List<WebElement> UsersInTag = driver.findElements(By.xpath("(//*[@class = 'selectable bodr hp-clickable '])"));
		System.out.println("Size of all users in the tag = "+UsersInTag);
		
	}*/
	
	
}
