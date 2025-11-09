// Abstract base class for all bakery products
import java.io.Serializable;

public abstract class Product implements Serializable {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Each abstract type can have its own description
    public abstract String getDescription();

    @Override
    public String toString() {
        return name + " - R" + price;
    }
}