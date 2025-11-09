// Subclass of Product representing a Cupcake
public class Cupcake extends Product {
    private String topping;
    private int quantityPerBox;

    public Cupcake(String name, double price, String topping, int quantityPerBox) {
        super(name, price);
        this.topping = topping;
        this.quantityPerBox = quantityPerBox;
    }

    @Override
    public String getDescription() {
        return quantityPerBox + "x Cupcakes with " + topping + "topping";
    }
}