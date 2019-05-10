package promocode_Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class ProductCatalog {

	public WebDriver driver;
	
	
	By Categories = By.xpath("(//*[text() = 'Categories '])[2]");
	By Brands = By.xpath("(//*[text() = 'Brands '])[2]");
	By Products = By.xpath("(//*[text() = 'Products'])[2]");
	By ExportCSV = By.xpath("//*[text() = 'EXPORT CSV']");
	
	
	public ProductCatalog(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	public void CategoriesClick()
	
	{
		driver.findElement(Categories).click();
	        
	}
	
	public void BrandsClick()
	
	{
		driver.findElement(Brands).click();    
	}
	
	public void ProductsClick()

	{
	
	driver.findElement(Products).click();
        
 	}

	public void ExportCSVClickProducts()
	
	{
		driver.findElement(ExportCSV).click();
		
		driver.findElement(By.xpath("//*[@for = 'productTitle']")).click();
		driver.findElement(By.xpath("//*[@for = 'createdTime']")).click();
		driver.findElement(By.xpath("//*[@class = ' btn-submit-blue queueExport']")).click();
		driver.findElement(By.xpath("//*[@class = 'fa fa-en iconNew-export']")).click();  // To download first csv
		
		
	}
	
	public void ExportCSVClickBrands()
	
	{
		driver.findElement(ExportCSV).click();
		
		driver.findElement(By.xpath("//*[@for = 'brandId']")).click();
		driver.findElement(By.xpath("//*[@for = 'GMV']")).click();
		driver.findElement(By.xpath("//*[@class = 'viewed']")).click();
		driver.findElement(By.xpath("//*[@class = 'fa fa-en iconNew-export']")).click();  // To download first csv
		
		
	}

	public void ExportCSVClickCategories()

{
	driver.findElement(ExportCSV).click();
	
	driver.findElement(By.xpath("//*[@for = 'categoryId']")).click();
	driver.findElement(By.xpath("//*[@for = 'clientCategoryNo']")).click();
	driver.findElement(By.xpath("//*[@for = 'createdTime']")).click();
	driver.findElement(By.xpath("//*[@class = ' btn-submit-blue queueExport']")).click();  // To download first csv
	
	
}
	
	
	
	
	
	
}
