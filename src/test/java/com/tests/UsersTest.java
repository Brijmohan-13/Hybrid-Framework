package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.UsersPage;

public class UsersTest extends TestBase  {	
	
	UsersPage up;
	
	
	
	@Test
	public void verifyTitle()
	{
		up=DashboardTest.up;
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Users");
	}
	
	
	@Test
	public void validateHeadings(){
		boolean value=up.verifyHeadings();
		Assert.assertTrue(value);
		
	}
	
}


