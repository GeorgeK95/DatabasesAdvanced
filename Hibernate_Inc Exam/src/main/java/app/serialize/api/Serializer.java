package app.serialize.api;

public interface Serializer {

    <T> void serialize(T serializable, String filePath);

    <T> T deserialize(Class<T> classType, String filePath);
}
