package com.ap.ui.base;              // import dependencies

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase {      // mother code

	public static WebDriver driver;  // supperclass

	public static Properties propt;// get information from base

	public static EventFiringWebDriver en_driver; // en-driver is a object// event firing web driver is invoke en_driver

	public static WebEventListener eventListener;  //

	public TestBase() { // we use constructor,using a try catch method to work with and access config file

		
		try {
			propt = new Properties();
FileInputStream ipa = new FileInputStream(System.getProperty("user.dir") + "/automation1/src/main/java/com/ap/ui/config/config.properties");
			// (user.direct) use to understand i am using directory
			propt.load(ipa); // 
		}  catch (FileNotFoundException e) {  
			e.printStackTrace();
        }
		// when we work file we should use try catch bug
		// when we use file class we should use IOE exception
        catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static void initialization() { //invoking which method i am using it
		String browserName = propt.getProperty("broswer");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
			} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","path of gecko driver");
           driver = new FirefoxDriver(); // calling new driver
		} else if (browserName.equalsIgnoreCase("IE")) {
          System.setProperty("webdriver.ie.driver", "path of ie driver");
           driver = new InternetExplorerDriver();
		}
		// it will handle the web driver
		// creating object for action that's occurring and sharing with driver
		en_driver = new EventFiringWebDriver(driver);
		// creating object of webeventListener to register it with
		// even firing Webdriver
		eventListener = new WebEventListener();
		en_driver.register(eventListener);
		// event can be captured based on the method we create webEvventListener
		
		// since we know driver object is for bowaser_en driver is for event.
		// that taking place.

		// we declaring with equal to each when they are exchanging the info
		driver = en_driver;
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_laod, TimeUnit.SECONDS);
        driver.get(propt.getProperty("url"));
	}

    
}
