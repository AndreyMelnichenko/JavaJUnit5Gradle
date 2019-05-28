package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesCache {
    private static PropertiesCache INSTANCE = new PropertiesCache();
    private final Properties configProp = new Properties();
    private String fileName = "test.properties";

    private PropertiesCache() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return INSTANCE.configProp.getProperty(key);
    }
}
