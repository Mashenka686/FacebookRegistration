package com.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.utils.Config;
import com.facebook.utils.Driver;
import com.facebook.utils.Page;

public class EmailPage {

	private WebDriver driver;

	public EmailPage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mail")
	public WebElement email;

	@FindBy(xpath = "//tbody/tr/td[2]")
	WebElement welcomeEmail;

	public String getSecurityCode() {
		Page.waitForElement(welcomeEmail, 5000);
		String code = (welcomeEmail.getText()).replaceAll(" is your Facebook co", " ").replaceAll(" is your Facebook a",
				" ");
		return code;

	}

	public String getEmail() {
		String emailString = email.getAttribute("value");
		System.out.println(emailString);
		return emailString;
	}

	public void open() {
		driver.get(Config.getProperty("email_url"));
	}
}
