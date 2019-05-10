package EmailMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class EM_EventTriggered {
	public WebDriver driver;

		
		By Event_trigrred = By.xpath("//*[text()='Event Triggered']");  // event triggered tab 
		
		By Create_Campaign = By.xpath("(//*[@class='pull-right'])[3]");
		
		By Active_Campaings = By.xpath("//*[@id='dropdownMenu1']");
		
		By inactive_campaings = By.xpath("//*[text()='Inactive Campaigns']");
		
		   public EM_EventTriggered (WebDriver driver)
			{

				this.driver = driver;
			}

			public void Event_trigrred(){
				
				driver.findElement(Event_trigrred).click();
				
				}
			
	public void Create_Campaign(){
				
				driver.findElement(Create_Campaign).click();
				
				}
	public void Active_Campaings(){
		
		driver.findElement(Active_Campaings).click();
		
		}

	public void inactive_campaings(){
		
		driver.findElement(inactive_campaings).click();
		
		}


}
