package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;

//test class
//loggers can be used in test class as well

public class LoginTest extends TestBase {
	
	WebDriver driver;
	LoginPage lp;
	static DashboardPage dp;
	
	@BeforeSuite
	public void setup()	{
		
		driver=TestBase.initialization();				//only one driver in entire project***********this driver is initialized in TestBase class
		lp=new LoginPage(driver);
	}	
	
	@AfterSuite
	public void closeBrowser(){
		driver.close();
	}
			
	@Test(priority=1)
	public void verifyLogo()
	{
		boolean img=lp.isImageVisible();
		Assert.assertEquals(img, true);
	}
	
	@Test(groups="smoke" , priority=2)
	public void verifyHeading()
	{
		String heading=lp.getHeadingText();
		Assert.assertEquals(heading, "Java By Kiran");
	}
	
	@Test(priority=3)
	public void verifySubHeading()
	{
		String subHeading=lp.getSubHeadingText();
		Assert.assertEquals(subHeading, "JAVA | SELENIUM | PYTHON");
	}
	
	@Test(priority=4)
	public void verifyInvalidEmailMsg()
	{
		lp.enterUsername("brijmohan@gmail.com");
		lp.enterPassword("123456");
		lp.clickLoginBtn();
		String msg=lp.invalidEmailMsg();
		Assert.assertEquals(msg, "Please enter email as kiran@gmail.com");
	}
	
	@Test(priority=5)
	public void verifyInvalidPassMsg()
	{
		lp.clearEmailBox();
		lp.enterUsername("kiran@gmail.com");
		lp.clearPasswordBox();
		lp.enterPassword("654321");
		lp.clickLoginBtn();
		String msg=lp.invalidPasswordMsg();
		Assert.assertEquals(msg, "Please enter password 123456");
	}
	@Test(priority=6)
	public void verifyBlankEmailMsg()
	{
		lp.clearEmailBox();
		lp.enterUsername("");
		lp.clearPasswordBox();
		lp.enterPassword("123456");
		lp.clickLoginBtn();
		String msg=lp.getBlankEmailMsg();
		Assert.assertEquals(msg, "Please enter email");
	}
	
	@Test(priority=7)
	public void verifyBlankPassMsg()
	{
		lp.clearEmailBox();
		lp.enterUsername("kiran@gmail.com");
		lp.clearPasswordBox();
		lp.enterPassword("");
		lp.clickLoginBtn();
		String msg=lp.getBlankPassMsg();
		Assert.assertEquals(msg, "Please enter password.");
	}
	
	@Test(priority=8)
	public void verifyValidLogin()
	{
		lp.clearEmailBox();
		lp.enterUsername("kiran@gmail.com");
		lp.clearPasswordBox();
		lp.enterPassword("123456");
		dp=lp.clickLoginBtn();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
}//class ends