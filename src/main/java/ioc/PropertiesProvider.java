package ioc;

import com.google.inject.Provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesProvider implements Provider<Properties> {

    @Override
    public Properties get() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties config = new Properties();
        try {
            try(InputStream resourceStream = loader.getResourceAsStream("config.properties")) {
                assert resourceStream != null;
                config.load(resourceStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return config;
    }
}
