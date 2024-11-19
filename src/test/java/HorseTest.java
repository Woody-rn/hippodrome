import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class HorseTest {

    @ParameterizedTest
    @NullSource
    @DisplayName("Should throw IllegalArgumentException if first constructor parameter is null")
    void shouldThrowIllegalArgumentException_IfFirstConstructorParameterNull(String nameAsNull) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameAsNull, 1, 1));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("When constructor throws IllegalArgumentException because first value to null then message contains")
    void whenConstructorThrowsIllegalArgumentExceptionBecauseFirstNull_thenMessageContains(String nameAsNull) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameAsNull, 1, 1));
        String expectedMessage = "Name cannot be null.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r", "\f"})
    @DisplayName("Should throw an IllegalArgumentException if the first constructor parameter is blank")
    void shouldThrowIllegalArgumentException_IfFirstConstructorParameterBlank(String nameLike) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameLike, 1, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r", "\f"})
    @DisplayName("When constructor throws IllegalArgumentException because first value to blank then message contains")
    void whenConstructorThrowsIllegalArgumentExceptionBecauseFirstBlank_thenMessageContains(String nameLike) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameLike, 1, 1));
        String expectedMessage = "Name cannot be blank.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException if second constructor parameter is negative")
    void shouldThrowIllegalArgumentException_IfSecondConstructorParameterNegative() {
        int checkValue = -1;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", checkValue, 1));
    }

    @Test
    @DisplayName("When constructor throws IllegalArgumentException because second value to negative then message contains")
    void whenConstructorThrowsIllegalArgumentExceptionBecauseSecondNegative_thenMessageContains() {
        int checkValue = -1;
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", checkValue, 1));
        String expectedMessage = "Speed cannot be negative.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException if third constructor parameter is negative")
    void shouldThrowIllegalArgumentException_IfThirdConstructorParameterNegative() {
        int checkValue = -1;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", 1, checkValue));
    }

    @Test
    @DisplayName("When constructor throws IllegalArgumentException third second value to negative then message contains")
    void whenConstructorThrowsIllegalArgumentExceptionBecauseThirdNegative_thenMessageContains() {
        int checkValue = -1;
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", 1, checkValue));
        String expectedMessage = "Distance cannot be negative.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }


}