package custom.annotation.example2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation with conditional execution.
 */
@Test
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(ExtServiceAvailableCondition.class)
public @interface ExtServiceAvailable {
    String site();
}
