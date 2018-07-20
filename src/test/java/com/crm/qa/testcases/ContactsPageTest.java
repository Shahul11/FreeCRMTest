package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPages;
	String sheetName="contacts";

	public ContactsPageTest() {

	}

	@BeforeMethod
	public void setUp() {
		Intilization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPages= new ContactsPage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnContactLink();
		
	} 

	//@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		boolean contactsPagelabel = contactsPages.validateContactsLabel();
		Assert.assertTrue(contactsPagelabel, "contacts Page label not matching");

	}

	//@Test(priority = 2)
	public void selectContactsTest() {
		contactsPages.seleContactsByName("Parul Sharma");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider="getCRMTestData")
	public void verifyNewContactTest(String title, String firstName, String lastName, String companyName)
	{
		homePage.clickOnNewContactLink();
		contactsPages.createNewContact(title,firstName,lastName,companyName);
	}

	@AfterMethod
	public void tearDwown() {
		driver.quit();
	}
}
