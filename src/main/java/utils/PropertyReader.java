package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public final static String CONFIG_PROPERTIES_DIRECTORY = "config.properties";
    public String getPropValues(String propName)
    {	Properties prop= new Properties();
        InputStream input = null;
        try {

            input = getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES_DIRECTORY);

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty(propName));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop.getProperty(propName);

    }

}

