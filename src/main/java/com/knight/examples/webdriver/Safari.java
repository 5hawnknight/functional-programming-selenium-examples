package com.knight.examples.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari implements WebDriverType
{
	@Override
	public boolean isWebDriverType(String type)
	{
		return StringUtils.equalsIgnoreCase("safari", type);
	}
	@Override
	public WebDriver getWebDriver()
	{
	    WebDriver driver = new SafariDriver();
        return driver;
	}
}