package com.epam.tc.hw4.util;

import com.epam.tc.hw4.driver.DriverSingleton;
import io.qameta.allure.Attachment;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestFailedListener implements ITestListener {

    public void onTestFailure(ITestResult itestresult) {
        WebDriver driver = DriverSingleton.getWebDriver();
        saveScreenshot(driver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] saveScreenshot(WebDriver driver) {
        File screenCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/" + "Screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
