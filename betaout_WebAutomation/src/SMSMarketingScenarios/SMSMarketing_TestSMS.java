package SMSMarketingScenarios;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SMSMarketingPages.SMSMarketing_Broadcast_Active;
import SMSMarketingPages.SMSMarketing_CampaignType;
import SMSMarketingPages.SMSMarketing_Design;
import SMSMarketingPages.SMSMarketing_Homepage;
import SMSMarketingPages.SMSMarketing_Target;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;

/**
 * @author - Navpreet
 */
public class SMSMarketing_TestSMS {

	public static WebDriver driver;

	@Test
	public void SMS_BroadcastCampaign() throws Exception
	
	{
		System.out.println("Scenario : SMS Marketing > Campaigns > Broadcast > Test SMS");
		
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();

		set.getQAURL();
		
		Properties prop = set.loadPropertyFile();
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getNavpreetQAUsername());
		obj.upswd(set.getNavpreetQAPassword());
		obj.ulogin();
		
		// Add code to select account
		set.selectAccountNav();
		System.out.println("User has logged in successfully");
		
		Homepage home_obj = new Homepage(driver);
		home_obj.sms_mktg_click();
		Thread.sleep(3000);
		
		SMSMarketing_Homepage page_obj = new SMSMarketing_Homepage(driver);
		page_obj.Campaigns_BroadCast_CreateCampaignClick();
		
		SMSMarketing_CampaignType type_obj = new SMSMarketing_CampaignType(driver);
		type_obj.CampaignTypeClick();
	
		String name = "Test_sms"+" "+System.currentTimeMillis();
		type_obj.CampaignNameClick(name);
		type_obj.PrintChooseCampaignHeading();
		type_obj.PrintCampaignNameHeading();
		type_obj.SaveNextClick();
		Thread.sleep(5000);
		
		SMSMarketing_Design design_obj = new SMSMarketing_Design(driver);
		design_obj.ChooseGatewayClick();
		design_obj.SMSTextClick(prop.getProperty("SMSContent"));
		design_obj.SaveNextClick();
		Thread.sleep(5000);
		
		SMSMarketing_Target target_obj = new SMSMarketing_Target(driver);
		
		/*target_obj.ANDConditionClick();
		target_obj.ANDDropdown1Click();
		target_obj.ANDDropdown2Click();
		target_obj.ANDDropdown3Click();
		target_obj.ANDDropdown4Click(prop.getProperty("SMSNumber"));
		target_obj.RefreshContactsClick();
		Thread.sleep(8000);*/
		
		// Add Code for Test SMS SendTestSMSClick
		target_obj.SendTestSMSClick(prop.getProperty("SMSNumber"));
		Thread.sleep(4000);
		design_obj.ExitClick();
		
		// Assert name of campaign
		
		String BroadcastCampName = page_obj.printCampaignName();
		System.out.println("Campaign Name = " +BroadcastCampName );
		
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(BroadcastCampName, name);
		s_assert.assertAll();
		System.out.println("Assertion -> Name of the campaign is matched");
	
		// Add code to clone, edit and delete campaign 

		page_obj.Campaigns_BroadCast_CloneClick();
		
		// Print and assert name of campaign
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		String CloneCampName = page_obj.printCampaignName();
		System.out.println("Name of the cloned campaign = "+CloneCampName);
		
		boolean CloneValue = CloneCampName.contains("Clone");
		System.out.println("Boolean value of clone campaig = "+CloneValue);
		s_assert.assertEquals(CloneValue, true);
		System.out.println("Assertion of clone campaign is done");
		Thread.sleep(1500);
		page_obj.EditCampaign();         // Edit the value of SMS Text
		
		String newContent = prop.getProperty("SMSEditContent");
		
		design_obj.SMSTextClick(newContent);
		
		design_obj.SaveExitClick();
		
		
		// Compare the edited value has been updated or not
		
		String SMSText = page_obj.printSMSText();
		System.out.println("Text printed below the campaign name = " +SMSText);
	//	s_assert.assertEquals(SMSText, newContent);
		
		boolean editedValue = SMSText.contains(newContent);
		System.out.println("Boolean value of new content in SMS content = "+editedValue);
		
		s_assert.assertEquals(editedValue, true);
		System.out.println("Assertion of new content in SMS content is done");
		
		page_obj.Campaigns_BroadCast_DeleteClick();
		
		driver.navigate().refresh();
		
		String CampaignNameAfterDelete = page_obj.printCampaignName();
		System.out.println("Name of the campaign after deleting cloned campaign = "+CampaignNameAfterDelete);
		
		boolean CloneCamp1= CampaignNameAfterDelete.contains("Clone");
		System.out.println("Boolean result for visibility of clone campaign after deletion = "+CloneCamp1);
		s_assert.assertEquals(CloneCamp1, false);
		System.out.println("Deleted campaign is not displayed");
		
		s_assert.assertAll();
		
	}

	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
}	