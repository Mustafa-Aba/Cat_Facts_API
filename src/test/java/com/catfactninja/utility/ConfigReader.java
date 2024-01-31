package com.catfactninja.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties configFile;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }
}
