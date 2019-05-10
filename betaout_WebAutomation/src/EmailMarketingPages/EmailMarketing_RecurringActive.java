package EmailMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class EmailMarketing_RecurringActive {

	
public WebDriver driver;
	
	
	By Monthly = By.xpath("(//*[@id = 'btn-monthly'])");
	By Weekly = By.xpath("(//*[@id = 'btn-weekly'])");
	By Daily = By.xpath("(//*[@id = 'btn-daily'])");
	
	By EditName = By.xpath("(//*[@class = 'fa fa-pencil editCampignNameIn'])");
	By EditName_Rename = By.xpath("//*[contains(@id,'renameCampign_')]");
	By EditName_Save = By.xpath("(//*[text() = 'Save'])");
	By EditName_Cancel = By.xpath("(//*[text() = 'Cancel'])[1]");
	
	By Monthly_StartDate = By.xpath("(//*[@class = 'add-on'])[1]");
	By Monthly_EndDate = By.xpath("(//*[@class = 'add-on'])[2]");
	By Monthly_Time = By.xpath("(//*[@class = 'add-on'])[3]");
	By Monthly_ExclusionDate = By.xpath("(//*[@class = 'plus-bg'])[2]");
	By Monthly_ExclusionDate_SelectDate = By.xpath("(//*[@class = 'add-on'])[4]");
	By Monthly_ExclusionDate_Save = By.xpath("(//*[@data-action = 'exclusionDateSave'])");
	By Monthly_DaysToSend = By.xpath("(//*[@class = 'plus-bg'])[1]");
	By Monthly_DaysToSend_Weekdays = By.xpath("(//*[@for = 'Weekdays'])");
	By Monthly_DaysToSend_Weekdays_Mon = By.xpath("(//*[@for = 'Mon'])");
	By Monthly_DaysToSend_Weekdays_Tues = By.xpath("(//*[@for = 'Tue'])");
	By Monthly_DaysToSend_Weekdays_Wed = By.xpath("(//*[@for = 'Wed'])");
	By Monthly_DaysToSend_Weekdays_Thurs = By.xpath("(//*[@for = 'Thu'])");
	By Monthly_DaysToSend_Weekdays_Fri = By.xpath("(//*[@for = 'Fri'])");
	By Monthly_DaysToSend_Weekdays_Sat = By.xpath("(//*[@for = 'Sat'])");
	By Monthly_DaysToSend_Weekdays_Sun = By.xpath("(//*[@for = 'Sun'])");
	By Monthly_DaysToSend_Weekdays_Save = By.xpath("(//*[@data-action = 'sendDaysSave'])");
	
	By Monthly_DaysToSend_Monthdays = By.xpath("(//*[@for = 'Month'])");
	By Monthly_DaysToSend_Monthdays_1st = By.xpath("(//*[@for = 'month_1'])");
	By Monthly_DaysToSend_Monthdays_2nd = By.xpath("(//*[@for = 'month_2'])");   // same goes for all dates
	By Monthly_DaysToSend_Monthdays_Save = By.xpath("(//*[@data-action = 'sendDaysSave'])");

	By Monthly_Schedule = By.xpath("(//*[@id = 'scheduleMail'])");
	By Monthly_Preview = By.xpath("(//*[@id = 'weekly-preview'])");
	By Monthly_ExcludingPreview = By.xpath("(//*[@id = 'excluding-preview'])");
	
	
	
	By Weekly_StartDate = By.xpath("(//*[@class = 'add-on'])[1]");
	By Weekly_EndDate = By.xpath("(//*[@class = 'add-on'])[2]");
	By Weekly_Time = By.xpath("(//*[@class = 'add-on'])[3]");
	By Weekly_ExclusionDate = By.xpath("(//*[@class = 'plus-bg'])[2]");
	By Weekly_ExclusionDate_SelectDate = By.xpath("(//*[@class = 'add-on'])[4]");
	By Weekly_ExclusionDate_Save = By.xpath("(//*[@data-action = 'exclusionDateSave'])");
	By Weekly_DaysToSend = By.xpath("(//*[@class = 'plus-bg'])[1]");
	By Weekly_DaysToSend_Weekdays_Mon = By.xpath("(//*[@for = 'Mon'])");
	By Weekly_DaysToSend_Weekdays_Tues = By.xpath("(//*[@for = 'Tue'])");
	By Weekly_DaysToSend_Weekdays_Wed = By.xpath("(//*[@for = 'Wed'])");
	By Weekly_DaysToSend_Weekdays_Thurs = By.xpath("(//*[@for = 'Thu'])");
	By Weekly_DaysToSend_Weekdays_Fri = By.xpath("(//*[@for = 'Fri'])");
	By Weekly_DaysToSend_Weekdays_Sat = By.xpath("(//*[@for = 'Sat'])");
	By Weekly_DaysToSend_Weekdays_Sun = By.xpath("(//*[@for = 'Sun'])");
	By Weekly_DaysToSend_Weekdays_Save = By.xpath("(//*[@data-action = 'sendDaysSave'])");
	
	By Weekly_Schedule = By.xpath("(//*[@id = 'scheduleMail'])");
	By Weekly_Preview = By.xpath("(//*[@id = 'weekly-preview'])");
	By Weekly_ExcludingPreview = By.xpath("(//*[@id = 'excluding-preview'])");
	
	By Daily_StartDate = By.xpath("(//*[@class = 'add-on'])[1]");
	By Daily_EndDate = By.xpath("(//*[@class = 'add-on'])[2]");
	By Daily_Time = By.xpath("(//*[@class = 'add-on'])[3]");
	By Daily_ExclusionDate = By.xpath("(//*[@class = 'plus-bg'])[2]");
	By Daily_ExclusionDate_SelectDate = By.xpath("(//*[@class = 'add-on'])[4]");
	By Daily_ExclusionDate_Save = By.xpath("(//*[@data-action = 'exclusionDateSave'])");
	
	By Daily_Schedule = By.xpath("(//*[@id = 'scheduleMail'])");
	By Daily_Preview = By.xpath("(//*[@id = 'daily-preview'])");
	By Daily_ExcludingPreview = By.xpath("(//*[@id = 'excluding-preview'])");
	
	
	By EndDate_NextMonth = By.xpath(("(//*[@class = 'next'])[4]"));
//	By EndDate_SelectDate = By.xpath(("(//*[@class = 'day' and text()='10'])"));
	
	By EndDate_SelectDate1 = By.xpath("(//*[@class = 'day' and text()='1'])[1]");
	By EndDate_SelectDate2 = By.xpath("(//*[@class = 'day' and text()='1'])[2]");
	By EndDate_SelectDate3 = By.xpath("(//*[@class = 'day' and text()='1'])[3]");
	
	By Time_IncreementHours = By.xpath("(//*[@data-action = 'incrementHours'])");
	By Time_DecreementHours = By.xpath("(//*[@data-action = 'decrementHours'])");
	
	By Time_IncreementMinutes = By.xpath("(//*[@data-action = 'incrementMinutes'])");
	By Time_DecreementMinutes = By.xpath("(//*[@data-action = 'decrementMinutes'])");
	
	
	By Exclusion_NextMonth = By.xpath("(//*[@class = 'next'])[7]");
//	By Exclusion_SelectDate = By.xpath(("(//*[@class = 'day' and text()='10'])"));
	
	By Exclusion_SelectDate1 = By.xpath("(//*[@class = 'day' and text()='1'])[1]");
	By Exclusion_SelectDate2 = By.xpath("(//*[@class = 'day' and text()='1'])[2]");
	By Exclusion_SelectDate3 = By.xpath("(//*[@class = 'day' and text()='1'])[3]");
	
	By RemoveDuplicateCheckbox = By.xpath(".//*[@for='chkDuplicate']");
	
	
	// Delete recur camp and broad camp after creating recurring campaign
	
	By DeleteRecur = By.xpath("(//*[@class = 'iconAction-delete'])[1]");
	By Recur_EnterDeleteTextbox = By.xpath("(//*[@id = 'capsVal'])");
	By Recur_DeleteConfirm = By.xpath("//*[contains(@class,'ConfirmDeletedRecurringCampaign')]");
		
	By DeleteBroadSecond = By.xpath("(//*[@class = 'iconAction-delete'])[2]");
	By Broad_EnterDeleteTextbox = By.xpath("(//*[@id = 'capsVal'])");
	By Broad_DeleteConfirm = By.xpath("//*[contains(@class,'ConfirmDeletedcampignType')]");
	
	
	public EmailMarketing_RecurringActive(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void MonthlyClick()
	{
		driver.findElement(Monthly).click();
	}
	
	public void WeeklyClick()
	{
		driver.findElement(Weekly).click();
	}
	
	public void DailyClick()
	{
		driver.findElement(Daily).click();
	}
	

	public void EditNameClick()
	{
		driver.findElement(EditName).click();
	}
	

	public void EditName_RenameClick()
	{
		String name = driver.findElement(EditName_Rename).getText();
		System.out.println("Name of the campaign = "+name);
	}
	
	public void EditName_SaveClick()
	{
		driver.findElement(EditName_Save).click();
	}
	
	public void EditName_CancelClick()
	{
		driver.findElement(EditName_Cancel).click();
	}
	
	public void Monthly_StartDateClick()
	{
		driver.findElement(Monthly_StartDate).click();
	}
	
	public void Monthly_EndDateClick()
	{
		driver.findElement(Monthly_EndDate).click();
	}
	
	public void Monthly_TimeClick()
	{
		driver.findElement(Monthly_Time).click();
	}
	
	public void Monthly_ExclusionDateClick()
	{
		driver.findElement(Monthly_ExclusionDate).click();
	}
	
	public void Monthly_ExclusionDate_SelectDateClick()
	{
		driver.findElement(Monthly_ExclusionDate_SelectDate).click();
	}
	
	public void Monthly_ExclusionDate_SaveClick()
	{
		driver.findElement(Monthly_ExclusionDate_Save).click();
	}
	
	public void Monthly_DaysToSendClick()
	{
		driver.findElement(Monthly_DaysToSend).click();
	}
	
	public void Monthly_DaysToSend_WeekdaysClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays).click();
	}
	
	public void Monthly_DaysToSend_Weekdays_MonClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Mon).click();
	}
	
	
	public void Monthly_DaysToSend_Weekdays_TuesClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Tues).click();
	}
	
	
	public void Monthly_DaysToSend_Weekdays_WedClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Wed).click();
	}
	
	public void Monthly_DaysToSend_Weekdays_ThursClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Thurs).click();
	}
	
	public void Monthly_DaysToSend_Weekdays_FriClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Fri).click();
	}
	
	public void Monthly_DaysToSend_Weekdays_SatClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Sat).click();
	}
	
	public void Monthly_DaysToSend_Weekdays_SunClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Sun).click();
	}
	
	public void Monthly_DaysToSend_Weekdays_SaveClick()
	{
		driver.findElement(Monthly_DaysToSend_Weekdays_Save).click();
	}
	
	public void Monthly_DaysToSend_MonthdaysClick()
	{
		driver.findElement(Monthly_DaysToSend_Monthdays).click();
	}
	
	public void Monthly_DaysToSend_Monthdays_1stClick()
	{
		driver.findElement(Monthly_DaysToSend_Monthdays_1st).click();
	}
	
	public void Monthly_DaysToSend_Monthdays_2ndClick()
	{
		driver.findElement(Monthly_DaysToSend_Monthdays_2nd).click();
	}
	
	public void Monthly_DaysToSend_Monthdays_SaveClick()
	{
		driver.findElement(Monthly_DaysToSend_Monthdays_Save).click();
	}
	
	public void Monthly_ScheduleClick()
	{
		driver.findElement(Monthly_Schedule).click();
	}
	
	public void Monthly_PreviewClick()
	{	
		String name = driver.findElement(Monthly_Preview).getText();
		System.out.println("Details of Monthly campaign = "+name);
	}
	
	public void Monthly_ExcludingPreviewClick()
	{
		String name = driver.findElement(Monthly_ExcludingPreview).getText();
		System.out.println("Details of Monthly Excluding campaign = "+name);
	}
	
	public void Weekly_StartDateClick()
	{
		driver.findElement(Weekly_StartDate).click();
	}
	
	public void Weekly_EndDateClick()
	{
		driver.findElement(Weekly_EndDate).click();
	}
	
	public void Weekly_TimeClick()
	{
		driver.findElement(Weekly_Time).click();
	}
	
	public void Weekly_ExclusionDateClick()
	{
		driver.findElement(Weekly_ExclusionDate).click();
	}
	
	public void Weekly_ExclusionDate_SelectDateClick()
	{
		driver.findElement(Weekly_ExclusionDate_SelectDate).click();
	}
	
	public void Weekly_ExclusionDate_SaveClick()
	{
		driver.findElement(Weekly_ExclusionDate_Save).click();
	}
	
	public void Weekly_DaysToSendClick()
	{
		driver.findElement(Weekly_DaysToSend).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_MonClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Mon).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_TuesClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Tues).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_WedClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Wed).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_ThursClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Thurs).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_FriClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Fri).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_SatClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Sat).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_SunClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Sun).click();
	}
	
	public void Weekly_DaysToSend_Weekdays_SaveClick()
	{
		driver.findElement(Weekly_DaysToSend_Weekdays_Save).click();
	}
	
	public void Weekly_ScheduleClick()
	{
		driver.findElement(Weekly_Schedule).click();
	}
	
	public void Weekly_PreviewClick()
	{
		String name = driver.findElement(Weekly_Preview).getText();
		System.out.println("Details of weekly campaign = "+name);
	}
	
	public void Weekly_ExcludingPreviewClick()
	{
		String name = driver.findElement(Weekly_ExcludingPreview).getText();
		System.out.println("Details of weekly excluding campaign = "+name);
	}
	
	public void Daily_StartDateClick()
	{
		driver.findElement(Daily_StartDate).click();
	}
	
	public void Daily_EndDateClick()
	{
		driver.findElement(Daily_EndDate).click();
	}
	
	public void Daily_TimeClick()
	{
		driver.findElement(Daily_Time).click();
	}
	
	public void Daily_ExclusionDateClick()
	{
		driver.findElement(Daily_ExclusionDate).click();
	}
	
	public void Daily_ExclusionDate_SelectDateClick()
	{
		driver.findElement(Daily_ExclusionDate_SelectDate).click();
	}
	
	public void Daily_ExclusionDate_SaveClick()
	{
		driver.findElement(Daily_ExclusionDate_Save).click();
	}
	
	public void Daily_ScheduleClick()
	{
		driver.findElement(Daily_Schedule).click();
	}
	
	public void Daily_PreviewClick()
	{
		String name = driver.findElement(Daily_Preview).getText();
		System.out.println("Details of Daily campaign = "+name);
	
	}
	
	public void Daily_ExcludingPreviewClick()
	{
		String name = driver.findElement(Daily_ExcludingPreview).getText();
		System.out.println("Details of Daily Excludings campaign = "+name);
	
	}
	
	
	public void EndDate_NextMonthClick()
	{
		
		driver.findElement(EndDate_NextMonth).click();
	}
	
	public void EndDate_SelectDateClick()
	{
		
	//	driver.findElement(EndDate_SelectDate).click();
		
		if(driver.findElement(EndDate_SelectDate1).isDisplayed() == true)
			{
				driver.findElement(EndDate_SelectDate1).click();
			}
		else if (driver.findElement(EndDate_SelectDate2).isDisplayed() == true) 
		{
			driver.findElement(EndDate_SelectDate2).click();
		}
		else if (driver.findElement(EndDate_SelectDate3).isDisplayed() == true) 
		{
			driver.findElement(EndDate_SelectDate3).click();
		}
		else
			System.out.println("Date is not displayed on the calendar");
		
	
	}
	
	public void Time_IncreementHoursClick()
	{
		
		driver.findElement(Time_IncreementHours).click();
	}
	
	
	public void Time_DecreementHoursClick()
	{
		
		driver.findElement(Time_DecreementHours).click();
	}
	
	
	public void Time_IncreementMinutesClick()
	{
		
		driver.findElement(Time_IncreementMinutes).click();
	}
	
	
	public void Time_DecreementMinutesClick()
	{
		
		driver.findElement(Time_DecreementMinutes).click();
	}
	

	
	public void Exclusion_NextMonthClick()
	{
		
		driver.findElement(Exclusion_NextMonth).click();
	}
	
	public void Exclusion_SelectDateClick()
	{
		
	//	driver.findElement(Exclusion_SelectDate).click();

		if(driver.findElement(Exclusion_SelectDate1).isDisplayed() == true)
		{
			driver.findElement(Exclusion_SelectDate1).click();
		}
	else if (driver.findElement(Exclusion_SelectDate2).isDisplayed() == true) 
	{
		driver.findElement(Exclusion_SelectDate2).click();
	}
	else if (driver.findElement(Exclusion_SelectDate3).isDisplayed() == true) 
	{
		driver.findElement(Exclusion_SelectDate3).click();
	}
	else
		System.out.println("Date is not displayed on the calendar");
		
		
	}
	
	public void RemoveDuplicateCheckboxClick()
	{
		driver.findElement(RemoveDuplicateCheckbox).click();
	}
	
	
	public void DeleteRecur()
	{
		driver.findElement(DeleteRecur).click();
	}
	
	public void Recur_EnterDeleteTextbox()
	{
		driver.findElement(Recur_EnterDeleteTextbox).sendKeys("DELETE");
	}
	
	public void Recur_DeleteConfirm()
	{
		driver.findElement(Recur_DeleteConfirm).click();
	}
	
	public void DeleteBroadSecond()
	{
		driver.findElement(DeleteBroadSecond).click();
	}
	
	public void Broad_EnterDeleteTextbox()
	{
		driver.findElement(Broad_EnterDeleteTextbox).sendKeys("DELETE");
	}
	
	public void Broad_DeleteConfirm()
	{
		driver.findElement(Broad_DeleteConfirm).click();
	}
	
	
	
	
	
	
	
}
