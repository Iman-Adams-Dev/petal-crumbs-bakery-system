// Manages Products. orders, and file operations
import java.io.*;
import java.util.*;

public class BakeryManager {
    private ArrayList<Order> orders;
    private ArrayList<Product> products;

    public BakeryManager() {
        orders = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    // Save all orders to file
    public void saveOrdersToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(orders);
            System.out.println("Orders saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving orders: " + e.getMessage());
        }
    }

    // Load all orders from file
    public void loadOrdersFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            orders = (ArrayList<Order>) in.readObject();
            System.out.println("Orders loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading orders: " + e.getMessage());
        }
    }
}