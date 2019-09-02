import java.io.FileNotFoundException;
import java.io.PrintWriter;

class FileOutputWriter {

    static void write(String path, String[] list) {

        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (String line : list) {
                printWriter.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
