package app.serialize;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component(value = "XMLSerializer")
public class XmlParser implements Serializer {

    @Override
    public <T> void serialize(T t, String fileName) {
//        String path = System.getProperty("user.dir") + File.separator + fileName;
        File f = new File(fileName);
        try {
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
        } catch (IOException ioe) {
            //log here
            throw new SerializationException("Could not create output file :" + fileName, ioe);
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            OutputStream outputStream = new FileOutputStream(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            jaxbMarshaller.marshal(t, bufferedWriter);
        } catch (JAXBException jbe) {
            //log here
            throw new SerializationException("Could not create Marchaller for class " + t.getClass(), jbe);
        } catch (FileNotFoundException fnfe) {
            //log here
            throw new SerializationException("Could not write to file " + fileName, fnfe);
        }

    }

    @Override
    public <T> T deserialize(Class<T> clazz, String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            try (
                    InputStream is = clazz.getResourceAsStream(fileName);
                    BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
            ) {
                T result = (T) jaxbUnmarshaller.unmarshal(bfr);
                return result;
            }
        } catch (JAXBException e) {
            //log here
            throw new SerializationException("Could not create JAXB Context for class : " + clazz, e);
        } catch (IOException e) {
            //log here
            throw new SerializationException("Could not write to file : " + fileName, e);
        }
    }
}
