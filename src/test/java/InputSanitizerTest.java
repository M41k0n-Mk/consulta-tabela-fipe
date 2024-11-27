import me.m41k0n.utils.InputSanitizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InputSanitizerTest {
    @Test
    void shouldReturnStringWithoutWhitespace() {
        Assertions.assertEquals("carros", InputSanitizer.sanitize(" carros "));
    }
}