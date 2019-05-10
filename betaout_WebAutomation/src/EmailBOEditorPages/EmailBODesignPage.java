package EmailBOEditorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author - Navpreet
 */
public class EmailBODesignPage {

	WebDriver driver;
	
	
	By Exit = By.xpath("(//*[@id = 'exit'])");
	By Save = By.xpath("(//*[@id = 'save'])");
	By SaveExit = By.xpath("(//*[@id = 'saveNExit'])");
	By SaveNext = By.xpath("(//*[@id = 'saveNNext'])");
	
	By MoreOptions = By.xpath("(//*[@id = 'dropdownMenu1'])");
	By SendTestMail = By.xpath("(//*[@id = 'sendTempMail'])");
	By SendTestMail_EnterEmail = By.xpath("//*[@name = 'emails']");
	By SendTestMail_Send = By.xpath("//*[@id = 'send_test_email']");
	
	
	
	By SaveAsTemplate = By.xpath("(//*[@data-action = 'saveAsTemplate'])");
	
	By Templates = By.xpath("(//*[@class = 'template'])");
	By Basic = By.xpath("(//*[text() = 'Basic'])");
	By Themes = By.xpath("(//*[@class = 'boutEditor-Icon-theme'])");
	By Saved = By.xpath("(//*[@class = 'boutEditor-Icon-saved'])");
	public By SavedTemplate = By.xpath("(//*[@class = 'boEditor_subCategoryElementsImage'])[1]");  // Source to drag
	public By BlankSpace = By.xpath("//*[contains(@class,'ui-droppable campaignOutter')]"); // Destination to drag
	
	By DynamicPrompt_BackToDesign = By.xpath("(//*[contains(@class,'back-to-design')])[4]"); 
	By DynamicPrompt_Continue = By.xpath("//*[contains(@class,'dynamicProperty')]");
	By LinkConfirmationPrompt = By.xpath("(//*[@id = 'okButton'])");
	
	
	By Elements = By.xpath("(//*[@class = 'boutEditor-Icon-element'])");
	By Background = By.xpath("(//*[@class = 'boEditor_sidebarnav'])");
	
			
	
	public EmailBODesignPage(WebDriver driver)
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
	
	public void SendTestMail()
	{
		driver.findElement(SendTestMail).click();
	}
	
	public void SendTestMail_EnterEmail(String email)
	{
		driver.findElement(SendTestMail_EnterEmail).sendKeys(email);;
	}
	
	public void SendTestMail_Send()
	{
		driver.findElement(SendTestMail_Send).click();
	}
	
	
	
	public void SaveAsTemplate()
	{
		driver.findElement(SaveAsTemplate).click();
	}
	
	public void Templates()
	{
		driver.findElement(Templates).click();
	}
	
	public void Basic()
	{
		driver.findElement(Basic).click();
	}
	
	public void Themes()
	{
		driver.findElement(Themes).click();
	}
	
	public void Saved()
	{
		driver.findElement(Saved).click();
	}
	
	public void SavedTemplate()
	{
		driver.findElement(SavedTemplate).click();
	}
	
	public void DynamicPrompt_BackToDesign()
	{
		driver.findElement(DynamicPrompt_BackToDesign).click();
	}
	
	public void DynamicPrompt_Continue()
	{
		driver.findElement(DynamicPrompt_Continue).click();
	}
	
	public void Elements()
	{
		driver.findElement(Elements).click();
	}
	
	public void Background()
	{
		driver.findElement(Background).click();
	}
	
	
	public void LinkConfirmationPrompt()
	{
		driver.findElement(LinkConfirmationPrompt).click();
	}
	
	
	
	
	
	
}
