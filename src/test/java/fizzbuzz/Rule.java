package fizzbuzz;

import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public class Rule {

    public static final Rule EMPTY = new Rule(__ -> false, "");
    private final IntPredicate condition;
    private final IntFunction<Optional<String>> termSupplier;

    public Rule(final IntPredicate condition, final String term) {
        this.condition = condition;
        this.termSupplier = toSupplier(term);
    }

    private Rule(final IntPredicate condition, final IntFunction<Optional<String>> termSupplier) {
        this.condition = condition;
        this.termSupplier = termSupplier;
    }

    private IntFunction<Optional<String>> toSupplier(final String term) {
        return (num) -> Optional.ofNullable(term);
    }

    public Rule combine(Rule other) {
        return new Rule(condition.or(other.condition), concat(this::getTerm, other::getTerm));
    }

    private IntFunction<Optional<String>> concat(IntFunction<Optional<String>> f, IntFunction<Optional<String>> g) {
        return (int num) -> Optional.of(num).map(n -> f.apply(n).orElse("") + g.apply(n).orElse(""));
    }

    public Optional<String> getTerm(int number) {
        return this.condition.test(number) ? termSupplier.apply(number) : Optional.empty();
    }

}
