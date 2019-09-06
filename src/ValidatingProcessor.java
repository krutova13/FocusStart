import java.util.*;

class ValidatingProcessor extends CommandLineProcessor {
    /**
     * Если список входных параметров невалидный, кидает исключение
     *
     * @param args список входных параметров
     * @throws IllegalArgumentException
     */

    ValidatingProcessor(String[] args) throws IllegalArgumentException {

        super(args);

        String[] validArgs = new String[]{"-a", "-d", "-i", "-s"};

        Set<String> flags = new HashSet<>();
        Set<String> list = new HashSet<String>(Arrays.asList(args));
        Set<String> validList = new HashSet<>(Arrays.asList(validArgs));

        for (String arg : list) {
            if (validList.contains(arg)) {
                flags.add(arg);
            } else if (!list().contains(arg))
                throw new IllegalArgumentException("Присутвует неизвестный аргумент");
        }

        if ((flags.size() > 2) || (flags.size() == 0)) {
            throw new IllegalArgumentException("Неверное количество аргументов");
        } else if (((flags.contains(validArgs[0]) && flags.contains(validArgs[1])) ||
                (flags.contains(validArgs[2]) && flags.contains(validArgs[3]))) ||
                (flags.size() == 1 && flags.contains(validArgs[0])) ||
                (flags.size() == 1 && flags.contains(validArgs[1]))) {
            throw new IllegalArgumentException("Неразрешимое сочетание аргументов");
        }

        if (list().size() < 2) throw new IllegalArgumentException("Необходимо минимум 2 файла: входной и выходной");
    }
}
