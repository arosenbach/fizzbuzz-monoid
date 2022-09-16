package fizzbuzz;

import java.util.function.IntPredicate;

public class FizzBuzzService {
    private final RulesCollection rules = new RulesCollection(
            Rule.of(isMultipleOf(3), "fizz"),
            Rule.of(isMultipleOf(5), "buzz"),
            Rule.of(isMultipleOf(7), "zumba")
    );

    private static IntPredicate isMultipleOf(int x) {
        return (number) -> number % x == 0;
    }

    public String say(int number) {
        return rules
                .filter(rule -> rule.test(number))
                .map(Rule::getTerm)
                .reduce(String::concat)
                .orElse(String.valueOf(number));
    }
}
