package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//constructor

	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	//WebElements
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnkLogin;
	
	//Actions
	
	public void clickMyAccount() 
	{
		lnkMyAccount.click();	
	}
	
    
	public void clickRegister() 
	{
		lnkRegister.click();
	}
	
	public void clickLogin() 
	{
		lnkLogin.click();
	}
}
