// Subclass of Product representing a Cake
public class Cake extends Product {
    private String flavor;
    private String size;

    public Cake(String name, double price, String flavor, String size) {
        super(name, price);
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return size + " " + flavor + " Cake";
    }
}