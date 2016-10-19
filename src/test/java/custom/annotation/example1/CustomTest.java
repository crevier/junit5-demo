package custom.annotation.example1;

import custom.extension.example1.ExtServiceConnectorExtensionExampleTest;
import custom.extension.example2.TimerExtensionExampleTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation that define the CustomTest
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("Adneom")
@ExtendWith(ExtServiceConnectorExtensionExampleTest.ExtServiceConnectorParameterResolver.class)
@ExtendWith(TimerExtensionExampleTest.TimerExtension.class)
public @interface CustomTest {
}
