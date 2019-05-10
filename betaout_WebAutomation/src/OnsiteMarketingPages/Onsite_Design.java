package OnsiteMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class Onsite_Design {

	public WebDriver driver;

	public By saveandnext = By.xpath("//span[text() = 'Save & Next']"); // Common for
																	// CTA,
																	// Mobile
																	// and
																	// EmailSignup
	public By save = By.xpath("(//*[text() = 'Save'])[1]"); // Common for CTA, Mobile
														// and EmailSignup
	public By exit = By.xpath("//*[text() = 'Exit']"); // Common for CTA, Mobile and
												// EmailSignup
	By saveandexit = By.xpath("//*[text() = 'Save & Exit']"); // Common for CTA,
																// Mobile and
																// EmailSignup

	By CouponCode = By.xpath("(.//*[@id='mce_41'])");

	By EditName = By.xpath("(//*[@class = 'fa fa-pencil editInstanceNameIn '])");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameInstance_')]");
	By EditName_Save = By.xpath("(//*[text() = 'Save'])[2]");
	By EditName_Cancel = By.xpath("(//*[text() = 'Cancel'])[1]");
	By SelectAnimation = By.xpath("(//*[@class = 'customSelect-sm animationvalue'])");
	By EditCustomCSS = By.xpath("(//*[@id = 'style-1'])[1]");
	By GetHTMLCode = By.xpath("(//*[@class = 'GetHTMLCode'])");

	// For EmailSignups

	By EmailSignupEmail = By.xpath("(//*[text() = 'Email'])[1]");
	By EmailSignupSenderID = By.xpath("(//*[@id = 'senderEmailId'])");
	By EmailSignupSubject = By.xpath("(//*[@id = 'emailSubject'])");

	// For MobileLead

	By MobileLeadSelectCountry = By.xpath("(//*[@name = 'phone'])");		
	By MobileLeadSelectCountry_Popup = By.xpath("//*[@id = 'Your_EmaIl']");
	By MobileLeadSelectCountry_StickyBar = By.xpath(".//*[@id='Your_EmaIl']");
	
	By PulloutOpenedRadioButton = By.xpath("(//*[@name = 'sidekickView'])[1]");
	
	/*By MobileLeadSelectCountry_Popup = By.xpath("(//*[@name = 'phone'])");
	By MobileLeadSelectCountry_Pullout = By.xpath("(//*[@name = 'phone'])");
	By MobileLeadSelectCountry_Inline = By.xpath("(//*[@name = 'phone'])");
	By MobileLeadSelectCountry_StickyBar = By.xpath("(//*[@name = 'phone'])");
*/
	
	// Add locators for Timer
	
	public By Countdown = By.xpath("(//*[@id = 'mce_42'])");
	public By Timer_Iframe = By.xpath("//*[contains(@src,'https://qa.betaout.in/tinymce/js/tinymce/plugins/digitalTimer')]");
	public By Timer_SelectClock1 = By.xpath("(//*[@class = 'timer-option-panels'])[1]");
	public By Timer_SelectClock2 = By.xpath("(//*[@class = 'timer-option-panels'])[2]");
	public By Timer_SelectClock3 = By.xpath("(//*[@class = 'timer-option-panels'])[3]");
	public By Timer_SelectClock4 = By.xpath("(//*[@class = 'timer-option-panels'])[4]");
	public By Timer_SelectClock5 = By.xpath("(//*[@class = 'timer-option-panels'])[5]");
	public By Timer_SelectClock6 = By.xpath("(//*[@class = 'timer-option-panels'])[6]");
	public By Timer_SelectClock7 = By.xpath("(//*[@class = 'timer-option-panels'])[7]");
	public By Timer_SelectClock8 = By.xpath("(//*[@class = 'timer-option-panels'])[8]");
	

	public By Timer_OpenDate = By.xpath("(//*[@placeholder = 'SELECT END DATE FROM COUNTDOWN'])");
//	public By Timer_OpenTime = By.xpath("(//*[@class = 'col-sm-12'])[2]");
	
	public By Timer_OpenTime = By.xpath("//*[contains(@class,'datetimepicker2')]");
	
	public By Timer_IncreementHour = By.xpath("//*[@data-action = 'incrementHour']");
	public By Timer_DecrementHour = By.xpath("//*[@data-action = 'decrementHour']");
	public By Timer_IncrementMinute = By.xpath("//*[@data-action = 'incrementMinute']");
	public By Timer_DecrementMinute = By.xpath("//*[@data-action = 'decrementMinute']");
	public By Timer_AMPMArrow1 = By.xpath("(//*[@data-action = 'toggleMeridian'])[1]");
	public By Timer_AMPMArrow2 = By.xpath("(//*[@data-action = 'toggleMeridian'])[2]");
	
	public By Timer_AddExpiryImage = By.xpath("(//*[@data-toggle = 'modal'])");
	public By Timer_DisableCampaignAfterExpiry = By.xpath("//*[@class = 'mobile_label']");
	public By Timer_BackToDefault = By.xpath("//*[@class = 'default']");

	public By Timer_SaveNext1 = By.xpath("//*[contains(@class,'nextbutton1')]");
	public By Timer_SaveNext2 = By.xpath("//*[contains(@class,'nextbutton2')]");
	public By Timer_SaveNext3 = By.xpath("//*[contains(@class,'nextbutton3')]");
	
	
	public By CTAButtonIframe = By.xpath("//*[contains(@src,'//qa.betaout.in/apps/create-popup-template')]");
	public By CTAButton = By.xpath("//*[@id = 'button-1']");
	public By CTATargetURL = By.xpath("//*[@class = 'changeCurrentButtonProp']");
	
	
	By SMSTab = By.xpath("(//*[@data-id = 'screen3'])");
	By DropdownSMSGateway = By.xpath("(//*[@id = 'senderSmsId'])");
	By SMSText = By.xpath("(//*[@class = 'fullHtml'])");
	

	
	public Onsite_Design(WebDriver driver)

	{
		this.driver = driver;

	}

	public void save_next()

	{

		driver.findElement(saveandnext).click();

	}

	public void save_click()

	{

		driver.findElement(save).click();

	}

	public void exit_next()

	{

		driver.findElement(exit).click();

	}

	public void saveandexit_click()

	{

		driver.findElement(saveandexit).click();

	}

	public void EmailSignupEmailClick()

	{
		driver.findElement(EmailSignupEmail).click();

	}

	public void EmailSignupSenderIDClick()

	{
		String emailaddress = driver.findElement(EmailSignupSenderID).getText();
		System.out.println("Name of the email address = " + emailaddress);
	}

	public void EmailSignupSubjectClick(String subject)

	{
		driver.findElement(EmailSignupSubject).sendKeys(subject);
	}

	public void MobileLeadSelectCountryClick_Banner() throws Exception

	{
		driver.findElement(MobileLeadSelectCountry).click();
		Thread.sleep(2500);
		
		driver.findElement(By.xpath("(//*[@placeholder = 'Search country you want to show'])")).sendKeys("India");
		Thread.sleep(2000);
		
		/*Select select = new Select(driver.findElement(By.xpath("//*[@placeholder = 'Search country you want to show']")));
		select.selectByVisibleText("India (+91)");*/
		
		driver.findElement(By.xpath("(//*[@value = 'India (+91)'])[1]")).click(); // Select India
		Thread.sleep(2000);																			

	}

	public void MobileLeadSelectCountryClick_Popup() throws Exception

	{	
		driver.switchTo().frame(driver.findElement(By.id("iframe")));
		Thread.sleep(3000);
		
		driver.findElement(MobileLeadSelectCountry_Popup).click();
		Thread.sleep(2500);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[contains(@class,'search_country')]")).sendKeys("India");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@value = 'India (+91)'])[1]")).click(); // Select India
		Thread.sleep(2000);																			

	}
	

	public void MobileLeadSelectCountryClick_Pullout() throws Exception

	{ Thread.sleep(2000);
		driver.findElement(MobileLeadSelectCountry).click();
		Thread.sleep(2500);
		
		driver.findElement(By.xpath("(//*[@placeholder = 'Search country you want to show'])")).sendKeys("India");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@value = 'India (+91)'])[1]")).click(); // Select India
		Thread.sleep(2000);																			

	}


	public void MobileLeadSelectCountryClick_Inline() throws Exception

	{
		driver.findElement(MobileLeadSelectCountry).click();
		Thread.sleep(2500);
		
		driver.findElement(By.xpath("(//*[@placeholder = 'Search country you want to show'])")).sendKeys("India");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@value = 'India (+91)'])[1]")).click(); // Select India
		Thread.sleep(2000);																			

	}


	public void MobileLeadSelectCountryClick_StickyBar() throws Exception

	{	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('Your_EmaIl').click();");
	//	driver.findElement(MobileLeadSelectCountry_StickyBar).click();
		Thread.sleep(2500);
		
		driver.findElement(By.xpath("(//*[@placeholder = 'Search country you want to show'])")).sendKeys("India");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@value = 'India (+91)'])[1]")).click(); // Select India
		Thread.sleep(2000);																			

	}
	
	

public void PulloutOpenedRadioButton()

	{

		driver.findElement(PulloutOpenedRadioButton).click();

	}
	
	
	public void CouponCodeClick() {
		driver.findElement(CouponCode).click();
	}

	public void EditNameClick() {
		driver.findElement(EditName).click();

		String CampaignName = driver.findElement(EditName_Rename).getText();
		System.out.println("Name of the campaign = " + CampaignName);

		driver.findElement(EditName_Save).click();
	}

	public void SelectAnimationClick() {
		Select dropdown = new Select(driver.findElement(SelectAnimation));
		dropdown.selectByVisibleText("Default (Zoom out)");
	}

	public void EditCustomCSSClick() {
		driver.findElement(EditCustomCSS).click();

		String CustomCSSContent = driver.findElement(By.xpath("(//*[@target-id = 'style-1'])")).getText();
		System.out.println("CSS Content of page = " + CustomCSSContent);
	}

	public void GetHTMLCodeClick() {
		driver.findElement(GetHTMLCode).click();

		String HTMLContent = driver.findElement(By.xpath("(//*[@id = 'CustomHTMLBox'])")).getText();
		System.out.println("HTML Content of page = " + HTMLContent);

	}

	
	public void CTAButtonClickOnDesign()
	{
		driver.findElement(CTAButton).click();
	}
	
	
	public void CTAButtonClickOnsite()
	{
		driver.findElement(CTAButton).click();
	}
	
	public void CTATargetURL(String ShortURL)
	{
		driver.findElement(CTATargetURL).clear();
		driver.findElement(CTATargetURL).sendKeys(ShortURL);
		
	}	
	
	public void SMSTab()
	{
		driver.findElement(SMSTab).click();
	}
	
	public void DropdownSMSGateway() 
	{
		Select sel = new Select(driver.findElement(DropdownSMSGateway));
		sel.selectByVisibleText("Synic-sys -sinfini(TNDRCT) ");
		
	}
	
	public void SMSText(String text) throws Exception
	{
		driver.findElement(SMSText).clear();
		Thread.sleep(1000);
		driver.findElement(SMSText).sendKeys(text);
	}
	
}
