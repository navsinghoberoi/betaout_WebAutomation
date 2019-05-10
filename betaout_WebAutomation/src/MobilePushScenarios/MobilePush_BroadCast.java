package MobilePushScenarios;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MobilePushPages.MobilePush_SendOrSchedulePage;
import MobilePushPages.createCampaignPage;
import MobilePushPages.mobilePush_DesignPage;
import MobilePushPages.mobilePush_TargetingPage;
import common_Classes.Account_Settings;
import common_Classes.Homepage;
import common_Classes.Loginpage;
import common_Classes.Setup_class;
/**
 * @author - Navpreet
 */
public class MobilePush_BroadCast {

	public static WebDriver driver;
	
	
	@Test
	
	public void CreateBroadCastCampaign() throws Exception
	
	{
		Setup_class set = new Setup_class(driver);
		
		driver = set.setup();
		
		Properties prop = set.loadPropertyFile();
		
		set.getQAURL();	
		
		Loginpage obj = new Loginpage(driver);
		
		obj.loginbutton();
		obj.uname(set.getRishabhQAUsername());
		obj.upswd(set.getRishabhQAPassword());
		obj.ulogin();
		
		// Add code to select account
		set.selectAccountRishabh();;
		System.out.println("User has logged in successfully");
		
		Homepage homeobj = new Homepage(driver);
		homeobj.mobilepush_click();
		
		createCampaignPage obj1 = new createCampaignPage(driver);
		obj1.campaignButton();
		String campaignNameEntered = "Broadcamp"+System.currentTimeMillis();
		obj1.broadcastImage();
		obj1.enterCampaignName(campaignNameEntered);
		obj1.clickOnSaveandNextButton();
		
		Thread.sleep(5000);
		
		mobilePush_DesignPage obj2 = new mobilePush_DesignPage(driver);
		
		String titleEntered = "Title" +System.currentTimeMillis();
		obj2.setMobilePushTitle(titleEntered);
		
		String messageEntered = "Message" +System.currentTimeMillis();
		obj2.setMobilePushMessageBody(messageEntered);
		obj2.clickOnSaveAndNextButton();
		
		Thread.sleep(5000);
		
		mobilePush_TargetingPage obj3 = new mobilePush_TargetingPage(driver);
		
		obj3.clickOnAddButton();
		obj3.ANDDropdown1Click();
		obj3.ANDDropdown2Click();
		obj3.ANDDropdown3Click();
		obj3.ANDDropdown4Click(prop.getProperty("CustIDfMobilePush"));   // GCM id 
		
		obj3.clickOnRefreshButton();
		Thread.sleep(5000);
		
		obj2.clickOnSaveAndNextButton();
		Thread.sleep(5000);
		
		MobilePush_SendOrSchedulePage obj4 = new MobilePush_SendOrSchedulePage(driver);
		obj4.clickOnSendNowButtonInPage();
		Thread.sleep(2000);
		obj4.clickOnSendNowButtonInPopUp();
		Thread.sleep(10000);
		
		String camaignNameFetched = obj1.CampaignNamePrint();
		System.out.println("Fetched campaign name = "+camaignNameFetched);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(campaignNameEntered, camaignNameFetched);
		sa.assertAll();
		System.out.println("Assertion of campaign name is done");
		
		Thread.sleep(60000);
		
		// Search User > Properties to verify data of 'pn_last_sent_date' field
		
		homeobj.search_click();
		Thread.sleep(3000);
		homeobj.SearchSubmitButton();
		Thread.sleep(7000);
		
		homeobj.EnterSearchDataInternalClick(prop.getProperty("CustIDfMobilePush"));
		Thread.sleep(1500);
		
		homeobj.InternalSearchSubmitClick();
		Thread.sleep(5000);
		
		
		driver.findElement(homeobj.OpenContact).click();  // Open Contact
		
		Thread.sleep(10000);
			
		homeobj.PropertiesTabClick();
		Thread.sleep(5000);
 		
		String pn_lastsentdate = homeobj.printPnSentDate().trim();
		System.out.println("pn_last_sent_date = "+pn_lastsentdate);
		
		String result;
		
		if(pn_lastsentdate.equals("0 min ago") || pn_lastsentdate.equals("1 min ago") || pn_lastsentdate.equals("2 mins ago")    )
			{System.out.println("Last sent date displays time less than 2 min, i.e. PASS");
				result = "PASS";
			}
		else {
			System.out.println("Last sent date displays time more than 2 min, i.e. FAIL");
			result = "FAIL";
			}
		
		
		sa.assertEquals(result, "PASS");
		sa.assertAll();
		
		System.out.println("All assertions are completed now");
		
	}
	
	@AfterMethod
	public void kill()
	{
		System.out.println("Closing the browser now");
		driver.quit();
		
		
	}
	
}
