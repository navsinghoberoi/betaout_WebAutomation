package CartRecoveryScenarios;
/**
 * @author - Navpreet
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common_Classes.Setup_class;

public class AddToCart_WoocommerceOne {

	public static WebDriver driver;
	
	@Test
	
	public void addToCart() throws Exception

	{
		
	/*	Setup_class set = new Setup_class(driver);
		
		driver = set.setup();*/
	
		driver.get("http://woocommerceone.basera.com/");
		
		driver.findElement(By.xpath("(//*[@href = 'http://woocommerceone.basera.com/my-account/'])")).click();
		
		Thread.sleep(3000);
		
	//	driver.findElement(By.xpath("(//*[@id = 'username'])")).clear();
		
		driver.findElement(By.xpath("(//*[@id = 'username'])")).sendKeys("nav1866@yopmail.com");	
		
	//	driver.findElement(By.xpath("(//*[@id = 'password'])")).clear();
		
		driver.findElement(By.xpath("(//*[@id = 'password'])")).sendKeys("navpreet@123");
		
		driver.findElement(By.xpath("(//*[@name = 'login'])")).click();
		
	//	Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//*[@title = 'Home'])")).click();
		
	//	Thread.sleep(5000);
		
	
		driver.findElement(By.xpath("(//*[@data-product_id = '697'])")).click();        // Add to Cart
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@title = 'View Cart'])")).click();
		Thread.sleep(6000);
		
//		driver.findElement(By.xpath("(//*[@href = 'http://woocommerceone.basera.com/checkout/'])[2]")).click();
//		Thread.sleep(10000);
		
//		driver.findElement(By.xpath("(//*[@id = 'place_order'])")).click();
//		Thread.sleep(10000);

		
		Thread.sleep(720000);    // Wait for 12 min
	}
	
}
