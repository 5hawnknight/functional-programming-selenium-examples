package com.knight.examples.tests;

import com.knight.examples.library.WebDriverHandler;
import com.knight.examples.webdriver.Driver;
import org.testng.annotations.Test;

public class WebDriverExamples {

    @Test
    public void exampleOne(){
        WebDriverHandler.setWebDriver(Driver.createInstance.apply("chrome"));
        try { Thread.sleep(3000); } catch (Exception e) {}
        Driver.quitInstance.accept(WebDriverHandler.getDriver());
    }
}
