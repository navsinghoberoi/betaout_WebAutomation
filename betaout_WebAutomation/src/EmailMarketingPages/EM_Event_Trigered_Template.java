package EmailMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class EM_Event_Trigered_Template {
	
	public WebDriver driver;
	
	
	
	By Select_Use_this_template = By.xpath("//*[@data-tid='389']");
	
	By Select_Preview_Template = By.xpath("//*[@id='389']");
	
	By Add_subject = By.xpath("(//*[@placeholder='Add subject here'])[2]");
	
	By Sender_Id = By.xpath("//*[@id= 'senderEmailId']");	
	
	By Exit_button = By.xpath("//*[text() = 'Exit']");
	
	By Save_As_Draft = By.xpath("//*[text() = 'Save AS DRAFT']");
	
	By Save_And_exit = By.xpath("//*[text() = 'Save & Exit']");
	
	
	 public EM_Event_Trigered_Template (WebDriver driver)
		{

			this.driver = driver;
		}
	
	 
	 
	 public void Sender_Id (String sender_email_select){
			
			Select select = new Select(driver.findElement(Sender_Id));
		      select.selectByVisibleText(sender_email_select);		
					} 
	 
	 public void Select_Use_this_template (){
			
		driver.findElement(Select_Use_this_template).click();	
					} 
	 
	 public void Select_Preview_Template (){
			
			driver.findElement(Select_Preview_Template).click();	
						} 
	 
	 public void Sender_Id (){
			
			driver.findElement(Sender_Id).click();	
						}
	 
	 public void Exit_button (){
			
			driver.findElement(Exit_button).click();	
						}
	 
	 public void Save_As_Draft (){
			
			driver.findElement(Save_As_Draft).click();	
						}
	 public void Save_And_exit (){
			
			driver.findElement(Save_And_exit).click();	
						}
	 
}
