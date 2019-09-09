import java.io.IOException;
import java.util.List;

class Sorter {

    Sorter(String[] args, List<String> list, String[][] files) {

        CommandLineProcessor commandLineProcessor = new CommandLineProcessor(args);
        FileOutputWriter fileOutputWriter = new FileOutputWriter();
        MergeSort mergeSort = new MergeSort();

        if (commandLineProcessor.is("-s")) {
            MergeSort.isString = true;
        }
        if (commandLineProcessor.is("-d")) {
            fileOutputWriter.write(list.get(list.size() - 1),
                    mergeSort.setAscending(false, files));
        } else {
            fileOutputWriter.write(list.get(list.size() - 1),
                    mergeSort.setAscending(true, files));
        }
    }
}
