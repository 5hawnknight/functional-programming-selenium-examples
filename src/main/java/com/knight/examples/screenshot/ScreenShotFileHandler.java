package com.knight.examples.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface ScreenShotFileHandler {
    Predicate<WebDriver> instanceOfRemoteDriver = driver -> driver instanceof RemoteWebDriver;
    Function<WebDriver,File> remoteDriverScreenshotFile = driver -> ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
    Function<WebDriver,File> webDriverScreenshotFile = driver ->  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    Function<WebDriver,File> getFile = driver -> instanceOfRemoteDriver.test(driver) ? remoteDriverScreenshotFile.apply(driver) :  webDriverScreenshotFile.apply(driver);
    Function<WebDriver,Supplier<File>> getFileV2 = driver -> instanceOfRemoteDriver.test(driver) ? () -> remoteDriverScreenshotFile.apply(driver) : () -> webDriverScreenshotFile.apply(driver);
}