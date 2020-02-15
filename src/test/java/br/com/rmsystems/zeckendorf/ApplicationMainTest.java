package br.com.rmsystems.zeckendorf;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
public class ApplicationMainTest {

    @Test()
    public void whenStartApplicationWithoutArgumentsThrowAnException() {
        assertThrows(RuntimeException.class, () -> ApplicationMain.main(null));
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
