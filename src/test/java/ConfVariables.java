public class ConfVariables {


    public static String getProperty(String configProperty,String property){
        return ((String) ApplicationProperties.LoadPropertiesFile(configProperty).get(property));
    }

}
