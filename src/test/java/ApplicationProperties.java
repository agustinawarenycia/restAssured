import java.io.IOException;
import java.util.Properties;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;


public class ApplicationProperties {
        public static Properties LoadPropertiesFile(String configProperty) {

        Properties prop = new Properties();
        try {
            prop.load(getClassLoader().getResourceAsStream(configProperty));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
