package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @BeforeEach
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Томатный соус", 30);
    }

    @Test
    public void shouldReturnPrice() {
        float expected = 30f;
        assertEquals(expected, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldReturnName() {
        String expected = "Томатный соус";
        assertEquals(expected, ingredient.getName());
    }

    @Test
    public void shouldReturnIngredientType() {
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, ingredient.getType());
    }
}

