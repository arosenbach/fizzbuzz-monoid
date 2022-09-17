package fizzbuzz;

import java.util.Optional;
import java.util.function.IntPredicate;

public abstract class Rule {

    IntPredicate condition;
    String term;
    private Rule next;

    public static IntPredicate isMultipleOf(int x) {
        return (number) -> number % x == 0;
    }

    public Rule setNext(Rule next) {
        this.next = next;
        return next;
    }


    public String apply(final int number) {
        final String nextTerm = Optional.ofNullable(next)
                .map(rule -> rule.apply(number))
                .orElse("");
        if (this.condition.test(number)) {
            return this.term + nextTerm;
        }
        return nextTerm;

    }
}
