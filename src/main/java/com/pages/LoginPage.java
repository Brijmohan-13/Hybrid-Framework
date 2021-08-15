package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page class---WebElements & its methods
public class LoginPage {	
	
	WebDriver driver;
	DashboardPage dp;
	RegistrationPage rp;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button")
	private WebElement loginButton;
	
	@FindBy(xpath="//img")
	private WebElement logo;
	
	@FindBy(tagName="b")
	private WebElement heading;
	
	@FindBy(tagName="h4")
	private WebElement subHeading;
	
	@FindBy(partialLinkText="Register")
	private WebElement regLink;
	
	public void enterUsername(String name)	{
		userName.sendKeys(name);
	}
	
	public void enterPassword(String pass){
		password.sendKeys(pass);
	}
	
	public boolean isImageVisible(){
		boolean img=logo.isDisplayed();
		return img;
	}
	
	public String getHeadingText(){
		String text=heading.getText();
		return text;
	}
	
	public String getSubHeadingText(){
		String text=subHeading.getText();
		return text;
	}
	
	public String invalidEmailMsg()
	{
		String msg=driver.findElement(By.id("email_error")).getText();
		return msg;
	}

	public String invalidPasswordMsg()
	{
		String msg=driver.findElement(By.id("password_error")).getText();
		return msg;
	}
	
	public String getBlankEmailMsg()
	{
		String msg=driver.findElement(By.id("email_error")).getText();
		return msg;
	}

	public String getBlankPassMsg()
	{
		String msg=driver.findElement(By.id("password_error")).getText();
		return msg;
	}
	
	public void clearEmailBox()
	{
		userName.clear();
	}

	public void clearPasswordBox()
	{
		password.clear();
	}

	public boolean isregBtnClickable()
	{
		return regLink.isEnabled();
	}
	
	public boolean isLoginBtnClickable()
	{
		return loginButton.isEnabled();
	}
	
	public DashboardPage clickLoginBtn(){
		loginButton.click();
		dp=new DashboardPage(driver);			//linking
		return dp;
	}
	
	public RegistrationPage clickRegLink(){
		regLink.click();
		rp=new RegistrationPage(driver);	
		return rp;
	}
	
	
}//class ends