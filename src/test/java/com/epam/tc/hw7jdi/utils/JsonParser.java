package com.epam.tc.hw7jdi.utils;

import com.epam.tc.hw7jdi.entities.MetalsAndColorsData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonParser {

    public static Object[][] jsonMetalsAndColorsParser(String path) throws IOException {
        Object[][] dataObject;
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, MetalsAndColorsData>>() {
        }.getType();
        Map<String, MetalsAndColorsData> myMap = gson.fromJson(new JsonReader(new FileReader(path)), type);
        int i = 0;
        dataObject = new Object[myMap.size()][1];
        for (Map.Entry<String, MetalsAndColorsData> entry : myMap.entrySet()) {
            dataObject[i][0] = entry.getValue();
            i++;
        }
        return dataObject;
    }
}
