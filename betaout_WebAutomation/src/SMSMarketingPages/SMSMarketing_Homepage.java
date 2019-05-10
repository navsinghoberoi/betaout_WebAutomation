package SMSMarketingPages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class SMSMarketing_Homepage {

	
	public WebDriver driver;
	
	By Overview = By.xpath("(//*[@href = '/sms/overview'])[2]");
	By Campaigns = By.xpath("(//*[@href = '/sms/campaign'])[3]");
	By SuppressionList = By.xpath("(//*[@href = '/sms/suppression-list'])[2]");
	
	
	By Campaigns_BroadCast = By.xpath("(//*[@href = '/sms/campaign'])[4]");
//	By Campaigns_BroadCast_CreateCampaign = By.xpath("(//*[@href = '/sms/campaign-type'])[2]");
	By Campaigns_BroadCast_CreateCampaign = By.xpath("(//*[@href = '/sms/campaign-type-new/nv/campaignType/broadcast'])[2]");
	By Campaigns_BroadCast_Delete = By.xpath("(//*[@title = 'Delete'])[1]");
	By Campaigns_BroadCast_Clone = By.xpath("(//*[@title = 'Clone'])[1]");
	By Campaigns_BroadCast_CloneConfirm = By.xpath("(//*[@name = 'clone'])");
	By Campaigns_BroadCast_ConditionArrow = By.xpath("(//*[@class = 'open-close-caret'])[1]");
	By Campaigns_BroadCast_Export = By.xpath("(//*[@href = '/sms/campaign/nv/export/Y'])");
	By Campaigns_BroadCast_Edit = By.xpath("(//*[@title = 'Edit'])[1]");
	By Campaigns_BroadCast_Stats = By.xpath("(//*[@title = 'Stats'])[1]");
	
	By Campaigns_OnetoOne = By.xpath("(//*[@href = '/sms/one-to-one/compose'])[1]");	
	By Campaigns_OnetoOne_Gateway = By.xpath("//*[@name = 'smsGatewayId']");
	By Campaigns_OnetoOne_To = By.xpath("//*[@name = 'mobile']");
	By Campaigns_OnetoOne_Message = By.xpath("//*[@name = 'message']");
	By Campaigns_OnetoOne_Send = By.xpath("//*[@name = 'send']");
	
	//Event Trigger
	By Campaigns_EventTrigger = By.xpath("(//*[@href = '/sms/event-trigger'])[1]");
	By Campaigns_EventCreateCampaign = By.xpath("(//*[@href = '/sms/event-trigger/new'])");
	By Campaign_EventEditCamp = By.xpath("(//*[@class = 'iconAction-edit'])[1]");
	By Campaign_EventCloneCamp = By.xpath("(//*[@class = 'iconAction-clone'])[1]");
	By Campaign_EventDeleteCamp = By.xpath("(//*[@class = 'iconAction-delete'])[1]");
	By Campaign_EventStatsCamp = By.xpath("(//*[@class = 'iconAction-stats'])[1]");
	By Campaigns_EventInactiveCamp = By.xpath("(//*[@class = 'iconAction-pause'])[1]");          	
	By Campaigns_EventActiveCamp = By.xpath("(//*[@class = 'iconAction-active'])[1]");    	
	By Campaigns_CreatedCampName = By.xpath("//*[contains(@class,'camp-name')][1]");
	
	By Campaigns_EventName = By.xpath("(//*[@class = 'hp-main-figure'])[1]");
	By Campaigns_Total = By.xpath("(//*[@class = 'hp-main-figure'])[2]");
	By Campaigns_Sent = By.xpath("(//*[@class = 'hp-main-figure'])[3]");
	
	
	
	By Campaigns_Recurring = By.xpath("(//*[@href = '/sms/recurring/campaign'])[1]");
//	By Campaigns_Recurring_CreateCampaign = By.xpath("(//*[@href = '/sms/campaign-type/nv/re/100'])[2]");
	By Campaigns_Recurring_CreateCampaign = By.xpath("(//*[@href = '/sms/campaign-type-new/nv/campaignType/recurring'])[2]");
	By Campaigns_Recurring_Delete = By.xpath("(//*[@title = 'Trash'])[2]");
	By Campaigns_Recurring_Names = By.xpath("(//*[@title = 'view design'])");  // Provide index to access a particular campaign
	
	
	By SuppressionList_DND = By.xpath("(//*[@href = '/sms/suppression-list'])[3]");
	By SuppressionList_DND_AddDNDNumbers = By.xpath("(//*[text() = 'Add new DND numbers'])[2]");
	By SuppressionList_DND_Export = By.xpath("(//*[@href = '/sms/suppression-list/nv/export/Y'])");
	
	By SuppressionList_BlackList = By.xpath("(//*[@href = '/sms/suppression-list/blacklist'])[1]");
	By SuppressionList_BlackList_AddBlacklistNumbers = By.xpath("(//*[text() = 'Add New Blacklist Numbers'])[2]");
	By SuppressionList_BlackList_Export = By.xpath("(//*[@href = '/sms/suppression-list/blacklist/nv/export/Y'])");
	
	By SuppressionList_InvalidSubscriber = By.xpath("(//*[@href = '/sms/suppression-list/invalid'])[1]");
	By SuppressionList_InvalidSubscriber_AddInvalidNumbers = By.xpath("(//*[text() = 'Add New Invalid Numbers'])[2]");
	By SuppressionList_InvalidSubscriber_Export = By.xpath("(//*[@href = '/sms/suppression-list/invalid/nv/export/Y'])");
		
	By CampaignName = By.xpath("(//*[contains(@href,'/sms/permalink/nv/smsTextId')])[1]");
	By RecurringCampaignName = By.xpath("(//*[@title = 'view design'])[1]");
	By RecurringCampaignDetails = By.xpath("(//*[@class = 'hp-btn-container'])[1]");
	
	By SMSText = By.xpath("(//*[@class = 'hp-campaign-description'])[1]");
	
	// Add locators for Counts
	
	By SentRecipients = By.xpath("(//*[contains(@class,'selectable')])/td[2]");
	By Delivered = By.xpath("(//*[contains(@class,'selectable')])/td[3]");
	By Clicked = By.xpath("(//*[contains(@class,'selectable')])/td[4]");
	By Discarded = By.xpath("(//*[contains(@class,'selectable')])/td[5]");
	By Failed = By.xpath("(//*[contains(@class,'selectable')])/td[6]");
	
	
	// Stats page locators
	
	public By SentIframe = By.xpath("(//*[contains(@src,'/sms/stats/nv/cType')])[1]");
	By DeliveredIframe = By.xpath("(//*[contains(@src,'/sms/stats/nv/cType')])[2]");
	By ClickedIframe = By.xpath("(//*[contains(@src,'/sms/stats/nv/cType')])[3]");
	By FailedIframe = By.xpath("(//*[contains(@src,'/sms/stats/nv/cType')])[4]");
	By DiscardedIframe = By.xpath("(//*[contains(@src,'/sms/stats/nv/cType')])[5]");
	By UndeliveredIframe = By.xpath("(//*[contains(@src,'/sms/stats/nv/cType')])[6]");
	
	By ExportCSV = By.xpath("(//*[text() = 'EXPORT CSV'])");
	By DownloadCSV = By.xpath("(//*[contains(@class,'iconNew-export')])[1]");
		
	public SMSMarketing_Homepage(WebDriver driver)
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
	
	public void SuppressionListClick()
	{
		driver.findElement(SuppressionList).click();
	}
	
	public void Campaigns_BroadCastClick()
	{
		driver.findElement(Campaigns_BroadCast).click();
	}
	
	public void Campaigns_BroadCast_CreateCampaignClick()
	{
		driver.findElement(Campaigns_BroadCast_CreateCampaign).click();
	}
	
	public void Campaigns_BroadCast_DeleteClick() throws Exception
	{
		driver.findElement(Campaigns_BroadCast_Delete).click();
		
		driver.findElement(By.xpath("(//*[@id = 'capsVal'])")).sendKeys("DELETE");
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Delete'])[2]")).click();
	}
	
	public void Campaigns_BroadCast_CloneClick() throws Exception
	{
		driver.findElement(Campaigns_BroadCast_Clone).click();
		Thread.sleep(2000);
	/*String nameofbutton = driver.findElement(By.xpath("(//*[@name = 'clone'])")).getText();
	System.out.println("Name of button on clone confirmation prompt = "+nameofbutton);*/
		driver.findElement(Campaigns_BroadCast_CloneConfirm).click();
	
	}
	
	public void Campaigns_BroadCast_ConditionArrowClick() throws Exception
	{
		driver.findElement(Campaigns_BroadCast_ConditionArrow).click();
		Thread.sleep(1500);
		driver.findElement(Campaigns_BroadCast_ConditionArrow).click();
	}
	

	
	public void Campaigns_BroadCast_ExportClick() 
	{
		driver.findElement(Campaigns_BroadCast_Export).click();
		
	}
	
	public void Campaigns_BroadCast_Stats()
	{
		driver.findElement(Campaigns_BroadCast_Stats).click();
		
	}
	

	public void Campaigns_OnetoOneClick()
	{
		driver.findElement(Campaigns_OnetoOne).click();
	
	}
	
	public void Campaigns_OnetoOne_GatewayClick()
	{
		Select gateway = new Select(driver.findElement(Campaigns_OnetoOne_Gateway));
		gateway.selectByVisibleText("GolfLan -way2mint(GOLFLN)");
		
	}
	
	public void Campaigns_OnetoOne_ToClick(String number)
	{
		driver.findElement(Campaigns_OnetoOne_To).sendKeys(number);
		
	}
	
	public void Campaigns_OnetoOne_MessageClick(String message)
	{
		driver.findElement(Campaigns_OnetoOne_Message).sendKeys(message);
	}
	
	public void Campaigns_OnetoOne_SendClick()
	{
		driver.findElement(Campaigns_OnetoOne_Send).click();
	}
	
	
	public void Campaigns_EventTrigger()
	{
		driver.findElement(Campaigns_EventTrigger).click();
	}
	
	public void Campaigns_EventCreateCampaign()
	{
		driver.findElement(Campaigns_EventCreateCampaign).click();
	}
	
	public void Campaign_EventEditCamp()
	{
		driver.findElement(Campaign_EventEditCamp).click();
	}
	
	public void Campaign_EventCloneCamp()
	{
		driver.findElement(Campaign_EventCloneCamp).click();
	}
	
	public void Campaign_EventDeleteCamp()
	{
		driver.findElement(Campaign_EventDeleteCamp).click();
	}
	
	public void Campaign_EventStatsCamp()
	{
		driver.findElement(Campaign_EventStatsCamp).click();
	}
	
	public void Campaigns_EventInactiveCamp()
	{
		driver.findElement(Campaigns_EventInactiveCamp).click();
	}
	
	public void Campaigns_EventActiveCamp()
	{
		driver.findElement(Campaigns_EventActiveCamp).click();
	}
	
	
	public String getCampaigns_CreatedCampName()
	{
		String name = driver.findElement(Campaigns_CreatedCampName).getText();
		return name;
	}
	
	
	public String getCampaigns_Campaigns_EventName()
	{
		String name = driver.findElement(Campaigns_EventName).getText();
		return name;
	}
	
	public String Campaigns_Total()
	{
		String total = driver.findElement(Campaigns_Total).getText();
		return total;
		
		
	}
	
	public String Campaigns_Sent()
	{
		String sent = driver.findElement(Campaigns_Sent).getText();
		return sent;
	}
	
	
	
	
	
	public void Campaigns_RecurringClick()
	{
		driver.findElement(Campaigns_Recurring).click();
	}
	
	public void Campaigns_Recurring_CreateCampaignClick()
	{
		driver.findElement(Campaigns_Recurring_CreateCampaign).click();
	}
	
	public void Campaigns_Recurring_DeleteClick() throws Exception
	{
		driver.findElement(Campaigns_Recurring_Delete).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@id = 'capsVal'])")).sendKeys("DELETE");
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[text() = 'Delete'])[2]")).click();
	}
	
	
	public void Campaigns_Recurring_NamesClick()
	{
		List<org.openqa.selenium.WebElement> name = driver.findElements(Campaigns_Recurring_Names);
	    System.out.println("Total elements :"+name.size());
	              
	    String campaign_name =  ((org.openqa.selenium.WebElement) name.get(0)).getText();
		System.out.println("Name of the first campaign = "+campaign_name);
		
	}
	
	public void SuppressionList_DNDClick()
	{
		driver.findElement(SuppressionList_DND).click();
	}
	
	public void SuppressionList_DND_AddDNDNumbersClick(String number) throws Exception
	{
		driver.findElement(SuppressionList_DND_AddDNDNumbers).click();
		
		// Select values from dropdown
		Thread.sleep(2000);
		Select phonedropdown = new Select(driver.findElement(By.xpath("(//*[@name = 'field'])")));
		phonedropdown.selectByVisibleText("Phone");   // Select Phone
		
		String name = driver.findElement(By.xpath("(//*[@name = 'field'])")).getText();
		System.out.println("Name of all the options from Dropdown = "+name);
		
		driver.findElement(By.xpath("(//*[@name = 'values'])")).sendKeys(number);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@name = 'send_test_sms'])")).click(); // Add button
		Thread.sleep(2000);
	}

	public void SuppressionList_DND_ExportClick()
	{
		driver.findElement(SuppressionList_DND_Export).click();
		
		List<org.openqa.selenium.WebElement> log = driver.findElements(By.xpath("(//*[@style = 'vertical-align: middle'])"));
	    System.out.println("Total elements :"+log.size());
	              
	      String name =   ((org.openqa.selenium.WebElement) log.get(1)).getText();
	      System.out.println("Name of the exported file = "+name);
	      
	      driver.findElement(By.xpath("(//*[@style = ' vertical-align: top'])[1]")).click();    // Download 1st file
	      
	}

	public void SuppressionList_BlackListClick()
	{
		driver.findElement(SuppressionList_BlackList).click();
	
	}

	public void SuppressionList_BlackList_AddBlacklistNumbersClick(String number) throws Exception
	{
		driver.findElement(SuppressionList_BlackList_AddBlacklistNumbers).click();
		Thread.sleep(2000);

		Select phonedropdown = new Select(driver.findElement(By.xpath("(//*[@name = 'field'])")));
		phonedropdown.selectByVisibleText("Phone");
		
		String name = driver.findElement(By.xpath("(//*[@name = 'field'])")).getText();
		System.out.println("Name of all options from Selected Dropdown = "+name);
		
		driver.findElement(By.xpath("(//*[@name = 'values'])")).sendKeys(number);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@name = 'send_test_sms'])")).click(); // Add button
		Thread.sleep(2000);
	}

	public void SuppressionList_BlackList_ExportClick() throws Exception
	{
		driver.findElement(SuppressionList_BlackList_Export).click();
		
		List<org.openqa.selenium.WebElement> log = driver.findElements(By.xpath("(//*[@style = 'vertical-align: middle'])"));
	    System.out.println("Total elements :"+log.size());
	    Thread.sleep(5000);

	      String name =   ((org.openqa.selenium.WebElement) log.get(1)).getText();
	      System.out.println("Name of the exported file = "+name);
	      
	      driver.findElement(By.xpath("(//*[@style = ' vertical-align: top'])[1]")).click();    // Download 1st file
		
	}
	
	public void SuppressionList_InvalidSubscriberClick()
	{
		driver.findElement(SuppressionList_InvalidSubscriber).click();
	}

	public void SuppressionList_InvalidSubscriber_AddInvalidNumbersClick(String number) throws Exception
	{
		driver.findElement(SuppressionList_InvalidSubscriber_AddInvalidNumbers).click();
		Thread.sleep(2000);

		
		Select phonedropdown = new Select(driver.findElement(By.xpath("(//*[@name = 'field'])")));
		phonedropdown.selectByVisibleText("Phone");   // Select Phone
		
		String name = driver.findElement(By.xpath("(//*[@name = 'field'])")).getText();
		System.out.println("Name of all options from Selected Dropdown = "+name);
		
		driver.findElement(By.xpath("(//*[@name = 'values'])")).sendKeys(number);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@name = 'send_test_sms'])")).click(); // Add button
		Thread.sleep(2000);

	}

	public void SuppressionList_InvalidSubscriber_ExportClick() throws Exception
	{
		driver.findElement(SuppressionList_InvalidSubscriber_Export).click();
		List<org.openqa.selenium.WebElement> log = driver.findElements(By.xpath("(//*[@style = 'vertical-align: middle'])"));
	    System.out.println("Total elements :"+log.size());
	    Thread.sleep(5000);   
	    String name =   ((org.openqa.selenium.WebElement) log.get(1)).getText();
	    System.out.println("Name of the exported file = "+name);
	      
	    driver.findElement(By.xpath("(//*[@style = ' vertical-align: top'])[1]")).click();    // Download 1st file
	
	}

	public void PrintOverviewInfoClick()
	{
	
		List<org.openqa.selenium.WebElement> log = driver.findElements(By.xpath("(//*[@class = 'panel-title pull-left'])"));
	    System.out.println("Total elements :"+log.size());
		
	   /* Iterator<WebElement> itr = log.iterator();
	    while(itr.hasNext()) {
	    	WebElement row = itr.next();
	        System.out.println("Name of the headings are="+row.getText());
	        
	    					}*/

	    List<org.openqa.selenium.WebElement> log1 = driver.findElements(By.xpath("(//*[@class = 'pull-left font-lg'])"));
		
	   // System.out.println("Total elements :"+log1.size());
			
		  /*  Iterator<WebElement> itr1 = log1.iterator();
		    while(itr1.hasNext()) {
		    	WebElement row1 = itr1.next();
		      // System.out.println("Numeric values of the headings are="+row1.getText());
		    	System.out.println("Numeric values of the headings are="+row1.getText());*/

  		
	    for(int i=0;i<log.size();i++)
	    {
	    	System.out.println(log.get(i).getText()+" = "+log1.get(i).getText());
	    	
	    }
	    
		    						}
		    		

	
	public void EditCampaign()
	{
		driver.findElement(Campaigns_BroadCast_Edit).click();
	}
		    
	public String printCampaignName()	
	{
		String name = driver.findElement(CampaignName).getText();
		return name;
	}
	
	
	public String printSMSText()	
	{
		String text = driver.findElement(SMSText).getText();
		return text;
	}
		
	public String printSent()
	{
		String  SentDelivered = driver.findElement(SentRecipients).getText();
		String Sent = SentDelivered.split("\n")[0];
		System.out.println("Count for Sent for campaign = "+Sent);
		return Sent;
	}
	
	public String printRecipients()
	{
		String  SentDelivered= driver.findElement(SentRecipients).getText();
		String Recipients = SentDelivered.split("\n")[1];
		System.out.println("Count for Recipients for campaign = "+Recipients);
		return Recipients;
	}
		
	public String printDelivered()
	{
		String  DeliveredWithPercent = driver.findElement(Delivered).getText();
		String Delivered = DeliveredWithPercent.split("\n")[0];
		System.out.println("Count for Delivered for campaign = "+Delivered);
		return Delivered;
	}
	
	public String printDeliveredPercent()
	{
		String  DeliveredWithPercent = driver.findElement(Delivered).getText();
		String DeliveredPercent = DeliveredWithPercent.split("\n")[1];
		System.out.println("Count for DeliveredPercent for campaign = "+DeliveredPercent);
		return DeliveredPercent;
	}
	
	
	public String printClicked()
	{
		String ClickedCount = driver.findElement(Clicked).getText();
		System.out.println("Count for Clicked for campaign = "+ClickedCount);
		return ClickedCount;
	}
	
	
	public String printDiscarded()
	{
		String DiscardedCombo = driver.findElement(Discarded).getText();
		String DiscardedCount = DiscardedCombo.split("\n")[0];
		System.out.println("Count for Discarded for campaign = "+DiscardedCount);
		return DiscardedCount;
	}
	
	
	public String printDiscardedPercent()
	{
		String DiscardedCombo = driver.findElement(Discarded).getText();
		String DiscardedPercent = DiscardedCombo.split("\n")[1];
		System.out.println("Count for Discarded Percent for campaign = "+DiscardedPercent);
		return DiscardedPercent;
	}
	
	
	public String printFailed()
	{
		String FailedCount = driver.findElement(Failed).getText();
		System.out.println("Count for Failed for campaign = "+FailedCount);
		return FailedCount;
	}
	
	
	 public boolean SMS_PrintContactsFromStats(String PhoneNumberToBeMatched)
	 {
		  // Sent Iframe
		 driver.switchTo().frame(driver.findElement(SentIframe));
		 System.out.println("Now present in Sent iframe");
		 WebElement Sentbody = driver.findElement(By.cssSelector("body"));
		 String SentData = Sentbody.getText();
		 System.out.println(SentData);		
		 boolean SentBoolean = SentData.contains(PhoneNumberToBeMatched);
		 System.out.println("Result of comparison of Phone number in Sent Heading = " +SentBoolean);
		 driver.switchTo().defaultContent();
		 
		 System.out.println("------------------------------------------------------------------");
		 
	
		  // Delivered Iframe 
		 driver.switchTo().frame(driver.findElement(DeliveredIframe));
		 System.out.println("Now present in Delivered Iframe");
		 WebElement Deliveredbody = driver.findElement(By.cssSelector("body"));
		 String DeliveredbodyData = Deliveredbody.getText();
		 System.out.println(DeliveredbodyData);
		 boolean DeliveredBoolean = DeliveredbodyData.contains(PhoneNumberToBeMatched);
		 System.out.println("Result of comparison of Phone Number in Delivered Heading = " +DeliveredBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		  // Clicked Iframe  
		 driver.switchTo().frame(driver.findElement(ClickedIframe));
		 System.out.println("Now present in Clicked Iframe");
		 WebElement Clickedbody = driver.findElement(By.cssSelector("body"));
		 String ClickedbodyData = Clickedbody.getText();
		 System.out.println(ClickedbodyData);
		 boolean ClickedDataBoolean = ClickedbodyData.contains(PhoneNumberToBeMatched);
		 System.out.println("Result of comparison of Phone Number in Clicked Data Heading = " +ClickedDataBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		 
		  // Failed Iframe 
		 driver.switchTo().frame(driver.findElement(FailedIframe));
		 System.out.println("Now present in Failed Iframe");
		 WebElement Failedbody = driver.findElement(By.cssSelector("body"));
		 String FailedbodyData = Failedbody.getText();
		 System.out.println(FailedbodyData);
		 boolean FailedBoolean = FailedbodyData.contains(PhoneNumberToBeMatched);
		 System.out.println("Result of comparison of Phone number in Failed Heading = " +FailedBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		  // DiscardedIframe 
		 driver.switchTo().frame(driver.findElement(DiscardedIframe));
		 System.out.println("Now present in Discarded Iframe");
		 WebElement Discardedbody = driver.findElement(By.cssSelector("body"));
		 String DiscardedData = Discardedbody.getText();
		 System.out.println(DiscardedData);
		 boolean DiscardedBoolean = DiscardedData.contains(PhoneNumberToBeMatched);
		 System.out.println("Result of comparison of Phone Number in Discarded Heading = " +DiscardedBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		  
		  // UndeliveredIframe  
		 driver.switchTo().frame(driver.findElement(UndeliveredIframe));
		 System.out.println("Now present in Undelivered Iframe");
		 WebElement Undeliveredbody = driver.findElement(By.cssSelector("body"));
		 String UndeliveredbodyData = Undeliveredbody.getText();
		 System.out.println(UndeliveredbodyData);
		 boolean UndeliveredbodyDataBoolean = UndeliveredbodyData.contains(PhoneNumberToBeMatched);
		 System.out.println("Result of comparison of Phone Number in Undelivered Heading = " +UndeliveredbodyDataBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		 
		 return SentBoolean;

	 }
	 
	
	public void ExportCSVclick()
	{
		driver.findElement(ExportCSV).click();
		
	}
	
	public void DownloadCSVclick()
	{
		driver.findElement(DownloadCSV).click();
		
	}
	
	public String RecurringCampaignName()
	{
		String recurname = driver.findElement(RecurringCampaignName).getText();
		return recurname;
	}
	
	public String RecurringCampaignDetails()
	{
		String recurdetails = driver.findElement(RecurringCampaignDetails).getText();
		return recurdetails;
	}
	
	
	
	
	
	
}
	

