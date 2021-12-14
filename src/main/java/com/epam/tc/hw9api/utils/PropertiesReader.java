package com.epam.tc.hw9api.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties;

    public PropertiesReader() {
    }

    public static String getProperty(String getData) {
        String data = "";
        try {
            properties = new Properties();
            properties.load(new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/hw9api/test.properties"));
            data = properties.getProperty(getData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
