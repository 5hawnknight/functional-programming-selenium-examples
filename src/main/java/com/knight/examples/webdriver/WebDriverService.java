package com.knight.examples.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

public class WebDriverService
{
	public WebDriver getInstance(String browserType)
	{
		return RegisterWebDrivers.getTypes()
				.filter(isMatchWith(browserType))
				.findFirst()
				.map(registerWebDriver -> registerWebDriver.getWebDriver())
				.orElseThrow(() -> new RuntimeException("the browser type failed to find/match any registered WebDriver"));
	}

	private Predicate<WebDriverType> isMatchWith(String type)
	{
		return registerWebDriver -> registerWebDriver.isWebDriverType(type);
	}
}