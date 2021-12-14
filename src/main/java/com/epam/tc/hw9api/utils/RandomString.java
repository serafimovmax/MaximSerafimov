package com.epam.tc.hw9api.utils;

import org.apache.commons.lang.RandomStringUtils;

public class RandomString {

    public static String generateRandomName() {
        return RandomStringUtils.randomAlphabetic(40);
    }
}
