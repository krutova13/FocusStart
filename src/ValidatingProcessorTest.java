import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ValidatingProcessorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void wrongArgumentException() {
        String[] args = {"-i", "-xxx"};
        thrown.expect(IllegalArgumentException.class);
        new ValidatingProcessor(args);
    }

    @Test
    public void wrongArgumentException2() {
        String[] args = {"-i", "-d", "-a"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Неверное количество аргументов");
        new ValidatingProcessor(args);
    }

    @Test
    public void wrongArgumentException3() {
        String[] args = {"-i", "-d", "-a"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Неверное количество аргументов");
        new ValidatingProcessor(args);
    }

    @Test
    public void wrongArgumentException4() {
        String[] args = {"-i", "-s"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Некорректные аргументы");
        new ValidatingProcessor(args);
    }

    @Test
    public void wrongArgumentException5() {
        String[] args = {"-a"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Некорректные аргументы");
        new ValidatingProcessor(args);
    }

    @Test
    public void wrongArgumentException6() {

        String[] args = {"-"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Некорректные аргументы");
        new ValidatingProcessor(args);
    }

    @Test
    public void wrongArgumentException7() {
        String[] args = {"-i", "-i"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Присутствуют одинаковые аргументы");
        new ValidatingProcessor(args);
    }

    @Test
    public void wrongListException() {
        String[] args = {"-i", "-a", "q.txt"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Необходимо минимум 2 файла: входной и выходной");
        new ValidatingProcessor(args);
    }


    @Test
    public void correctArgumentsNoException() {
        String[] args = {"-i", "ff", "vdvdr.txt"};
        new ValidatingProcessor(args);
    }

    @Test
    public void correctArgumentsNoException2() {
        String[] args = {"-s", "eeeeeeeeeeeeee", "docx.docx"};
        new ValidatingProcessor(args);
    }

    @Test
    public void correctArgumentsNoException3() {
        String[] args = {"-i", "-a", "gfnnf.txt", "gwrwr"};
        new ValidatingProcessor(args);

    }

}
