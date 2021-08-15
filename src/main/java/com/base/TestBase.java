package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TestBase class is the super class of all the classes in project
//contains driver initialization method()
//contains property file reading method()
//contains Logger class(Logger info is used to print msg in Logger file)

//with crtl + o --->we can see all methods/variables of class

//TestBase class is the best class to write common code
public class TestBase {

	public static WebDriver driver;											//driver is made public and static since it is to be used for entire project
	public static Logger log=Logger.getLogger(TestBase.class);				//dependency apache.log4j....current class is passed through constructor
	static FileInputStream fis;												//from java.io package
	
	public static String readProperty(String key)
	{	log.info("Reading a value of property :"+key);
		Properties prop=new Properties();									//Properties class is in java.util package like collection
		try {
				log.info("Initializing property file");
				fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
				prop.load(fis);
			} 
		catch (Exception e) {
			log.error("Invalid Property file path");
			e.printStackTrace();
		    }
		log.info("Value of property for the key :" +key+" is "+readProperty(key));
		return prop.getProperty(key);											//returns value of property by passing key/property
																				//like getAttribute(); of webelement returns value of attribute by passing attribute
	}
	
	public static WebDriver initialization() {
		log.info("Initializing browser");		
		if(readProperty("browser").equals("chrome"))
				{	log.info("User wants to test with Chrome browser");
					System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
					driver=new ChromeDriver();
				}
		
		else if(readProperty("browser").equals("firefox"))
			{	
			log.info("User wants to test with Firefox browser");
			System.getProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			}
		
		else{
			log.info("User wants to test with Invalid browser");
			System.out.println("Invalid browser");
			return null;
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);			//for complete page--always gives Timeout Exception 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);			//implicit wait--always gives NoSuchElementException
																					//explicit wait works on particular WebElement (see DriverUtils class for explicit wait code )
//		Thread.sleep(40);
																					
		log.info("launching an application");
		driver.get(readProperty("url"));
		return driver;
	}
	
	public static void getScreenshot(WebDriver driver,String name)											//return type can be changed to String.....i.e. screenshot path
	{
		log.info("Test case failed and taking screenshot");
		TakesScreenshot ts=(TakesScreenshot)driver;					//dependency apache commons-io	
		File src=ts.getScreenshotAs(OutputType.FILE);				//File class is from java.io
		File dest=new File(System.getProperty("user.dir")+"/screenshots/"+name+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) {
			e.printStackTrace();

		log.info("Screenshot saved in the project directory");}
//		log.callAppenders("this method can be used for all Log  messages");
	}
	
	//unit testing means testing our code...developer also do white box testing...with dummy value
	
	public static void main(String[] args) {
		readProperty("browser");
		initialization();
		getScreenshot(driver, "demo");
		}
	
}//class ends
//extent report code will be in this class from ojt 
//page linking is optional
//comments added in .java file is with //
//comments added in .feature file and .properties file is with #
//comments added in .xml file is with	 <!--  -->