import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class HorseTest {

    @ParameterizedTest
    @NullSource
    @DisplayName("Should throw IllegalArgumentException if Horse first constructor parameter is null")
    void shouldThrowIllegalArgumentException_IfHorseFirstConstructorParameterNull(String nameAsNull) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameAsNull, 1, 1));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("When Horse constructor throws IllegalArgumentException because first value to null then message contains")
    void whenHorseConstructorThrowsIllegalArgumentExceptionBecauseFirstNull_thenMessageContains(String nameAsNull) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameAsNull, 1, 1));
        String expectedMessage = "Name cannot be null.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r", "\f"})
    @DisplayName("Should throw an IllegalArgumentException if Horse first constructor parameter is blank")
    void shouldThrowIllegalArgumentException_IfHorseFirstConstructorParameterBlank(String nameLike) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameLike, 1, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r", "\f"})
    @DisplayName("When Horse constructor throws IllegalArgumentException because first value to blank then message contains")
    void whenHorseConstructorThrowsIllegalArgumentExceptionBecauseFirstBlank_thenMessageContains(String nameLike) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameLike, 1, 1));
        String expectedMessage = "Name cannot be blank.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException if Horse second constructor parameter is negative")
    void shouldThrowIllegalArgumentException_IfHorseSecondConstructorParameterNegative() {
        int checkValue = -1;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", checkValue, 1));
    }

    @Test
    @DisplayName("When Horse constructor throws IllegalArgumentException because second value to negative then message contains")
    void whenHorseConstructorThrowsIllegalArgumentExceptionBecauseSecondNegative_thenMessageContains() {
        int checkValue = -1;
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", checkValue, 1));
        String expectedMessage = "Speed cannot be negative.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException if Horse third constructor parameter is negative")
    void shouldThrowIllegalArgumentException_IfHorseThirdConstructorParameterNegative() {
        int checkValue = -1;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", 1, checkValue));
    }

    @Test
    @DisplayName("When Horse constructor throws IllegalArgumentException third second value to negative then message contains")
    void whenHorseConstructorThrowsIllegalArgumentExceptionBecauseThirdNegative_thenMessageContains() {
        int checkValue = -1;
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Horse", 1, checkValue));
        String expectedMessage = "Distance cannot be negative.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should return first constructor parameter Horse")
    void shouldReturnFirstConstructorParameterHorse() {
        String expectedName = "Horse";
        Horse horse = new Horse(expectedName, 1, 1);
        String checkName = horse.getName();
        Assertions.assertEquals(expectedName, checkName);
    }

    @Test
    @DisplayName("Should return second constructor parameter Horse")
    void shouldReturnSecondConstructorParameterHorse() {
        double expectedSpeed = 0.9d;
        Horse horse = new Horse("Horse", expectedSpeed, 1);
        double checkSpeed = horse.getSpeed();
        Assertions.assertEquals(expectedSpeed, checkSpeed);
    }

    @Test
    @DisplayName("Should return third constructor parameter Horse")
    void shouldReturnThirdConstructorParameterHorse() {
        double expectedDistance = 0.9d;
        Horse horse = new Horse("Horse", 1, expectedDistance);
        double checkDistance = horse.getDistance();
        Assertions.assertEquals(expectedDistance, checkDistance);
    }

    @Test
    @DisplayName("Should return zero when initialized with two parameters Horse")
    void shouldReturnZero_whenInitializedWithTwoParametersHorse() {
        double expectedDistance = 0;
        Horse horse = new Horse("Horse", 1);
        double checkDistance = horse.getDistance();
        Assertions.assertEquals(expectedDistance, checkDistance);
    }
}