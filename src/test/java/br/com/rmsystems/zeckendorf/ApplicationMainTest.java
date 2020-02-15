package br.com.rmsystems.zeckendorf;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationMainTest {

    @Test(expected = Exception.class)
    public void whenStartApplicationWithoutArgumentsThrowAnException() {
        ApplicationMain.main(null);
    }

    @Test
    public void whenStartApplicationWithMoreThanOrLessThanTwoArgumentsThrowAnException() {
        assertThrows(RuntimeException.class, () -> ApplicationMain.main(new String[]{"1"}));
        assertThrows(RuntimeException.class, () -> ApplicationMain.main(new String[]{"1","2","3"}));
    }

    @Test
    public void whenStartApplicationWithNoIntegerArgumentsThrowAnException() {
        assertThrows(Exception.class, () -> ApplicationMain.main(new String[]{"a", "1"}));
        assertThrows(Exception.class, () -> ApplicationMain.main(new String[]{"a", "b"}));
    }

    @Test
    public void mustBeTheFirstArgumentSmallerThanTheSecondArgument() {
        assertThrows(Exception.class, () -> ApplicationMain.main(new String[]{"2", "1"}));
    }
}
