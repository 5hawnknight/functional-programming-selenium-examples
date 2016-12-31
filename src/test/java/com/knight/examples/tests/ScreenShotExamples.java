package com.knight.examples.tests;

import com.knight.examples.library.WebDriverHandler;
import com.knight.examples.screenshot.ScreenShot;
import com.knight.examples.screenshot.WebDriverScreenShot;
import com.knight.examples.webdriver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.function.Function;
import java.util.function.Supplier;

public class ScreenShotExamples {

    Function<String,Supplier<String>> applyBuildLocation = name -> () -> String.format("build/screenshots/%s.png",name);
    Function<String,Supplier<String>> applyOutLocation = name -> () -> String.format("out/screenshots/%s.png",name);

    @Test
    public void exampleOne(){
        WebDriverScreenShot.save.accept("filename", ScreenShot.take);
    }
    @Test
    public void exampleTwo(){
        WebDriverScreenShot.saveV2.accept(applyBuildLocation.apply("filename"));
    }
    @Test
    public void exampleThree(){
        WebDriverScreenShot.saveV3.accept(applyOutLocation.apply("filename"));
    }

    @BeforeTest
    public void setup() {
        WebDriverHandler.setWebDriver(Driver.createInstance.apply("chrome"));
    }
    @AfterMethod
    public void tearDown() {
        Driver.quitInstance.accept(WebDriverHandler.getDriver());
    }
}
