package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	UsersPage up;
	
	public DashboardPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Users")
	private WebElement usersButton;
	
	@FindBy(linkText="Operators")
	private WebElement opearatorsButton;
	
	@FindBy(partialLinkText="Links")
	private WebElement usefulLinksButton;
	
	@FindBy(linkText="Downloads")
	private WebElement downloadsButton;
	
	@FindBy(linkText="Logout")
	private WebElement logoutButton1;

	@FindBy(linkText="LOGOUT")
	private WebElement logoutButton2;
	
	@FindBy(xpath="//h3[text()='Selenium']")
	private WebElement courseSel;
	
	@FindBy(xpath="//h3[text()='Java / J2EE']")
	private WebElement courseJava;
	
	@FindBy(xpath="//h3[text()='Python']")
	private WebElement coursePython;
	
	@FindBy(xpath="//h3[text()='Php']")
	private WebElement coursePhp;
	
	@FindBy(xpath="//h3[text()='Automation Testing']")
	private WebElement domain1;
	
	@FindBy(xpath="//h3[text()='Software Development']")
	private WebElement domain2;
	
	@FindBy(xpath="//h3[text()='Data Science']")
	private WebElement domain3;
	
	@FindBy(xpath="//h3[text()='Web Development']")
	private WebElement domain4;
	
	@FindBy(xpath="//h3[text()='Selenium']//following::a[1]")
	private WebElement moreInfoBtn1;
	
	@FindBy(xpath="//h3[text()='Selenium']//following::a[2]")
	private WebElement moreInfoBtn2;
	
	@FindBy(xpath="//h3[text()='Selenium']//following::a[3]")
	private WebElement moreInfoBtn3;
	
	@FindBy(xpath="//h3[text()='Selenium']//following::a[4]")
	private WebElement moreInfoBtn4;
	
	
	public UsersPage clickOnUsersButton(){
		usersButton.click();
		up=new UsersPage(driver);
		return up;
	}
	

	
	
	
	
	
	
	
	
	
	

}
