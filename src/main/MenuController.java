package main;
import java.util.Scanner;

public class MenuController {
    private final Scanner scanner = new Scanner(System.in);
    private final GenericSorting sorter = new GenericSorting();
    
    // Generic menu for CRUD operations
    public <T> void showCrudMenu(String entityName, CrudService<T> service, Factory<T> factory) {
        while (true) {
            System.out.println("\n=== " + entityName + " Management ===");
            System.out.println("1. Add " + entityName);
            System.out.println("2. Display All " + entityName);
            System.out.println("3. Update " + entityName);
            System.out.println("4. Delete " + entityName);
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                	// adding item
                    T item = factory.create(-1);
                    service.add(item);
                }
                case "2" -> displayAll(service); // display item
                case "3" -> updateItem(service, factory); // update item
                case "4" -> deleteItem(service); // delete item
                case "5" -> { return; }
                default -> System.out.println("Invalid input. Try again!");
            }
        }
    }

    private <T> void displayAll(CrudService<T> service) {
        if (service.getAll().isEmpty()) System.out.println("No records found.");
        else {
	        T item = service.getItem(0);
	        Member member;
	        Product product;
	        Package pkg;
	        String[] headers = null;
	        if (item instanceof Member) {
		        member = (Member) item;
		        headers = member.getAtt();
	        }
	        else if (item instanceof Product) {
		        product = (Product) item;
		        headers = product.getAtt();
	        }
	        else {
		        pkg = (Package) item;
		        headers = pkg.getAtt();
	        }
        
	        System.out.println("---------------------------------");
	        System.out.println("Display option");
	        System.out.println("1. Default");
	            
	        int index = 2;
	        for (String header : headers) {
	        	System.out.println(index + ". Sort by " + header);
	        	index++;
	        }
	        index = 1;
	        
	        String choice = scanner.nextLine();
	        System.out.println("===============================================");
	        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", headers[0], headers[1], headers[2], headers[3]);
	        System.out.println("===============================================");
	        if(choice.equals("1")) {
	        	
	            if(choice.equals("1")) {
	                for(T a : service.getAll()) {
	                    String parts = a.toString(); // Use proper data methods here
	                    System.out.println(parts);
	                }
	            }
		        else {
		        	sorter.sortList(service.getAll(), choice);
	                for(T a : service.getAll()) {
	                    String[] parts = item.toString().split(","); // Use proper data methods here
	                    System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", 
	                        parts[0], 
	                        parts[1], 
	                        parts[2],
	                        parts[3]
	                    );
	                }
		            
				}
	            System.out.println("===============================================");
	        }
        }
	}

    private <T> void deleteItem(CrudService<T> service) {
        System.out.print("Enter index to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            service.delete(index);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }

    private <T> void updateItem(CrudService<T> service, Factory<T> factory) {
        System.out.print("Enter index to update: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            T updatedItem = factory.create(index);
            service.update(index, updatedItem);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
}
