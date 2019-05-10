package ContactDatabasePagesAndScenarios;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import ContactDatabasePagesAndScenarios.ContactDatabase;
import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
/**
 * @author - Navpreet
 */
public class AddNewContactDatabase {
	
	public static WebDriver driver;
	
	
	static String firstName = "AutoF"+System.currentTimeMillis();
	static String lastName = "AutoL"+System.currentTimeMillis();
	static String email = System.currentTimeMillis()+""+"@yopmail.com";
	static String tagNameUser = "Tag5"+System.currentTimeMillis();
	static String description = "AutoDescription"+System.currentTimeMillis();
	
	
	@Test
	public void AddNewContact() throws Exception{
		
	/*	ExtentReports logger = ExtentReports.get(AddNewContactDatabase.class);
		
		logger.init("D:\\AutomationReports\\AutomationReport1.html", true);
		logger.startTest("ADD Contacts And Tags");
	*/	
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		
	//	logger.log(LogStatus.INFO, "Browser setup is done");
		
		driver.get("https://pre-prod-102.betaout.com/");
		
	//	logger.log(LogStatus.INFO, "URL is opened on browser");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("sjs22858@gmail.com");
		obj.upswd("simranjeet");
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
		
	//	logger.log(LogStatus.INFO, "User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		homeobj.contact_db_click();
		
	//	logger.log(LogStatus.INFO, "User is on Contact Database page");
		
		ContactDatabase db = new ContactDatabase(driver);
		
		db.Contacts_CreateNewContactClick();
		
		db.Contacts_FirstNameClick(firstName);      
		db.Contacts_LastNameClick(lastName);
		db.Contacts_EmailClick(email);
		db.Contacts_SaveClick();
		
	//	logger.log(LogStatus.INFO, "User has created a new Contact");
		
		Thread.sleep(12000);
		
		driver.navigate().refresh();
		Thread.sleep(8000);
	
		driver.navigate().refresh();
		Thread.sleep(5000);	
		
		VerifyContactsInfo();  
		
		driver.navigate().back();
		
		driver.navigate().back();

		db.TagsClick();
		
	//	logger.log(LogStatus.INFO, "User has switched to Tags tab");
		
		db.Tags_CreateNewTagClick();
		
		
		db.Tags_TagNameClick(tagNameUser);
		db.Tags_DescriptionClick(description);
		Thread.sleep(2000);
		db.Tags_SaveClick();

	//	logger.log(LogStatus.INFO, "User has added a new tag");
		
		Thread.sleep(8000);
		
		VerifyTagsInfo();
	
		
	//	logger.endTest();
	
		
	//	driver.get("D:\\AutomationReports\\AutomationReport1.html");
		
    //	driver.quit();
		
	}

	public static void VerifyContactsInfo()         
	{
		List<WebElement> allContact = driver.findElements(By.xpath("//*[@style = 'color:#8c8c8c;']"));     
		System.out.println("Total number of contacts - " +allContact.size());        
		
		for (WebElement element: allContact) {
		      System.out.println("Email of all contacts are = "+element.getText());
		}
	
		
		// Open the contact details
		
		 allContact.get(0).click();                                                    // Open First Contact
		 
		 driver.findElement(By.xpath("(//*[text() = 'Properties'])[2]")).click();      // Open Properties tab
		
		 String ContactEmail = driver.findElement(By.xpath("(//*[@style = ' max-width: 700px;word-wrap: break-word'])[1]")).getText();
		 String ContactFirstName = driver.findElement(By.xpath("(//*[@style = ' max-width: 700px;word-wrap: break-word'])[2]")).getText();
		 String ContactLastName = driver.findElement(By.xpath("(//*[@style = ' max-width: 700px;word-wrap: break-word'])[5]")).getText();
		 
		 System.out.println("Email of new contact = "+ContactEmail);
		 System.out.println("First name of new contact = "+ContactFirstName);
		 System.out.println("Last Name of new contact = "+ContactLastName);
	
		 Assert.assertEquals(email, ContactEmail);                // Enter details same used in scenario
		 System.out.println("Email Assertion is passed");
		 Assert.assertEquals(firstName, ContactFirstName);			 // Enter details same used in scenario
		 System.out.println("FirstName Assertion is passed");
		 Assert.assertEquals(lastName, ContactLastName);			 // Enter details same used in scenario
		 System.out.println("LastName Assertion is passed");
		 
	}
	
	
	public static void VerifyTagsInfo()				
	{
		
		List<WebElement> allTags = driver.findElements(By.xpath("//*[contains(@href,'/users/segment-permalink/nv/segmentId')]"));     
		System.out.println("Total number of contacts - " +allTags.size());    
		
		for (WebElement element: allTags) {
		      System.out.println("Name of all tags are = "+element.getText());
		}
		
		String tagname = allTags.get(0).getText();
		System.out.println("Name of first tag = "+tagname);
		
		Assert.assertEquals(tagNameUser, tagname); 
		System.out.println("Tagname Assertion is passed");
		
		allTags.get(0).click();     // Open first tag
		
		List<WebElement> UsersInTag = driver.findElements(By.xpath("(//*[@class = 'selectable bodr hp-clickable '])"));
		System.out.println("Size of all users in the tag = "+UsersInTag);
		
	}
	
	
	
	
}