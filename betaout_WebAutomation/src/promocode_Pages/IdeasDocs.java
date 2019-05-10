package promocode_Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class IdeasDocs {

	public WebDriver driver;
	
	By Resources = By.xpath("(//*[text() = 'Resources'])[2]");
	By Templates = By.xpath("(//*[text() = 'Templates'])[2]");
	By APIDocs = By.xpath("(//*[@href = '/ideas/api-v2'])[3]");
	By PluginsNExtensions = By.xpath("(//*[text() = 'Plugins & Extensions'])[2]");
	By APIKey = By.xpath("(//*[text() = 'API Key'])[3]");
	By Glossary = By.xpath("(//*[text() = 'Glossary'])[2]");

	
	public IdeasDocs(WebDriver driver)
	
	{
		this.driver = driver;
	
	}
	
	
	public void ResourcesClick()

	{
		driver.findElement(Resources).click();
		
	}

	public void TemplatesClick()
	
	{
	
		driver.findElement(Templates).click();
	}
	
	public void APIDocsClick()
	
	{

		driver.findElement(APIDocs).click();
	}
	
	public void PluginsNExtensionsClick()

	{

	driver.findElement(PluginsNExtensions).click();
	
	}

	public void APIKeyClick()

	{

	driver.findElement(APIKey).click();
	
	}

	public void GlossaryClick()

	{

	driver.findElement(Glossary).click();
	
	}

	
}
