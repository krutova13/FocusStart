import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CommandLineProcessor {

    private final Set<String> flags = new HashSet<>();
    private final List<String> list = new ArrayList<>();

    CommandLineProcessor(String[] args) throws IllegalArgumentException {
        for (String param : args) {
            if ((param.charAt(0)) == '-') {
                if (flags.contains(param)) throw new IllegalArgumentException("Присутствуют одинаковые аргументы");
                else flags.add(param);
            } else {
                list.add(param);
            }
        }
    }

    boolean is(String flag) {
        return flags.contains(flag);
    }

    List<String> list() {
        List<String> result = new ArrayList<>(list.size());
        result.addAll(list);
        return result;
    }
}