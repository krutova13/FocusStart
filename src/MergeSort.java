import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeSort implements Comparator<String> {

    static boolean isString = false;

    final String[] setAscending(boolean ascending, String[]... list) {

        String[] result;

        if (list.length > 1) {
            return reMerge(ascending, list);
        } else {
            System.out.println("Поскольку входной файл всего 1 - выводим его в исходном виде");
            return new String[]{Arrays.toString(list[0])};
        }
    }

    private String[] reMerge(boolean ascending, String[]... args) {

        String[] end;

        if (args.length > 2) {
            end = reMerge(ascending, Arrays.copyOfRange(args, 1, args.length));
        } else {
            end = args[1];
        }
        if (ascending) {
            return mergeGrow(args[0], end);
        } else return mergeDec(args[0], end);
    }

    private String[] mergeGrow(String[] arr1, String[] arr2) {

        String[] arrayMerge = new String[arr1.length + arr2.length];
        int posA = 0, posB = 0;

        for (int i = 0; i < arrayMerge.length; i++) {
            if (posA == arr1.length) {
                arrayMerge[i] = arr2[posB];
                posB++;
            } else if (posB == arr2.length) {
                arrayMerge[i] = arr1[posA];
                posA++;
            } else if (compare(arr1[posA], arr2[posB]) < 0) {
                arrayMerge[i] = arr1[posA];
                posA++;
            } else {
                arrayMerge[i] = arr2[posB];
                posB++;
            }
        }
        return arrayMerge;
    }

    private String[] mergeDec(String[] arr1, String[] arr2) {

        String[] arrayMerge = new String[arr1.length + arr2.length];
        int posA = arr1.length - 1, posB = arr2.length - 1;

        for (int i = 0; i < arrayMerge.length; i++) {
            if (posA == -1) {
                arrayMerge[i] = arr2[posB];
                posB--;
            } else if (posB == -1) {
                arrayMerge[i] = arr1[posA];
                posA--;
            } else if (compare(arr1[posA], arr2[posB]) > 0) {
                arrayMerge[i] = arr1[posA];
                posA--;
            } else {
                arrayMerge[i] = arr2[posB];
                posB--;
            }
        }
        return arrayMerge;
    }

    @Override
    public int compare(String o1, String o2) {

        if (!isString) {
            try {
                return new Integer(o1).compareTo(new Integer(o2));
            } catch (IllegalArgumentException e) {
                System.out.println("В файл присутствуют некорректные числа");
                System.exit(0);
            }
        }
        return o1.compareTo(o2);
    }
}