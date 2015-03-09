package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-10-9
 * Time: ÏÂÎç3:11
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesOp {

    public static void main(String[] args){
        PropertiesOp propertiesOp = new PropertiesOp();
//        propertiesOp.load("role_image_array_names.properties");
        propertiesOp.load("titleimgpath.properties");
    }

    public Properties load(String properties_name){
        Properties properties = new Properties();
//        System.out.println("properties_name="+properties_name);
//        InputStream inputstream = ClassLoader.getSystemResourceAsStream(properties_name);
        InputStream inputstream = this.getClass().getResourceAsStream(properties_name);
        try {
            properties.load(inputstream);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Enumeration<String> enumvalue = (Enumeration<String>) properties.propertyNames();
//
//        while(enumvalue.hasMoreElements()){
//            String key = enumvalue.nextElement();
//            System.out.println(key + " : "+ properties.getProperty(key));
//        }

        return properties;
    }
}

