package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//constructor
	
  public LoginPage(WebDriver driver)
  {
	 super( driver);
  }

  //WebElemnet
  
  @FindBy(xpath="//input[@id='input-email']") 
  WebElement txtEmailId;
  
  @FindBy(xpath="//input[@id='input-password']")
  WebElement txtPassword;
  
  @FindBy(xpath="//input[@value='Login']")
  WebElement btnLogin;
  
  //Actions
  
  public void setEmail(String email)
  {
	  txtEmailId.sendKeys(email);
  }
  
  public void setPassword(String pwd)
  {
	  txtPassword.sendKeys(pwd);
  }
  
  public void clickLogin()
  {
	  btnLogin.click();
  }
  
}
