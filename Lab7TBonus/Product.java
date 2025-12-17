public class Product {
    private String name;
    private int stock;

    public Product(String n, int s) {
        name = n;
        stock = s;
    }

    public String getName() { return name; }

    public void buyOne() {
        if (stock > 0) {
            stock--;
            System.out.println("You bought a " + name + ".");
        }

        else System.out.println("Out of stock!");
    }

    public void printInfo() { System.out.println("Product: " + name + " | Stock: " + stock); }
}
