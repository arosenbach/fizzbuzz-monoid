package fizzbuzz;

public class FizzBuzzService {

    public String say(int number) {
        final MultipleOf3Rule multipleOf3Rule = new MultipleOf3Rule();
        multipleOf3Rule
                .setNext(new MultipleOf5Rule())
                .setNext(new MultipleOf7Rule());
        final String term = multipleOf3Rule.apply(number);
        return term.isEmpty() ? String.valueOf(number) : term;
    }
}
