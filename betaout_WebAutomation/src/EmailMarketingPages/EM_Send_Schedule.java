package EmailMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author - Navpreet
 */
public class EM_Send_Schedule {
	public WebDriver driver;
	
		
		By Remove_Duplicate_Checkbox = By.xpath(".//*[@class='mobile_label']");
		
		By Exit_Button = By.xpath(".//*[@id='saveTemplateAndMove']");
		
		By Save_As_Draft = By.xpath("//*[text()='Save AS DRAFT']");
		
		By Save_And_Exit = By.xpath("(//*[text()='Save & Exit'])[1]");
		
		By SEND_NOW = By.xpath("//*[@id='btnSendEmail']");
		    
		By SEND_NOW_CONFIRM = By.xpath("(//*[@name = 'send'])[2]");
	
		
		// Add locators for Update Properties
		
		By UpdatePropertiesCheckbox = By.xpath("//*[@for = 'checkbox1']");
		By Schedule_AddRow = By.xpath("//*[contains(@class,'addBtnScheduling')]");
		By Schedule_Drodown = By.xpath("(//*[@id = 'changeDataByProprtyAndEvent_1'])[1]");
		By Schedule_EnterText = By.xpath("(//*[@id = 'simpleTextBox_1'])");
		
		By Send_AddRow = By.xpath("//*[contains(@class,'addBtnSending')]");
		By Send_Drodown = By.xpath("(//*[@id = 'changeDataByProprtyAndEventSend_1'])[1]");
		By Send_EnterText = By.xpath("(//*[@id = 'simpleTextBoxSend_1'])");
		
		public EM_Send_Schedule(WebDriver driver)
		{
			this.driver = driver;
		}

		
		public void Remove_Duplicate_CheckboxClick()
		{
			
			driver.findElement(Remove_Duplicate_Checkbox).click();
		}
		
		
		public void Exit_ButtonClick()
		{
			
			driver.findElement(Exit_Button).click();
		}
		
		
		public void Save_As_DraftClick()
		{
			
			driver.findElement(Save_As_Draft).click();
		}
		
		
		public void Save_And_ExitClick()
		{
			
			driver.findElement(Save_And_Exit).click();
		}
		
		
		public void SEND_NOWClick()
		{
			
			driver.findElement(SEND_NOW).click();
		}
		
		
		
		public void SEND_NOW_CONFIRMClick()
		{
			
			driver.findElement(SEND_NOW_CONFIRM).click();
		}
		
		
		public void UpdatePropertiesCheckbox()
		{
			driver.findElement(UpdatePropertiesCheckbox).click();
		}
		
		public void Schedule_AddRow() 
		{
			driver.findElement(Schedule_AddRow).click();
		}
		
		public void Schedule_Drodown(String scheduleValue) 
		{
			Select sel = new Select(driver.findElement(Schedule_Drodown));
			sel.selectByVisibleText(scheduleValue);
			
		}
		
		public void Schedule_EnterText(String text)
		{
			driver.findElement(Schedule_EnterText).sendKeys(text);
		}
		
		
		
		public void Send_AddRow() 
		{
			driver.findElement(Send_AddRow).click();
		}
		
		public void Send_Drodown(String sendValue) 
		{
			Select sel = new Select(driver.findElement(Send_Drodown));
			sel.selectByVisibleText(sendValue);
			
		}
		
		public void Send_EnterText(String text)
		{
			driver.findElement(Send_EnterText).sendKeys(text);
		}
		
		
		
		
		
		
		
}
