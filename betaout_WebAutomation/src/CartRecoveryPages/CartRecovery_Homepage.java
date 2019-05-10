package CartRecoveryPages;

import org.apache.regexp.recompile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class CartRecovery_Homepage {

	public WebDriver driver;
	
	
	public By Overview = By.xpath("(//*[@href = '/carts/cart'])[3]");
	public By Campaigns = By.xpath("(//*[@href = '/carts/cart-campaign'])[2]");
	public By Overview_Carts = By.xpath("(//*[@ty = 'cart'])");
	public By Overview_Revenue = By.xpath("(//*[@ty = 'gmv'])");
	public By Campaigns_CreateCampaign = By.xpath("(//*[@href = '/carts/create-new/'])[2]");
	public By Campaigns_NameofAllCampaigns = By.xpath("(//*[@style = ' display: inline-block;'])");        // By using index for iterating
	public By Campaigns_Edit = By.xpath("(//*[@title = 'Edit'])[1]");
	public By Campaigns_ActiveInstance = By.xpath("(//*[@title = 'Make Active'])[1]");
	public By Campaigns_InactiveInstance = By.xpath("(//*[@title = 'Make Inactive'])[1]");
	public By Campaigns_DeleteInstance = 	By.xpath("(//*[@title = 'Delete'])[2]");
	public By Campaigns_DeleteInstance_EnterDelete = By.xpath("(//*[@id = 'capsVal'])");
	public By Campaigns_DeleteInstance_ConfirmDeletebutton = By.xpath("(//*[text() = 'DELETE'])");	
	public By Campaigns_Clone = By.xpath("(//*[@title = 'Copy'])[1]");
	public By Campaigns_Clone_Confirm = By.xpath("(//*[@name = 'clone'])");
	
	
	public By Campaigns_total_sequences = By.xpath("//*[contains(@id,'project_email')]");
	public By Campaigns_total_subjects = By.xpath("(//*[contains(@id,'project_email')])/td[3]");    // xpath changed
	public By Campaigns_totalcampaigns = By.xpath("(//*[contains(@class,'selectable')])");     	    // xpath changed
	public By Campaigns_campaign_name = By.xpath("(//*[contains(@class,'selectable')])/td[1]"); 	// xpath changed
	public By Campaigns_campaign_createdinfo = By.xpath("(//*[contains(@class,'hp-btn-container')])[1]");	// xpath changed
	
	
	public By WoocommerceAccount_MyAccount = By.xpath("(//*[text() = 'My Account'])");
	public By WoocommerceAccount_Username = By.xpath("(//*[@id = 'username'])");
	public By WoocommerceAccount_Password = By.xpath("(//*[@id = 'password'])");
	public By WoocommerceAccount_Login = By.xpath("(//*[@name = 'login'])");
	public By WoocommerceAccount_Home = By.xpath("(//*[text() = 'Home'])");
	public By WoocommerceAccount_AddToCart = By.xpath("(//*[@data-product_id = '697'])");
	public By WoocommerceAccount_ViewCart = By.xpath("(//*[@title = 'View Cart'])");
	public By WoocommerceAccount_OpenAcuraCar = By.xpath("(//*[@src = '//woocommerceone.betaout.in/wp-content/uploads/2016/06/Acura-NSX-concept-01-626x382-1-150x150.jpg'])");

	
	public By YopmailAccount_Username = By.xpath("(//*[@id = 'login'])");
	public By YopmailAccount_CheckInbox= By.xpath("(//*[@title = 'Check inbox @yopmail.com'])");
	public By YopmailAccount_Iframe = By.id("ifinbox");
	public By YopmailAccount_TotalEmails = By.xpath("(//*[@class = 'lms'])");
	public By YopmailAccount_IframeText = By.id("ifmail");
	public By YopmailAccount_Text = By.cssSelector("p"); 

	public By WoocommerceAccount_ProceedToCheckout = By.xpath("//*[text() = 'Proceed to Checkout']");
	public By WoocommerceAccount_PlaceOrder = By.xpath("//*[@id = 'place_order']");
	
	// Locators for Stats
	
	
	By Sequence = By.xpath("(//*[contains(@class,'selectable')])/td[2]");
	By Sent = By.xpath("(//*[contains(@class,'selectable')])/td[3]");
	By Opened = By.xpath("(//*[contains(@class,'selectable')])/td[4]");
	By Clicked = By.xpath("(//*[contains(@class,'selectable')])/td[5]");
	By Tageted = By.xpath("(//*[contains(@class,'selectable')])/td[6]");
	By ReTageted = By.xpath("(//*[contains(@class,'selectable')])/td[7]");
	By Recovered = By.xpath("(//*[contains(@class,'selectable')])/td[8]");
	
	
	// Cart
	
	By Cart = By.xpath("(//*[@href='http://woocommerceone.betaout.in/cart/'])");
	
	
	// Extra locators
	
	By CouponSubmit = By.xpath("//*[@name = 'couponDataSubmit']");
	
	public By Iframe1 = By.xpath("(//*[contains(@src,'/email-permalink/nv/peId')])");
	public By Iframe2 = By.xpath("//*[contains(@src,'https://qa.betaout.in/tinymce/js/tinymce/plugins')]");
	public By CampaignsSize = By.xpath("(//*[@class = 'couponcodeId'])");
	public By SearchCampName = By.xpath("//*[@id = 'couponCodeSearch']");
	public By UseCampaignButton = By.xpath("//*[contains(@class,'getSelectedCoupon')]");
	
	By ClickOnSale = By.xpath("(//*[contains(text(),'SALE')])");
	By CouponTinyMCE = By.xpath("//*[@id='mce_38']");
	
	
	public CartRecovery_Homepage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public void OverviewClick()
	{
		driver.findElement(Overview).click();
	}
	
	public void CampaignsClick()
	{
		driver.findElement(Campaigns).click();
	}
	
	public void Overview_CartsClick()
	{
		driver.findElement(Overview_Carts).click();
	}
	
	public void Overview_RevenueClick()
	{
		driver.findElement(Overview_Revenue).click();
	}
	
	public void Campaigns_CreateCampaignClick()
	{
		driver.findElement(Campaigns_CreateCampaign).click();
	}
	
	public void Campaigns_NameofAllCampaignsClick()
	{
		driver.findElement(Campaigns_NameofAllCampaigns).click();
	}
	
	
	
	public void Campaigns_EditClick()
	{
		driver.findElement(Campaigns_Edit).click();
	}
	
	
	
	public void Campaigns_ActiveInstanceClick()
	{
		driver.findElement(Campaigns_ActiveInstance).click();
	
	}
	
	
	public void Campaigns_InactiveInstanceClick()
	{
		driver.findElement(Campaigns_InactiveInstance).click();
	
	}
	
	
	public void Campaigns_DeleteInstanceClick() throws Exception
	{
		driver.findElement(Campaigns_DeleteInstance).click();
		driver.findElement(Campaigns_DeleteInstance_EnterDelete).sendKeys("DELETE");
		Thread.sleep(2000);
		driver.findElement(Campaigns_DeleteInstance_ConfirmDeletebutton).click();
		Thread.sleep(2000);
		
	}
	
	public void Campaigns_CloneClick() throws Exception
	{
		driver.findElement(Campaigns_Clone).click();
		Thread.sleep(2000);
		driver.findElement(Campaigns_Clone_Confirm).click();
		
	}
	
	
	public String printSequenceData()
	{
		String data = driver.findElement(Sequence).getText();
		return data;
	}

	
	public String printSentData()
	{
		String data = driver.findElement(Sent).getText();
		return data;
	}
	
	public String printOpenedData()
	{
		String data = driver.findElement(Opened).getText();
		return data;
	}
	
	public String printClickedData()
	{
		String data = driver.findElement(Clicked).getText();
		return data;
	}
	
	public String printTagetedData()
	{
		String data = driver.findElement(Tageted).getText();
		return data;
	}
	
	public String printReTagetedData()
	{
		String data = driver.findElement(ReTageted).getText();
		return data;
	}
	
	public String printRecoveredData()
	{
		String data = driver.findElement(Recovered).getText();
		return data;
	}
	
	
	
	public void openCart()
	{
		
		driver.findElement(Cart).click();
	}
	
	
	public void CouponSubmitClick()
	{
		driver.findElement(CouponSubmit).click();
	}
	
	
	public void UseCampaignButton()
	{
		driver.findElement(UseCampaignButton).click();
	}
	
	
	
	public void ClickOnSale()
	{
		driver.findElement(ClickOnSale).click();
	}
	
	public void CouponTinyMCEClick()
	{
		driver.findElement(CouponTinyMCE).click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
