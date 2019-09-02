import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeSort implements Comparator<String> {

    final String[] merge(String param, String[]... list) {
        String[] result;

        if (list.length > 1) {
            return reMerge(param, list);
        } else {
            System.out.println("Поскольку входной файл всего 1 - выводим его в исходном виде");
            return new String[]{Arrays.toString(list[0])};
        }
    }

    private String[] reMerge(String param, String[]... args) {
        String[] end;

        //System.out.println("Входим в метод, кол-во списков для мержа: " + args.length);

        if (args.length > 2) {
//            System.out.println("Количество больше 2, убираем 0 эл-т, мержим хвост");
            end = reMerge(param, Arrays.copyOfRange(args, 1, args.length));
//            System.out.println("Хвост смержен");
        } else {
//            System.out.println("Количество = 2, считаем хвостом 1 элемент");
            end = args[1];
        }
//        System.out.println("Отдаем мержГроу 0й элемент и хвост и возвращаемся из метода");
        if (param.equals("GrowInt") || param.equals("GrowString")) {
            return mergeGrow(param, args[0], end);
        } else return mergeDec(param, args[0], end);
    }

    private String[] mergeGrow(String param, String[] arr1, String[] arr2) {
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
        System.out.println(Arrays.toString(arrayMerge));
        return arrayMerge;
    }

    private String[] mergeDec(String param, String[] arr1, String[] arr2) {
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
//        System.out.println(Arrays.toString(arrayMerge));
        return arrayMerge;
    }

    @Override
    public int compare(String o1, String o2) {
        if (VerifyInput.isNumber(o1, o2)) {
            return new Integer(o1).compareTo(new Integer(o2));
        } else return o1.compareTo(o2);
    }
}
