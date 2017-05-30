package com.facebook.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public static void waitForElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitForClickable(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
