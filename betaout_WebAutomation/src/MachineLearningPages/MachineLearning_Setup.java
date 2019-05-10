package MachineLearningPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * @author - Navpreet
 */
public class MachineLearning_Setup {
	
	public WebDriver driver;
	
	
	
	By RecommendationEngine_text = By.xpath("(//*[text() = 'Recommendation Engine'])");
	By Rec_Engine_On = By.xpath("(//*[@class = 'onoffswitch-inner22'])");
	By TemplatesName = By.xpath("(//*[@class = 'col-xs-10 '])");   // Use Array to pick text
	By NoOfProductsViewedAlsoViewed = By.xpath("//*[@id = 'number_of_product']");
	By ViewedAlsoViewedIncreementProducts = By.xpath("//*[@class = 'next_counter']");
	By ViewedAlsoViewedDecreementProducts = By.xpath("//*[@class = 'prev_counter']");
	By ViewedAlsoViewedSave = By.xpath("(//*[@data-attr = 'viewed_also_viewed'])[2]");
	
	By ViewedAlsoViewedToggle = By.xpath("(//*[@for = 'onoffswitch1'])[1]");
	By BoughtAlsoBoughtToggle = By.xpath("(//*[@for = 'onoffswitch1'])[2]");
	By TopSellingToggle = By.xpath("(//*[@for = 'onoffswitch1'])[3]");
	By TopViewedToggle = By.xpath("(//*[@for = 'onoffswitch1'])[4]");
	By TopSellingInCategoryToggle = By.xpath("(//*[@for = 'onoffswitch1'])[5]");
	By TopViewedInCategoryToggle = By.xpath("(//*[@for = 'onoffswitch1'])[6]");
	By TopSellingInBrandToggle = By.xpath("(//*[@for = 'onoffswitch1'])[7]");
	By TopViewedInBrandToggle = By.xpath("(//*[@for = 'onoffswitch1'])[8]");
	By CrossSellToggle = By.xpath("(//*[@for = 'onoffswitch1'])[9]");
	By UpSellToggle = By.xpath("(//*[@for = 'onoffswitch1'])[10]");
	
	
	By ViewedAlsoViewed = By.xpath("(//*[@data-name = 'People who viewed this also viewed this'])");
	By BoughtAlsoBought = By.xpath("(//*[@data-name = 'People who bought this also bought this'])");
	By TopSelling = By.xpath("(//*[@data-name = 'Top selling products'])");
	By TopViewed = By.xpath("(//*[@data-name = 'Top viewed products'])");
	By TopSellingInCategory = By.xpath("(//*[@data-name = 'Top selling products in this category'])");
	By TopViewedInCategory = By.xpath("(//*[@data-name = 'Top viewed products in this category'])");
	By TopSellingInBrand = By.xpath("(//*[@data-name = 'Top selling products in this brand'])");
	By TopViewedInBrand = By.xpath("(//*[@data-name = 'Top viewed products in this brand'])");
	By CrossSell = By.xpath("(//*[@data-name = 'Cross Sell'])");
	By UpSell = By.xpath("(//*[@data-name = 'Up Sell'])");
	
	
	
	
	
	
	public MachineLearning_Setup(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void ViewedAlsoViewedTemplate()
	{
		
		driver.findElement(ViewedAlsoViewed).click();
	}
	
	
	
	public void BoughtAlsoBoughtTemplate()
	{
		
		driver.findElement(BoughtAlsoBought).click();
	}
	
	
	public void TopSellingTemplate()
	{
		
		driver.findElement(TopSelling).click();
	}
	
	
	public void TopViewedTemplate()
	{
		
		driver.findElement(TopViewed).click();
	}
	
	
	public void TopSellingInCategoryTemplate()
	{
		
		driver.findElement(TopSellingInCategory).click();
	}
	
	
	public void TopViewedInCategoryTemplate()
	{
		
		driver.findElement(TopViewedInCategory).click();
	}
	
	
	public void TopSellingInBrandTemplate()
	{
		
		driver.findElement(TopSellingInBrand).click();
	}
	
	
	public void TopViewedInBrandTemplate()
	{
		
		driver.findElement(TopViewedInBrand).click();
	}
	
	
	public void CrossSellTemplate()
	{
		
		driver.findElement(CrossSell).click();
	}
	
	
	public void UpSellTemplate()
	{
		
		driver.findElement(UpSell).click();
	}
	
	
	
	public void RecEnginePrint()
	{
		
	String name = 	driver.findElement(RecommendationEngine_text).getText();
		System.out.println("Text displayed on page =  "+name);
	}
	
	
	
	public boolean IsRecEngineDisplayed()
	{
		
	boolean result =  driver.findElement(Rec_Engine_On).isDisplayed();
		return result;
	}
	
	
	public void printTemplateNames()
	{
		
	List<WebElement> allTemplates = driver.findElements(TemplatesName);
	System.out.println("Total number of recommendation templates are = " +allTemplates.size());
	
	System.out.println("Name of all templates is given below");
	
	
	for(int i=0;i<allTemplates.size();i++)
		
	{
		System.out.println((i+1) +" "+allTemplates.get(i).getText());
		
	}
		
			}
	
	
	
	public void ViewedAlsoViewedStatus()
											{
		
	String dataStatus =  driver.findElement(ViewedAlsoViewed).getAttribute("data-status");
	System.out.println("Status of template = "+dataStatus);
	
	if(dataStatus == "inactive")
	{
		System.out.println("Viewed also viewedTemplate is Inactive");
	}
	
	else
	{
		System.out.println("Viewed also viewedTemplate is Active");
	}
	
											}
	
	
	public String NoOfProductsViewedAlsoViewedPrint()
	{
		String number = driver.findElement(NoOfProductsViewedAlsoViewed).getText();
	//	System.out.println("Number of products of Viewed also Viewed = "+number);
		return number;
	}
	
	
	public void ViewedAlsoViewedIncreementProducts()
	{
		
		driver.findElement(ViewedAlsoViewedIncreementProducts).click();
	}
	
	
	public void ViewedAlsoViewedDecreementProducts()
	{
		
		driver.findElement(ViewedAlsoViewedDecreementProducts).click();
	}
	
	
	public void ViewedAlsoViewedSave()
	{
		
		driver.findElement(ViewedAlsoViewedSave).click();
	}
	
	
	public void ViewedAlsoViewedToggle()
	{
		driver.findElement(ViewedAlsoViewedToggle).click();
	}
	
	
	public void BoughtAlsoBoughtToggle()
	{
		driver.findElement(BoughtAlsoBoughtToggle).click();
	}
	
	
	public void TopSellingToggle()
	{
		driver.findElement(TopSellingToggle).click();
	}
	
	
	public void TopViewedToggle()
	{
		driver.findElement(TopViewedToggle).click();
	}
	
	
	public void TopSellingInCategoryToggle()
	{
		driver.findElement(TopSellingInCategoryToggle).click();
	}
	
	
	public void TopViewedInCategoryToggle()
	{
		driver.findElement(TopViewedInCategoryToggle).click();
	}
	
	
	public void TopSellingInBrandToggle()
	{
		driver.findElement(TopSellingInBrandToggle).click();
	}
	
	
	public void TopViewedInBrandToggle()
	{
		driver.findElement(TopViewedInBrandToggle).click();
	}
	
	
	public void CrossSellToggle()
	{
		driver.findElement(CrossSellToggle).click();
	}
	
	
	public void UpSellToggle()
	{
		driver.findElement(UpSellToggle).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
