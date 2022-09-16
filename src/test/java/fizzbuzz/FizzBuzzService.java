package fizzbuzz;

import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class FizzBuzzService {
    private final RulesCollection rules = new RulesCollection(
            Rule.of(isMultipleOf(3), () -> "fizz"),
            Rule.of(isMultipleOf(5), () -> "buzz"),
            Rule.of(isMultipleOf(7), () -> "zumba")
    );

    private static IntPredicate isMultipleOf(int x) {
        return (number) -> number % x == 0;
    }

    public String say(int number) {
        return rules
                .filter(rule -> rule.test(number))
                .map(Rule::getResultSuppliers)
                .reduce(Rule::combineResultSuppliers)
                .map(Supplier::get)
                .orElse(String.valueOf(number));
    }
}
