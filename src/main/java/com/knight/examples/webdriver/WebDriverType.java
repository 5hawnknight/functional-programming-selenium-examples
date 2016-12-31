package com.knight.examples.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverType
{
	WebDriver getWebDriver();
	boolean isWebDriverType(String type);
}
