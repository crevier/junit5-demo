package custom.extension.example2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import utils.Timer;

import java.util.concurrent.TimeUnit;

/**
 * Example of custom extension in action.
 */
//@Disabled
@ExtendWith(TimerExtensionExampleTest.TimerExtension.class)
public class TimerExtensionExampleTest {

    @Test
    public void test_with_no_custom_extension() throws InterruptedException {
        Assertions.assertTrue(true, "This should pass");
    }

    @Test
    //@ExtendWith(TimerExtension.class)
    public void test_with_a_custom_extension() throws InterruptedException {
        Thread.sleep(555l);
        Assertions.assertTrue(true, "This should pass too");
    }

    /**
     * Our custom extension
     */
    public static class TimerExtension implements AfterTestExecutionCallback, BeforeTestExecutionCallback {

        private Timer timer;

        public void beforeTestExecution(TestExtensionContext context) {
            timer = Timer.start();
        }

        public void afterTestExecution(TestExtensionContext context){
            timer.stop();
            System.out.println("Test run in "+timer.getElapsedTimeInMillisec()+"ms.");
        }

    }

}
