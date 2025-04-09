package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() 
	{
		
		logger.info("****************The test case is started**************************");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****************Clicked on MyAccount Link**************************");
		hp.clickRegister();
		logger.info("****************Clicked on Register Link**************************");
		
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		logger.info("****************Providing the customer details**************************");
		regpage.setFirstName(randomString().toUpperCase());//Kiara
		regpage.setLastName(randomString().toUpperCase());//Advani
		regpage.setEmail(randomString()+"@gmail.com");//kiaraadvani@gmail.com
		regpage.setTelephone(randomNumber());//9827288812
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);//Password@12234
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("****************validating the Test Case**************************");
		String confmsg=regpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*******************Testcase TC001 is Finished*************************************");
	}
	
};
