package com.knight.examples.tests;

import com.knight.examples.screenshot.ScreenShot;
import com.knight.examples.screenshot.WebDriverScreenShot;

import java.util.function.Function;
import java.util.function.Supplier;

public class TakeScreenShotExamples {

    Function<String,Supplier<String>> applyBuildLocation = name -> () -> String.format("build/screenshots/%s.png",name);
    Function<String,Supplier<String>> applyOutLocation = name -> () -> String.format("out/screenshots/%s.png",name);

    public void exampleOne(){
        WebDriverScreenShot.save.accept("filename", ScreenShot.take);
    }
    public void exampleTwo(){
        WebDriverScreenShot.saveV2.accept(applyBuildLocation.apply("filename"));
    }
    public void exampleThree(){
        WebDriverScreenShot.saveV3.accept(applyOutLocation.apply("filename"));
    }
}
