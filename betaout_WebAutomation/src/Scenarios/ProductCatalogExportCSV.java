package Scenarios;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ContactDatabasePagesAndScenarios.ContactDatabase;
import common_Classes.Setup_class;
import promocode_Pages.Coupon_Add_Coupon_Codes;
import promocode_Pages.Coupon_Campaign;
import promocode_Pages.Coupon_Config;
import promocode_Pages.IdeasDocs;
import promocode_Pages.ProductCatalog;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
/**
 * @author - Navpreet
 */

public class ProductCatalogExportCSV {


	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception{

		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
	
		driver.get("https://staging-102.betaout.com/");
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname("sjs22858@gmail.com");
		obj.upswd("simranjeet");
		obj.ulogin();
		
		System.out.println("User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		homeobj.product_catalog_click();
		
		
		ProductCatalog catalogobj = new ProductCatalog(driver);
	
		catalogobj.ProductsClick();
		String ProductsName = driver.findElement(By.xpath("//a[@href = '/products/product-overview']")).getText();
		System.out.println("Name of tha page = "+ProductsName);	
		
	//	catalogobj.ExportCSVClickProducts();
		
		catalogobj.BrandsClick();
		String BrandsName = driver.findElement(By.xpath("//a[@href = '/products/product-brands']")).getText();
		System.out.println("Name of tha page = "+BrandsName);	
		
		//	catalogobj.ExportCSVClickBrands();
		
		catalogobj.CategoriesClick();
		String CategoriesName = driver.findElement(By.xpath("//a[@href = '/products/product-categories']")).getText();
		System.out.println("Name of tha page = "+CategoriesName);	
		
	//	catalogobj.ExportCSVClickCategories();
		
		
		
		
	
										}
	
	
	
}