package fizzbuzz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class RulesCollection {
    private final List<Rule> rules;

    public RulesCollection(final Rule... rules) {
        this.rules = Arrays.asList(rules);
    }

    public Stream<Rule> filter(final Predicate<Rule> predicate) {
        return rules.stream().filter(predicate);
    }
}
