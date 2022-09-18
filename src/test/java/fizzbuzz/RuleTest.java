package fizzbuzz;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.ForAll;
import net.jqwik.api.Functions;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Rule")
class RuleTest {

    @Nested
    @DisplayName("Rule::getTerm")
    class getTerm {

        @Test
        @DisplayName("returns empty when rule doesn't apply")
        void returnEmpty() {
            // Arrange
            final Rule sut = new Rule(__ -> false, "XXX");

            // Act
            final Optional<String> actual = sut.getTerm(42);

            // Assert
            assertEquals(actual, Optional.empty());
        }

        @Test
        @DisplayName("returns the term (as an Optional) when rule applies")
        void returnsTerm() {
            // Arrange
            final Rule sut = new Rule(__ -> true, "XXX");

            // Act
            final Optional<String> actual = sut.getTerm(42);

            // Assert
            assertEquals(actual, Optional.of("XXX"));
        }
    }

    @Nested
    @DisplayName("is a monoid with Rule::combine")
    class Combine {

        @Test
        @DisplayName("right identity: x <> mempty ≡ x)")
        void rightIdentity() {
            final Rule rule1 = new Rule(__ -> true, "AAA");
            final Rule rule2 = rule1.combine(Rule.EMPTY);
            assertEquals(rule1.getTerm(42), rule2.getTerm(42));
        }

        @Test
        @DisplayName("left identity: mempty <> x ≡ x)")
        void leftIdentity() {
            final Rule rule1 = new Rule(__ -> true, "AAA");
            final Rule rule2 = Rule.EMPTY.combine(rule1);
            assertEquals(rule1.getTerm(42), rule2.getTerm(42));
        }

        @Test
        @DisplayName("associativity: (x <> y) <> z ≡ x <> (y <> z)")
        void associativity() {
            final Rule rule1 = new Rule(__ -> true, "AAA");
            final Rule rule2 = new Rule(__ -> true, "BBB");
            final Rule rule3 = new Rule(__ -> true, "CCC");
            assertEquals((rule1.combine(rule2)).combine(rule3).getTerm(42),
                    rule1.combine((rule2.combine(rule3))).getTerm(42));
        }
    }

    @Property
    boolean right_identity(@ForAll("rule") Rule rule1, @ForAll int anInteger) {
        final Rule rule2 = rule1.combine(Rule.EMPTY);
        return rule1.getTerm(anInteger).equals(rule2.getTerm(anInteger));
    }

    @Property
    boolean left_identity(@ForAll("rule") Rule rule1, @ForAll int anInteger) {
        final Rule rule2 = Rule.EMPTY.combine(rule1);
        return rule1.getTerm(anInteger).equals(rule2.getTerm(anInteger));
    }

    @Property
    boolean associativity(@ForAll("rule") Rule rule1, @ForAll("rule") Rule rule2, @ForAll("rule") Rule rule3, @ForAll int anInteger) {
        return (rule1.combine(rule2)).combine(rule3).getTerm(anInteger).equals(
                rule1.combine((rule2.combine(rule3))).getTerm(anInteger));
    }

    @Provide
    Arbitrary<Rule> rule() {
        Arbitrary<IntPredicate> predicates = Functions
                .function(IntPredicate.class)
                .returning(Arbitraries.of(true, false));
        Arbitrary<String> strings = Arbitraries.strings();
        return Combinators.combine(predicates, strings)
                .as(Rule::new);
    }

    @Provide
    Arbitrary<IntPredicate> predicates() {
        return Functions
                .function(IntPredicate.class)
                .returning(Arbitraries.of(true, false));
    }

}