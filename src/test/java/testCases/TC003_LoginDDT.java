
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")//getting data providers from different class package 
	public void verify_LoginDDT(String email, String pwd, String res)
	{
		logger.info("*****************Starting the TCOO3_LoginDDT**********************");
		
		try {
			
	
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/* Data is valid  -login success- Test Passed
		                  -login failed - Test Failed
		 
		   Data is invalid -login success -Test Failed
		                   -login failed - Test Passed
		                 
		 */
		
		if(res.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		if(res.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		 }
		} 
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}
