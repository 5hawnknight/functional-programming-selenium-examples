package com.knight.examples.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements WebDriverType
{
	@Override
	public boolean isWebDriverType(String type)
	{
		return StringUtils.equalsIgnoreCase("firefox", type);
	}
	@Override
	public WebDriver getWebDriver()
	{
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.v0.11.1.mac");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);
        return driver;
	}
}