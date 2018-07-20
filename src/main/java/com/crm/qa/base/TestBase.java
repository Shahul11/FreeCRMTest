package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

	public TestBase() {
		try {
			FileInputStream fis = new FileInputStream(
					new File("C:/Users/310259741/Documents/ProjectManagment/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties"));
			properties = new Properties();

			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Intilization() {
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:/Users/310259741/Documents/ProjectManagment/FreeCRMTest/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:/Users/310259741/Documents/ProjectManagment/FreeCRMTest/drivers/geckodriver.exe");
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		
	}

}
