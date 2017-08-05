package app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component(value = "JsonSerializer")
public class JsonParser implements Serializer {

    private Gson gson;

    @Autowired
    private FileParser fileParser;

    public JsonParser() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        this.fileParser = new FileParser();
    }

    @Override
    public <T> void serialize(T t, String fileName) {
        String content = this.gson.toJson(t);
        try {
            this.fileParser.writeFile(fileName, content);
        } catch (IOException e) {
            //log here
            throw new SerializationException("Could not serialize : " + content + " to file : " + fileName , e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> clazz, String fileName) {
        String file = "";
        try {
            file = this.fileParser.readFile(fileName);
            T object = this.gson.fromJson(file, clazz);
            return object;
        } catch (IOException e) {
            // log here
            throw new SerializationException("Could not deserialize to class " + clazz + " from file : " + fileName, e);
        }

    }
}
