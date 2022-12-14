package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties getLoadedPropertiesObject() throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("config/project.properties");

        // 2. create the object of Properties class
        Properties prop = new Properties();

        // 3. load this object with the file object
        prop.load(fis);

        return prop;
    }

    public static String getUrl() throws IOException {

        return getLoadedPropertiesObject().getProperty("url");
    }


}
