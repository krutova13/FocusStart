import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Start {

    Start(String[] args) {

        try {
            ValidatingProcessor validatingProcessor = new ValidatingProcessor(args);
            FileInputReader fileInputReader = new FileInputReader();
            MergeSort mergeSort = new MergeSort();
            FileOutputWriter fileOutputWriter = new FileOutputWriter();

            List<String> list = new ArrayList<>();
            list = validatingProcessor.list();

            String[][] files = new String[list.size() - 1][0];
            for (int i = 0; i < list.size() - 1; i++) {
                files[i] = fileInputReader.getList(list.get(i));
            }

            Sorter sorter = new Sorter(args, list, files);

            System.out.println("Файл сохранен в " + list.get(list.size() - 1));

        } catch (IllegalArgumentException e) {
            System.out.println("Вы передали некорректные аргументы: " + e);
            System.exit(0);
        }
    }
}
