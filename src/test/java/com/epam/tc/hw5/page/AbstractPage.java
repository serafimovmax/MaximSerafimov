package com.epam.tc.hw5.page;

import com.epam.tc.hw5.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver webDriver;


    protected abstract AbstractPage openPage();

    protected static final int WAIT = 10;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = DriverSingleton.getWebDriver();
    }
}
