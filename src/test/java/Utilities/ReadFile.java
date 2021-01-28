package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadFile {
    Properties properties;

    public ReadFile() {
        File src= new File("src/test/Sources/Info.properties");
        try {

            InputStream fi = new FileInputStream(src);
            properties = new Properties();
            properties.load(fi);

        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }

    }

    public String getUserID(){
        return properties.getProperty("userID");

    }

    public String getPassword(){
        return properties.getProperty("password");
    }
}
