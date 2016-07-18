package reader.parsers;

import reader.EnvException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JavaPropertiesParser implements PropertyParser {

    private final Properties properties;

    public JavaPropertiesParser(InputStream inputStream) {
        try {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new EnvException(e);
        }
    }

    @Override
    public String get(String property) {
        return properties.getProperty(property);
    }

    @Override
    public void reLoad() {
        //each call to get always gets the latest value
    }
}
