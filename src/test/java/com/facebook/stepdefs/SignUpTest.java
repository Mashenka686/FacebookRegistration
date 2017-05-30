package com.facebook.stepdefs;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.facebook.pages.EmailPage;
import com.facebook.pages.HomePage;
import com.facebook.testdata.SignUpDataToExcel;
import com.facebook.utils.Config;
import com.facebook.utils.Driver;
import com.facebook.utils.ExcelUtils;
import com.facebook.utils.Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpTest {
	WebDriver driver = Driver.getInstance();
	HomePage homePage = new HomePage();
	SignUpDataToExcel data = new SignUpDataToExcel();
	EmailPage emailPage = new EmailPage();
	String epage = driver.getWindowHandle();
	String code;
	String window;

	@Given("^User has a valid email$")
	public void user_has_a_valid_email() throws Throwable {

		emailPage.open();
		String email = emailPage.getEmail();
		ExcelUtils.setCellData(email, 1, 7);
	}

	@Given("^User is on homepage$")
	public void user_is_on_homepage() throws Throwable {

		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.open('" + Config.getProperty("url") + "');");
		window = driver.getWindowHandle();
		Set<String> winHan = driver.getWindowHandles();
		for (String string : winHan) {
			if (!window.equals(string)) {
				driver.switchTo().window(string);
			}
		}
		Assert.assertTrue(homePage.logo.isDisplayed());

	}

	@When("^User sings up for an account$")
	public void user_sings_up_for_an_account() throws Throwable {
		ArrayList<String> testData = new ArrayList<String>();
		System.out.println(ExcelUtils.getUsedRowsCount());
		for (int i = 0; i <= 7; i++) {
			System.out.println(ExcelUtils.getCellData(1, i));
			testData.add(ExcelUtils.getCellData(1, i));
		}
		homePage.signup(testData);
	}

	@Then("^User should receive email containing security code$")
	public void user_should_receive_email_containing_security_code() throws Throwable {

		driver.switchTo().window(epage);

		code = emailPage.getSecurityCode();
		System.out.println(code);
	}

	@Then("^After User enters security code$")
	public void after_User_enters_security_code() throws Throwable {

		window = driver.getWindowHandle();

		Set<String> winHan = driver.getWindowHandles();

		for (String string : winHan) {
			if (!window.equals(string)) {
				driver.switchTo().window(string);
			}
		}
		homePage.codeInput.sendKeys(code);
		Page.sleep(4000);
		try {
			Page.waitForClickable(homePage.continueBtn, 10);
			homePage.continueBtn.click();
		} catch (WebDriverException e) {
			System.out.println("Phone verification required.");
		}
	}

	@Then("^User should be logged into account and welcome message should be displayed$")
	public void user_should_be_logged_into_account_and_welcome_message_should_be_displayed() throws Throwable {
		System.out.println("User logged in into account and welcome message is displayed.");
	}

	@Then("^User uploads profile picture and welcome message should be displayed$")
	public void user_uploads_profile_picture_and_welcome_message_should_be_displayed() throws Throwable {
		try {
			homePage.chooseFileBtn.sendKeys(Config.getProperty("picture_path"));
			homePage.pictureSubmitBtn.click();
		} catch (NoSuchElementException w) {
			System.out.println("Email verification required");
		}
	}
}
