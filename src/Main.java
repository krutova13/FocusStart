public class Main {

    public static void main(String[] args) {
        getArgs(args);
    }

    private static void start3Params(String[] args, String param) {
        MergeSort mergeSort = new MergeSort();
        String[][] mas = new String[args.length - 3][0];

        for (int i = 2; i < args.length - 1; i++) {
            mas[i - 2] = FileInputReader.getList("C:\\Users\\sb_user\\Desktop\\" + args[i]);
        }
        FileOutputWriter.write("C:\\Users\\sb_user\\Desktop\\" + args[args.length - 1],
                mergeSort.merge(param, mas));

        System.out.println("Файл сохранен в " + args[args.length - 1]);
    }

    private static void start2Params(String[] args, String param) {
        MergeSort mergeSort = new MergeSort();
        String[][] mas = new String[args.length - 2][0];

        for (int i = 1; i < args.length - 1; i++) {
            mas[i - 1] = FileInputReader.getList("C:\\Users\\sb_user\\Desktop\\" + args[i]);
        }
        FileOutputWriter.write("C:\\Users\\sb_user\\Desktop\\" + args[args.length - 1],
                mergeSort.merge(param, mas));

        System.out.println("Файл сохранен в " + args[args.length - 1]);
    }


    private static void getArgs(String[] args) {
        if (args.length < 3) {
            System.out.println("Введены некорректные параметры! Заполните параметры по образцу : \n" +
                    "sort.exe -a -i in.txt out.txt(для целых чисел по возрастанию) \n" +
                    "sort.exe -d -i in.txt out.txt(для целых чисел по убыванию) \n" +
                    "sort.exe -a -s in.txt out.txt(для строк по возрастанию) \n" +
                    "sort.exe -d -s in.txt out.txt(для строк по убыванию) \n");
        }

        if (args[0].equals("-a") && args[1].equals("-i")) {
            System.out.println("Производится сортировка чисел по возрастанию");
            start3Params(args, "GrowInt");
        } else if (args[0].equals("-a") && args[1].equals("-s")) {
            System.out.println("Производится сортировка строк по возрастанию");
            start3Params(args, "GrowString");
        } else if (args[0].equals("-d") && args[1].equals("-i")) {
            System.out.println("Производится сортировка чисел по убыванию");
            start3Params(args, "DecInt");
        } else if (args[0].equals("-d") && args[1].equals("-s")) {
            System.out.println("Производится сортировка строк по убыванию");
            start3Params(args, "DecString");
        } else if (args[0].equals("-s")) {
            System.out.println("Производится сортировка строк по возрастанию");
            start2Params(args, "GrowString");
        } else if (args[0].equals("-i")) {
            System.out.println("Производится сортировка чисел по возрастанию");
            start2Params(args, "GrowInt");
        } else {
            System.out.println("Введены некорректные параметры!");
        }
    }
}
