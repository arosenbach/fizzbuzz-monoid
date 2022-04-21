package fizzbuzz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FizzBuzzFactory {
    private final List<Pair> pairs = Arrays.asList(
            new Pair(
                    15,
                    (Integer number) -> new SayAll(Arrays.asList(new SayFizz(), new SayBuzz()))),
            new Pair(
                    3,
                    (Integer number) -> new SayFizz()),
            new Pair(
                    5,
                    (Integer number) -> new SayBuzz())
    );

    public Say create(final Integer number) {
        return pairs.stream()
                .filter(isPairMatching(number))
                .findFirst()
                .map(pair -> pair.say.apply(number))
                .orElse(new SayIdentity(number));
    }

    private Predicate<Pair> isPairMatching(Integer number) {
        return (Pair pair) -> number % pair.divider == 0;
    }

    private record Pair(Integer divider,
                        Function<Integer, Say> say) {
    }

    public interface Say {
        String say();
    }

    private record SayAll(List<Say> says) implements Say {
        @Override
        public String say() {
            return says.stream().map(Say::say).collect(Collectors.joining());
        }
    }

    private static class SayFizz implements Say {
        @Override
        public String say() {
            return "fizz";
        }
    }

    private static class SayBuzz implements Say {
        @Override
        public String say() {
            return "buzz";
        }
    }

    private record SayIdentity(Integer number) implements Say {
        @Override
        public String say() {
            return String.valueOf(number);
        }
    }
}
