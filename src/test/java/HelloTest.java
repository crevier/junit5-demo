import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.expectThrows;

/**
 * Quick overview of Junit 5
 */
@Disabled
public class HelloTest {

    @Test
    public void empty_test_should_pass() {
        //this test is empty on purpose
        Assumptions.assumingThat(true,
                () -> Assertions.assertTrue(true));
    }

    @Test
    public void assert_true_should_pass() {
        Assertions.assertTrue(true);
    }

    @Test
    public void assume_false_should_be_skipped() {
        Assumptions.assumeTrue(false);
        Assertions.fail("This should be ignored");
    }

    @DisplayName("TEST with name")
    @Tag("my tag")
    @Test
    public void test_with_params_should_pass(TestInfo testInfo) {

        System.out.println(testInfo.toString());
    }

    @Test
    void expectThrows_should_pass() {
        Throwable exception = Assertions.expectThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("error");
        });
        assertEquals("error", exception.getMessage());
    }

    @Test
    void expectThrows_should_fail() {
        Assertions.expectThrows(AssertionError.class, () ->
                Assertions.expectThrows(IllegalArgumentException.class, () -> {
                    //
                }));
    }

    @Disabled
    @DisplayName("Nested test")
    @Nested
    static class NestedTest {

        @Test
        public void nested_assert_true_should_pass() {
            Assertions.assertTrue(true);
        }


    }

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("this is a before all call");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("this is a after all call");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("this is a before each call");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("this is a after each call");
    }


}
