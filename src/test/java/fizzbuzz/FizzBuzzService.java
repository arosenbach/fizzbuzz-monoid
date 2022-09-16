package fizzbuzz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FizzBuzzService {
    private final List<Map.Entry<Predicate<Integer>, Function<Integer, String>>> rules = List.of(
            Map.entry(isMultipleOf(3), (number) -> "fizz"),
            Map.entry(isMultipleOf(5), (number) -> "buzz"),
            Map.entry(isMultipleOf(7), (number) -> "zumba")
    );

    private static Predicate<Integer> isMultipleOf(int x) {
        return (number) -> number % x == 0;
    }

    public String say(Integer number) {
        return rules
                .stream()
                .filter(entry -> entry.getKey().test(number))
                .map(Map.Entry::getValue)
                .map(f -> f.apply(number))
                .collect(Collectors.joining());
    }
}
