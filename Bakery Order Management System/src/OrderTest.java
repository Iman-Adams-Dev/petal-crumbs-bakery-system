// OrderTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testAddProductToOrder() {
        Customer customer = new Customer("Iman", "0821234567");
        Order order = new Order(customer);

        Cake cake = new Cake("Chocolate Cake", 250, "Chocolate", "Large");
        Cupcake cupcake = new Cupcake("Vanilla Cupcake", 120, "Sprinkles", 6);

        order.addProduct(cake, 1);
        order.addProduct(cupcake, 2);

        double expectedTotal = (1 * 250) + (2 * 120);
        assertEquals(expectedTotal, order.getTotal(), 0.01);
    }

    @Test
    public void testEmptyOrderTotalIsZero() {
        Customer customer = new Customer("Iman", "0820000000");
        Order order = new Order(customer);
        assertEquals(0, order.getTotal());
    }

    @Test
    public void testOrderSummaryIncludesCustomer() {
        Customer customer = new Customer("Iman", "0821234567");
        Order order = new Order(customer);
        Cake cake = new Cake("Chocolate Cake", 250, "Chocolate", "Large");
        order.addProduct(cake, 1);
        String summary = order.getSummary();
        assertTrue(summary.contains("Iman"));
        assertTrue(summary.contains("Total: R250.0"));
    }
}
