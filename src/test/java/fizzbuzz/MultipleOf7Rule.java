package fizzbuzz;

public class MultipleOf7Rule extends Rule {

    public MultipleOf7Rule() {
        this.condition = Rule.isMultipleOf(7);
        this.term = "zumba";
    }
}
