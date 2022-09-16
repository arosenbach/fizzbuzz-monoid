package fizzbuzz;

import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class Rule {

    private final IntPredicate condition;
    private final Supplier<String> result;

    private Rule(final IntPredicate condition, final Supplier<String> result) {
        this.condition = condition;
        this.result = result;

    }

    public static Rule of(final IntPredicate condition, final Supplier<String> result) {
        return new Rule(condition, result);
    }

    public boolean test(final Integer number) {
        return this.condition.test(number);
    }

    public Supplier<String> getResultSuppliers() {
        return result;
    }

    public static Supplier<String> combineResultSuppliers(final Supplier<String> resultSupplier1, final Supplier<String> resultSupplier2) {
        return () -> resultSupplier1.get() + resultSupplier2.get();
    }
}
