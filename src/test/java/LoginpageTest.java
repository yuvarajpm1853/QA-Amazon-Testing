import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import generic_project.*;
import pages.*;

public class LoginpageTest extends Baseclass {
	Homepage home;
	Loginpage login;

	@BeforeMethod
	public void setup()
	{
		home=new Homepage(driver);
		login=new Loginpage(driver);
	}
		
	@Test(dataProvider="credentials",dataProviderClass=utilityclass.class)
	public void verifyLoginFunctionality(String testcase,String cred,String password,String result) throws IOException
	{
		home.ToLogin();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		login.enterCred(cred);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		if(testcase.equals("valid"))
		{
			login.enterPWD(password);
			String actResult = login.verifyURL();
			boolean isStringPresent = false;	
			String[] resultArray = {"https://www.amazon.in/?ref_=nav_ya_signin","https://www.amazon.in/ap/signin",
					"https://www.amazon.in/?_encoding=UTF8&ref_=nav_ya_signin"};
	        for (String res : resultArray) {
	            if (res.equals(actResult)) {
	                isStringPresent = true;
	                break;
	            }
	        }

	        Assert.assertTrue(isStringPresent, "Expected string is not present in the result array");
	    }
		
		else if (testcase.equals("invalid"))
		{
			String actResult = login.getErrorMsg();
			String expResult = result;
			Assert.assertEquals(actResult,expResult);
		}
		else if (testcase.equals("empty"))
		{
//			
//			Enter your email or mobile phone number
			String actResult = login.getErrorMsg();
//			String expResult = result;	
			boolean isStringPresent = false;	
			String[] resultArray = {"Wrong or Invalid email address or mobile phone number. Please correct and try again.","Enter your mobile number or email","Enter your email or mobile phone number"};
		    for (String res : resultArray) {
		        if (res.equals(actResult)) {
		            isStringPresent = true;
		            break;
		        }
    }

    Assert.assertTrue(isStringPresent, "ERROER");
		}
		
	}
}
