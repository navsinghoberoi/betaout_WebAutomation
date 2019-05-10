
package EmailMarketingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class EM_Broadcast_Template  {
	
// Template creation page
	WebDriver driver;

	By campaign_name = By.xpath("(//*[@class= 'form-group-outer'])[1]");
	
	By campaign_subject = By.xpath("(//*[@placeholder= 'Add subject here'])[2]");
	
	By Smiles = By.xpath ("//*[@data-type= 'picker']");
	
	By Sender_Id = By.xpath("//*[@id= 'senderEmailId']");	
	
	By Exit_button = By.xpath("//*[text()= 'Exit']");
	
	By Save_button = By.xpath("//*[text()= ' Save']");
	
	By Save_and_Exit = By.xpath("//*[text()=' Save & Exit']");
			
	By Save_and_NextStep = By.xpath("//*[text()= 'Save & Next Step ']");
	
	By Side_Menu = By.xpath("//*[@id='dropdownMenu1']");
	
	By Side_Menu_Change_template = By.xpath("//*[@class='changeTemplate']");
	
	By Side_Menu_Get_HTML_code = By.xpath("//*[@id='getHtmlCode']");
	
	By Side_Menu_Send_Test_Email = By.xpath("//*[@id='sendTempMail']");
	
	By Side_Menu_Clear_design = By.xpath("//*[@class='clearDesign']");
	
	By Linkurl_PopUp_OK = By.xpath("//*[@id='okButton']");
	
	By Linkurl_Checkbox = By.xpath("//*[@class='mobile_label']");
	
	By Linkurl_NewURL = By.xpath("//*[@id='betaout_replaceUrl']");
	
	By PopUp_Text = By.xpath(".//*[@class='confirmText']");// Pop text paste
	
	By Pop_up_Header = By.xpath("(.//*[@id='myModalLabel'])[1]");
	
	By Pop_up_close_button = By.xpath("(//img[contains(@class, 'close') and contains(@class, 'desktop_pop_close')])[3]");
	
	
	By TestMail_EnterEmail = By.xpath("(//*[@name='emails'])[1]");

	By TestMail_SendButton = By.xpath("(//*[@id='send_test_email'])[1]");
	
	By CTAButtonNew = By.xpath("(//*[text() = 'CALL TO ACTION'])[2]");
	
	By CTAButton = By.xpath("(//*[text() = 'CALL TO ACTION'])[1]");
	
	By CartRecoveryGoToCart = By.xpath("//*[contains(text(),'GO TO CART')]");
	
	// Add locators for Drag and Drop CTA Button
	
	public By RightArrowOnDesign = By.xpath("//*[@class = 'rightScroll lightright']");
	public By SelectButton = By.xpath("//*[@id = 'buttonSelect']");
	public By Source_CTA = By.xpath("(//*[@class = 'elasticBox ui-draggable'])[22]");
	public By Target_CTA = By.xpath("(//*[text() = 'Create a win-win situation for your customers.'])");
	
	public By TemplateText = By.xpath("//*[text() = 'Create a win-win situation for your customers.']");
	
	By PersonalizeTag = By.xpath("//*[@aria-label = 'personalized tags']");
	By SelectEmailProperty = By.xpath("//*[@data-mce-url1 = '{{email}}']");
	
	
	By CouponList = By.xpath("(//*[@data-target = '#useCouponModal'])");
	By SelectCouponListRadioButton = By.xpath("(//*[@name = 'couponcode'])");
	By UseCoupon = By.xpath("(//*[@id = 'useCoupon'])");
	By CouponDynamicAttribute = By.xpath("(//*[@id = 'coupon-dynamic-attribute'])");
	
	
	
/*	By Overview = By.xpath("(//*[@href= '/email/overview'])[3]");
	By Campaigns = By.xpath("(//*[@href= '/email/newsletter'])[2]");
	By SupressionList = By.xpath("(//*[@href= '/email/unsubscribers'])[2]");
	By Templates = By.xpath("(//*[@href= '/email/email-template'])[2]");
	By AllTabs = By.xpath("(//*[@class= 'topBar-new'])[2]");
	By CreateCampaign = By.xpath("(//*[@href= '/email/campaign-type'])[2]"); 
	 
	 
	 public void OverviewClick()
	 {
		 driver.findElement(Overview).click();
	 }
	
    
	 public void CampaignsClick()
	 {
		 driver.findElement(Campaigns).click();
	 }
	
	 
	 public void SupressionListClick()
		 {
			 driver.findElement(SupressionList).click();
		 }


	 public void TemplatesClick ()
	 {
		 driver.findElement(Templates).click();
	 }
	
*/	  
/*	 public void PrintAllTabs()
	 {
		 List<WebElement> list = driver.findElements(AllTabs);
		 System.out.println("Total tabs are = "+list.size());
				 
		 for(int i=0;i<list.size();i++)
		 {
		System.out.println("Name of the tab = " +list.get(i));	 
		 }*/
		 


	By Overview = By.xpath("(//*[@href= '/email/overview'])[3]");
	By SupressionList = By.xpath("(//*[@href= '/email/unsubscribers'])[2]");
	By Templates = By.xpath("(//*[@href= '/email/email-template'])[2]");
	
	 public void OverviewClick()
	 {
		 driver.findElement(Overview).click();
	 }
	
	 
	 public void PrintOverviewInfoClick() throws Exception
		{
		
			List<org.openqa.selenium.WebElement> log = driver.findElements(By.xpath("//*[contains(@class,'panel-title')]"));
		    System.out.println("Total elements :"+log.size());
			
		  /*  Iterator<WebElement> itr = log.iterator();
		    while(itr.hasNext()) {
		    	WebElement row = itr.next();
		        System.out.println("Name of the headings are="+row.getText());
		        
		    					}*/

		    List<org.openqa.selenium.WebElement> log1 = driver.findElements(By.xpath("(//*[@class = 'pull-left font-lg'])"));
		//	    System.out.println("Total elements :"+log1.size());
		
			    /*	
			    Iterator<WebElement> itr1 = log1.iterator();
			    while(itr1.hasNext()) {
			    	WebElement row1 = itr1.next();
			      // System.out.println("Numeric values of the headings are="+row1.getText());
			    	System.out.println("Numeric values of the headings are="+row1.getText());
			    
			    						}
			    		*/
			    for(int i=0;i<log.size();i++)
			    {
			    	System.out.println(log.get(i).getText()+" = "+log1.get(i).getText());
			    	Thread.sleep(1000);
			    }
	 
		}
 	 
	 public void SupressionListClick()
		 {
			 driver.findElement(SupressionList).click();
		 }


	 public void TemplatesClick ()
	 {
		 driver.findElement(Templates).click();
	 }
	
	
	 
	 public EM_Broadcast_Template (WebDriver driver)
		{

			this.driver = driver;
		}
	 
	 
	 public void campaign_name (String campaign_Name){
			driver.findElement(campaign_name).sendKeys(campaign_Name);
			
		}
	 
	 public void Campaign_Subject (String Campaign_Subject){
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
	 
	 
	 public void Save_button (){
		 
			driver.findElement(Save_button).click();
		
	 } 
	 
	 public void Save_and_Exit (){
		 
			driver.findElement(Save_and_Exit).click();
		
	 } 
	 
	 public void Save_and_NextStep (){
		 
			driver.findElement(Save_and_NextStep).click();
		
	 } 
	 
	 public void Side_Menu_Option (){
		 
			driver.findElement(Side_Menu).click();
		
	 } 
	 
	 public void Side_Menu_Change_template (){
		 
			driver.findElement(Side_Menu_Change_template).click();
		
	 } 
	 
	 public void Side_Menu_Get_HTML_code (){
		 
			driver.findElement(Side_Menu_Get_HTML_code).click();
		
	 } 
	  
	 public void Side_Menu_Send_Test_Email (){
		 
			driver.findElement(Side_Menu_Send_Test_Email).click();
		
	 } 
	 
	 public void Side_Menu_Clear_design (){
		 
			driver.findElement(Side_Menu_Clear_design).click();
		
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
	 
	 
	 public void PopUp_Text (){
		 
			String Pop_up_Text = driver.findElement(PopUp_Text).getText(); // Need to verify this Xpath as i don get time to verify
			
			System.out.println("Pop up text ="  + Pop_up_Text);
	 }    
	
	 public void Pop_up_close_button()
	 {
		 driver.findElement(Pop_up_close_button).click();
	 }
	 
	 
	 public void TestMail_EnterEmail(String EmailID)
	 {
		 driver.findElement(TestMail_EnterEmail).sendKeys(EmailID);;
	 }
	
	 
	 public void TestMail_SendButton()
	 {
		 driver.findElement(TestMail_SendButton).click();
	 }
	
	 
	 public void CTAButtonClick()
	 {
		 driver.findElement(CTAButton).click();
	 }
	 
	 public void CTAButtonNewClick()
	 {
		 driver.findElement(CTAButtonNew).click();
	 }
	 
	 
	 
	 public int PrintAllCTAButton()
	 {
		 List<WebElement> list = driver.findElements(By.xpath("(//*[text() = 'CALL TO ACTION'])"));
		 int totalButtons = list.size();
		 System.out.println("Total CTA Buttons are = "+totalButtons);
		 return totalButtons; 
		 
		 }
	 
	 public void CartRecoveryGoToCart()
	 {
		 
		 driver.findElement(CartRecoveryGoToCart).click();
	 }
	 
	 
	 public void personlizeTagClick()
	 {
		 driver.findElement(PersonalizeTag).click();
	 }
	 
	 public void selectEmailProperty()
	 {
		 driver.findElement(SelectEmailProperty).click();
	 }

	 
	 public void CouponList()
	 {
		 driver.findElement(CouponList).click();
	 }
	 
	 
	 public void SelectCouponListRadioButton()
	 {
		 driver.findElement(SelectCouponListRadioButton).click();
	 }
	 
	 
	 public void UseCouponClick()
	 {
		 driver.findElement(UseCoupon).click();
	 }
	 
	 public String getCouponDynamicAttribute()
	 {
		 String couponAttribute = driver.findElement(CouponDynamicAttribute).getText();
		 System.out.println("Dynamic attribute of coupon = "+couponAttribute);
		 return couponAttribute;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}


