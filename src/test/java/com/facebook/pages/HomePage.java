package com.facebook.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.utils.Config;
import com.facebook.utils.Driver;
import com.facebook.utils.Page;

public class HomePage {
	private WebDriver driver;

	public HomePage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i")
	public WebElement logo;

	@FindBy(xpath = "(//input[@placeholder])[1]")
	public WebElement firstName;

	@FindBy(name = "lastname")
	public WebElement lastName;

	@FindBy(name = "reg_email__")
	public WebElement email;

	@FindBy(name = "reg_email_confirmation__")
	public WebElement emailCheck;

	@FindBy(name = "reg_passwd__")
	public WebElement password;

	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	public WebElement firstMailTitle;

	@FindBy(name = "birthday_month")
	public WebElement month;

	@FindBy(name = "birthday_day")
	public WebElement day;

	@FindBy(name = "birthday_year")
	public WebElement year;

	@FindBy(xpath = "(//input[@name='sex'])[1]")
	public WebElement female;

	@FindBy(xpath = "(//input[@name='sex'])[2]")
	public WebElement male;

	@FindBy(name = "websubmit")
	public WebElement createAccountBtn;

	@FindBy(name = "code")
	public WebElement codeInput;

	@FindBy(name = "confirm")
	public WebElement continueBtn;

	@FindBy(name = "submit[Continue]")
	public WebElement pictureSubmitBtn;

	@FindBy(name = "upload_meta")
	public WebElement chooseFileBtn;

	public void open() {
		driver.get(Config.getProperty("url"));
		Page.sleep(1000);
	}

	public void signup(ArrayList<String> list) {

		firstName.sendKeys(list.get(0));
		lastName.sendKeys(list.get(1));
		email.sendKeys(list.get(7));
		emailCheck.sendKeys(list.get(7));
		password.sendKeys(list.get(2));
		Select sDay = new Select(day);
		sDay.selectByValue(list.get(3));
		Select sMonth = new Select(month);
		sMonth.selectByValue(list.get(4));
		Select sYear = new Select(year);
		sYear.selectByValue(list.get(5));
		if (list.get(6).equals("female")) {
			female.click();
		} else {
			male.click();
		}
		createAccountBtn.click();

	}
}
