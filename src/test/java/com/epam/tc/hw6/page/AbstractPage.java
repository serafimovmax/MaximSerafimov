package com.epam.tc.hw6.page;

import com.epam.tc.hw6.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = DriverSingleton.getWebDriver();
    }
}
