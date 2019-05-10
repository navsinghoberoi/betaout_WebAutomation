package OnsiteMarketingPages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import common_Classes.Loginpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
/**
 * @author - Navpreet
 */
public class Onsite_Target_Page {
	
		
	public WebDriver driver;
		
	By Target_Users = By.xpath(".//*[@data-lockdiv='t1']");      // to activate target users
	By TU_AllUsers = By.xpath(".//*[@for='target_user1']");
	By TU_VisitorsOnly = By.xpath(".//*[@for='target_user2']");
	By AddressableContacts = By.xpath(".//*[@for='target_user3']");
	By TU_VO_AllVisiters = By.xpath(".//*[@for='visitorType1']");
	By TU_VO_NewVisiters = 	By.xpath(".//*[@for='visitorType4']");
	By TU_VO_RepeatVisiters = By.xpath(".//*[@for='visitorType3']");
	By TU_AC_PickSegment = By.xpath(".//*[@data-lockdiv='t3']");     // to activate user segment    (dropdown)
	By TU_AC_Lifecycle = By.xpath(".//*[@data-lockdiv='t4']");     // to activate user lofecycle	(dropdown)
	By TU_AC_Tag = By.xpath(".//*[@data-lockdiv='t21']");     // to activate user tag				(dropdown)

	
	By Pageview_Target = By.xpath(".//*[@data-lockdiv='t5']");      // to activate page view target
	By PT_No = By.xpath(".//*[@for='pageview1']");
	By PT_Yes = By.xpath(".//*[@for='pageview2']");
	
	
	By Show_Instance = By.xpath(".//*[@data-lockdiv='t6']");      // to activate show this instance
	By SI_After = By.xpath(".//*[@for='showInstance1']");
	By SI_OnceInSession = By.xpath(".//*[@for='showInstance2']");
	By SI_Everytime = By.xpath(".//*[@for='showInstance3']");

	
	By Dont_Display_Below_Width = By.xpath(".//*[@data-lockdiv='t19']");      // to activate show this instance
	By DDBW_Never = By.xpath(".//*[@for='HideInstance1']");
	By DDBW_HideBelowSelectedSize = By.xpath(".//*[@for='HideInstance2']");
	
	By Auto_Hide = By.xpath(".//*[@data-lockdiv='t20']"); // to active auto hide
	By AH_NoAutohide = By.xpath(".//*[@for='autoHide1']");
	By AH_AutoHideAfterTime = By.xpath(".//*[@for='autoHide2']"); 			
	
	
	By Dont_Show_After_Click = By.xpath(".//*[@data-lockdiv='t24']"); // to active DO NOT SHOW THIS INSTANCE AGAIN AFTER CLICK MADE ON ANY LINK OR BUTTON OF INSTANCE 
	By DSAC_YesShow = By.xpath(".//*[@for='clickOnEngage1']");
	By DSAC_NoShow = By.xpath(".//*[@for='clickOnEngage2']");
	
	By Target_Pages = By.xpath(".//*[@data-lockdiv='t7']"); // to active target pages
	By TP_AllPages = By.xpath(".//*[@for='targt_page1']");
	By TP_SpecificURL = By.xpath(".//*[@for='targt_page2']");
	
	By Devices = By.xpath(".//*[@data-lockdiv='t8']"); // to active device
	By D_AllDevices = By.xpath(".//*[@for='Device1']");
	By D_Desktop = By.xpath(".//*[@for='Device2']");
	By D_Phone = By.xpath(".//*[@for='Device3']");
	By D_Tablet = By.xpath(".//*[@for='Device4']");
	

	By Platforms = By.xpath(".//*[@data-lockdiv='t9']"); // to active platforms
	By P_AllPlatforms = By.xpath(".//*[@for='Platform1']");
	By P_Windows = By.xpath(".//*[@for='Platform2']");
	By P_Linux = By.xpath(".//*[@for='Platform4']");
	By P_iOS = By.xpath(".//*[@for='Platform5']");
	By P_Android = By.xpath(".//*[@for='Platform6']");
	By P_Others = By.xpath(".//*[@for='Platform7']");
	
	
	By Browsers = By.xpath(".//*[@data-lockdiv='t10']"); // to active browsers
	By B_AllBrowsers = By.xpath(".//*[@for='Browser1']");
	By B_Chrome = By.xpath(".//*[@for='Browser2']");
	By B_Firefox = By.xpath(".//*[@for='Browser3']");
	By B_Safari = By.xpath(".//*[@for='Browser4']");
	By B_IE = By.xpath(".//*[@for='Browser5']");
	By B_Opera = By.xpath(".//*[@for='Browser6']");
	By B_Others = By.xpath(".//*[@for='Browser7']");
	
	
	By Time_Spent_Visitor = By.xpath(".//*[@data-lockdiv='t11']"); // to active TIME SPENT ON A PAGE BY A VISITOR
	
	By Show_After_Scrolling = By.xpath(".//*[@data-lockdiv='t12']"); // to active show after scrolling
	By SAS_No = By.xpath(".//*[@for='afterScrolling1']");
	By SAS_Yes = By.xpath(".//*[@for='afterScrolling2']");
	
	
	By Exit_Intent = By.xpath(".//*[@data-lockdiv='t13']"); // to active exit intent
	By EI_No = By.xpath(".//*[@for='exitIntent1']");
	By EI_Yes = By.xpath(".//*[@for='exitIntent2']");
	
	
	By Referral_Site_Targetting = By.xpath(".//*[@data-lockdiv='t14']"); // to active referral site targetting
	By RST_ShowForAll = By.xpath(".//*[@for='referralSite1']");
	By RST_OrganicSearch = By.xpath(".//*[@for='referralSite2']");
	By RST_SpecificSite = By.xpath(".//*[@for='referralSite3']");
	
	
	By UTM_Targetting = By.xpath(".//*[@data-lockdiv='t15']"); // to active UTM targetting
	By UTMT_ShowForAll = By.xpath(".//*[@for='utm1']");
	By UTMT_SpecificUTM = By.xpath(".//*[@for='utm2']");
	
	
	By Google_Analytics = By.xpath(".//*[@data-lockdiv='t22']"); // to active google analytics
	By GA_Disable = By.xpath(".//*[@for='GA1']");
	By GA_Enable = By.xpath(".//*[@for='GA2']");
	
	
	By Page_Variable = By.xpath(".//*[@data-lockdiv='t23']"); // to active page variable
	By PV_No = By.xpath(".//*[@for='onPageVariable1']");
	By PV_Yes = By.xpath(".//*[@for='onPageVariable2']");
	
	By Select_Country = By.xpath(".//*[@data-lockdiv='t16']"); // to active select country
	
	By Select_City = By.xpath(".//*[@data-lockdiv='t17']"); // to active select city
	
	By SaveAndNext = By.xpath("//*[text() = 'Save & Next']");
	By SaveAndExit = By.xpath("//*[text() = 'Save & Exit']");
	By Save =	By.xpath("//*[text() = 'Save']");
	By Exit = By.xpath("//*[text() = 'Exit']");
	
	By EditName = By.xpath("//*[contains(@class,'editInstanceNameIn ')]");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameInstance_')]");
	By EditName_Save = By.xpath("//*[contains(@class,'save_instance_name')]");
	By EditName_Cancel = By.xpath("//*[contains(@class,'cancel_instance_name')]");

	By ChooseCondition_Toggle = By.xpath("//*[@for = 'and']");
	By ANDtext = By.xpath("//*[text() = 'ALL']");
	By ORtext = By.xpath("//*[text() = 'ANY ONE']");
	
	
	
	
	public Onsite_Target_Page(WebDriver driver)
	
	{
		this.driver = driver;
		
	}
	
	
public void Target_Users_click()
	
	{
		driver.findElement(Target_Users).click();
		
	}
	
	

	public void TU_AllUsers_click()
	
	{
		driver.findElement(TU_AllUsers).click();
		
	}
	
	
	
	public void TU_VisitorsOnly_click()
	
	{
		driver.findElement(TU_VisitorsOnly).click();
		
	}
	
	public void AddressableContacts_click()
	
	{
		driver.findElement(AddressableContacts).click();
		
	}
	
	public void TU_VO_AllVisiters_click()
	
	{
		driver.findElement(TU_VO_AllVisiters).click();
		
	}
	
	public void TU_VO_NewVisiters_click()
	
	{
		driver.findElement(TU_VO_NewVisiters).click();
		
	}
	
	public void TU_VO_RepeatVisiters_click()
	
	{
		driver.findElement(TU_VO_RepeatVisiters).click();
		
	}
	
	public void TU_AC_PickSegment_click()
	
	{
		driver.findElement(TU_AC_PickSegment).click();
		
		// Select a value from dropdown
		
		Select select = new Select(driver.findElement(By.id("segmentIdSelect")));
		select.selectByIndex(1);
		
	}
	
	public void TU_AC_Lifecycle_click()
	
	{
		driver.findElement(TU_AC_Lifecycle).click();
	
		Select select = new Select(driver.findElement(By.id("lifeCycleIdSelect")));
		select.selectByIndex(1);
		
	}
	
	public void TU_AC_Tag_click()
	
	{
		driver.findElement(TU_AC_Tag).click();
		
		Select select = new Select(driver.findElement(By.id("tagIdSelect")));
		select.selectByIndex(1);
		
	}
	
	public void Pageview_Target_click()
	
	{
		driver.findElement(Pageview_Target).click();
		
	}
	
	public void PT_No_click()
	
	{
		driver.findElement(PT_No).click();
		
	}
	
	public void PT_Yes_click()
	
	{
		driver.findElement(PT_Yes).click();
		
		// Enter value in Show after page views
		
		driver.findElement(By.className("onlyNumber")).sendKeys("5");  // Enter number
		
	}
	
	public void Show_Instance_click()
	
	{
		driver.findElement(Show_Instance).click();
		
	}
	
	public void SI_After_click()
	
	{
		driver.findElement(SI_After).click();
		
		// Enter value in after n minutes
		
		driver.findElement(By.xpath("//*[@data-selector= 'showInstanceInNumbersOfTimes' and @type = 'text']")).sendKeys("2");
		
	}
	
	public void SI_OnceInSession_click()
	
	{
		driver.findElement(SI_OnceInSession).click();
		
	}
	
	public void SI_Everytime_click()
	
	{
		driver.findElement(SI_Everytime).click();
		
	}
	
	public void Dont_Display_Below_Width_click()
	
	{
		driver.findElement(Dont_Display_Below_Width).click();
		
	}
	
	public void DDBW_Never_click()
	
	{
		driver.findElement(DDBW_Never).click();
		
	}
	
	public void DDBW_HideBelowSelectedSize_click()
	
	{
		driver.findElement(DDBW_HideBelowSelectedSize).click();
		
		// Select value in dropdown
		
		Select select = new Select(driver.findElement(By.xpath("//*[@name= 'instanceHideSizes']")));
		select.selectByIndex(1);
		
	}
	
	public void Auto_Hide_click()
	
	{
		driver.findElement(Auto_Hide).click();
		
	}
	
	public void AH_NoAutohide_click()
	
	{
		driver.findElement(AH_NoAutohide).click();
		
	}
	

	public void AH_AutoHideAfterTime_click()
	
	{
		driver.findElement(AH_AutoHideAfterTime).click();
		
		// Enter time for auto hide
		
		driver.findElement(By.xpath("//*[@name= 'autoHideTimes']")).sendKeys("10");
		
	}
	
public void Dont_Show_After_Click_click()
	
	{
		driver.findElement(Dont_Show_After_Click).click();
		
	}
	
public void DSAC_YesShow_click()

{
	driver.findElement(DSAC_YesShow).click();
	
}

public void DSAC_NoShow_click()

{
	driver.findElement(DSAC_NoShow).click();
	
}

public void Target_Pages_click()

{
	driver.findElement(Target_Pages).click();
	
}

public void TP_AllPages_click()

{
	driver.findElement(TP_AllPages).click();
	
}

public void TP_SpecificURL_click(String url)

{
	driver.findElement(TP_SpecificURL).click();
	
	// Specify URL
	
	driver.findElement(By.xpath("//*[@for= 'targetPageConditionAnd']")).click(); // Choose condition radio button

	Select select = new Select(driver.findElement(By.xpath("//*[@data-selector= 'targetPagePregmatch']")));
	select.selectByIndex(3);            // to select contains
	
	driver.findElement(By.xpath("//*[contains(@class,'targetSpecificPage')]")).clear(); // URL
	
	driver.findElement(By.xpath("//*[contains(@class,'targetSpecificPage')]")).sendKeys(url); // URL
	
}

public void Devices_click()

{
	driver.findElement(Devices).click();
	
}

public void D_AllDevices_click()

{
	driver.findElement(D_AllDevices).click();
	
}

public void D_Desktop_click()

{
	driver.findElement(D_Desktop).click();
	
}

public void D_Phone_click()

{
	driver.findElement(D_Phone).click();
	
}

public void D_Tablet_click()

{
	driver.findElement(D_Tablet).click();
	
}

public void Platforms_click()

{
	driver.findElement(Platforms).click();
	
}

public void P_AllPlatforms_click()

{
	driver.findElement(P_AllPlatforms).click();
	
}

public void P_Windows_click()

{
	driver.findElement(P_Windows).click();
	
}

public void P_Linux_click()

{
	driver.findElement(P_Linux).click();
	
}

public void P_iOS_click()

{
	driver.findElement(P_iOS).click();
	
}

public void P_Android_click()

{
	driver.findElement(P_Android).click();
	
}

public void P_Others_click()

{
	driver.findElement(P_Others).click();
	
}

public void Browsers_click()

{
	driver.findElement(Browsers).click();
	
}

public void B_AllBrowsers_click()

{
	driver.findElement(B_AllBrowsers).click();
	
}

public void B_Chrome_click()

{
	driver.findElement(B_Chrome).click();
	
}


public void B_Firefox_click()

{
	driver.findElement(B_Firefox).click();
	
}

public void B_Safari_click()

{
	driver.findElement(B_Safari).click();
	
}

public void B_IE_click()

{
	driver.findElement(B_IE).click();
	
}

public void B_Opera_click()

{
	driver.findElement(B_Opera).click();
	
}

public void B_Others_click()

{
	driver.findElement(B_Others).click();
	
}

public void Time_Spent_Visitor_click()

{
	driver.findElement(Time_Spent_Visitor).click();
	driver.findElement(By.xpath(".//*[@id='SpendTime']")).sendKeys("10"); // Enter time in sec
	
}
public void Show_After_Scrolling_click()

{
	driver.findElement(Show_After_Scrolling).click();
	
}
public void SAS_No_click()

{
	driver.findElement(SAS_No).click();
	
}
public void SAS_Yes_click()

{
	driver.findElement(SAS_Yes).click();
	
}
public void Exit_Intent_click()

{
	driver.findElement(Exit_Intent).click();
	
}
public void EI_No_click()

{
	driver.findElement(EI_No).click();
	
}
public void EI_Yes_click()

{
	driver.findElement(EI_Yes).click();
	
}
public void Referral_Site_Targetting_click()

{
	driver.findElement(Referral_Site_Targetting).click();
	
}
public void RST_ShowForAll_click()

{
	driver.findElement(RST_ShowForAll).click();
	
}
public void RST_OrganicSearch_click()

{
	driver.findElement(RST_OrganicSearch).click();
	
}
public void RST_SpecificSite_click(String website)

{
	driver.findElement(RST_SpecificSite).click();
	
	driver.findElement(By.xpath("(//*[@name = 'specificSiteUrl'])[1]")).sendKeys(website);
	
}
public void UTM_Targetting_click()

{
	driver.findElement(UTM_Targetting).click();
	
}
public void UTMT_ShowForAll_click()

{
	driver.findElement(UTMT_ShowForAll).click();
	
}
public void UTMT_SpecificUTM_click()

{
	driver.findElement(UTMT_SpecificUTM).click();
	
	driver.findElement(By.xpath("(//*[@name = 'specificSiteUrl'])[1]")).sendKeys("Autospecific");
	
	
}
public void Google_Analytics_click()

{
	driver.findElement(Google_Analytics).click();
	
}
public void GA_Disable_click()

{
	driver.findElement(GA_Disable).click();
	
}
public void GA_Enable_click()

{
	driver.findElement(GA_Enable).click();
	
}
public void Page_Variable_click()

{
	driver.findElement(Page_Variable).click();
	
}
public void PV_No_click()

{
	driver.findElement(PV_No).click();
	
}
public void PV_Yes_click()

{
	driver.findElement(PV_Yes).click();
	
}
public void Select_Country_click()

{
	driver.findElement(Select_Country).click();
	
}
public void Select_City_click()

{
	driver.findElement(Select_City).click();
	
}

public void SaveAndNext_click()

{
	driver.findElement(SaveAndNext).click();
	
}


public void SaveAndExit_click()

{
	driver.findElement(SaveAndExit).click();
	
}

public void Save_click()

{
	driver.findElement(Save).click();
	
}

public void Exit_click()

{
	driver.findElement(Exit).click();
	
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
	

public void ChooseCondition_ToggleClick()
{
	driver.findElement(ChooseCondition_Toggle).click();
}
	
	
public String printANDtext()
{
	String text = driver.findElement(ANDtext).getText();
	System.out.println("Text before switching the toggle to OR = "+text);
	return text;
}
	
	
public String printORtext()
{
	String text = driver.findElement(ORtext).getText();
	System.out.println("Text after switching the toggle to OR = "+text);
	return text;
}
	
	
	
	
	
	
}
