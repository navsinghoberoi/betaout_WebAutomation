package EmailMarketingPages;

import org.openqa.selenium.WebDriver;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class EM_Create_campaign {
	
		WebDriver driver;
		// TODO Auto-generated method stub
		By CreateCapmain = By.xpath("(//*[text()='CREATE CAMPAIGN'])[2]"); // Click on Create campaigns button 
		
		By campaign_title = By.xpath("//*[@id = 'news_letter_name']"); // Campaign Title Box
		
		By Page_name =  By.xpath("//*[@class = 'add-campaign']/h1"); // Get text of this field
		
		  By Save_And_Next  = By.xpath("//*[text()='SAVE & NEXT STEP']");
		 
	    public EM_Create_campaign (WebDriver driver)
		{

			this.driver = driver;
		}
	    
		
		public void Broadcast_Createcapmain(){
			
			driver.findElement(CreateCapmain).click();
			
			}
		
		

		public void Broadcast_campaign_title(String Broadcast_campain_title){
			
			driver.findElement(campaign_title ).sendKeys(Broadcast_campain_title);
			
			String Page_Name = driver.findElement(Page_name).getText();
			
			System.out.println("Campanign page name" + Page_Name);
			
			driver.findElement(Save_And_Next).click();
			
			}
	}


