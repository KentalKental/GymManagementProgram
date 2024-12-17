package main;
import java.util.Scanner;

public class MenuController {
    private final Scanner scanner = new Scanner(System.in);

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
                    T item = factory.create();
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
        if (service.getAll().isEmpty()) {
            System.out.println("No records found.");
        } else {
            int index = 1;
            for (T item : service.getAll()) {
                System.out.println(index++ + ". " + item);
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
            T updatedItem = factory.create();
            service.update(index, updatedItem);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
}
