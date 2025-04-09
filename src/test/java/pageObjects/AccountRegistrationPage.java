package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{
	
	//constructor
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//WebElements
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	//WebElement txtLastName = driver.findElement(RelativeLocator.with(By.xpath("//input[@id='input-lastname']")).below(txtFirstName));
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	
	public void setPrivacyPolicy()
	{
		chkAgree.click();
	}
	
	public void clickContinue() 
	{
		
		//sloution1
		btnContinue.click();
		
		/*//solution 2
		btnContinue.submit();
		
		//solution3
		Actions act = new Actions(driver);
	    act.moveToElement(btnContinue).click().perform();
	    
	    //solution 4
	    JavascriptExecutor js=  (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", btnContinue);
	    
	    //solution 5
	    btnContinue.sendKeys(Keys.RETURN);
	    
	    //solution 6
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	    */
	    
		
	}
	
	public String getConfirmationMsg() 
	{
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
}

