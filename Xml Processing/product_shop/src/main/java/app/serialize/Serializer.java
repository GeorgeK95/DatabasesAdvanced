package app.serialize;

/**
 * Created by User on 2.8.2017 г..
 */
public interface Serializer {

    <T> void serialize(T t, String fileName);

    <T> T deserialize(Class<T> clazz, String fileName);
}
