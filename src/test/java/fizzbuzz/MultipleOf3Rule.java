package fizzbuzz;

public class MultipleOf3Rule extends Rule {
    public MultipleOf3Rule() {
        super();
        this.condition= isMultipleOf(3);
       this.term= "fizz";
    }
}
