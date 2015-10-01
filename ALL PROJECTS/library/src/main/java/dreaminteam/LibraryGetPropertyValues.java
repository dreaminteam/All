package dreaminteam;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dreaminteam on 7.4.15.
 */
public class LibraryGetPropertyValues {

    public String getPropValues(String key) throws IOException{

        String result="";
        Properties properties=new Properties();
        String propertiesFile="config.properties";

        try {
            InputStream stream=getClass().getClassLoader().getResourceAsStream(propertiesFile);
            properties.load(stream);
            result=properties.getProperty(key);
        } catch (Exception e){
            System.out.println("File "+propertiesFile+" not found");
            e.printStackTrace();
        }
        return result;
    }
}
