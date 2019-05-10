package OnsiteMarketingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author - Navpreet
 */
public class Onsite_Select_Template {

	public WebDriver driver;

	By Popup = By.xpath("(//*[@src = '/images/1-center.png'])"); // Common for
																	// CTA,
																	// Email
																	// signup
																	// and
																	// Mobile
																	// Lead
	By Pullout = By.xpath("(//*[@src = '/images/1-left.png'])"); // Common for
																	// CTA,
																	// Email
																	// signup
																	// and
																	// Mobile
																	// Lead
	By StickyBar = By.xpath("(//*[@src = '/images/infobar.png'])"); // Common
																	// for CTA,
																	// Email
																	// signup
																	// and
																	// Mobile
																	// Lead
	By Inline = By.xpath("(//*[@src = '/images/inline.png'])"); // Common for
																// CTA, Email
																// signup and
																// Mobile Lead
	
	
	By Mobile_Inline = By.xpath("//*[@src= '/images/inSite.png']");

	
	By Banner = By.xpath("(//*[@src = '/images/banner.png'])"); // Common for
																// CTA, Email
																// signup and
																// Mobile Lead
 
	By CTAPopuptemplate = By.xpath("//a[@data-tid = '381']"); 				// Headphones template																						// popup3
	By CTAPullouttemplate = By.xpath("//a[@data-tid = '384']");
	By CTAStickyBartemplate = By.xpath("//a[@data-tid = '385']");
	By CTAInlinetemplate = By.xpath("//a[@data-tid = '383']");
	By CTABannertemplate = By.xpath("//a[@data-tid = '382']");

	By CTATimerPopuptemplate = By.xpath("//a[@data-tid = '416']");          // Timer1
	

	By EmailSignupPopuptemplate = By.xpath("//a[@data-tid = '365']");                // Salutary Template
	By EmailSignupPullouttemplate = By.xpath("//a[@data-tid = '366']");
	By EmailSignupStickyBartemplate = By.xpath("//a[@data-tid = '367']");
	By EmailSignupInlinetemplate = By.xpath("//a[@data-tid = '368']");
	By EmailSignupBannertemplate = By.xpath("//a[@data-tid = '369']");

	By MobileLeadPopuptemplate = By.xpath("//a[@data-tid = '378']"); 		// Get Offer Template																						// Popup
	By MobileLeadPullouttemplate = By.xpath("//a[@data-tid = '379']");
	By MobileLeadStickyBartemplate = By.xpath("//a[@data-tid = '376']");
	By MobileLeadInlinetemplate = By.xpath("//a[@data-tid = '377']");
	By MobileLeadBannertemplate = By.xpath("//a[@data-tid = '375']");
	
	public Onsite_Select_Template(WebDriver driver)

	{
		this.driver = driver;

	}

	public void PopupClick()

	{

		driver.findElement(Popup).click();

	}

	public void PulloutClick()

	{

		driver.findElement(Pullout).click();

	}

	public void StickyBarClick()

	{

		driver.findElement(StickyBar).click();

	}

	public void InlineClick()

	{

		driver.findElement(Inline).click();

	}

	public void BannerClick()

	{

		driver.findElement(Banner).click();

	}

	public void CTAPopuptemplateClick()

	{

		driver.findElement(CTAPopuptemplate).click();

	}

	public void CTAPullouttemplateClick()

	{

		driver.findElement(CTAPullouttemplate).click();

	}

	public void CTAStickyBartemplateClick()

	{

		driver.findElement(CTAStickyBartemplate).click();

	}

	public void CTAInlinetemplateClick()

	{

		driver.findElement(CTAInlinetemplate).click();

	}

	public void CTABannertemplateClick()

	{

		driver.findElement(CTABannertemplate).click();

	}

	
	
	public void CTATimerPopuptemplateClick()

	{

		driver.findElement(CTATimerPopuptemplate).click();

	}
	
	
	
	
	
	
	
	public void EmailSignupPopuptemplateClick()

	{

		driver.findElement(EmailSignupPopuptemplate).click();

	}

	public void EmailSignupPullouttemplateClick()

	{

		driver.findElement(EmailSignupPullouttemplate).click();

	}

	public void EmailSignupStickyBartemplateClick()

	{

		driver.findElement(EmailSignupStickyBartemplate).click();

	}

	public void EmailSignupInlinetemplateClick()

	{

		driver.findElement(EmailSignupInlinetemplate).click();

	}

	public void EmailSignupBannertemplateClick()

	{

		driver.findElement(EmailSignupBannertemplate).click();

	}
	

	public void MobileLeadPopuptemplateClick()

	{

		driver.findElement(MobileLeadPopuptemplate).click();

	}

	public void MobileLeadPullouttemplateClick()

	{

		driver.findElement(MobileLeadPullouttemplate).click();

	}

	public void MobileLeadStickyBartemplateClick()

	{

		driver.findElement(MobileLeadStickyBartemplate).click();

	}

	public void MobileLeadInlinetemplateClick()

	{

		driver.findElement(MobileLeadInlinetemplate).click();

	}

	public void MobileLeadBannertemplateClick()

	{

		driver.findElement(MobileLeadBannertemplate).click();

	}
	
	
	public void Mobile_InlineClick()

	{

		driver.findElement(Mobile_Inline).click();

	}
	

	public void PrintSelectPageDetails()

	{
		String heading1 = driver.findElement(By.xpath("(//*[text() = 'Pop-up'])")).getText();
		String heading2 = driver.findElement(By.xpath("(//*[text() = 'Pullout Tab'])")).getText();
		String heading3 = driver.findElement(By.xpath("(//*[text() = 'Sticky Bar'])")).getText();
		String heading4 = driver.findElement(By.xpath("(//*[text() = 'Inline/Embedded'])")).getText();
		String heading5 = driver.findElement(By.xpath("(//*[text() = 'Banner'])")).getText();

		System.out.println("Name of the headings on the page are = " + heading1 + " " + heading2 + " " + heading3 + " "
				+ heading4 + " " + heading5);

	}

}
