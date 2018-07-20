package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	


	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement surName;

	@FindBy(name = "client_lookup")
	WebElement companyName;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public boolean validateContactsLabel() {
		return contactslabel.isDisplayed();
	}

	public void seleContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name
				+ "']/parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']"))
				.click();
	}

	public void createNewContact(String title, String fName, String lName, String cName) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		surName.sendKeys(lName);
		companyName.sendKeys(cName);
		saveBtn.click();

	}

}
