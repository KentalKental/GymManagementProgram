package main;

import java.util.Scanner;

public class PackageFactory implements Factory<Package>{
    private final Scanner scanner = new Scanner(System.in);
    private static int productCounter = 0;

    @Override
    public Package create(int x) {
    	String name,id = "PK-",input;
    	double price=0;
    	int quantity=0;
    	input = name = "";
    	
    	while(!input.equals("0"))
        System.out.print("Enter Package Name [Enter '0' to exit]: ");
        input = name = scanner.nextLine();

        if(input.equals("0")) return null;
        
        System.out.print("Enter Package Price [Enter '0' to exit]: ");
        price = Double.parseDouble(input = scanner.nextLine());
        
        if(input.equals("0")) return null;

        System.out.print("Enter Package Duration [Enter '0' to exit]: ");
        Integer.parseInt(input = scanner.nextLine());
        
        if(input.equals("0")) return null;
        
        id = (x != -1) ?id + (x+1):id + (++productCounter);
        return new Package(id, name, price, quantity);
    }

}
