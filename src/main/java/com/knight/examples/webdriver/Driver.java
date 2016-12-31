package com.knight.examples.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Driver {
    Function<String,WebDriver> createInstance = (String browserType) -> new WebDriverService().getInstance(browserType);
    Consumer<WebDriver> quitInstance = (WebDriver driver) -> Optional.ofNullable(driver).ifPresent(d -> driver.quit());
}
