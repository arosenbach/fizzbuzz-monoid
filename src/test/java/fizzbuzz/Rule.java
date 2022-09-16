package fizzbuzz;

import java.util.function.IntPredicate;

public class Rule {

    private final IntPredicate condition;
    private final String term;

    public Rule(final IntPredicate condition, final String term) {
        this.condition = condition;
        this.term = term;

    }

    public boolean test(final Integer number) {
        return this.condition.test(number);
    }

    public String getTerm() {
        return term;
    }

}
