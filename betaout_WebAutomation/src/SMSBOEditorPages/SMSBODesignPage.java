package SMSBOEditorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class SMSBODesignPage {

	WebDriver driver;
	
	
	By Exit = By.xpath("//*[@data-action = 'Exit']");
	By Save = By.xpath("//*[@data-action = 'save']");
	By SaveExit = By.xpath("//*[@data-action = 'saveAndExit']");
	By SaveNext = By.xpath("//*[@id = 'saveNNext']");
	
	By MoreOptions = By.xpath("//*[@id = 'dropdownMenu1']");
	By SendTestSMS = By.xpath("//*[@id = 'sendTextSms']");
	By TestSMS_EnterMobile = By.xpath("(//*[@name = 'mobiles'])[1]");
	By TestSMS_Send = By.xpath("(//*[@id = 'send_test_sms'])[1]");
	
	By EnterSMSText = By.xpath("//*[contains(text(),'ADD SMS TEXT')]");
	
	By Coupon = By.xpath("//*[@class = 'selectCouponCodeList']");
	By SelectCouponList = By.xpath("//*[@data-name = '13 april qa Nav']");   // select couponlist by Camp Name
	By UseCouponList = By.xpath("//*[contains(@class,'getSelectedCoupon')]");
 
	By DynamicPrompt_BackToDesign = By.xpath("(//*[contains(@class,'back-to-design')])[4]"); 
	By DynamicPrompt_Continue = By.xpath("//*[contains(@class,'dynamicProperty')]");	
	
	public SMSBODesignPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	public void Exit()
	{
		driver.findElement(Exit).click();
	}
	
	public void Save()
	{
		driver.findElement(Save).click();
	}
	
	public void SaveExit()
	{
		driver.findElement(SaveExit).click();
	}
	
	public void SaveNext()
	{
		driver.findElement(SaveNext).click();
	}
	
	public void MoreOptions()
	{
		driver.findElement(MoreOptions).click();
	}

	public void SendTestSMS()
	{
		driver.findElement(SendTestSMS).click();
	}
	
	public void TestSMS_EnterMobile(String number)
	{
		driver.findElement(TestSMS_EnterMobile).sendKeys(number);
	}
	
	public void TestSMS_Send()
	{
		driver.findElement(TestSMS_Send).click();
	}
	
	
	public void EnterSMSText(String message)
	{
		driver.findElement(EnterSMSText).sendKeys(message);
	}
	
	
	public void SelectCouponList() throws Exception
	{
		driver.findElement(Coupon).click();
		Thread.sleep(3000);
		driver.findElement(SelectCouponList).click();
		Thread.sleep(1000);
		driver.findElement(UseCouponList).click();
		
	}
	

	public void DynamicPrompt_BackToDesign()
	{
		driver.findElement(DynamicPrompt_BackToDesign).click();
	}
	
	public void DynamicPrompt_Continue()
	{
		driver.findElement(DynamicPrompt_Continue).click();
	}
	

}

