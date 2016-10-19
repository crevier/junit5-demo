import custom.extension.example2.TimerExtensionExampleTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Simple example of DynamicTests
 */
public class DynamicExampleTest {

    List<Boolean> data = Arrays.asList(true,false,true);

    @Disabled
    @TestFactory
    public Collection<DynamicTest> incremental_tests() {
        Collection<DynamicTest> tests = new ArrayList<>();
        for (Boolean elem : data) {
            tests.add(
                    DynamicTest.dynamicTest(
                            "incremental test n°",
                            () -> {
                                Assertions.assertTrue(elem, "this should be true");

                                Assertions.fail("hello");






                            }
                    )
            );
        }
        return tests;
    }


}
