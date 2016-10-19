package custom.annotation.example2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;


/**
 * Another Example of custom annotations in action
 */
@Disabled
public class ExtAvailableServiceExampleTest {

    @ExtServiceAvailable(site = "google")
    public void test_with_google() {
        Assertions.assertTrue(true, "this should pass");
    }

    @ExtServiceAvailable(site = "yahoo")
    public void test_with_yahoo() {
        Assertions.fail("this should be ignored");
    }

}
