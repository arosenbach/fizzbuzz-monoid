package fizzbuzz;

import java.util.function.IntPredicate;

public class Rule {

    private final IntPredicate condition;
    private final String term;

    private Rule(final IntPredicate condition, final String term) {
        this.condition = condition;
        this.term = term;

    }

    public static Rule of(final IntPredicate condition, final String term) {
        return new Rule(condition, term);
    }

    public boolean test(final Integer number) {
        return this.condition.test(number);
    }

    public String getTerm() {
        return term;
    }

}
