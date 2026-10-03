package com.fooddiary.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String path = System.getProperty("user.dir") +
                    "/src/main/resources/config.properties";
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(String key) {
        return properties.getProperty(key);
    }
}