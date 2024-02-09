package saveAndLoad;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class JacksonAPI {
    private static ObjectMapper mapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saving(Object obj, String filePath) {
        try {
            File file = new File(filePath);
            if(filePath.endsWith(".json")) {
                mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                mapper.writeValue(file, obj);
            }
            if(filePath.endsWith(".xml")){
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
                xmlMapper.writeValue(file, obj);
            }
            if(filePath.endsWith(".yaml")){
                mapper = new ObjectMapper(new YAMLFactory());
                mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                mapper.writeValue(file, obj);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static Object loading(String filePath, Class<?> clazz){
        Object obj = null;
        File file = new File(filePath);
        try {
            if(filePath.endsWith(".json") || filePath.endsWith(".yaml")) obj = mapper.readValue(file, clazz);
            if(filePath.endsWith(".xml")) obj = xmlMapper.readValue(file, clazz);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return obj;
    }
}
