package test;

import org.testng.annotations.*;
import generic_project.*;
import pages.*;

public class HomepageTest extends Baseclass {
	Homepage home;
	Loginpage login;

	@BeforeMethod
	public void setup()
	{
		home=new Homepage(driver);
		login=new Loginpage(driver);
	}
	
	@Test
	public void toMobileSection()
	{
		home.toMobile();
	}
	
	@Test
	public void toSmartMobile()
	{
		home.toSmartMobile();
	}
	
//	@Test
//	public void mobileSection()
//	{
//		home.toProd();
//	}
	
}

