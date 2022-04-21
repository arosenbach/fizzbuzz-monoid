package fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzShould {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, fizz",
            "4, 4",
            "5, buzz",
            "9, fizz",
            "15, fizzbuzz",
            "150, fizzbuzz"})
    public void say(Integer number, String expected) {
    }
}
