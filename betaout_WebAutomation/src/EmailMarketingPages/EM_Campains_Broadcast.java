package EmailMarketingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class EM_Campains_Broadcast {
// All codes of broadcast page
	
		WebDriver driver;
		
		public By campaign_tab=By.xpath("(//*[text()='Campaigns'])[2]"); // Click on Campaigns on Header menu
		
		public By Broadcast  = By.xpath("(//*[text()='Broadcast'])[1]"); // Click on Broadcast on Header menu
		
		public By Broadcast_name = By.xpath("//*[@title='view design']"); // Broadcast name list 
		
		public By Broadcast_Createcapmain = By.xpath("(//*[text()='CREATE CAMPAIGN'])[2]"); // Click on Create campaigns button 
				
		public By Broadcast_campaign_title = By.xpath("//*[@id = 'news_letter_name']"); // Campaign Title Box

		public By Page_name =  By.xpath("//*[@class = 'add-campaign']/h1"); // Get text of this field
	    
	   // By campaign_name = By.xpath("//*[@id = 'news_letter_name']");
	    
	    By Save_And_Next  = By.xpath("//*[text()='SAVE & NEXT STEP']");
	    
	    public By mail_chimp_server = By.xpath("//*[@class = 'zoom_img '])[1]");
	    
	    public By mail_Betaout_server = By.xpath("(//*[@class = 'zoom_img '])[2]");
	    
	    public By  Use_This_Temaplate_button = By.xpath("//*[@data-tid='389']");
	    
	    public By Preview_template = By.xpath("//*[@id='389']");
	    
	    public By EventTriggered = By.xpath("(//*[@href='/email/transactional/active'])[1]");
	    
	    public By OneToOne = By.xpath("(//*[@href='/email/one-to-one/compose'])[1]");
	    
	    public By Recurring = By.xpath("(//*[@href='/email/recurring/recurring'])[1]");
	    
	    
	    
	    
	    // Codes added for locators (Additional)
	    
	    public By broadcast_campaigns = By.xpath("//*[contains(@href,'/email-html-permalink')]");
	    public By sent_campaigns = By.xpath("//*[contains(@class,'selectable')]");
	    public By daliyCampName = By.xpath("(//*[@title = 'view design'])[1]");
	    public By dailyCampDetails = By.xpath("(//*[@class = 'hp-btn-container'])[1]");
	    public By allTemplates = By.xpath("//*[@class = 'caption']");
	    public By addEmailAddress = By.xpath("(//*[@id = 'textString'])");
	    
	    
	    
	    // Codes added for editing and cloning
	    By RefreshCampaign = By.xpath("(//*[@class = 'iconAction-refresh'])[1]");
	    By CloneCampaign = By.xpath("(//*[@class = 'iconAction-clone'])[1]");
	    By StatsCampaign = By.xpath("(//*[@class = 'iconAction-stats'])[1]");
	    By DeleteCampaign = By.xpath("(//*[@class = 'iconAction-delete'])[1]");
	    By EditCampaign = By.xpath("(//*[@class = 'iconAction-edit'])[1]");
	    
	    By CloneConfirm = By.xpath("(//*[@id = 'btnClone'])");
	   
	    
	    
	    // Codes for gettings Counts
	    
	    By Delivered = By.xpath("(//*[contains(@id,'totalSent')])[1]");
	    By TotalRecipients = By.xpath("(//*[contains(@id,'totalSubscribers')])[1]");
	    By OpenedPercent = By.xpath("(//*[contains(@id,'openPercentage')])[1]");
	    By TotalOpened = By.xpath("(//*[contains(@id,'totalOpened')])[1]");
	    By ClickedPercent = By.xpath("(//*[contains(@id,'clickPercentage')])[1]");
	    By TotalClicked = By.xpath("(//*[contains(@id,'totalClicked')])[1]");
	    By BouncedPercent = By.xpath("(//*[contains(@id,'bouncedPercentage')])[1]");
	    By TotalBounced = By.xpath("(//*[contains(@id,'totalBounced')])[1]");
	    By UnsubscribedPercent = By.xpath("(//*[contains(@id,'unsubscribePercentage')])[1]");
	    By TotalUnsubscribed = By.xpath("(//*[contains(@id,'totalUnsubscribes')])[1]");
	    
	    
	    
	    public EM_Campains_Broadcast (WebDriver driver)
		{

			this.driver = driver;
		}
	    
		public void campaign_Tab (){
			
			driver.findElement(campaign_tab).click();
			
			}
		
public void Broadcast_Tab (){
			
			driver.findElement(Broadcast).click();
			
			}

public void Broadcast_Createcapmain(){
	
	driver.findElement(Broadcast_Createcapmain).click();
	
	}

public void Broadcast_campaign_title(String Broadcast_campain_title){
	
	driver.findElement(Broadcast_campaign_title).sendKeys(Broadcast_campain_title);
	
	driver.findElement(Page_name).getText();
	
	driver.findElement(Save_And_Next).click();
	
	}

public void mail_Betaout_server (){
	driver.findElement(mail_Betaout_server).click();
	
}
	
public void Template (){
	driver.findElement(Use_This_Temaplate_button).click(); // Select Template 
	
}

public void Template_preview()
{
	driver.findElement(Preview_template).click(); // Preview template button
	
}
	
public void EventTriggeredClick()
{
	driver.findElement(EventTriggered).click(); // Preview template button
	
}
	

public void OneToOneClick()
{
	driver.findElement(OneToOne).click(); // Preview template button
	
}
	

public void RecurringClick()
{
	driver.findElement(Recurring).click(); // Preview template button
	
}
	

public void RefreshCampaignClick()
{
	driver.findElement(RefreshCampaign).click();
	
}


public void CloneCampaignClick() throws Exception
{
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(CloneCampaign)).build().perform();	
	Thread.sleep(3000);
	driver.findElement(CloneCampaign).click();
	Thread.sleep(4000);

	driver.findElement(CloneConfirm).click();

}



public void StatsCampaignClick() throws Exception
{
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(StatsCampaign)).build().perform();	
	Thread.sleep(3000);
	driver.findElement(StatsCampaign).click();
	Thread.sleep(2000);
}


public void DeleteCampaignClick() throws Exception
{
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(DeleteCampaign)).build().perform();	
	Thread.sleep(3000);
	driver.findElement(DeleteCampaign).click();
	Thread.sleep(2000);
}



public void EditCampaignClick() throws Exception
{
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(EditCampaign)).build().perform();	
	Thread.sleep(3000);
	driver.findElement(EditCampaign).click();
	Thread.sleep(2000);
}


		
public String printDelivered()
{
	String a = driver.findElement(Delivered).getText();
	return a;
}

public String printTotalRecipients()
{
	String a = driver.findElement(TotalRecipients).getText();
	return a;
}

public String printOpenedPercent()
{
	String a = driver.findElement(OpenedPercent).getText();
	return a;
}

public String printTotalOpened()
{
	String a = driver.findElement(TotalOpened).getText();
	return a;
}

public String printClickedPercent()
{
	String a = driver.findElement(ClickedPercent).getText();
	return a;
}

public String printTotalClicked()
{
	String a = driver.findElement(TotalClicked).getText();
	return a;
}

public String printBouncedPercent()
{
	String a = driver.findElement(BouncedPercent).getText();
	return a;
}

public String printTotalBounced()
{
	String a = driver.findElement(TotalBounced).getText();
	return a;
}

public String printUnsubscribedPercent()
{
	String a = driver.findElement(UnsubscribedPercent).getText();
	return a;
}

public String printTotalUnsubscribed()
{
	String a = driver.findElement(TotalUnsubscribed).getText();
	return a;
}





		}


