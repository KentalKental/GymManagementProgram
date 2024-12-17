package main;
import java.util.*;
public class ProductFactory implements Factory<Product> {
    private final Scanner scanner = new Scanner(System.in);
    private static int productCounter = 0;

    @Override
    public Product create() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Product Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        String id = "P-" + (++productCounter);
        return new Product(id, name, price, quantity);
    }
}
