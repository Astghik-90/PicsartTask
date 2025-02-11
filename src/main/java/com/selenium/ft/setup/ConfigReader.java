package com.selenium.ft.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties PROPERTIES;

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/configuration.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + e.getMessage());
        }
    }

    public static String getBaseURL() {
        return PROPERTIES.getProperty("base.url");
    }

    public static String getEditorPath() {
        return PROPERTIES.getProperty("editorPath");
    }

    public static String getImagePath(){
        return PROPERTIES.getProperty("imagePath");
    }
}

