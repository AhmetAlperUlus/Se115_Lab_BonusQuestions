import java.util.Scanner;

public class Lab7TBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many products does the store have? ");
        int size = sc.nextInt();

        Product[] inventory = new Product[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Stock: ");
            int stock = sc.nextInt();

            inventory[i] = new Product(name, stock);
        }

        System.out.println("--- Shop is Open! ---");

        while (true) {
            System.out.print("Enter product name to buy (or 'Q' to quit): ");
            String input = sc.next();

            if (input.equals("Q") || input.equals("q")) break;

            boolean found = false;

            for (int i = 0; i < size; i++) {
                if (inventory[i].getName().equals(input)) {
                    inventory[i].buyOne();
                    found = true;
                    break;
                }
            }

            if (!found) System.out.println("No such product!");
        }

        System.out.println("--- Final Inventory ---");

        for (int i = 0; i < size; i++) inventory[i].printInfo();
    }
}