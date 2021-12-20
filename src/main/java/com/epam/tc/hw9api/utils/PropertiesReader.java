package com.epam.tc.hw9api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties;

    public PropertiesReader() {
    }

    public static String getProperty(String getData) {
        String data = "";
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                        + "/src/test/resources/hw9api/test.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
            data = properties.getProperty(getData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
