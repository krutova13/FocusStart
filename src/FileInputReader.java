import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputReader implements AutoCloseable {

    String[] getList(String path) {

        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(path))) {

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }
        catch (IOException e) {
            System.out.println("Файл указан неверно и/или не существует: " + e);
            System.exit(0);
        }
        return list.toArray(new String[0]);
    }

    @Override
    public void close() throws Exception {
    }
}