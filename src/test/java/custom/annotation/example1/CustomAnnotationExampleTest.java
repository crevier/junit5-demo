package custom.annotation.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.ExtServiceConnector;

/**
 * Example of custom annotation in action.
 */
//@Disabled
public class CustomAnnotationExampleTest {

    @CustomTest
    public void test_with_custom_annotation(ExtServiceConnector connector) {
        Assumptions.assumingThat(
                connector.isConnectionAlive(),
                () -> Assertions.assertAll(
                        () -> Assertions.assertTrue(true, "this should pass"),
                        () -> Assertions.assertTrue(true, "this should pass too")
                )
        );
    }
}
