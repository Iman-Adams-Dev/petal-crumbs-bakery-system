// ProductTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testCakeDescription() {
        Cake cake = new Cake("Chocolate Cake", 250, "Chocolate", "Large");
        assertEquals("Large Chocolate Cake", cake.getDescription());
    }

    @Test
    public void testCupcakeDescription() {
        Cupcake cupcake = new Cupcake("Vanilla Cupcake", 120, "Sprinkles", 6);
        assertTrue(cupcake.getDescription().contains("Cupcakes with Sprinkles"));
    }

    @Test
    public void testPastryDescription() {
        Pastry pastry = new Pastry("Croissant", 30, "Butter");
        assertEquals("Pastry with Butter filling", pastry.getDescription());
    }

    @Test
    public void testProductPrice() {
        Cake cake = new Cake("Red Velvet", 300, "Red Velvet", "Medium");
        assertEquals(300, cake.getPrice());
    }
}
