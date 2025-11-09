// Represents a customer's order, using a HashMap to store products and their quantities
import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {
    private Customer customer;
    private HashMap<Product, Integer> items;
    private Date orderDate;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new HashMap<>();
        this.orderDate = new Date();
    }

    public void addProduct(Product p, int quantity) {
        items.put(p, items.getOrDefault(p, 0) + quantity);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Date: ").append(orderDate).append("\n\n");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            sb.append(entry.getKey().getDescription())
                    .append(" x ").append(entry.getValue())
                    .append(" = R").append(entry.getKey().getPrice() * entry.getValue())
                    .append("\n");
        }
        sb.append("\nTotal: R").append(getTotal());
        return sb.toString();
    }
}