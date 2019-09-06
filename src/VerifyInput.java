import java.util.List;

class VerifyInput {

    boolean isNumber(String... list) {
        try {
            for (String line : list) {
                Long.parseLong(line);
            }
            return true;

        } catch (NumberFormatException e) {
            return false;

        }
    }
}
