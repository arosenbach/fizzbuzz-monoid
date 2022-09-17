package fizzbuzz;

public class MultipleOf5Rule extends Rule {

    public MultipleOf5Rule() {
        this.condition = Rule.isMultipleOf(5);
        this.term="buzz";
    }
}
