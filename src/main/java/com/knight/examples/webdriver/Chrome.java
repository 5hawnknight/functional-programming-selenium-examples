package com.knight.examples.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chrome implements WebDriverType
{
	@Override
	public WebDriver getWebDriver()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.2.27");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        return new ChromeDriver(capabilities);
	}

	@Override
	public boolean isWebDriverType(String type)
	{
		return StringUtils.equalsIgnoreCase("chrome", type);
	}
}