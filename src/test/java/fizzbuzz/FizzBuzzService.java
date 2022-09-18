package fizzbuzz;

import java.util.List;
import java.util.function.IntPredicate;

public class FizzBuzzService {
    private final List<Rule> rules;


    {
        rules = List.of(
                new Rule(isMultipleOf(3), "fizz"),
                new Rule(isMultipleOf(5), "buzz"),
                new Rule(isMultipleOf(7), "zumba")
        );
    }

    private static IntPredicate isMultipleOf(int x) {
        return (number) -> number % x == 0;
    }

    public String say(int number) {
//        return (new Rule(isMultipleOf(3), "fizz"))
//                .combine((new Rule(isMultipleOf(5), "buzz")))
//                .combine((new Rule(isMultipleOf(7), "zumba")))
//                .getTerm(number)
//                .orElse(String.valueOf(number));
        return rules.stream()
                .reduce(Rule.EMPTY, Rule::combine)
                .getTerm(number)
                .orElse(String.valueOf(number));
    }
}
