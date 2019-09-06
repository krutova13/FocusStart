import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CommandLineProcessorTest {

    @Test
    public void is() {
        String[] args = new String[]{"-a", "-b"};
        CommandLineProcessor processor = new CommandLineProcessor(args);
        assertTrue("Требуемый флаг отсуствует!", processor.is("-a"));
        assertTrue("Требуемый флаг отсуствует!", processor.is("-b"));
        assertFalse("Лишний флаг", processor.is("-yy"));
    }

    @Test
    public void list() {
        String[] args = new String[]{"adrgdh", "b.txt"};
        List<String> argList = Arrays.asList(args);
        CommandLineProcessor processor = new CommandLineProcessor(args);
    }

    @Test
    public void flagsAndList() {
        List<String> flags = Arrays.asList("-i", "-s");
        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> args = new ArrayList<>();
        args.addAll(flags);
        args.addAll(list);
        CommandLineProcessor processor = new CommandLineProcessor(args.toArray(new String[0]));
        assertTrue("Требуемый флаг отсутствует!", processor.is("-i"));
        assertTrue("Требуемый флаг отсутствует!", processor.is("-s"));
        assertFalse("Лишний флаг", processor.is("djkg"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void duplicatedFlag() {
        String[] args = new String[]{"-i", "-s", "-i"};
        CommandLineProcessor processor = new CommandLineProcessor(args);
    }

}