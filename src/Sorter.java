import java.io.IOException;
import java.util.List;

class Sorter {

    Sorter(String[] args, List<String> list, String[][] files) {

        ValidatingProcessor validatingProcessor = new ValidatingProcessor(args);
        FileOutputWriter fileOutputWriter = new FileOutputWriter();
        MergeSort mergeSort = new MergeSort();

        if (validatingProcessor.is("-d")) {
            fileOutputWriter.write(list.get(list.size() - 1),
                    mergeSort.setAscending(false, files));
        } else {
            fileOutputWriter.write(list.get(list.size() - 1),
                    mergeSort.setAscending(true, files));
        }
    }
}
