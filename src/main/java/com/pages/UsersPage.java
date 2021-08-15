package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class UsersPage extends TestBase {
	
	WebDriver driver;
	
	public UsersPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Add User")
	private WebElement addUserButton;
	
	@FindBy(linkText="LOGOUT")
	private WebElement logoutButton;
	
	@FindBy(xpath="//tr[2]//td[8]")
	private WebElement deleteButton1;
	
	@FindBy(xpath="//tr[3]//td[8]")
	private WebElement deleteButton2;
	
	@FindBy(xpath="//tr[4]//td[8]")
	private WebElement deleteButton3;
	
	@FindBy(xpath="//tr[5]//td[8]")
	private WebElement deleteButton4;
	
	@FindBy(xpath="//th")
	List<WebElement>  headings;
	
	
	
	public boolean verifyHeadings(){
		ArrayList<String> actualHeadings=new ArrayList<String>();
		ArrayList<String> expectedHeadings=new ArrayList<String>();

		for(WebElement heading :headings )
		{
			String name=heading.getText();
			actualHeadings.add(name);
		}
		expectedHeadings.add("#");
		expectedHeadings.add("Username");
		expectedHeadings.add("Email");
		expectedHeadings.add("Mobile");
		expectedHeadings.add("Course");
		expectedHeadings.add("Gender");
		expectedHeadings.add("State");
		expectedHeadings.add("Action");
		
		if(actualHeadings.equals(expectedHeadings))
			return true;
		else 
			return false;
	}
	

}
