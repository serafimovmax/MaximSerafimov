package com.epam.tc.hw6.driver.exceptions;

public class WebDriverLaunchTypeException extends IllegalArgumentException {
    public WebDriverLaunchTypeException() {
        super("Unsupported launch type. Supported launch types are local and remote");
    }
}
