package com.epam.tc.hw6.driver;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static WebDriver webDriver;
    private static final long TEN_SECONDS = 10;

    private DriverSingleton() {}

    public static WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            String launchType = System.getProperty("launch.type", "local");
            String browserName = System.getProperty("browser.name", "chrome");
            webDriver = WebDriverFactory.createWebDriver(launchType,
                Browser.valueOf(browserName.toUpperCase(Locale.ROOT)));
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(TEN_SECONDS, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void closeWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
