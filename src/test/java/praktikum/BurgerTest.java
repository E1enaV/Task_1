package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredient2;

    @BeforeEach
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void shouldSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(List.of(ingredient), burger.ingredients);
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertEquals(List.of(), burger.ingredients);
    }

    @Test
    public void shouldMoveIngredient() {
        burger.ingredients.addAll(Arrays.asList(ingredient, ingredient2));
        List<Ingredient> expected = Arrays.asList(ingredient2, ingredient);
        burger.moveIngredient(0, 1);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void shouldGetPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(100f);
        assertEquals(300f, burger.getPrice(), 0);
    }

    @Test
    public void shouldGetReceipt() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getName()).thenReturn("cutlet");
        when(ingredient.getPrice()).thenReturn(100f);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                        ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expected, burger.getReceipt());
    }
}

