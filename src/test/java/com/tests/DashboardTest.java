package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.UsersPage;

//test class
public class DashboardTest extends TestBase {
	
	DashboardPage dp;
	static UsersPage up;
	
	
	
	
	@Test
	public void verifyUsersButton(){
		dp=LoginTest.dp;
		up=dp.clickOnUsersButton();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Users");
	}
	

	
	
	
	
	
	

}