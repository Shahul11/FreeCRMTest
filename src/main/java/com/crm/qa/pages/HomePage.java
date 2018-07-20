package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Shahul Hameed')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	/*@FindBy(xpath = "//a[contains(text(),'New Contact']")
	WebElement newContactLink;*/
	
	@FindBy(linkText = "New Contact")
	WebElement newContactLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}

	public TaskPage clickOnTasksLink() {
		taskLink.click();
		return new TaskPage();
	}

	public boolean validateUserLabel() {

		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}

