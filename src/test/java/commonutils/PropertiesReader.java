package commonutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesReader {

    static Properties props = new Properties();
    
    public PropertiesReader() {
    	readProperties();
    }

    public void readProperties() {
        try {
            String projectPath = System.getProperty("user.dir");

            String filePath1 = projectPath+"/configurations/config.properties";
            String filePath2 = projectPath+"/configurations/extent.properties";
            String filePath3 = projectPath+"/src/test/resources/properties/application.properties";

            props.load(Files.newInputStream(Paths.get(filePath1)));
            props.load(Files.newInputStream(Paths.get(filePath2)));
            props.load(Files.newInputStream(Paths.get(filePath3)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return props.getProperty(key);
    }

    public void setValue(String key,String value) {
        props.setProperty(key,value);
    }
}