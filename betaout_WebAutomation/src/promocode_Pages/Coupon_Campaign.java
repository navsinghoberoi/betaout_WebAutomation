package promocode_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * @author - Navpreet
 */
public class Coupon_Campaign {

	public WebDriver driver;

	By add_coupon_codes = By.xpath("//span[text() = 'ADD COUPON CODES']");
	
	By active_campaign = By.xpath("(//*[@class = 'resumeCouponCampign'])[1]");

	By resume_campaign = By.xpath("//*[@name = 'resumeCouponList']");
	
	By delete_campaign = By.xpath("(//*[@class = 'deleteEmailCampignType'])[5]");

	By enterdelete = By.xpath("//*[@id = 'capsVal']");

	By totalcodes = By.xpath("(//*[contains(@class,'greyBg')])[1]");         // xpath changed
	
	By distributedcodes = By.xpath("(//*[contains(@class,'greyBg')])[2]");		// xpath changed
	
	By unusedcodes = By.xpath("(//*[contains(@class,'greyBg')])[3]");			// xpath changed
	
	By dateofupload = By.xpath("(//*[@class = 'hp-btn-container'])[1]");		// xpath changed
	
	By CouponName = By.xpath("(//*[contains(@class,'selectable')])/td[2]");    // xpath changed
	
//	By CampaignsAssociated = By.xpath("(//*[@class = 'selectable draft'])/td[3]");
	
	By  CampaignsAssociated = By.xpath("(//*[contains(@class,'selectable')])/td[3]");   	// xpath changed
	
	
	// Add common locators for promocode scenarios 
	
		public By ExistingCouponCamp = By.xpath("//*[@name = 'couponListId']");
		public By EnterCode = By.xpath("//textarea[@class = 'textarea']");
		public By PasteCodesSave = By.xpath("//*[@name = 'couponDataSubmit']");
		public By CouponCampaignName = By.xpath("(//*[contains(@class,'selectable')])/td[2]");
		public By CouponCodeDesignPage = By.xpath("(.//*[@id='mce_41'])");
		public By TinyMCE = By.xpath("//*[contains(@src,'https://qa.betaout.in/tinymce/js/tinymce/plugins')]");
		By ScrollTillNextCouponList = By.xpath("//*[@data-id = '308']");
		public By SelectCampRadioButton = By.xpath("//*[@data-id = '307']");    // Select '13 april qa Nav' coupon list
		public By UseCampaignButton = By.xpath("//*[contains(@class,'getSelectedCoupon')]");
		public By ActiveCampName = By.xpath("(//a[@class = 'camp-name'])[1]");
		public By InactiveCouponCampIcon = By.xpath("(//*[@class = 'iconAction-pause'])[1]");
		public By PauseCouponCmap = By.xpath("(//*[@name = 'pauseCouponList'])");
	
		public By BannerIframe = By.xpath("//*[contains(@id,'iframeBanner')]");
		public By InlineIframe = By.xpath("//*[contains(@id,'iframeInline')]");
		public By PopupIframe = By.xpath("//*[contains(@id,'iframePopup')]");
		public By PulloutIframe = By.xpath("//*[contains(@id,'iframesidekick')]");
		public By StickybarBanner = By.xpath("//*[contains(@id,'iframeinfobar')]");
		
		
		public By CTAPopupIframe = By.xpath("//*[@id = 'iframe']");
		
		public 	By MobileInlineText = By.xpath("//*[@id = 'content-1-screen1']");
	
	
	
	
	public Coupon_Campaign(WebDriver driver)

	{
		this.driver = driver;

	}

	public void add_coupon_codes_button()

	{

		driver.findElement(add_coupon_codes).click();

	}
	
	
	public void activecampaign_click() throws Exception
	
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(active_campaign)).build().perform();	
		Thread.sleep(2000);
		driver.findElement(active_campaign).click();
		
	}
	
	public void resumecampaign_click()
	
	{
		driver.findElement(resume_campaign).click();
		
	}

	public void deletecampaign_click() throws InterruptedException

	{
		List<org.openqa.selenium.WebElement> delete = driver.findElements(delete_campaign);
	  //  System.out.println("Total elements :"+delete.size());
	              
	        ((org.openqa.selenium.WebElement) delete.get(5)).click();
	        
	        driver.findElement(enterdelete).sendKeys("DELETE");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@name = 'deleteCouponList']")).click();
	        
	}
	
	
	public void totalcodesprint()
	{
		
	String total = 	driver.findElement(totalcodes).getText();
	System.out.println("Total codes are = "+total);	
	
	}
	
	
	
	public void distributedcodesprint()
	{
		
	String distributed = 	driver.findElement(distributedcodes).getText();
	System.out.println("Distributed codes are = "+distributed);	
	
	}
	
	
	public void unusedcodesprint()
	{
		
	String unused = 	driver.findElement(unusedcodes).getText();
	System.out.println("Unused codes are = "+unused);	
	
	}
	
	
	public void dateofupload()
	{
		
		String date = driver.findElement(dateofupload).getText();
		System.out.println("Date of Upload = "+date);
	}
	
	
	public void totalCampaigns()
	{
	
	List<WebElement> allCampaigns	=	driver.findElements(CouponName);
	System.out.println("Total number of campaigns are = "+allCampaigns.size());	
	
	/*String campaignName = allCampaigns.get(0).getText();
	System.out.println("Name of the campaign = "+campaignName);*/
	
	}
	
	public void CampaignsAssociatedPrint()
	{
	
	List<WebElement> allAssociatedCampaigns	=	driver.findElements(CampaignsAssociated);
	
	String associatedNumber = allAssociatedCampaigns.get(0).getText();
	System.out.println("Number of associated campaigns = "+associatedNumber);
	
	}
	
	public void ScrollUptoNextCouponList() throws Exception
	{
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(ScrollTillNextCouponList)).perform();
		Thread.sleep(1000);
	}
	
	
	
	
}
