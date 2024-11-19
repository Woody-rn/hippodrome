import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MainTest {
    String[] args;

    @Disabled("This is a long test (22 seconds), run manually if necessary")
    @Test
    @Timeout(22)
    @DisplayName("Should complete with 22 seconds")
    void shouldCompleteWith22Seconds() throws Exception {
        Main.main(args);
    }
}