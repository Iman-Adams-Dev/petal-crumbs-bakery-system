// Subclass of Product representing a Pastry
public class Pastry extends Product {
    private String filling;

    public Pastry(String name, double price, String filling) {
        super(name, price);
        this.filling = filling;
    }

    @Override
    public String getDescription() {
        return "Pastry with " + filling + " filling";
    }
}