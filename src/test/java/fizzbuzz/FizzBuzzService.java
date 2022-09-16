package fizzbuzz;

import java.util.List;
import java.util.function.IntPredicate;

public class FizzBuzzService {
    private final List<Rule> rules = List.of(
            new Rule(isMultipleOf(3), "fizz"),
            new Rule(isMultipleOf(5), "buzz"),
            new Rule(isMultipleOf(7), "zumba")
    );

    private static IntPredicate isMultipleOf(int x) {
        return (number) -> number % x == 0;
    }

    public String say(int number) {
        return rules
                .stream()
                .filter(rule -> rule.test(number))
                .map(Rule::getTerm)
                .reduce(String::concat)
                .orElse(String.valueOf(number));
    }
}
