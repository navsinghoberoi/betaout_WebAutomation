package common_Classes;

import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
/**
 * @author - Navpreet
 */
public class Loginpage {

	public WebDriver driver;
	
	By login = By.xpath("//a[text() = 'log in']");
	By username =  By.xpath(".//*[@id='user_name']");
	By password =	By.xpath(".//*[@id='pwd']"); // password
	By clicklogin = By.xpath("//*[@name = 'submit']");

	
	public Loginpage(WebDriver driver)
	
	{
		this.driver = driver;
		
	}

public void loginbutton()

{
	
driver.findElement(login).click();

}


public void uname(String name)

{
	
driver.findElement(username).sendKeys(name);

}

public void upswd(String pass)

{
	
driver.findElement(password).sendKeys(pass);

}

public void ulogin()

{
	
driver.findElement(clicklogin).click();

}





					}