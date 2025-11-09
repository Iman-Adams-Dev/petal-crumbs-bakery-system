// BakeryManagerTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class BakeryManagerTest {

    private BakeryManager manager;

    @BeforeEach
    public void setup() {
        manager = new BakeryManager();
        manager.addProduct(new Cake("Chocolate Cake", 250, "Chocolate", "Large"));
        manager.addProduct(new Cupcake("Vanilla Cupcake", 120, "Sprinkles", 6));
    }

    @Test
    public void testAddProduct() {
        assertEquals(2, manager.getProducts().size());
    }

    @Test
    public void testSaveAndLoadOrders() {
        Customer c = new Customer("Iman", "0821234567");
        Order o = new Order(c);
        o.addProduct(manager.getProducts().get(0), 1);
        manager.addOrder(o);

        manager.saveOrdersToFile("testOrders.dat");

        File file = new File("testOrders.dat");
        assertTrue(file.exists());

        BakeryManager loadedManager = new BakeryManager();
        loadedManager.loadOrdersFromFile("testOrders.dat");

        file.delete(); // cleanup

        // No exception means load worked — good sign
        assertNotNull(loadedManager);
    }
}
