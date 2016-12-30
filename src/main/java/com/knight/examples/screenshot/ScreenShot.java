package com.knight.examples.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface ScreenShot
{
    Function<String,Supplier<String>> applyStandardLocation = name -> () -> String.format("build/screenshots/%s.png",name);

    BiConsumer<File,Supplier<String>> copyFile = (file,location) -> {
        try {
            FileUtils.copyFile(file, new File(location.get()));
        } catch (IOException ioe) {}
    };
    BiConsumer<File,File> copyFileV2 = (fromFile,toFile) -> {
        try {
            FileUtils.copyFile(fromFile, toFile);
        } catch (IOException ioe) {}
    };
    BiConsumer<Supplier<File>,Supplier<File>> copyFileV3 = (fromFile,toFile) -> {
        try {
            FileUtils.copyFile(fromFile.get(), toFile.get());
        } catch (IOException ioe) {}
    };

    BiConsumer<WebDriver,String> take = (driver,name) ->
        copyFile.accept(ScreenShotFileHandler.getFile.apply(driver), applyStandardLocation.apply(name));

    BiConsumer<WebDriver,Supplier<String>> takeV2 = (driver,location) ->
        copyFile.accept(ScreenShotFileHandler.getFile.apply(driver),location);

    BiConsumer<WebDriver, Supplier<File>> takeV3 = (driver, file) ->
            copyFileV2.accept(ScreenShotFileHandler.getFile.apply(driver), file.get());

    BiConsumer<WebDriver, Supplier<File>> takeV4 = (driver, file) ->
            copyFileV3.accept(ScreenShotFileHandler.getFileV2.apply(driver), file);
}