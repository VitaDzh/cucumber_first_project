package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private  static Properties properties = new Properties();

    static{ // whenever u call ConfigReader, this block will be executed first
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) { // FileNotFoundException
            e.printStackTrace();
        }
    }

    //Method to read from properties
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
