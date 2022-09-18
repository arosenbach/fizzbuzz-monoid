package fizzbuzz;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Property
    void every_third_element_starts_with_fizz(@ForAll("divisibleBy3") int i) {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        assertTrue(fizzBuzzService.say(i).startsWith("fizz"));
    }

    @Property
    void every_five_element_contains_buzz(@ForAll("divisibleBy5") int i) {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        assertTrue(fizzBuzzService.say(i).contains("buzz"));
    }

    @Property
    void every_seven_element_contains_zumba(@ForAll("divisibleBy7") int i) {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        assertTrue(fizzBuzzService.say(i).contains("zumba"));
    }

    @Provide
    Arbitrary<Integer> divisibleBy3() {
        return Arbitraries.integers().between(1, 100).filter(i -> i % 3 == 0);
    }

    @Provide
    Arbitrary<Integer> divisibleBy5() {
        return Arbitraries.integers().between(1, 100).filter(i -> i % 5 == 0);
    }

    @Provide
    Arbitrary<Integer> divisibleBy7() {
        return Arbitraries.integers().between(1, 100).filter(i -> i % 7 == 0);
    }
}
