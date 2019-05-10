package EmailMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class EM_Landing_Page {
	
	WebDriver driver;
	
	By Header = By.xpath("(//*[@class='topBar-new'])[2]/li"); // Click on Campaigns

	public EM_Landing_Page(WebDriver driver) {
		// TODO Auto-generated method stub
		
		{

			this.driver = driver;
		}
	}
		public void header_elements() {
			
			driver.findElements(By.xpath("(//*[@class='topBar-new'])[2]/li"));


			
		

	}

}
