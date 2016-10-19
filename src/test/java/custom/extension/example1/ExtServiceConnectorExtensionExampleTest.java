package custom.extension.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import utils.ExtServiceConnector;

/**
 * Another example of custom extension in action.
 */
//@Disabled
public class ExtServiceConnectorExtensionExampleTest {

    @Test
    @ExtendWith(ExtServiceConnectorParameterResolver.class)
    public void test_with_alive_connection(ExtServiceConnector connector) {
        Assumptions.assumingThat(
                connector.isConnectionAlive(),
                () -> Assertions.assertAll(
                        () -> Assertions.assertTrue(true, "this should pass"),
                        () -> Assertions.assertTrue(true, "this should pass too")
                )
        );
    }

    @Test
    @ExtendWith(ExtServiceConnectorParameterResolver.class)
    public void test_with_broken_connection(ExtServiceConnector connector) {
        Assumptions.assumingThat(
                connector.isConnectionAliveOrNot(),
                () -> Assertions.assertAll(
                        () -> Assertions.fail("this should be ignored"),
                        () -> Assertions.fail("this should be ignored too")
                )
        );
    }

    /**
     * Our other custom extension.
     */
    public static class ExtServiceConnectorParameterResolver implements ParameterResolver, AfterTestExecutionCallback, BeforeTestExecutionCallback {

        private ExtServiceConnector connector = new ExtServiceConnector();

        @Override
        public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return (parameterContext.getParameter().getType() == ExtServiceConnector.class);
        }

        @Override
        public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return connector;
        }

        @Override
        public void afterTestExecution(TestExtensionContext testExtensionContext) throws Exception {
            connector.close();
        }

        @Override
        public void beforeTestExecution(TestExtensionContext testExtensionContext) throws Exception {
            System.out.println("---" + testExtensionContext.getDisplayName() + "---");
            connector.connect();
        }
    }
}
