package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPages;

	public HomePageTest() {

	}

	@BeforeMethod
	public void setUp() {
		Intilization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepageActualTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homepageActualTitle, "CRMPRO", "Home Page title is not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameLableTest() {
		testUtil.switchToFrame();
		boolean actualLableName = homePage.validateUserLabel();
		Assert.assertTrue(actualLableName);
	}
	
	@Test(priority= 3)
	public void verifyContactsTest()
	{
		testUtil.switchToFrame();
		contactsPages= homePage.clickOnContactLink();
		
	}
	

	@AfterMethod
	public void tearDwown() {
		driver.quit();
	}

}
