package TryPackage;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author - Navpreet
 */
public class WebdriverInterface implements WebDriver {

	
	public WebDriver driver;
	
	
	
	public void add()
	{
		System.out.println("Function not related to interface");
	}
	
	public void sub()
	{
		System.out.println("Function not related to interface");
	}

	
	
	
	
	

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	
		@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}


		@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}


		@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void get(String URL) {
		System.out.println("This get function is overridden by Nav");
		System.out.println("URL to be opened by this command = " +URL);
	}
	
	
	
	
	
	
	
	
}
