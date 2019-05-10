package EmailMarketingPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class EM_EventTriggeredCreateCampaign {

	public WebDriver driver;
	
	
//	By EventTrigger_CreateCampaignButton = By.xpath("(//*[@href='/email/event/campaign-type'])[2]");

	By EventTrigger_CreateCampaignButton = By.xpath("(//*[@href='/email/choose-campaign-type/nv/campaignType/eventTrigger'])[2]");
	
	By EventTrigger_CampaignName = By.xpath("(//*[@id='news_letter_name'])");
	
//	By EventTrigger_SaveCampaign = By.xpath("(//*[@id='news_letter_sub_button'])");
	By EventTrigger_SaveCampaign = By.xpath("(//*[@name='save'])");
			
	By EventTrigger_MakeActive = By.xpath("//*[text() ='Make Active']");
	
	By EventTrigger_Save = 	By.xpath("//*[@name ='save']");
	
	By EventTrigger_Delete = By.xpath("//*[@id ='delete_transactional_email']");
	
	By Event_name_edit  = By.xpath("//*[@id = 'transactional_email_name_span']");
	
	By Check_Stats = By.xpath("//*[text() = 'Check Stats']");
	
	By SelectEvent = By.xpath("//*[@id = 'eventTypeId']");
	
	By ChooseDelay = By.xpath("//*[@id = 'delayMsTime']");

	By ChooseLifecycle = By.xpath("//*[@id = 'lifeCycleIds']");
	
	By Choose_Tags = By.xpath("(//*[@title= 'None selected'])[1]");
		
	By Choose_Segments = By.xpath("(//*[@title= 'None selected'])[2]");
	
	By Check_time_interval = By.xpath("//*[@class= 'mobile_label']");
	
	By Add_email_button = By.xpath("//*[@id= 'add_email_div']");
	
	
	// Select template
	By  Use_This_Temaplate_button = By.xpath("//*[@data-tid='389']");
	    
	By Preview_template = By.xpath("//*[@id='389']");
	
	//Enter data for email template
	By campaign_name = By.xpath("(//*[@class= 'form-group-outer'])[1]");
	
	By campaign_subject = By.xpath("(//*[@placeholder= 'Add subject here'])[2]");
	
	By Smiles = By.xpath ("//*[@data-type= 'picker']");
	
	By Sender_Id = By.xpath("//*[@id= 'senderEmailId']");	
	
	By Exit_button = By.xpath("//*[text()= 'Exit']");
	
	By Save_and_Exit = By.xpath("//*[@data-action='saveTranExit']");
			
	By SaveAsDraft = By.xpath("//*[@data-action='save']");

	By Linkurl_PopUp_OK = By.xpath("//*[@id='okButton']");
	
	By Linkurl_Checkbox = By.xpath("//*[@class='mobile_label']");
	
	By Linkurl_NewURL = By.xpath("//*[@id='betaout_replaceUrl']");
	
	// Option to perform on campaign
	
	By AllCampaignsDropdown = By.xpath("(//*[@class ='bg_drop_arw'])");
	By SelectActiveCampaigns = By.xpath("(//*[@class ='active '])");
	By SelectInactiveCampaigns = By.xpath("(//*[@href ='/email/transactional/inactive'])");
	
	By EventTrigger_EditCampaign = By.xpath("(//*[@class ='iconAction-edit'])[1]");
	By EventTrigger_DeleteCampaign = By.xpath("(//*[@class ='iconAction-delete'])[1]");
	public 	By EventTrigger_StatsCampaign = By.xpath("(//*[@class ='iconAction-stats'])[1]");
	By EventTrigger_PrintContacts = By.xpath("//*[contains(@style,'vertical-align: middle')]");
	public By EventTrigger_InactiveCampaign = By.xpath("(//*[@class ='iconAction-pause'])[1]");
	By EventTrigger_ActiveCampaign = By.xpath("(//*[@class ='iconAction-active'])[1]");
	
	
	By EventTrigger_Name = By.xpath("//*[contains(@class,'selectable')]/td[1]");
	By EventTrigger_TriggerEvent = By.xpath("//*[contains(@class,'selectable')]/td[2]");
	By EventTrigger_LifecycleStage = By.xpath("//*[contains(@class,'selectable')]/td[3]");
	
	
	
	// Stats page locators
	
	By SentIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[1]");
	By LastOpenedIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[2]");
	By PeopleWhoDidntOpnedEmailIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[3]");
	By LastClickedIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[4]");
	By LastUnsubscribeIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[5]");
	By LastBouncedIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[6]");
	By LastSpamIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[7]");
	By EmailNotSentIframe = By.xpath("(//*[contains(@src,'/email/stats/nv/cType')])[8]");
	
	
	
	
	 public EM_EventTriggeredCreateCampaign (WebDriver driver)
		{

			this.driver = driver;
		}
	
	 
	 
	 public void EventTrigger_CreateCampaignButton()
	 {
		 driver.findElement(EventTrigger_CreateCampaignButton).click();
	 }
	 
	
	 public void EventTrigger_CampaignName(String name)
	 {
		 driver.findElement(EventTrigger_CampaignName).sendKeys(name);;
	 }
	
	
	 public void EventTrigger_SaveCampaign()
	 {
		 driver.findElement(EventTrigger_SaveCampaign).click();
	 }
	
	 
	 public void EventTrigger_MakeActive()
	 {
		 driver.findElement(EventTrigger_MakeActive).click();
	 }
	 
	 public void EventTrigger_Save()
	 {
		 driver.findElement(EventTrigger_Save).click();
	 }
	 
	 public void EventTrigger_Delete()
	 {
		 driver.findElement(EventTrigger_Delete).click();
	 }
	 

	 public void Event_name_edit(String Edit_Event_name){
			
			driver.findElement(Event_name_edit).sendKeys(Edit_Event_name);
			
			}
	 public void Check_Stats(){
			
			driver.findElement(Check_Stats).click();
			
			}
	 public void SelectEventFromDropdown(String event){
			
		 Select sel = new Select(driver.findElement(SelectEvent));
		 sel.selectByVisibleText(event);
			}
	 
	 public void ChooseDelayFromDropdown(String time){
	
		 Select sel = new Select(driver.findElement(ChooseDelay));
		 sel.selectByVisibleText(time);			
			
			}
	 
	 public void ChooseLifecycleFromDropdown(String lifecycle){
			
		 Select sel = new Select(driver.findElement(ChooseLifecycle));
		 sel.selectByVisibleText(lifecycle);		
	
			}
	 public void Choose_Tags(){
			
			driver.findElement(Choose_Tags).click();
			
			}
	 public void Choose_Segments(){
			
			driver.findElement(Choose_Segments).click();
			
			}
	 public void Check_time_interval(){
			
			driver.findElement(Check_time_interval).click();
			
			}
	 public void Add_email_button(){
			
			driver.findElement(Add_email_button).click();
			
			}
	
	 
	 public void Template (){
			driver.findElement(Use_This_Temaplate_button).click(); // Select Template 
			
		}

	public void Template_preview()
		{
			driver.findElement(Preview_template).click(); // Preview template button
			
		}
	 
	 public void campaign_name (String campaign_Name){
			driver.findElement(campaign_name).sendKeys(campaign_Name);
			
		}
	 
	 public void Campaign_Subject(String Campaign_Subject){
			driver.findElement(campaign_subject).sendKeys(Campaign_Subject);
			
		}
	 
	 public void Smilies (){
			driver.findElement(Smiles).click();
			
		} 
	 
	 public void Sender_Id (String sender_email_select){
			
			Select select = new Select(driver.findElement(Sender_Id));
		      select.selectByVisibleText(sender_email_select);		
					} 
	 
	 public void Exit_button (){
		 
			driver.findElement(Exit_button).click();
		
	 } 
	 
	 
	 public void Save_and_Exit (){
		 
			driver.findElement(Save_and_Exit).click();
		
	 } 
	 
	 public void SaveAsDraft (){
		 
			driver.findElement(SaveAsDraft).click();
		
	 } 
		
	 
	 public void Linkurl_PopUp_OK (){
		 
			driver.findElement(Linkurl_PopUp_OK).click();
	 } 
	 
	 
	 public void Linkurl_TickCheckbox(){
		 
			driver.findElement(Linkurl_Checkbox).click();
	 } 
	 
	 
	 public void Linkurl_NewURL(String URL){
		 
			driver.findElement(Linkurl_NewURL).sendKeys(URL);;
	 } 
	 
	 
	 public void AllCampaignsDropdownClick()
	 {
		 driver.findElement(AllCampaignsDropdown).click();
	 }
	 
	 public void SelectActiveCampaignsClick()
	 {
		 driver.findElement(SelectActiveCampaigns).click();
	 }
	 
	 public void SelectInactiveCampaignsClick()
	 {
		 driver.findElement(SelectInactiveCampaigns).click();
	 }
	 
	 public void EventTrigger_EditCampaignClick()
	 {
		 driver.findElement(EventTrigger_EditCampaign).click();
	 }
	
	 public void EventTrigger_DeleteCampaignClick()
	 {
		 driver.findElement(EventTrigger_DeleteCampaign).click();
	 }
	 
	 
	 public void EventTrigger_StatsCampaignClick()
	 {
		 driver.findElement(EventTrigger_StatsCampaign).click();
	 }
	 
	 /*public boolean EventTrigger_PrintContactsFromStats(String EmailtoBeMatched)
	 {
		 List<WebElement> allContacts = new ArrayList<WebElement>();
		 allContacts = driver.findElements(EventTrigger_PrintContacts);
		 
		// ArrayList<WebElement> allContacts = (ArrayList<WebElement>) driver.findElements(EventTrigger_PrintContacts);
		 	
		 for(WebElement web : allContacts)
		 {
			 System.out.println(web.getText());
		 }
		
		 
		 boolean retval = allContacts.contains(EmailtoBeMatched);
	 
		 return retval;
	 }
	*/ 
	 
	 public boolean EventTrigger_PrintContactsFromStats(String EmailtoBeMatched)
	 {
		  // Sent Iframe
		 driver.switchTo().frame(driver.findElement(SentIframe));
		 System.out.println("Now present in Sent iframe");
		 WebElement Sentbody = driver.findElement(By.cssSelector("body"));
		 String SentData = Sentbody.getText();
		 System.out.println(SentData);		
		 boolean SentBoolean = SentData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Sent Heading = " +SentBoolean);
		 driver.switchTo().defaultContent();
		 
		 System.out.println("------------------------------------------------------------------");
		 
		  // LastOpened Iframe
		 driver.switchTo().frame(driver.findElement(LastOpenedIframe));
		 System.out.println("Now present in Last Opened Iframe");
		 WebElement LastOpenedbody = driver.findElement(By.cssSelector("body"));
		 String LastOpenedData = LastOpenedbody.getText();
		 System.out.println(LastOpenedData);
		 boolean LastOpenedBoolean = LastOpenedData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Last Opened Heading = " +LastOpenedBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		 
		  // PeopleWhoDidntOpnedEmail Iframe 
		 driver.switchTo().frame(driver.findElement(PeopleWhoDidntOpnedEmailIframe));
		 System.out.println("Now present in PeopleWhoDidntOpnedEmail Iframe");
		 WebElement PeopleWhoDidntOpnedEmailbody = driver.findElement(By.cssSelector("body"));
		 String PeopleWhoDidntOpnedEmailData = PeopleWhoDidntOpnedEmailbody.getText();
		 System.out.println(PeopleWhoDidntOpnedEmailData);
		 boolean DidntOpenedMailBoolean = PeopleWhoDidntOpnedEmailData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Didnt Opened Mail Heading = " +DidntOpenedMailBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		  // LastClicked Iframe  
		 driver.switchTo().frame(driver.findElement(LastClickedIframe));
		 System.out.println("Now present in LastClicked Iframe");
		 WebElement LastClickedbody = driver.findElement(By.cssSelector("body"));
		 String LastClickedData = LastClickedbody.getText();
		 System.out.println(LastClickedData);
		 boolean LastClickedDataBoolean = LastClickedData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Last Clicked Data Heading = " +LastClickedDataBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		 
		  // LastUnsubscribe Iframe 
		 driver.switchTo().frame(driver.findElement(LastUnsubscribeIframe));
		 System.out.println("Now present in LastUnsubscribe Iframe");
		 WebElement LastUnsubscribebody = driver.findElement(By.cssSelector("body"));
		 String LastUnsubscribeData = LastUnsubscribebody.getText();
		 System.out.println(LastUnsubscribeData);
		 boolean LastUnsubscribeDataBoolean = LastUnsubscribeData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Last Unsubscribe Data Heading = " +LastUnsubscribeDataBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		  // LastBouncedIframe 
		 driver.switchTo().frame(driver.findElement(LastBouncedIframe));
		 System.out.println("Now present in LastBounced Iframe");
		 WebElement LastBouncedIframebody = driver.findElement(By.cssSelector("body"));
		 String LastBouncedIframebodyData = LastBouncedIframebody.getText();
		 System.out.println(LastBouncedIframebodyData);
		 boolean LastBouncedIframebodyDataBoolean = LastBouncedIframebodyData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Last Bounced Mail Heading = " +LastBouncedIframebodyDataBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		 
		  // LastSpamIframe Iframe 
		 driver.switchTo().frame(driver.findElement(LastSpamIframe));
		 System.out.println("Now present in LastSpam Iframe");
		 WebElement LastSpamIframebody = driver.findElement(By.cssSelector("body"));
		 String LastSpamIframebodyData = LastSpamIframebody.getText();
		 System.out.println(LastSpamIframebodyData);
		 boolean LastSpamIframebodyDataBoolean = LastSpamIframebodyData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Last Spam Mail Heading = " +LastSpamIframebodyDataBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		 
		  // EmailNotSentIframe  
		 driver.switchTo().frame(driver.findElement(EmailNotSentIframe));
		 System.out.println("Now present in EmailNotSent Iframe");
		 WebElement EmailNotSentIframebody = driver.findElement(By.cssSelector("body"));
		 String EmailNotSentIframebodyData = EmailNotSentIframebody.getText();
		 System.out.println(EmailNotSentIframebodyData);
		 boolean EmailNotSentIframebodyDataBoolean = EmailNotSentIframebodyData.contains(EmailtoBeMatched);
		 System.out.println("Result of comparison of EmailID in Email Not Sent Mail Heading = " +EmailNotSentIframebodyDataBoolean);
		 driver.switchTo().defaultContent();
		 System.out.println("------------------------------------------------------------------");
		 
		 
		 return SentBoolean;

	 }
	 
	 
	 
	 
	 public void EventTrigger_InactiveCampaignClick()
	 {
		 driver.findElement(EventTrigger_InactiveCampaign).click();
	 }
	 
	 public void EventTrigger_ActiveCampaignClick()
	 {
		 driver.findElement(EventTrigger_ActiveCampaign).click();
	 }
	 
	 
	 public String PrintEventTriggerName()
	 {
		String name = driver.findElement(EventTrigger_Name).getText();
		return name;
	 }
	 
	 public String PrintEventTrigger_TriggerEvent()
	 {
		String name = driver.findElement(EventTrigger_TriggerEvent).getText();
		return name;
	 }

	 public String PrintEventTrigger_LifecycleStage()
	 {
		String name = driver.findElement(EventTrigger_LifecycleStage).getText();
		return name;
	 }

	 
	 
	 
	 
	 
	 
}
