package com.epam.tc.hw7jdi.utils;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "metalsAndColorsDataSet")
    public static Object[][] metalsAndColorsDataSet() throws IOException {
        return JsonParser.jsonMetalsAndColorsParser("src/test/resources/JDI_ex8_metalsColorsDataSet.json");
    }
}
