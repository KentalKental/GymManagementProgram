package main;
import java.util.*;
public class ProductFactory implements Factory<Product> {
    private final Scanner scanner = new Scanner(System.in);
    private static int productCounter = 0;

    @Override
    public Product create(int x, CrudService<Package> service) {
    	String name,input,id = "P-";
    	double price = 0;
    	int quantity = 0;
    	input = name = "";
		System.out.print("Enter Product Name [Enter '0' to exit]: ");
        input = name = scanner.nextLine();
        
        if(input.equals("0")) return null;
        
        System.out.print("Enter Product Price [Enter '0' to exit]: ");
        price = Double.parseDouble(input = scanner.nextLine());
        
        if(input.equals("0")) return null;
        
        System.out.print("Enter Product Quantity [Enter '0' to exit]: ");
        quantity = Integer.parseInt(input = scanner.nextLine());
        
        if(input.equals("0")) return null;
        
        id = (x == 1) ?"P-"+ productCounter:"P-" + (++productCounter);
    	
    	
        return new Product(id, name, price, quantity);
    }
}
