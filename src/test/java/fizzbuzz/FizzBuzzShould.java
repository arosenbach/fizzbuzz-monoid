package fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzShould {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, fizz",
            "4, 4",
            "5, buzz",
            "7, zumba",
            "9, fizz",
            "15, fizzbuzz",
            "150, fizzbuzz",
            "21, fizzzumba"})
    public void say(Integer number, String expected) {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        String actual = fizzBuzzService.say(number);
        assertEquals(expected, actual);
    }
}
