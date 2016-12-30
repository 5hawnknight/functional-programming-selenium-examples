package com.knight.examples.screenshot;

import com.knight.examples.library.WebDriverHandler;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface WebDriverScreenShot {
    BiConsumer<String, BiConsumer<WebDriver,String>> save = (fileName, function) -> {
        function.accept(WebDriverHandler.getDriver(),fileName);
    };
    Consumer<Supplier<String>> saveV2 = location -> {
        ScreenShot.takeV2.accept(WebDriverHandler.getDriver(),location);
    };
    Consumer<Supplier<String>> saveV3 = location -> {
        ScreenShot.takeV3.accept(WebDriverHandler.getDriver(), () -> new File(location.get()));
    };
}