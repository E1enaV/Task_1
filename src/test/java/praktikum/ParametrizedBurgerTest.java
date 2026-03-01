package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedBurgerTest {

    private static final Database database = new Database();
    private static final Ingredient ingredient1 = database.availableIngredients().get(1);
    private static final Ingredient ingredient2 = database.availableIngredients().get(3);
    private static final Ingredient ingredient3 = database.availableIngredients().get(5);

    private Burger burger;

    @BeforeEach
    public void setUp() {
        burger = new Burger();
        burger.ingredients.addAll(Arrays.asList(ingredient1, ingredient2, ingredient3));
    }

    @ParameterizedTest
    @MethodSource("moveIngredientsParameters")
    public void shouldMoveIngredients(int index, int newIndex, List<Ingredient> expected) {
        burger.moveIngredient(index, newIndex);
        assertEquals(expected, burger.ingredients);
    }

    static Stream<Arguments> moveIngredientsParameters() {
        return Stream.of(
                Arguments.of(0, 1, List.of(ingredient2, ingredient1, ingredient3)),
                Arguments.of(0, 2, List.of(ingredient2, ingredient3, ingredient1)),
                Arguments.of(1, 2, List.of(ingredient1, ingredient3, ingredient2)),
                Arguments.of(2, 0, List.of(ingredient3, ingredient1, ingredient2)),
                Arguments.of(2, 1, List.of(ingredient1, ingredient3, ingredient2))
        );
    }

    @ParameterizedTest
    @MethodSource("removeIngredientParameters")
    public void shouldRemoveIngredient(int index, List<Ingredient> expected) {
        burger.removeIngredient(index);
        assertEquals(expected, burger.ingredients);
    }

    static Stream<Arguments> removeIngredientParameters() {
        return Stream.of(
                Arguments.of(0, List.of(ingredient2, ingredient3)),
                Arguments.of(1, List.of(ingredient1, ingredient3)),
                Arguments.of(2, List.of(ingredient1, ingredient2))
        );
    }
}

