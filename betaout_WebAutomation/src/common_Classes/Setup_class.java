package common_Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/**
 * @author - Navpreet
 */
public class Setup_class	{

	
	public WebDriver driver;
	
 public WebDriver setup() throws Exception {

		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
		
				//	driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		/* FileInputStream fileInput = new FileInputStream(new File("src\\data.properties"));	 		 
		 Properties prop = new Properties();
		 prop.load(fileInput);
*/
		
		return driver;					
}

 
 public Properties loadPropertyFile() throws Exception
 {
	 FileInputStream fileInput = new FileInputStream(new File("Resources\\data.properties"));	 		 
	 Properties prop = new Properties();
	 prop.load(fileInput);
	 
	 return prop;
 }
 	
	public String getCurrentDateTime()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		String finalDate = df.format(dateobj);
		System.out.println(finalDate);
		return finalDate;
	}
		
	

	/*
	public void setScheduleDateAndTime() throws Exception
	{
		 		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Date scheduleDate = new Date((System.currentTimeMillis() - TimeUnit.HOURS.toMillis(5)) - TimeUnit.MINUTES.toMillis(27));

		System.out.println(dateFormat.format(scheduleDate));
		
		String date1 = dateFormat.format(scheduleDate);
		System.out.println(date1);
		Date currentDate = new Date(System.currentTimeMillis());
		String todayDate = dateFormat.format(currentDate); 
		System.out.println(date1);
		
		int currentHour = Integer.valueOf(todayDate.substring(11, 13));
		int scheduleHour = Integer.valueOf(date1.substring(11,13));
		
		int currentMinute = Integer.valueOf(todayDate.substring(14, 16));
		int scheduleMinute = Integer.valueOf(date1.substring(14, 16));
		
		for(int i=0;i<5;i++)
			driver.findElement(By.xpath("(//*[@data-action = 'decrementHours'])")).click();	
					
		if(scheduleMinute>29)
		{						
			for(int i=0;i<(currentMinute-scheduleMinute);i++)
			{
				driver.findElement(By.xpath("(//*[@data-action = 'decrementMinutes'])")).click();
				Thread.sleep(500);
			}
		}
	
		else
		{				
			for(int i = 0; i < 28 ; i++)
			{
				driver.findElement(By.xpath("(//*[@data-action = 'decrementMinutes'])")).click();
				Thread.sleep(500);
			}
			
			
		}
		
		//driver.findElement(scheduleDateInputField).sendKeys(date1);//Will set a campaign time after 3 minutes.
				
	}
*/
	
	
	public void setScheduleDateAndTime() throws Exception
	
	{
		
	/*	for(int i = 0; i < 28 ; i++)
		{
			driver.findElement(By.xpath("(//*[@data-action = 'decrementMinutes'])")).click();
			Thread.sleep(250);
		}
			
		for(int i = 0; i < 5 ; i++)
		{
			driver.findElement(By.xpath("(//*[@data-action = 'decrementHours'])")).click();
			Thread.sleep(250);
		}
	*/	
		driver.findElement(By.xpath("(//*[@data-action = 'incrementMinutes'])")).click();
		
	}
	
	
	
	public WebElement isElementPresnt(WebDriver driver,By locator,int time)

	{
	  
	WebElement ele = null;
	 
	for(int i=0;i<time;i++)
	{
	try{
	ele=driver.findElement(locator);

//	ele=driver.findElement(xpathlocator);
		
		break;
	}
	catch(Exception e)
	{
	try 
	{
	Thread.sleep(1000);
	} catch (InterruptedException e1) 
	{
	System.out.println("Waiting for element to appear on DOM");
	}
	}
	 
	 
	}
	return ele;
	 
	}
	
	// Methods for username , passwords , URLs
	
	public void getQAURL()                            
	{
		driver.get("https://qa.betaout.in/");	
		
	//	driver.get("https://qa-f1.betaout.in/");
	//	driver.get("https://qa-f2.betaout.in/");
	//	driver.get("https://qa-f3.betaout.in/");
	}

	
	public void getPreProdURL()                            
	{
		driver.get("https://pre-prod-102.betaout.com/");	
	}
	

	public void getStagingURL()
	{
		driver.get("https://stag.betaout.in/");	
	}
	
	public void getLiveURL()
	{
		driver.get("https://app.betaout.com/");	
	}
	
	public String getWoocommerceOneURL()
	{
		String URL = "http://woocommerceone.betaout.in/";
		driver.get(URL);
		return URL;
	}
	
	
	public String getWoocommerceURL()
	{
		
		String URL = "http://woocommerce.betaout.in/";
		driver.get(URL);
		return URL;
		
	}
	
	public void getYopmailURL()
	{
		driver.get("http://www.yopmail.com/en/");
		
	}
	
	public void getGmailURL()
	{
		driver.get("https://www.google.com/gmail/about/");
		
	}
	
	
	public void getPrestaShopURL()
	{
		driver.get("http://prestashop1616.basera.com/");
		
	}
	
	
	public void getPreProdCartCampaignPage()
	{
		driver.get("https://pre-prod-102.betaout.com/carts/cart-campaign");
		
	}
	
	public void getQACartCampaignPage()
	{
		driver.get("https://qa.betaout.in/carts/cart-campaign");
		
	}
	
	public String getWoocommercetestUsername()
	{
		return "Woocommercetest@y0v.in";
	}
	
	public String getWoocommercetestPassword()
	{
		return "Woocommercetest";
	}
	

	public String getBetaoutpushUsername()
	{
		return "betaoutpush.multiple@getamplify.com";
	}
	
	public String getBetaoutpushPassword()
	{
		return "123456";
	}

	
	
	public String getSimranUsername()
	{
		return "sjs22858@gmail.com";
	}
	
	public String getSimranPassword()
	{
		return "simranjeet";
	}
	
	public String getShivangiUsername()                
	{
		return "shivangi+1@devrover.com";
	}
	
	public String getShivangiPassword()
	{
		return "11111111";
	}
	
	public String getNavCartUsername()          
	{
		return "navcartrecovery@gmail.com";
	}
	
	public String getNavCartPassword()
	{
		return "cartrecovery";
	}
	
	
	public String getNavpreetQAUsername()          
	{
		return "navpreet@socialcrawler.in";
	}
	
	public String getNavpreetQAPassword()
	{
	
	//	return "navpreet";
	//	return "11111122";
		return "qa@betaout123";
	
	}
	

	public String getRishabhQAUsername()          
	{
		return "rishabh@betaoutinc.com";
	}
	
	public String getRishabhQAPassword()
	{
		return "rishabh100";
	}
	
	
	
	public void verifyLogs()
	{
		  	String html_source=driver.findElement(By.tagName("html")).getText(); 
		    String firstLine = html_source.split("\n")[0];
		    System.out.println("Content of first line = "+firstLine);
		    
/*		    SoftAssert sa = new SoftAssert();
		    sa.assertEquals(firstLine, "    <!DOCTYPE html>");
*/	
		//  System.out.println("Comparison of first line is completed successfully");
		//  sa.assertAll();

		//    int count = 0;
		    
		    if(firstLine.contains("<!") || (firstLine.trim().isEmpty()))
		    {
		    	System.out.println("No logs are printed i.e. PASS");
		    }
		    
		    else
		    {
		    	System.out.println("Logs are printed i.e. FAIL");
		  //  	count = count+1;
		    }
	
		//    return count;
	}

	// Methods for uploading files dynamically - 
	
	public String uploadPromocodeFileCSV()
	
	{
		
		String opf = System.getProperty("user.dir");
		File fp = new File(opf + "/Resources/valid_CSV.csv");
		if(fp.exists() == true)
		System.out.println("File is present at the defined location");	
		else {
			System.out.println("File is NOT present at the defined location");	
		}
		String path1 = fp.getAbsolutePath();
		return path1;
		
	}
	
	
	
	public String uploadBounceListImportCSV()
	
	{
		
		String opf = System.getProperty("user.dir");
		File fp = new File(opf + "/Resources/bounceimport.csv");
		if(fp.exists() == true)
		System.out.println("File is present at the defined location");	
		else {
			System.out.println("File is NOT present at the defined location");	
		}
		String path1 = fp.getAbsolutePath();
		return path1;
		
	}
	
public String uploadOrderImportCSV()

{
	
	String opf = System.getProperty("user.dir");
	File fp = new File(opf + "/Resources/orderimport.csv");
	if(fp.exists() == true)
	System.out.println("File is present at the defined location");	
	else {
		System.out.println("File is NOT present at the defined location");	
	}
	String path1 = fp.getAbsolutePath();
	return path1;
	
}

public String uploadProductImportCSV()

{
	
	String opf = System.getProperty("user.dir");
	File fp = new File(opf + "/Resources/productimport.csv");
	if(fp.exists() == true)
	System.out.println("File is present at the defined location");	
	else {
		System.out.println("File is NOT present at the defined location");	
	}
	String path1 = fp.getAbsolutePath();
	return path1;
	
}

public String uploadSMSSuppressionListCSV()

{
	
	String opf = System.getProperty("user.dir");
	File fp = new File(opf + "/Resources/smssuppressionblacklistimport.csv");
	if(fp.exists() == true)
	System.out.println("File is present at the defined location");	
	else {
		System.out.println("File is NOT present at the defined location");	
	}
	String path1 = fp.getAbsolutePath();
	return path1;
	
}

public String uploadSpamListCSV()

{
	
	String opf = System.getProperty("user.dir");
	File fp = new File(opf + "/Resources/spamimport.csv");
	if(fp.exists() == true)
	System.out.println("File is present at the defined location");	
	else {
		System.out.println("File is NOT present at the defined location");	
	}
	String path1 = fp.getAbsolutePath();
	return path1;
	
}

public String uploadUnsubscribeListCSV()

{
	
	String opf = System.getProperty("user.dir");
	File fp = new File(opf + "/Resources/unsubscribeimport.csv");
	if(fp.exists() == true)
	System.out.println("File is present at the defined location");	
	else {
		System.out.println("File is NOT present at the defined location");	
	}
	String path1 = fp.getAbsolutePath();
	return path1;
	
}


	public String uploadUserImportCSV()
	
	{
		
		String opf = System.getProperty("user.dir");
		File fp = new File(opf + "/Resources/userimport.csv");
		if(fp.exists() == true)
		System.out.println("File is present at the defined location");	
		else {
			System.out.println("File is NOT present at the defined location");	
		}
		String path1 = fp.getAbsolutePath();
		return path1;
		
	}
	
	
public String uploadTestNGEmailableReport()
	
	{
		String opf = System.getProperty("user.dir");
		File fp = new File(opf + "/test-output/emailable-report.html");
	//	File fp = new File(opf + "/test-output/index.html");
		if(fp.exists() == true)
		System.		out.println("File is present at the defined location");	
		else {
			System.out.println("File is NOT present at the defined location");	
		}
		String path1 = fp.getAbsolutePath();
		return path1;
		
	}
	
	public void selectAccountNav()
	{
		driver.findElement(By.xpath("//*[text() = 'Navpreet`s Account']")).click();     // When not in use, comment this line
		
		System.out.println("------------------------------------------------------");
	}
	
	
	public void selectAccountRishabh()
	{
		driver.findElement(By.xpath("//*[contains(text(),'Rishabh')]")).click();     // When not in use, comment this line
		
		System.out.println("------------------------------------------------------");
	}
	
	
	public void getCouponListURL()
	{
		driver.get("https://pre-prod-102.betaout.com/promocode/coupon-list/");
	}
	
	
	public void DynamicPrompt_Continue()
	{
		driver.findElement(By.xpath("//*[contains(@class,'dynamicProperty')]")).click();
	}
	
	
	public void LinkConfirmationPrompt()
	{
		driver.findElement(By.xpath("(//*[@id = 'okButton'])")).click();
	}
	
	
	public void SMSEventActiveURL()
	{
		driver.get("https://qa.betaout.in/sms/event-trigger/nv/status/active");	
	}
	
public Setup_class(WebDriver driver)

{
	this.driver = driver;	
}

								}
	
