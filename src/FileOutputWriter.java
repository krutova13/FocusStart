import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

class FileOutputWriter {

    void write(String path, String[] list) {

        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (String line : list) {
                printWriter.println(line);
            }
        } catch (IOException e) {
            System.out.println("Имя выходного файла задано некорректно: "+ e);
            System.exit(0);
        }
    }
}
