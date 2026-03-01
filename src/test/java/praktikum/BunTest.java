package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    private Bun bun;

    @BeforeEach
    public void setUp() {
        bun = new Bun("Булочка с кунжутом", 100);
    }

    @Test
    public void shouldGetName() {
        String expected = "Булочка с кунжутом";
        assertEquals(expected, bun.getName());
    }

    @Test
    public void shouldGetPrice() {
        float expected = 100f;
        assertEquals(expected, bun.getPrice(), 0);
    }
}

