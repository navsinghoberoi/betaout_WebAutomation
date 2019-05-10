package CartRecoveryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class CartRecovery_Design {
	
	
	public WebDriver driver;
	
	By Back = By.xpath("//*[contains(@class,'btn blue')]");
	By Exit = By.xpath("(//*[@href = '/carts/cart-campaign/'])");
	By Save = By.xpath("(//*[@data-action = 'save'])");
	By SaveExit = By.xpath("(//*[@data-action = 'saveAndNext'])[1]");
	
	By EmailOuterBackground = By.xpath("(//*[@id = 'email_outer'])");
	By EmailBackground = By.xpath("(//*[@id = 'email_content'])");
	By FooterCSS = By.xpath("(//*[@id = 'highlight_content'])[1]");
	By SocialBar = By.xpath("(//*[@id = 'header_background'])[1]");
	By ChangeTemplate = By.xpath("//*[contains(@href,'/carts/choose-cartabandoned-template/nv/cid')]");
	By GetHTMLCode = By.xpath("(//*[@class = 'GetHTMLCode'])");
	By SendTestMail = By.xpath("(//*[@class = 'save-data'])");
	By SendTestMail_EnterMail = By.xpath("(//*[@name = 'emails'])");
	By SendTestMail_Send = By.xpath("(//*[@id = 'send_test_email'])");
	
	By Preview = By.xpath("(//*[@data-target = '#templatePreview'])");
	
	By Subject = By.xpath("(//*[@id = 'subject'])");
	By ChooseSender = By.xpath("(//*[@id = 'senderEmailId'])");
	By TimeOfSending_Value = By.xpath("(//*[@id = 'timeVal'])");
	By TimeOfSending_Minutes = By.xpath("(//*[@id = 'timeType'])");
	
	By EditName = By.xpath("//*[contains(@class,'fa fa-pencil editCampignNameIn ')]");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameCampign_')]");
	By EditName_Save = By.xpath("//*[contains(@class,'save_campign_name')]");
	By EditName_Cancel = By.xpath("//*[contains(@class,'cancel_campign_name')]");
	
	By Upload = By.xpath("(//*[text()='UPLOAD'])[1]");
	By Upload_ChooseFile = By.xpath("(//*[@id='file'])");
	By ImportURL = By.xpath("(//*[@value='http://'])[1]");
	By Import = By.xpath("(//*[text()='IMPORT'])[1]");
	By TargetURL = By.xpath("(//*[@target-name='url'])[1]");
	By AltText = By.xpath("(//*[@target-name='alt'])[1]");
	By TitleText = By.xpath("(//*[@target-name='link'])[1]");
	
	
	
	

	public CartRecovery_Design(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void BackClick()
	{
		driver.findElement(Back).click();
	}
	
	
	public void ExitClick()
	{
		driver.findElement(Exit).click();
	}
	
	public void SaveClick()
	{
		driver.findElement(Save).click();
	}
	
	public void SaveExitClick()
	{
		driver.findElement(SaveExit).click();
	}
	
	
	public void EmailOuterBackgroundClick()
	{
		driver.findElement(EmailOuterBackground).click();
		
		String name = driver.findElement(By.xpath("(//*[@target-id = 'header_background'])")).getText();
		System.out.println("Email Outer Background Data = "+name);
		
	}
	
	public void EmailBackgroundClick()
	{
		driver.findElement(EmailBackground).click();
		
		String name = driver.findElement(By.xpath("(//*[@target-id = 'email_content'])")).getText();
		System.out.println("Email Background Data = "+name);
		
	}
	
	public void FooterCSSClick()
	{
		driver.findElement(FooterCSS).click();
		
		String name = driver.findElement(By.xpath("(//*[@target-id = 'highlight_content'])")).getText();
		System.out.println("Footer CSS Data = "+name);
	}
	
	public void SocialBarClick()
	{
		driver.findElement(SocialBar).click();
		
		String name = driver.findElement(By.xpath("(//*[@target-id = 'header_background'])")).getText();
		System.out.println("Social Bar Data = "+name);
	}
	
	public void ChangeTemplateClick()
	{
		driver.findElement(ChangeTemplate).click();
		
	}
	
	public void GetHTMLCodeClick()
	{
		driver.findElement(GetHTMLCode).click();
		
		String name = driver.findElement(By.xpath("(//*[@id = 'CustomHTMLBox'])")).getText();
		System.out.println("HTML Code = "+name);
	}
	
	public void SendTestMailClick(String email)
	{
		driver.findElement(SendTestMail).click();
		
		driver.findElement(SendTestMail_EnterMail).sendKeys(email);
		driver.findElement(SendTestMail_Send).click();
		
	}
	
	public void PreviewClick()
	{
		driver.findElement(Preview).click();
		
		driver.findElement(By.xpath("(//*[@class = 'close'])[1]")).click();
	}
	
	public void SubjectClick(String subject)
	{
		driver.findElement(Subject).sendKeys(subject);
	}
	
	public void ChooseSenderClick(String EmailGateway)
	{
		Select dropdown = new Select(driver.findElement(ChooseSender));
		dropdown.selectByVisibleText(EmailGateway);
		
	}
	
	public void TimeOfSending_ValueClick(String value)
	{
		Select dropdown = new Select(driver.findElement(TimeOfSending_Value));
		dropdown.selectByVisibleText(value);
		
	}
	
	public void TimeOfSending_MinutesClick()
	{	
		Select dropdown = new Select(driver.findElement(TimeOfSending_Minutes));
		dropdown.selectByVisibleText("Minutes");
	}
	
	public void EditNameClick()
	{
		driver.findElement(EditName).click();
		
		String CampaignName =	driver.findElement(EditName_Rename).getText();
		System.out.println("Name of the campaign = "+CampaignName);

			driver.findElement(EditName_Save).click();
		
	}
	
	public void EditName_CancelClick()
	{
		driver.findElement(EditName_Cancel).click();
	}

	public void UploadClick(String Path)
	{
		driver.findElement(Upload).click();
		
		driver.findElement(Upload_ChooseFile).sendKeys(Path);
	}
	
	public void ImportClick(String URL)
	{
		driver.findElement(ImportURL).sendKeys(URL);
		
		driver.findElement(Import).click();
	}
	
	
	public void TargetURLClick(String targetURL)
	{
		driver.findElement(TargetURL).sendKeys(targetURL);
	}
	
	

	public void AltTextClick(String altText)
	{
		driver.findElement(AltText).sendKeys(altText);
	}
	
	

	public void TitleTextClick(String titleText)
	{
		driver.findElement(TitleText).sendKeys(titleText);
	}
	
	
	
	
}
