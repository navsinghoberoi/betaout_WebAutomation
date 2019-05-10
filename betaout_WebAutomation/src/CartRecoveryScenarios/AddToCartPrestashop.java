package CartRecoveryScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class AddToCartPrestashop {

	public static WebDriver driver;
	
	@Test
	
	public void addToCart() throws Exception

	{
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("http://prestashop1616.basera.com/");
		
		driver.findElement(By.xpath("(//*[@title = 'Log in to your customer account'])")).click();
	
		driver.findElement(By.xpath("(//*[@id = 'email'])")).sendKeys("navcart123@yopmail.com");
		
		driver.findElement(By.xpath("(//*[@id = 'passwd'])")).sendKeys("cartrecovery");
		
		driver.findElement(By.xpath("(//*[@id = 'SubmitLogin'])")).click();
		
		driver.findElement(By.xpath("(//*[@title = 'Home'])")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("(//*[@title = 'Blouse'])[2]")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'fancybox-frame')]")));
		
		driver.findElement(By.xpath("(//*[text() = 'Add to cart'])")).click();
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
		
	//	driver.findElement(By.xpath("(//*[@title = 'Proceed to checkout'])")).click();
		
		
		Thread.sleep(720000);    // Wait for 12 min
	}
	
}
