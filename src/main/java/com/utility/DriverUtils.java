package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class DriverUtils extends TestBase{
	
	//explicit wait will be for webelement
	//if the webelement is not found within the given time,gives exception

	public void waitForElement(WebElement element,int time){
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
