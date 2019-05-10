package EmailBOEditorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class EmailBOCreatePage {

	WebDriver driver;

	By CustomDesign = By.xpath("//*[contains(@class,'selector_createcmpgn_custdesign')]");
	By HTML = By.xpath("//*[contains(@class,'selector_createcmpgn_html')]");
			
	By CampaignName = By.xpath("//*[@name = 'newsletterName']");
	
	By ChannelDropdown = By.xpath("(//*[@class = 'BO_dropdown_arrw'])[1]");
	By BetaoutDropdown = By.xpath("(//*[@gateway = 'newsletter'])");
	By MailchimpChannel = By.xpath("(//*[@gateway = 'mailchimp'])");

	By GatewayDropdown = By.xpath("(//*[@class = 'BO_dropdown_arrw'])[2]");
	
	By Subject = By.xpath("(//*[@placeholder = 'Subject'])[2]");
	
	By CampaignTag = By.xpath("(//*[@id = 'campaignTag'])");
	By AddIconCampaign = By.xpath("(//*[@class = 'campaign_tag'])");
	
	By Exit = By.xpath("(//*[text() = 'Exit'])");
	By Save = By.xpath("(//*[text() = 'Save'])");
	By SaveNext = By.xpath("(//*[@class = 'BO_savebtn'])");

	
	// For Recurring and EventTrigger
	
	By GatewayDropdown_Recurring = By.xpath("(//*[@class = 'BO_dropdown_arrw'])[1]");
	
    public EmailBOCreatePage(WebDriver driver)
	{

		this.driver = driver;
	}

	
    public void CustomDesignClick()
    {
    	driver.findElement(CustomDesign).click();
    }

    
    public void HTMLClick()
    {
    	driver.findElement(HTML).click();
    }
    
    
    public void CampaignName(String name)
    {
    	driver.findElement(CampaignName).sendKeys(name);
    }
    
    
    public void ChannelDropdown()
    {
    	driver.findElement(ChannelDropdown).click();
    }
    
    public void SelectBetaoutChannel()
    {
    	driver.findElement(BetaoutDropdown).click();
    }
    
    public void SelectMailchimpChannel()
    {
    	driver.findElement(MailchimpChannel).click();
    }
    
    public void GatewayDropdown() throws Exception
    {
    	driver.findElement(GatewayDropdown).click(); 	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("(//*[text() = 'shivangi@devrover.com(ses)'])")).click();
 
    }
 
    public void GatewayDropdown_Recurring() throws Exception
    {
    	driver.findElement(GatewayDropdown_Recurring).click(); 	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("(//*[text() = 'shivangi@devrover.com(ses)'])")).click();
 
    }
    
    
    
    public void Subject(String subject)
    {
    	driver.findElement(Subject).sendKeys(subject);
    }
   
    public void CampaignTag(String tag)
    {
    	driver.findElement(CampaignTag).sendKeys(tag);
    	
    }
    
    public void AddIconCampaign()
    {
    	driver.findElement(AddIconCampaign).click();
    }
    
    public void Save()
    {
    	driver.findElement(Save).click();
    }
    
    public void Exit()
    {
    	driver.findElement(Exit).click();
    }
    
    public void SaveNext()
    {
    	driver.findElement(SaveNext).click();
    }
    
	
}
