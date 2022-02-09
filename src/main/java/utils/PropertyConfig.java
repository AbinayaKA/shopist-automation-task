package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {

    Properties properties;
    FileInputStream fileInputStream;
    String propertiesFile = "";

    public PropertyConfig(String propertiesFile) throws IOException {

        this.propertiesFile = propertiesFile;
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(propertiesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties.load(fileInputStream);
    }

    public String getProperty(String key) {

        String value = properties.getProperty(key);
        return value.trim();
    }

}
