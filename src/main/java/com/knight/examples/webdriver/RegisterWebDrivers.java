package com.knight.examples.webdriver;

import java.util.stream.Stream;

public interface RegisterWebDrivers
{
    static Stream<WebDriverType> getTypes()
    {
        return Stream.of(
                new Firefox(),
                new Chrome(),
                new Safari()
        );
    }
}