package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") + "/config/properties/configuration.properties";
    private static Properties properties = new Properties();

    // Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    // Get all configuration data and assign to related fields.
    private void loadData() {
        try {
            // Read configuration.properties file
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public String getV1Uri() {
        return properties.getProperty("v1Uri");
    }

    public String getV2Uri() {
        return properties.getProperty("v2Uri");
    }
}