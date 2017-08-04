package app.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileParser {

    public String readFile(String fileName) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        try (
                InputStream is = getClass().getResourceAsStream(fileName);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(is))
        ) {
            String line = null;
            while ((line = bfr.readLine()) != null) {
                fileContent.append(line);
            }
        }

        return fileContent.toString();
    }

    public void writeFile(String fileName, String content) throws IOException {
        try (OutputStream os = new FileOutputStream(fileName);
             BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os))
        ) {
            bfw.write(String.valueOf(content));
        }
    }
}
