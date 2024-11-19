import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class HippodromeTest {


    @ParameterizedTest
    @NullSource
    @DisplayName("Should throw IllegalArgumentException if Hippodrome constructor parameter is null")
    void shouldThrowIllegalArgumentException_IfHippodromeConstructorParameterNull(List<Horse> listHorsesAsNull) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(listHorsesAsNull));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("When Hippodrome constructor throws IllegalArgumentException because value to null then message contains")
    void whenHippodromeConstructorThrowsIllegalArgumentExceptionBecauseNull_thenMessageContains(List<Horse> listHorsesAsNull) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(listHorsesAsNull));
        String expectedMessage = "Horses cannot be null.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException if Hippodrome constructor parameter is empty")
    void shouldThrowIllegalArgumentException_IfHippodromeConstructorParameterEmpty() {
        List<Horse> listHorseIsEmpty = Collections.emptyList();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(listHorseIsEmpty));
    }

    @Test
    @DisplayName("When Hippodrome constructor throws IllegalArgumentException because value to empty then message contains")
    void whenHippodromeConstructorThrowsIllegalArgumentExceptionBecauseEmpty_thenMessageContains() {
        List<Horse> listHorseIsEmpty = Collections.emptyList();
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(listHorseIsEmpty));
        String expectedMessage = "Horses cannot be empty.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @MethodSource("providerListHorse")
    @DisplayName("Should return same list Horses as input list Hippodrome")
    void shouldReturnSameListAsInputHippodrome(List<Horse> listHorse) {
        Hippodrome hippodrome = new Hippodrome(listHorse);
        List<Horse> checkListHorse = hippodrome.getHorses();
        Assertions.assertEquals(listHorse, checkListHorse);

    }

    @ParameterizedTest
    @MethodSource("providerListHorse")
    @DisplayName("Should return Horse with max distance")
    void shouldReturnHorseWithMaxDistance(List<Horse> listHorse) {
        Hippodrome hippodrome = new Hippodrome(listHorse);
        double expectedDistance = 30d;
        double checkDistance = hippodrome.getWinner().getDistance();
        Assertions.assertEquals(expectedDistance, checkDistance);

    }

    public static Stream<List<Horse>> providerListHorse() {
        List<Horse> listHorse = IntStream.rangeClosed(1, 30)
                .mapToObj(i -> new Horse("Horse_" + i, 1, i))
                .collect(Collectors.toList());
        return Stream.of(listHorse);
    }

    @Test
    @DisplayName("Should call move method on all horses")
    void shouldCallMoveMethodAllHorses() {
        List<Horse> horseList = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> Mockito.mock(Horse.class))
                .collect(Collectors.toList());
        var hippodrome = new Hippodrome(horseList);
        hippodrome.move();
        horseList.forEach(entity -> Mockito.verify(entity).move());


    }
}