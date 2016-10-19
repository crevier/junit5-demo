package custom.annotation.example2;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.locks.Condition;


/**
 * Extension that disable the test if the site is not google.
 */
public class ExtServiceAvailableCondition implements TestExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext testExtensionContext) {
        String service = testExtensionContext
                .getElement()
                .get()
                .getAnnotation(ExtServiceAvailable.class)
                .site();
        System.out.println(testExtensionContext.getDisplayName() + " site used is : " + service);
        if ("google".equals(service)) {
            return ConditionEvaluationResult.enabled("because google is too big to fail");
        }
        return ConditionEvaluationResult.disabled("because no");
    }
}
