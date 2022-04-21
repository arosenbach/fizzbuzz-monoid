package fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzShould {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, zumba",
            "4, 4",
            "5, buzz",
            "9, fizz",
            "15, fizzbuzz",
            "150, fizzbuzz"})
    void say(Integer number, String expected) {
        // Arrange
        final FizzBuzzFactory fizzBuzzFactory = new FizzBuzzFactory();
        final FizzBuzzFactory.Say sut = fizzBuzzFactory.create(number);

        // Act
        final String output = sut.say();

        // Assert
        assertEquals(expected, output);
    }
}
