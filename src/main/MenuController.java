package main;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private final Scanner scanner = new Scanner(System.in);
    private final GenericSorting sorter = new GenericSorting();
    private final GenericSearching searcher = new GenericSearching();
    
    // Generic menu for CRUD operations
    public <T> void showCrudMenu(String entityName, CrudService<T> service, Factory<T> factory, CrudService<Package> packageService) {
        while (true) {
            System.out.println("\n=== " + entityName + " Management ===");
            System.out.println("1. Add " + entityName);
            System.out.println("2. Display All " + entityName);
            System.out.println("3. Update " + entityName);
            System.out.println("4. Delete " + entityName);
            System.out.println("5. Search " + entityName);
            System.out.println("6. Back to Main Menu " + entityName);
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    T item = factory.create(-1,packageService);
                    service.add(item);
                }
                case "2" -> displayAll(service); // display item
                case "3" -> updateItem(service, factory, packageService); // update item
                case "4" -> deleteItem(service); // delete item
                case "5" -> searchItem(service); //search item
                case "6" -> { return; }
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
	            
	        int index = 1;
	        for (String header : headers) {
	        	System.out.println(index + ". Sort by " + header);
	        	index++;
	        }
	        index = 1;
	        
	        String choice = scanner.nextLine();
	        System.out.println("==============================================================");
	        System.out.printf("| %-3s ","No.");
	        for(String header : headers) {
    	       System.out.printf("| %-10s ", header);
	        }
	        System.out.printf("|\n");
	        index=1;
	        System.out.println("==============================================================");
	        sorter.sortList(service.getAll(), choice);
            for(T a : service.getAll()) {
                String parts = a.toString(); // Use proper data methods here
                System.out.printf("| %-3d ",index++);
                System.out.printf("%s\n",parts);
            }
            System.out.println("==============================================================");
            scanner.nextLine();
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

    private <T> void updateItem(CrudService<T> service, Factory<T> factory, CrudService<Package> packageService) {
        System.out.print("Enter index to update: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            T updatedItem = factory.create(index,packageService);
            service.update(index, updatedItem);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
    
    private <T> void searchItem(CrudService<T> service) {
    	// search by name, id, age, 
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
	        System.out.println("Search option");

	        int index = 1;
	        for (String header : headers) {
	        	System.out.println(index + ". Search by " + header);
	        	index++;
	        }
	        
	        String choice = scanner.nextLine();
	        List<T> searchedList = searcher.searchList(service.getAll(), choice);
	        System.out.println("===============================================================");
	        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", headers[0], headers[1], headers[2], headers[3]);
	        System.out.println("===============================================================");
	        for(T a : searchedList) {
                String parts = a.toString(); // Use proper data methods here
                System.out.println(parts);
            }
	        System.out.println("===============================================================");
            scanner.nextLine();
        }
    }
	
}
   
