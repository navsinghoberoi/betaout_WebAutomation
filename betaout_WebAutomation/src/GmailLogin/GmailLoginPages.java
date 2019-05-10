package GmailLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
/**
 * @author - Navpreet
 */
public class GmailLoginPages {

	public WebDriver driver;
	
	
	// Old locators for loggin in
	
/*	By username = By.xpath("//*[@id = 'Email']");
	By nextButton = By.xpath("//*[@id = 'next']");
	By password = By.xpath("//*[@id = 'Passwd']");
	By signIn = By.xpath("//*[@id = 'signIn']");*/
	
	// New locators for loggin in
	By username = By.xpath("//*[@id = 'identifierId']");
	By nextButton = By.xpath("//*[@id = 'identifierNext']");
	By password = By.xpath("//*[@name = 'password']");
	By signIn = By.xpath("//*[@id = 'passwordNext']");
	
	
	By timeForEmail = By.xpath("//*[@class = 'zA zE']/td[8]");
	public By openEmail = By.xpath("(//*[@class='y6'])[1]");
	By emailSubject = By.xpath("//*[@class = 'hP']");
	By emailMessage = By.xpath("(//*[contains(@class,'a3s')])[1]");
	By accountClick = By.xpath("//*[contains(@title,'Google Account:')]");
	By signout = By.xpath("//*[contains(@href,'https://accounts.google.com/Logout?')]");
	By Username = By.xpath("(//*[@class='yX xY '])[1]");
	
	By entersearchData = By.xpath("//*[@name = 'q']");
	By searchButton = By.xpath("//*[@id = 'gbqfb']");
	
	By backToIndex = By.xpath("//*[@aria-label = 'Back to Inbox']");
	
	By Select = By.xpath("//*[@aria-label = 'Select']");
	By Select_All = By.xpath("//*[text() = 'All']");

	By Delete = By.xpath("(//*[@class='asa'])[11]");
	
	By SignInDifferentAccount = By.xpath("//*[@id = 'account-chooser-link']");
	By AddNewAccount = By.xpath("//*[@id = 'account-chooser-add-account']");
	
	By ShowDetailsIcon = By.xpath("//*[@class = 'ajz']");
	By FROM_NameAndEmailDetails = By.xpath("(//*[@class = 'gD'])[1]");
	
	// Additional Locators for Opening Mail
	By MailOptions = By.xpath("//*[@title = 'Google apps']");
	By SelectMail = By.xpath("//*[@id = 'gb23']");
	
	
	public GmailLoginPages(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void enterUsername(String name)
	{
		driver.findElement(username).sendKeys(name);
	}
	
	
	public void nextButtonClick()
	{
		driver.findElement(nextButton).click();
	}
	
	
	public void enterPassword(String pswd)
	{
		driver.findElement(password).sendKeys(pswd);
	}
	
	
	public void signInClick()
	
	{
		driver.findElement(signIn).click();
	}
	
	
	public void printTimeForEmail()
	{
		System.out.println(driver.findElement(timeForEmail).getText());
	}
	
	public void openEmail() throws Exception
	{
		driver.findElement(MailOptions).click();
		Thread.sleep(1500);
		driver.findElement(SelectMail).click();
		Thread.sleep(1500);
		driver.findElement(openEmail).click();
	}
	
	public String printemailSubject()
	{
		String subject = driver.findElement(emailSubject).getText();
		return subject;
	}
	
	public String printemailMessage()
	{
		String message = driver.findElement(emailMessage).getText();
		return message;
	}
	
	public void accountClick()
	{
		driver.findElement(accountClick).click();
	}
	
	public void signout()
	{
		driver.findElement(signout).click();
	}
	
	
	public String printUsername()
	{
		String username = driver.findElement(Username).getText();
		return username;
	}
	
	
	public void entersearchData(String search)
	{
		driver.findElement(entersearchData).sendKeys(search);
	}
	
	public void searchButton()
	{
		driver.findElement(searchButton).click();
	}
	
	
	public void clickBackArrow()
	{
		driver.findElement(backToIndex).click();
	}
	
	public void SelectAllMails() throws Exception
	{
		driver.findElement(Select).click();
		
		System.out.println("1");
		Thread.sleep(2000);
		driver.findElement(Select_All).click();
		
		System.out.println("2");
		Thread.sleep(2000);
	}
	
	
	public void DeleteAllMails()
	{
		driver.findElement(Delete).click();
	}
	
	
	public void SignInDifferentAccount()
	{
		driver.findElement(SignInDifferentAccount).click();
	}
	
	public void AddNewAccount()
	{
		driver.findElement(AddNewAccount).click();
	}
	
	
	public void showDetails()
	{
		driver.findElement(ShowDetailsIcon).click();
	}
	
	
	public String printFROMName()
	{
		String FROM_Name = driver.findElement(FROM_NameAndEmailDetails).getAttribute("name");
		return FROM_Name;
	}
	

	public String printFROMEmailAddress()
	{
		String FROM_EmailAddress = driver.findElement(FROM_NameAndEmailDetails).getAttribute("email");
		return FROM_EmailAddress;
	}

	
	
	
	
	
}
